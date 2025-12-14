import { Navigate, Route, BrowserRouter as Router, Routes } from "react-router-dom";
import Feed from "./pages/Feed";
import Login from "./pages/Login";
import Signup from "./pages/Signup";

function App() {
  const isLoggedIn = !!localStorage.getItem("userId"); // check if user logged in

  return (
    <Router>
      <Routes>
        <Route 
          path="/" 
          element={isLoggedIn ? <Navigate to="/feed" /> : <Navigate to="/login" />} 
        />
        <Route 
          path="/login" 
          element={isLoggedIn ? <Navigate to="/feed" /> : <Login />} 
        />
        <Route 
          path="/signup" 
          element={isLoggedIn ? <Navigate to="/feed" /> : <Signup />} 
        />
        <Route 
          path="/feed" 
          element={isLoggedIn ? <Feed /> : <Navigate to="/login" />} 
        />
      </Routes>
    </Router>
  );
}

export default App;
