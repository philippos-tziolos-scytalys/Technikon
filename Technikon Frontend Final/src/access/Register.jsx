import './Register.css';
import React, {useState} from 'react';
import {Modal, Form, Button, Row, Col} from 'react-bootstrap';
import axios from "axios";

import PhoneInput from 'react-phone-input-2';
import 'react-phone-input-2/lib/style.css';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Register = ({showModal, toggleModal}) => {

  const [user,setUser]=useState({
    tinNumber:"",
    name:"",
    lastname:"",
    username:"",
    email:"",
    password:"",
    address:"",
    phoneNumber:""
})

const{tinNumber, name, lastname, username, email, password, address, phoneNumber}=user;

const onInputChange = (e) => {
  const { name, value } = e.target;
  setUser((prevState) => ({
    ...prevState,
    [name]: name === 'phoneNumber' ? value.replace(/\D/g, '') : value,
  }));
};
const onPhoneInputChange = (phoneNumber, country, e, formattedValue) => {
  const phoneEvent = {
    target: {
      name: "phoneNumber",
      value: formattedValue,
    },
  };
  onInputChange(phoneEvent);
};


const onClick = async (e) => {
  e.preventDefault();
  console.log("Submitting form...");
  try {
    await axios.post("http://localhost:8080/api/auth/register", user);
    toast.success('Registration successful!');
    toggleModal();
    window.location.reload();
  } catch (error) {
    if (error.response.status === 500) {
      // alert("Username, email, or tin number already exists");
      toast.error('Username, email, or tin number already exists');
    } else {
      alert("An error occurred. Please try again.");
    }
  }
};
  return (
    <div classname="register">
    <Modal className='modal' show={showModal} onHide={toggleModal}>
      <Modal.Header closeButton>
        <Modal.Title>Create Customer</Modal.Title>
      </Modal.Header>
      <Modal.Body>
          <Form className='modal-form'>

            <Row>
                <Form.Group controlId="name">
                  <Form.Label>First name</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Name: e.g. John"
                    value={name}
                    name="name"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
            </Row>
            <Row>
                <Form.Group controlId="lastname">
                  <Form.Label>Last Name</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Last Name: e.g. Williams"
                    value={lastname}
                    name="lastname"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
            </Row>
            <Row>
              <Form.Group controlId="phone">
                <Form.Label>Phone number</Form.Label>
                <PhoneInput
                  placeholder='e.g. 0123456789'
                  country={'gr'}
                  value={phoneNumber}
                  onChange={(phoneNumber, country, e, formattedValue) => onPhoneInputChange(phoneNumber, country, e, formattedValue)}
                />
              </Form.Group>
            </Row>
            <Row>
                <Form.Group controlId="address">
                  <Form.Label>Address</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="e.g. Example street 123, Athens, Greece"
                    value={address}
                    name="address"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
            </Row>
            <Row>
              <Col sm={6}>
                <Form.Group controlId="email">
                  <Form.Label>Email</Form.Label>
                  <Form.Control
                    type="email"
                    placeholder="Email"
                    value={email}
                    name="email"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
              </Col>
              <Col sm={6}>
                <Form.Group controlId="tinNumber">
                  <Form.Label>TIN number</Form.Label>
                  <Form.Control
                    type={"number"}
                    placeholder="TIN"
                    value={tinNumber}
                    name="tinNumber"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
              </Col>
            </Row>
            <Row>
                <Form.Group controlId="username">
                  <Form.Label>Username</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Customer's username"
                    value={username}
                    name="username"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
            </Row>
            <Row>
                <Form.Group controlId="usePassword">
                  <Form.Label>Customer's password</Form.Label>
                  <Form.Control
                    type="password"
                    placeholder="Customer's password"
                    value={password}
                    name="password"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
            </Row>
          </Form>
        </Modal.Body>
      <Modal.Footer>
        <div className='button-container' type='submit'>
            <Button className='btn btn-primary'  onClick={(e)=>onClick(e)}>Create account</Button>
            <ToastContainer />
            <Button className='btn btn-secondary' onClick={toggleModal}>Cancel</Button>
        </div>
      </Modal.Footer>
    </Modal>
    </div>
  );
}
export default Register;
