import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import { useState } from "react";

import Login from "./pages/login";
import Signup from "./pages/signup";
import Home from "./pages/Home";
import Dashboard from "./pages/Dashboard";
import CampaignDetails from "./pages/CampaignDetails";
import CreateCampaign from "./pages/CreateCampaign";
import Donate from "./pages/Donate";
import UserDashboard from "./pages/UserDashboard";
import AdminDashboard from "./pages/AdminDashboard";

export default function App() {
  const [user, setUser] = useState(null);

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Dashboard />} />

        <Route path="/home" element={<Home />} />
        <Route path="/campaign/:id" element={<CampaignDetails />} />
        <Route path="/donate/:id" element={<Donate />} />

        <Route path="/login" element={<Login setUser={setUser} />} />
        <Route path="/signup" element={<Signup />} />

        <Route
          path="/user"
          element={
            user?.role === "user" ? <UserDashboard /> : <Navigate to="/login" />
          }
        />

        <Route
          path="/admin"
          element={
            user?.role === "admin" ? (
              <AdminDashboard />
            ) : (
              <Navigate to="/login" />
            )
          }
        />

        <Route
          path="/create"
          element={user ? <CreateCampaign /> : <Navigate to="/login" />}
        />
      </Routes>
    </BrowserRouter>
  );
}