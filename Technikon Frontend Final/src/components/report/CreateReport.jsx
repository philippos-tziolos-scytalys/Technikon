import axios from "axios";
import React, { useState } from "react";
import { Modal, Form, Button, Row } from 'react-bootstrap';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function CreateProperty({showModal, toggleModal}) {

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
            if (e.target.name.startsWith("user")) {
              const nestedField = e.target.name.split(".")[1];
              setReport({
                ...report,
                user: { ...user, [nestedField]: e.target.value },
            });
            } else {
              setReport({ ...report, [e.target.name]: e.target.value });
            }
          };
          
    
      const onClick = async (e) => {
        e.preventDefault();
        console.log("Submitting form...");
        try {
          await axios.post('http://localhost:8080/api/reports/create', report);
          toggleModal();
          window.location.reload();
          toast.success('Property created successfully!');
        } catch (error) {
          if (error.response.status === 500) {
            toast.error('An error occurred. Please try again');
          } else {
            alert("An error occurred. Please try again.");
          }
        }
      };
      
  return (
    <>
      <Modal className='modal' show={showModal} onHide={toggleModal}>
      <Modal.Header closeButton>
      <Modal.Title>Create new report</Modal.Title>
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
    <Form.Label>Report Owner (TIN Number)</Form.Label>
    <Form.Control
      type="number"
      placeholder="e.g. tin number: 00000"
      value={user.tinNumber}
      name="user.tinNumber"
      onChange={(e) => onInputChange(e)}
    />
  </Form.Group>
</Row>
</Form>
    </Modal.Body>
    <Modal.Footer>
          <div className='button-container' type='submit'>
            <Button className='btn btn-primary' onClick={(e) => onClick(e)}>Create</Button>
            <ToastContainer />
            <Button className='btn btn-secondary' onClick={toggleModal}>Cancel</Button>
          </div>
        </Modal.Footer>
  </Modal>
  </>
  )
}

export default CreateProperty