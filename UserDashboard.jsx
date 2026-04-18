import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function UserDashboard() {
  const [campaigns, setCampaigns] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetch("/api/my-campaigns")
      .then(res => res.json())
      .then(data => setCampaigns(data));
  }, []);

  return (
    <div className="dashboard">
      <h2>Your Campaigns</h2>

      <button onClick={() => navigate("/create")}>+ Create</button>

      {campaigns.map(c => {
        const percent = (c.raised / c.target) * 100;

        return (
          <div className="campaign-card" key={c._id}>
            <div className="campaign-title">{c.name}</div>

            <div className="progress-bar">
              <div
                className="progress-fill"
                style={{ width: `${percent}%` }}
              ></div>
            </div>

            <div className="stats">
              <span>₹{c.raised}</span>
              <span>Goal ₹{c.target}</span>
            </div>

            <button onClick={() => navigate(`/create?id=${c._id}`)}>
              Edit
            </button>
          </div>
        );
      })}
    </div>
  );
}