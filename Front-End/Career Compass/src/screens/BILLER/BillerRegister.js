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

function BillerRegister() {
  const [billerName, setBillerName] = useState("");
  const [consumerNumber, setConsumerNumber] = useState("");
  const [registry] = useState("");

  const handleClick = (e) => {
    e.preventDefault();
    const customer = { billerName, consumerNumber };
    console.log(registry);
    fetch("http://localhost:8080/ebanking/registry/register/", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(customer),
    }).then(() => {
      alert("Biller Registered Succesfully. go to Biller Provider Page...");
    });
  };

  return (
    <div className="biller-registry-body">
      <Container className="registry">
        <Navbar bg="dark" variant="dark">
          <Container>
            <Navbar.Brand href="#">BILLER REGISTER</Navbar.Brand>
            <br></br>
          </Container>
        </Navbar>
        <div className="registry-field">
          <Box className="biller-Select">
            <FormControl variant="filled" fullWidth>
              <InputLabel>Billers</InputLabel>
              <Select
                labelId="demo-simple-select-filled-label"
                id="demo-simple-select-filled"
                fullWidth
                value={billerName}
                onChange={(e) => setBillerName(e.target.value)}
              >
                <MenuItem value="">
                  <em>None</em>
                </MenuItem>
                <MenuItem value={"Airtel"}>Airtel</MenuItem>
                <MenuItem value={"Jio"}>Jio</MenuItem>
                <MenuItem value={"Vi"}>Vi</MenuItem>
              </Select>
            </FormControl>
          </Box>
          <Box id="cons-number">
            <TextField
              required
              label="Consumer Number"
              defaultValue=""
              placeholder="mob or cons number"
              value={consumerNumber}
              onChange={(e) => setConsumerNumber(e.target.value)}
            />
          </Box>
          <br></br>
          <Button variant="contained" onClick={handleClick} className="myButton">
            Register
          </Button>
          <br></br>
        </div>
      </Container>
    </div>
  );
}

export default BillerRegister;
