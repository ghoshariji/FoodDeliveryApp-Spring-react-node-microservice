import axios from "./authUserIndex";
import axios1 from "axios";
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

export const getAllProduct = async () => {
  try {
    const data = await axios1.get(
      "http://localhost:5000/micro/products/get-product"
    );
    return data.data;
  } catch (error) {
    console.log("Error" + error);
  }
};
