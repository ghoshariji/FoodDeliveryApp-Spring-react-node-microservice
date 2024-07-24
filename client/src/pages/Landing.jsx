import React from "react";
import Beforenav from "../components/navabr/Beforenav";
import Hero from "./Herosectio";
import Subscribe from "./Subscribe";
import Heroabout from "./Heroabout";
import Review from "./Review";
const Landing = () => {
  return (
    <div>
        <Beforenav />
        <Hero />
        <Subscribe />
        <Heroabout />
        <Review />
    </div>
  );
};

export default Landing;
