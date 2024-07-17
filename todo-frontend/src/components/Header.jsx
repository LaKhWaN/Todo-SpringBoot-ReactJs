import React from "react";
import { useNavigate } from "react-router-dom";

function Header() {
  const navigator = useNavigate();

  const todoNav = () => {
    navigator("/");
  };

  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <a className="navbar-brand">Todo Management</a>
        <div className="navbar-collapse" id="navbarNav">
          <ul className="navbar-nav">
            <li className="nav-item active">
              <a onClick={todoNav} className="nav-link" href="#">
                All Todos
              </a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  );
}

export default Header;
