import { useEffect, useState } from "react";
import API from "../api";

export default function AdminDashboard() {
  const [campaigns, setCampaigns] = useState([]);

  useEffect(() => {
    API.get("/campaigns")
      .then(res => setCampaigns(res.data))
      .catch(err => console.log(err));
  }, []);

  const handleDelete = async (id) => {
    await API.delete(`/campaign/${id}`);
    setCampaigns(campaigns.filter(c => c._id !== id));
  };

  return (
    <div className="dashboard">
      <h2>Admin Panel</h2>

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
              <span>₹{c.target}</span>
            </div>

            <button onClick={() => handleDelete(c._id)}>
              Delete
            </button>
          </div>
        );
      })}
    </div>
  );
}