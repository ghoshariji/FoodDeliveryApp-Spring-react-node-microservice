const conversationModel = require("../modal/ConversationModal");
const messageModel = require("../modal/MessageModal");
const { getReceiverId, emitMessage } = require("../socket/Socket");

const save = async (req, res) => {
  try {
    console.log(req.body);

    const { senderId, receiverId, newMessage } = req.body;
    let conversation = await conversationModel.findOne({
      particapant: { $all: [senderId, receiverId] },
    });

    // if no-data present then create a new ParcipantArray and put values

    if (!conversation) {
      conversation = await conversationModel.create({
        particapant: [senderId, receiverId],
      });
    }

    // every time create a messageValue -> id -> ref -> mongoose.Schema.Types.ObjectId, -> populate -> create and save in db
    const message = await messageModel.create({
      senderId,
      receiverId,
      newMessage,
    });
    // svae in db -> conversation Modal
    if (message) {
      conversation.chat.push(message._id);
    }
    // user online then direct send the message in real time bases
    await conversation.save();
    const socketId = getReceiverId(receiverId);
    if (socketId) {
      emitMessage(socketId, message);
    }

    return res.status(201).send({
      message: "Message saved",
      success: true,
    });
  } catch (error) {
    console.log(error.message);
    return res.status(409).send({
      message: error.message,
      success: false,
    });
  }
};

module.exports = { save, getMessage, getChatList };
