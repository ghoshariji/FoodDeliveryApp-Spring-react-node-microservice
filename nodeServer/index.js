const express = require("express");
const app = express();
const PORT = 5000;
const socket = require("socket.io");
const cors = require("cors");
app.use(cors());
app.use(express.urlencoded({ extended: true }));
app.use(express.json());

const http = require("http");
const server = http.createServer(app);
// db-conn
const db = require("./dbconn/dbConn")

const { initSocket } = require("./socket/Socket");
initSocket(server);
// implementing socket.io

// const io = require("socket.io")(server, {
//   cors: {
//     origin: ["http://localhost:3000"],
//     methods: ["GET", "POST"],
//   },
// });

// getrting the userId When socket is Connected

// making a object for storing the userId with socketId -> map

// const userOnline = {};
// io.on("connection", (socket) => {
//   const userId = socket.handshake.query.userId;
//   if (userId) {
//     userOnline[userId] = socket.id;
//     io.emit("user-list", Object.keys(userOnline));
//   }

//   socket.on("disconnect", () => {
//     delete userOnline[userId];
//     io.emit("user-list", Object.keys(userOnline));
//   });
//   socket.on("error", (err) => {
//     console.error(`Socket error from ${userId}: ${err.message}`);
//   });
// });
// // getting the if userOnline then send the socketId from the userId

// const getReceiverId = (id) => userOnline[id];

// const emitMessage = (socketId, message) => {
//   if (io && socketId) {
//     io.to(socketId).emit("newMessage", message);
//   }
// };

server.listen(PORT, () => {
  console.log("Server Start");
});
