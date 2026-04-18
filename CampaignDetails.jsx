import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import API from "../api";


export default function CampaignDetails() {
  const { id } = useParams();
  const [campaign, setCampaign] = useState({});
  const navigate = useNavigate();

  useEffect(() => {
    API.get(`http://localhost:8080/campaigns`)
      .then(res => setCampaign(res.data))
      .catch(err => console.log(err));
  }, [id]);

  const percent = campaign.target
    ? Math.min(100, (campaign.raised / campaign.target) * 100)
    : 0;

  return (
    <div className="form-page">
      <div className="form-card">
        <h2>{campaign.name}</h2>

        <div className="progress-bar">
          <div
            className="progress-fill"
            style={{ width: `${percent}%` }}
          ></div>
        </div>

        <p>
          ₹{campaign.raised || 0} / ₹{campaign.target || 0}
        </p>

        <input value={campaign.description || ""} readOnly />
        <input value={campaign.contact || ""} readOnly />

        <button onClick={() => navigate(`/donate/${id}`)}>
          Donate Now
        </button>
      </div>
    </div>
  );
}