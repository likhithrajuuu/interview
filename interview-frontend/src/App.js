import React, { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [customers, setCustomers] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

  const fetchCustomers = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/customers");
      setCustomers(response.data);
      setFiltered(response.data);
    } catch (error) {
      console.error("Failed to fetch customers:", error.message);
    }
  };

  useEffect(() => {
    fetchCustomers();
  }, []);

  useEffect(() => {
    const term = searchTerm.toLowerCase();
    const results = customers.filter((customer) =>
      customer.name.toLowerCase().includes(term) ||
      customer.email.toLowerCase().includes(term)
    );
    setFiltered(results);
  }, [searchTerm, customers]);

  return (
    <div className="App">
      <h1>Customer Directory</h1>
      <input
        type="text"
        placeholder="Search by name or email..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
        className="search-input"
      />

      <div className="customer-grid">
        {filtered.length > 0 ? (
          filtered.map((customer) => (
            <div className="customer-card" key={customer.id}>
              <h2>{customer.name}</h2>
              <p>Email: {customer.email}</p>
              <p>Orders: {customer.orderCount}</p>
            </div>
          ))
        ) : (
          <p>No customers found.</p>
        )}
      </div>
    </div>
  );
}

export default App;