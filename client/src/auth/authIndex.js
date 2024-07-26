import axios from "axios"

const axiosInstance = axios.create({
    baseURL:"http://localhost:5001",
    headers:{
          'Content-Type': 'multipart/form-data'
    }
})

export default axiosInstance;