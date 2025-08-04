// src/pages/CustomersPage.jsx
import React, { useEffect, useState } from "react";
import { getAllCustomers } from "../api/customerApi";

function CustomersPage() {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    const fetch = async () => {
      const data = await getAllCustomers();
      setCustomers(data);
    };
    fetch();
  }, []);

  return (
    <div>
      <h2>Customers</h2>
      <ul>
        {customers.map((cust) => (
          <li key={cust.id}>
            {cust.firstName} {cust.lastName} - {cust.email} (Orders: {cust.orderCount})
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CustomersPage;