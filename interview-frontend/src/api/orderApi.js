import axios from "axios";

const BASE_URL = "http://localhost:8080/api/order";

export const getOrdersByUserId = async (userId) => {
  const response = await axios.get(`${BASE_URL}/user/${userId}`);
  return response.data;
};

export const getOrderById = async (orderId) => {
  const response = await axios.get(`${BASE_URL}/${orderId}`);
  return response.data;
};