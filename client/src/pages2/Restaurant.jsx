import React from "react";
import Afternav from "../components/navabr/Afternav";

const Restaurant = () => {
  return (
    <>
    <Afternav />
    <div>

      <div className="collapse collapse-arrow bg-base-200">
        <input type="radio" name="my-accordion-2" defaultChecked />
        <div className="collapse-title text-xl font-medium">
          Click to open this one and close others
        </div>
        <div className="collapse-content">
        <button className="btn btn-block">block</button>
        </div>
      </div>
      
    </div>
    </>
  );
};

export default Restaurant;
