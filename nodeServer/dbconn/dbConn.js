const mongoose = require("mongoose");
const dbUri = "";

mongoose
  .connect(dbUri)
  .then(() => {
    console.log("DataBase Connected");
  })
  .cathc((err) => {
    console.log("Error to conn db " + err);
  });
