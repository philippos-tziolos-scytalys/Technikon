import axios from "axios";
import React, { useEffect, useState } from "react";
import { Modal, Form, Button, Row } from 'react-bootstrap';

export default function UpdateCustDetails({ showModal, toggleModal, reportId }) {

  const [report, setReport] = useState({
    id: "",
    reportDate: "",
    reportType: "",
    reportDescription: "",
    user: {
      id: "",
      tinNumber: ""
    },
  });


  const { 
    reportDate, 
    reportType, 
    reportDescription, 
    user } = report;

    const onInputChange = (e) => {
        const { name, value } = e.target;
        setReport((prevState) => ({
          ...prevState,
          [name]: value,
        }));
      };

  
  useEffect(() => {
    if (reportId) {
      loadReport();
    }
  }, [reportId]);

  const onClick = async (e) => {
    e.preventDefault();
    console.log("Submitting form...");
    try {
      await axios.put(`http://localhost:8080/api/reports/update/${reportId}`, report);
      toggleModal();
      window.location.reload();
      console.log("Property successfully updated!");
    } catch (error) {
      if (error.response.status === 500) {
        alert("An error occurred. Please try again.");
      } else {
        alert("An error occurred. Please try again.");
      }
    }
  };
  

  const loadReport = async () => {
    try {
      const result = await axios.get(`http://localhost:8080/api/reports/search/${reportId}`);
      setReport(result.data);
    } catch (error) {
      console.error("Error fetching user data:", error);
    }
  };
  return (
    <>
      <Modal className='modal' show={showModal} onHide={toggleModal}>
      <Modal.Header closeButton>
      <Modal.Title>Report Details</Modal.Title>
      </Modal.Header>
      <Modal.Body>
      <Form className='modal-form'>

              <Row>
                  <Form.Group controlId="reportDate">
                    <Form.Label>Report Date</Form.Label>
                    <Form.Control
                      type="date"
                      placeholder="PIN: e.g. 1999-11-09"
                      value={reportDate}
                      name="reportDate"
                      onChange={(e) => onInputChange(e)}
                    />
                  </Form.Group>
              </Row>
              <Row>
                  <Form.Group controlId="reportType">
                      <Form.Label>Type of report</Form.Label>
                      <select
                      className="form-control"
                      id="reportType"
                      name="reportType"
                      value={reportType}
                      onChange={(e) => onInputChange(e)}
                      >
                      <option value="">Select type of report</option>
                      <option value="USER_REGISTRATION">USER REGISTRATION</option>
                      <option value="USER_UPDATE">USER UPDATE</option>
                      <option value="USER_DELETION">USER DELETION</option>
                      <option value="USER_LOGIN">USER LOGIN</option>
                      <option value="PROPERTY_REGISTRATION">PROPERTY REGISTRATION</option>
                      <option value="PROPERTY_UPDATE">PROPERTY UPDATE</option>
                      <option value="PROPERTY_DELETION">PROPERTY DELETION</option>
                      <option value="REPAIR_REGISTRATION">REPAIR REGISTRATION</option>
                      <option value="REPAIR_UPDATE">REPAIR UPDATE</option>
                      <option value="REPAIR_DELETION">REPAIR DELETION</option>
                      </select>
                  </Form.Group>
              </Row>
              <Row>
                <Form.Group controlId="reportDescription">
                  <Form.Label>Description</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="enter a description"
                    value={reportDescription}
                    name="reportDescription"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
              </Row>
              <Row>
                <Form.Group controlId="user">
                  <Form.Label>Report Owner</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="e.g. tin number: 00000"
                    value={user.tinNumber}
                    name="user"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
              </Row>
        </Form>
    </Modal.Body>
    <Modal.Footer>
          <div className='button-container' type='submit'>
            <Button className='btn btn-primary' onClick={(e) => onClick(e)}>Update account</Button>
            <Button className='btn btn-secondary' onClick={toggleModal}>Cancel</Button>
          </div>
        </Modal.Footer>
  </Modal>
  </>
  );
}