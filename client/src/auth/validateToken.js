import axios from "./tokenIndex";

export const validateToken = async (payload) => {
  try {
    const config = {
      headers: {
        "Authorization": `Bearer ${payload}`,
      },
    };
    const data = await axios.post("/validate-token",{},config);
    return data.data;
  } catch (error) {
    console.log("Error" + error);
  }
};
