import axios from "axios";

const BASE_URL = "http://localhost:8080/api/customers";

// Get paginated customers
export const getAllCustomers = async (page = 0, size = 10) => {
  const response = await axios.get(`${BASE_URL}/get/all`, {
    params: { page, size }
  });
  return response.data;
};

// Get customer by ID
export const getCustomerById = async (id) => {
  const response = await axios.get(`${BASE_URL}/${id}`);
  return response.data;
};