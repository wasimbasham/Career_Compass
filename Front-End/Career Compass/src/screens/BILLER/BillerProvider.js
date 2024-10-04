import React, { useState } from "react";
// import ReactDOM from 'react-dom';
import "../BILLER/Registry.css";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import TextField from "@material-ui/core/TextField";
import MenuItem from "@material-ui/core/MenuItem";
import InputLabel from "@material-ui/core/InputLabel";
import Select from "@material-ui/core/Select";
import Container from "@material-ui/core/Container";
import FormControl from "@material-ui/core/FormControl";
import { Navbar } from "react-bootstrap";

function BillerProvider(props) {
  const [consumerNumberFk, setConsumerNumberFk] = useState("");
  const cust = JSON.parse(sessionStorage.getItem("customer"));

  const [accNumber, setAccNumber] = useState("");
  const [amount, setAmount] = useState("");
  const [provider] = useState("");

  const handleClick = (e) => {
    e.preventDefault();
    setAccNumber(cust.savingsAccount.accNumber)
    const customer = { consumerNumberFk, accNumber, amount };
    console.log(provider);
    console.log("accnumber"+cust.savingsAccount.accountNumber)
    console.log(JSON.stringify(customer))
    fetch("http://localhost:8080/ebanking/registry/provider/", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(customer),
    }).then(() => {
      alert("Payment Succesfull...");
    });
  };

  return (
    <div className="biller-registry-body">
      <Container className="registry">
        <Navbar bg="dark" variant="dark">
          <Container>
            <Navbar.Brand href="#">BILLER PROVIDER</Navbar.Brand>
          </Container>
        </Navbar>
        <div className="registry-field">
          <Box className="cons-number">
            <TextField
              required
              label="Consumer Number"
              defaultValue=""
              placeholder="mob or cons number"
              value={consumerNumberFk}
              onChange={(e) => setConsumerNumberFk(e.target.value)}
            />
          </Box>
          <Box className="">
            <Box>
                <TextField
                required
                  label="Account Number"
                  placeholder="acc num"
                  value={accNumber}
                  onChange={(e) => setAccNumber(e.target.value)}
                />
            </Box>
          </Box>
          <Box id="cons-number">
            <TextField
              required
              label="Amount"
              defaultValue=""
              placeholder="1000"
              value={amount}
              onChange={(e) => setAmount(e.target.value)}
            />
          </Box>

          <br></br>
          <Button variant="contained" onClick={handleClick} className="myButton">
            Pay
          </Button>
          <br></br>
        </div>
      </Container>
    </div>
  );
}

export default BillerProvider;
