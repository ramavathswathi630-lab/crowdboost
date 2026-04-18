import { useState } from "react";
import { useNavigate } from "react-router-dom";
import API from "../api";

export default function CreateCampaign() {
  const [data, setData] = useState({
    cname: "",
    description: "",
    targetAmt: "",
  });

  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const handleChange = (e) => {
    setData({
      ...data,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      setLoading(true);

      // ✅ Use ONE consistent API call (not mixed)
      const res = await API.post("http://localhost:8080/campaigns", data);

      alert(res.data.message || "Campaign created successfully");

      navigate("/home");
    } catch (err) {
      console.error(err);

      const message =
        err.response?.data?.message || "Creation failed. Try again.";

      alert(message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="form-page">
      <div className="form-card">
        <h2>Create Campaign</h2>

        <form onSubmit={handleSubmit}>
          <input
            type="text"
            name="cname"
            placeholder="Campaign Name"
            value={data.name}
            onChange={handleChange}
          />

          <textarea
            name="description"
            placeholder="Description"
            value={data.description}
            onChange={handleChange}
          />

          <input
            type="text"
            name="targetAmt"
            placeholder="Target Amount"
            value={data.target}
            onChange={handleChange}
          />

          <button type="submit" disabled={loading}>
            {loading ? "Creating..." : "Create"}
          </button>
        </form>
      </div>
    </div>
  );
}