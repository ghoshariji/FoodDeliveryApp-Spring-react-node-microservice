import React from "react";
import { useDispatch } from "react-redux";
import { addProductToCart } from "../store/slice/ProductSlice";
const Heroauth = () => {
  // getting a new react-redux method name is the useDispatch it is for the performing all the task that are present in the slice
  const dispatch = useDispatch();
  const data = [
    {
      id: "1",
      name: "shoe1",
      image:
        "https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.webp",
    },
    {
      id: "2",
      name: "shoe2",
      image:
        "https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.webp",
    },
    {
      id: "3",
      name: "shoe3",
      image:
        "https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.webp",
    },
    {
      id: "4",
      name: "shoe4",
      image:
        "https://img.daisyui.com/images/stock/photo-1606107557195-0e29a4b5b4aa.webp",
    },
  ];
  const handleCart = (val) => {
    dispatch(addProductToCart(val));
  };
  return (
    <div className="flex flex-col md:flex-row justify-between">
      {data.map((val, ind) => {
        return (
          <>
            <div className="card glass w-96" key={ind}>
              <figure>
                <img src={val.image} alt="car!" />
              </figure>
              <div className="card-body">
                <h2 className="card-title">Life hack</h2>
                <p>How to park your car at your garage?</p>
                <div className="card-actions justify-end">
                  <button
                    className="btn btn-primary"
                    onClick={() => handleCart(val)}
                  >
                    Add to Cart
                  </button>
                </div>
              </div>
            </div>
          </>
        );
      })}
    </div>
  );
};

export default Heroauth;
