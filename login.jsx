import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "../App.css";

export default function Login({ setUser }) {
  const [data, setData] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();

    if (data.username === "admin") {
      setUser({ role: "admin" });
      navigate("/admin");
    } else {
      setUser({ role: "user" });
      navigate("/user");
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h2>Enter your login credentials</h2>

        <form onSubmit={handleLogin}>
          <label>Username:</label>
          <input
            type="text"
            placeholder="Enter your Username"
            value={data.username}
            onChange={(e) =>
              setData({ ...data, username: e.target.value })
            }
          />

          <label>Password:</label>
          <input
            type="password"
            placeholder="Enter your Password"
            value={data.password}
            onChange={(e) =>
              setData({ ...data, password: e.target.value })
            }
          />

          <button type="submit">Submit</button>
        </form>

        <p className="signup-text">
          Not registered?{" "}
          <span onClick={() => navigate("/signup")}>
            Create an account
          </span>
        </p>
      </div>
    </div>
  );
}