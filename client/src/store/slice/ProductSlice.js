import { createSlice } from "@reduxjs/toolkit";

const products = createSlice({
  name: "product",
  initialState: [],
  reducers: {
    addProductToCart(state, action) {
      state.push(action.payload);
    },
  },
});
export default products.reducer;

export const { addProductToCart } = products.actions;
