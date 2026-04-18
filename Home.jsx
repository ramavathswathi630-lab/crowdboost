import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import API from "../api";

export default function Home() {
  const [campaigns, setCampaigns] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    API.get("http://localhost:8080/campaigns")
      .then(res => {
        setCampaigns(res.data); // ✅ Axios fix
      })
      .catch(err => {
        console.error("Error fetching campaigns:", err);
      });
  }, []);

  return (
    <div className="container">
      <h2>All Campaigns</h2>

      {campaigns.map((c) => (
        <div
          key={c.id}   // ✅ FIXED (_id → id)
          className="card"
          onClick={() => navigate(`/campaign/${c.id}`)}
        >
          <h3>{c.cname}</h3>  {/* ✅ backend field */}
          <p>{c.description}</p>
        </div>
      ))}
    </div>
  );
}