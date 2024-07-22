const route = require("express").Router();
const chatController = require("../controller/ChatController");
route.post("/save-message", chatController.save);

module.exports = route;
