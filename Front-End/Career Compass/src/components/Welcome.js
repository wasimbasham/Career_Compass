import React, { Component } from "react";

import { Card, Container } from "react-bootstrap";

import { Link } from "react-router-dom";
import './Welcome.css'
// import AccountBalanceIcon from '@mui/icons-material/AccountBalance';
// import { IconButton } from "@material-ui/core";

class Welcome extends Component {
  render() {
    return (
      <Container className="mainbg">
    
      <div className="BankName"> <center><h1 id="head1">WELCOME TO MADRAS UNIVERSITY BANK</h1></center></div>
  
       
      <br/>
    
      
        <div>
          <div className="login-button">
            <Card className="loginbox">
                  <Card.Body>
                    <Card.Title>Login Now</Card.Title>
                    <Card.Text>
                      <div>
                        <Link to="/custlogin" className="nav-link">
                          Login NetBanking
                        </Link>
                      </div>
                    </Card.Text>
                  </Card.Body>
              </Card>
          </div>
          <div className="register-button">
          <Card className="registerbox">
                <Card.Body>
                  <Card.Title>New To NetBanking?</Card.Title>
                  <Card.Text>
                    <div>
                      <Link
                        to="/custRegister"
                        className="nav-link text-justify"
                      >
                        Register Here
                      </Link>
                    </div>
                  </Card.Text>
                </Card.Body>
              </Card> 
          </div>
          <div className="right-img">
                <img src="https://e-registration.bhic.com.my/eregistration/sysbootstrap/landing/img/gif/gif7.gif" 
                alt="img" />

              </div>
         </div>
        
      </Container>
    );
  }
}
export default Welcome;
