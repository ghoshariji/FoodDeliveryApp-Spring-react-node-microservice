import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Landing from "./pages/Landing";
import Footer from "./pages/Footer";
import Home from "./pages/Home";
import Restaurant from "./pages2/Restaurant";
import History from "./pages2/History";
import Resfoodlist from "./pages2/Resfoodlist";
import Restaurantfood from "./pages2/Restaurantfood";
import Homeadmin from "./shopadmin/Homeadmin";

const App = () => {
  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Landing />} />
        <Route path="/home" element={<Home />} />
        <Route path="/restaurant" element={<Restaurant />} />
        <Route path="/restaurant-food-list" element={<Restaurantfood />} />
        <Route path="/history" element={<History />} />
        <Route path="/admin-home" element={<Homeadmin />} />
      </Routes>
      
    </BrowserRouter>
    <Footer />
    </>
  );
};

export default App;
