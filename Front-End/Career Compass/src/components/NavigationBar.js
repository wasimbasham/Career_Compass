import React from "react";
import { Navbar, Nav, Button } from "react-bootstrap";
import { Link } from "react-router-dom";
import "./NavigationBar.css";

const NavigationBar = (props) => {
  return (
    <Navbar className="nav">
      <Navbar.Brand href="/">MADRAS UNIVERSITY BANK</Navbar.Brand>

      <Nav className="mr-auto">
        <Link to="/" className="homehover">
          HOME
        </Link>
      </Nav>
      <nav class="navbar navbar-default">
      </nav>
      <div class="dropdown">
        <button class="btn btn-primary " type="button">
          <Link to="/applynew">
            {" "}
            <span>Apply Now</span>
          </Link>
        </button>
      </div>
      <Button href="/adminlogin" className="nav-link" variant="primary">Admin Login</Button>{' '}
    </Navbar>
    
  );
};

export default NavigationBar;
