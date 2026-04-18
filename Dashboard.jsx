import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Dashboard() {
  const [campaigns, setCampaigns] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetch("/api/campaigns")
      .then(res => res.json())
      .then(data => setCampaigns(data));
  }, []);

  return (
    <div className="dashboard">

      {/* 🔝 TOP BAR */}
      <div className="topbar">
        <h2>CrowdBoost</h2>

        <button onClick={() => navigate("/login")}>
          Login
        </button>
      </div>

      {/* 📦 CAMPAIGNS */}
      {campaigns.map(c => {
        const percent = (c.raised / c.target) * 100;

        return (
          <div
            key={c._id}
            className="campaign-card"
            onClick={() => navigate(`/campaign/${c._id}`)}
          >
            <div className="campaign-title">{c.name}</div>
            <div className="campaign-desc">{c.description}</div>

            <div className="progress-bar">
              <div
                className="progress-fill"
                style={{ width: `${percent}%` }}
              ></div>
            </div>

            <div className="stats">
              <span>₹{c.raised} raised</span>
              <span>Goal ₹{c.target}</span>
            </div>
          </div>
        );
      })}
    </div>
  );
}