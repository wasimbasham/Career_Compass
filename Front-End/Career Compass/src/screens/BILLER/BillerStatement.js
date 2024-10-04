import React, { useState, useEffect } from "react";
import "../BILLER/Registry.css";
import Container from "@material-ui/core/Container";
import Button from "@material-ui/core/Button";
import { Navbar } from "react-bootstrap";
import ReactHTMLTableToExcel from "react-html-table-to-excel";
import jsPDF from "jspdf";

const BillerStatement = () => {
  const [biller_statement, setBiller_statement] = useState([]);

  const DounloadStatementa = () => {
    var doc = new jsPDF("px", "pt", "a3");
    doc.html(document.querySelector("#pdf"), {
      callback: function (pdf) {
        pdf.save("BillerStatement.pdf");
      },
    });
  };

  useEffect(() => {
    fetch("http://localhost:8080/ebanking/registry/statement/", {
      method: "GET",
      headers: { "Content-Type": "application/json" },
    })
      .then((response) => response.json())
      .then((body) => {
        setBiller_statement(body);
      });
  }, []);

  return (
    <div id="pdf" className="state-bdy">
      <Container className="registry">
        <Navbar bg="dark" variant="dark">
          <Container className="statement-head">
            <Navbar.Brand href="#">BILLER STATEMENT</Navbar.Brand>
          </Container>
        </Navbar>
        <div className="state-body">
          <h1>
            <center>Statement</center>
          </h1>
          <table id="statement" className="table table-bordered table-dark">
            <thead className="thead-light">
              <tr>
                <td>Id</td>
                <td> Account No</td>
                <td> Amount</td>
                <td> Type</td>
                <td> Transaction Id</td>
              </tr>
            </thead>

            <tbody>
              {biller_statement.length > 0 ? (
                biller_statement.map((lst) => (
                  <>
                    <tr key={lst.id}>
                      <td>{lst.id}</td>
                      <td> {lst.accNumber}</td>
                      <td> {lst.amount}</td>
                      <td> {lst.type}</td>
                      <td> {lst.transIdFk}</td>
                    </tr>
                  </>
                ))
              ) : (
                <></>
              )}
            </tbody>
          </table>
          <div>
            <ReactHTMLTableToExcel
              className="btn btn-info"
              table="statement"
              filename="ReportExcel"
              sheet="Sheet"
              buttonText="Export excel"
            />
            <Button onClick={DounloadStatementa} className="myButton">
              Export Pdf
            </Button>
          </div>
        </div>
      </Container>
    </div>
  );
};
export default BillerStatement;
