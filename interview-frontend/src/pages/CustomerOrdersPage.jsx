// src/pages/CustomerOrdersPage.jsx
import React, { useEffect, useState } from "react";
import { getOrdersByUserId } from "../api/orderApi";

function CustomerOrdersPage({ userId }) {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    const fetchOrders = async () => {
      const data = await getOrdersByUserId(userId);
      setOrders(data);
    };
    fetchOrders();
  }, [userId]);

  return (
    <div>
      <h3>Orders for User #{userId}</h3>
      <ul>
        {orders.map((order) => (
          <li key={order.orderId}>
            {order.productName} - ₹{order.totalAmount}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CustomerOrdersPage;