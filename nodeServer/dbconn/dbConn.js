const mongoose = require("mongoose");
const dbUri = "mongodb+srv://arijitghosh1203:arijit12@cluster0.tocmouc.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

mongoose
  .connect(dbUri)
  .then(() => {
    console.log("DataBase Connected");
  })
  .catch((err) => {
    console.log("Error to conn db " + err);
  });
