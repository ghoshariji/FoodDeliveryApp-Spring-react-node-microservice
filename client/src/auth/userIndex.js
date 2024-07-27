import axios from "./authUserIndex";

export const registerNow = async (payload) => {
  try {
    const data = await axios.post("/register", payload);
    return data.data;
  } catch (error) {
    console.log("Error" + error);
  }
};

export const loginNow = async (payload) => {
  try {
    const data = await axios.post("/login", payload);
    return data.data;
  } catch (error) {
    console.log("Error" + error);
  }
};
