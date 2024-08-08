import React, { useEffect, useState } from "react";
import { getAllProduct } from "../auth/userIndex";

const Newlaunch = () => {
  const [data, setData] = useState([]);

  const fetchData = async () => {
    try {
      console.log("Come")
      const result = await getAllProduct();
      setData(result);
      console.log("Fetched data: ", result);
    } catch (error) {
      console.error("Error fetching data: ", error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const createUrl = (fileData,type) => {
    try {
      if (!fileData || fileData.length === 0) {
        throw new Error("Invalid file data");
      }
      const byteArray = new Uint8Array(fileData);
      const blob = new Blob([byteArray], { type:type });
      const url = URL.createObjectURL(blob);
      console.log("Generated URL: ", url);
      
      return url;
    } catch (error) {
      console.error("Error creating URL: ", error);
      return "";
    }
  };

  return (
    <div className="flex flex-col md:flex-row justify-between">
      {data.map((val, ind) => {
        const imgUrl = createUrl(val.productImg,val.contentType);
        return (
          <div key={ind} className="card bg-base-100 w-96 shadow-xl m-4">
            <figure>
              {imgUrl ? <img src="https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.webp" alt={val.name} /> : <p>Image not available</p>}
            </figure>
            <div className="card-body">
              <h2 className="card-title">{val.name}</h2>
              <p>{val.description}</p>
              <div className="card-actions justify-end">
                <button className="btn btn-primary">Buy Now</button>
              </div>
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default Newlaunch;
