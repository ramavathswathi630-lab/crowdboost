import { useState } from "react";
import { useParams } from "react-router-dom";
import API from "../api";

export default function Donate() {
  const { id } = useParams();
  const [data, setData] = useState({
    Name:"",
    Amount:""

  });

  const handleDonate = async (e) => {
    e.preventDefault();

    await API.post(`http://localhost:8080/donations/did`, data);
    alert("Proceeding to payment...");
  };

  return (
    <div>
      <form onSubmit={handleDonate}>
        <input
          type="text"
          name="Name"
          placeholder="Name"
          onChange={(e) =>
            setData({ ...data, name: e.target.value })
          }
        />

        <input
          type="text"
          name="Amount"
          placeholder="Amount"
          onChange={(e) =>
            setData({ ...data, amount: e.target.value })
          }
        />

        <button type="submit">Donate</button>
      </form>
    </div>
  );
}