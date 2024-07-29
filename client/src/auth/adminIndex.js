import axios from "./authIndex";

export const addProduct1 = async (payload) => {
  try {
    const data = await axios.post("/add-product", payload);
    return data.data;
  } catch (error) {
    console.log("Error" + error);
  }
};
