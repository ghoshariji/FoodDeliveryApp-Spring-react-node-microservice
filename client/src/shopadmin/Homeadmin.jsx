import React, { useEffect, useState } from "react";
import Afternav from "../components/navabr/Afternav";
import { addProduct1 } from "../auth/adminIndex";
import { validateToken } from "../auth/validateToken";

const Homeadmin = () => {
  const [addProduct, setProduct] = useState(false);
  const [sellerId1, setSellerId] = useState("");
  const handleOpenModal = () => {
    setProduct(true);
  };

  const fetchSellerId = async () => {
    const token = localStorage.getItem("token");
    console.log(token);
    try {
      const data = await validateToken(token);
      setSellerId(data.userModal.id);
      console.log(data);
    } catch (error) {
      console.log("Error" + error);
    }
  };
  useEffect(() => {
    fetchSellerId();
  }, []);

  const handleCloseModal = () => {
    setProduct(false);
  };
  const [post, setPost] = useState({
    name: "",
    price: "",
    quantity: "",
    description: "",
    productImg: "",
    sellerId: "",
  });

  const handleInput = (e) => {
    setPost({ ...post, [e.target.name]: e.target.value });
  };

  const handleImg = (e) => {
    setPost({ ...post, img: e.target.files[0] });
  };
  const handleAddProduct = async (e) => {
    try {
      e.preventDefault();
      const formData = new FormData();
      formData.append("name", post.name);
      formData.append("price", post.price);
      formData.append("quantity", post.quantity);
      formData.append("description", post.description);
      formData.append("productImg", post.productImg);
      formData.append("sellerId", sellerId1);

      const data = await addProduct1(formData);
      console.log(data);
    } catch (error) {
      console.log("Error" + error);
    }
  };
  return (
    <div>
      <Afternav />
      <div className="flex flex-row justify-around item-center m-20 p-20">
        <button
          data-modal-target="authentication-modal"
          data-modal-toggle="authentication-modal"
          className="block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
          type="button"
          onClick={handleOpenModal}
        >
          Add Product
        </button>
        <button
          data-modal-target="authentication-modal"
          data-modal-toggle="authentication-modal"
          className="block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
          type="button"
          onClick={handleOpenModal}
        >
          Edit Product
        </button>
        <button
          data-modal-target="authentication-modal"
          data-modal-toggle="authentication-modal"
          className="block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
          type="button"
          onClick={handleOpenModal}
        >
          Delete Product
        </button>
      </div>

      {addProduct && (
        <div
          id="authentication-modal"
          tabIndex="-1"
          aria-hidden="true"
          className="fixed inset-0 z-50 overflow-y-auto overflow-x-hidden flex justify-center items-center bg-black bg-opacity-50"
        >
          <div className="relative p-4 w-full max-w-md max-h-full">
            <div className="relative bg-white rounded-lg shadow dark:bg-gray-700">
              <div className="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600">
                <h3 className="text-xl font-semibold text-gray-900 dark:text-white">
                  Add Product
                </h3>
                <button
                  type="button"
                  className="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
                  onClick={handleCloseModal}
                >
                  <svg
                    className="w-3 h-3"
                    aria-hidden="true"
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 14 14"
                  >
                    <path
                      stroke="currentColor"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      strokeWidth="2"
                      d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6"
                    />
                  </svg>
                  <span className="sr-only">Close modal</span>
                </button>
              </div>
              <div className="p-4 md:p-5">
                <form className="space-y-4" onSubmit={handleAddProduct}>
                  <div>
                    <label
                      htmlFor="email"
                      className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                    >
                      Enter Name
                    </label>
                    <input
                      type="text"
                      name="name"
                      id="email"
                      className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                      placeholder="water"
                      value={post.name}
                      onChange={handleInput}
                      required
                    />
                  </div>
                  <div>
                    <label
                      htmlFor="password"
                      className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                    >
                      Enter Price
                    </label>
                    <input
                      type="text"
                      name="price"
                      id="password"
                      placeholder="rs:500"
                      className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                      required
                      value={post.price}
                      onChange={handleInput}
                    />
                  </div>
                  <div>
                    <label
                      htmlFor="password"
                      className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                    >
                      Enter Description
                    </label>
                    <input
                      type="text"
                      name="description"
                      id="password"
                      placeholder="nice product"
                      className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                      required
                      value={post.description}
                      onChange={handleInput}
                    />
                  </div>
                  <div>
                    <label
                      htmlFor="password"
                      className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                    >
                      Enter Quantity
                    </label>
                    <input
                      type="text"
                      name="quantity"
                      id="password"
                      placeholder="1,2,3,4"
                      className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                      required
                      value={post.quantity}
                      onChange={handleInput}
                    />
                  </div>
                  <div>
                    <label
                      htmlFor="password"
                      className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
                    >
                      Enter Product Image
                    </label>
                    <input
                      type="file"
                      name="password"
                      id="password"
                      placeholder="••••••••"
                      className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
                      required
                      onChange={handleImg}
                    />
                  </div>

                  <button
                    type="submit"
                    className="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
                  >
                    Add Product
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default Homeadmin;
