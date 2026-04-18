import { useState } from "react";
import { useNavigate } from "react-router-dom";
import API from "../api"; // axios instance

export default function Signup() {
  const [data, setData] = useState({
    mname: "",
    username: "",
    contact: "",
    email: "",
    password: "",
  });

  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const handleChange = (e) => {
    setData({ ...data, [e.target.name]: e.target.value });
  };

  const handleSignup = async (e) => {
    e.preventDefault();

    // ✅ Basic validation
    if (!data.name || !data.username || !data.email || !data.password) {
      alert("Please fill all required fields");
      return;
    }

    try {
      setLoading(true);

      const res = await API.post("http://localhost:8080/members/register", data);

      alert(res.data.message || "User created successfully");

      navigate("/login");
    } catch (err) {
      console.error(err);

      // ✅ Proper error handling
      const message =
        err.response?.data?.message || "Signup failed. Try again.";

      alert(message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h2>Create your account</h2>

        <form onSubmit={handleSignup}>
          <label>Full Name:</label>
          <input
            type="text"
            name="name"
            placeholder="Enter your full name"
            value={data.name}
            onChange={handleChange}
          />

          <label>Username:</label>
          <input
            type="text"
            name="username"
            placeholder="Enter username"
            value={data.username}
            onChange={handleChange}
          />

          <label>Email:</label>
          <input
            type="email"
            name="email"
            placeholder="Enter email"
            value={data.email}
            onChange={handleChange}
          />

          <label>Contact:</label>
          <input
            type="text"
            name="contact"
            placeholder="Enter contact number"
            value={data.contact}
            onChange={handleChange}
          />

          <label>Password:</label>
          <input
            type="password"
            name="password"
            placeholder="Enter password"
            value={data.password}
            onChange={handleChange}
          />

          <button type="submit" disabled={loading}>
            {loading ? "Creating..." : "Signup"}
          </button>
        </form>

        <p className="signup-text">
          Already have an account?{" "}
          <span onClick={() => navigate("/login")}>
            Login here
          </span>
        </p>
      </div>
    </div>
  );
}