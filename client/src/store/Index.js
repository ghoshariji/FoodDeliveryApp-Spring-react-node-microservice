import {configureStore} from "@reduxjs/toolkit"
import products from "./slice/ProductSlice"
// creating configure store for the how much needed

const store = configureStore({
    reducer:{
        products:products
    }
})

export default store