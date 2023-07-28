import axios from "axios";
import React, { useState } from "react";
import { Modal, Form, Button, Row } from 'react-bootstrap';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function CreateProperty({showModal, toggleModal}) {

    const [property, setProperty] = useState({
        id: "",
        pinNumber: "",
        address: "",
        yearOfConstruction: "",
        propertyType: "",
        propertyPictureUrl: "",
        propertyCoordinatesLong: "",
        propertyCoordinatesLat: "",
        activeState: "",
        user: {
          id: "",
          tinNumber: "",
          name: "",
          lastname: "",
          address: "",
          phoneNumber: "",
          username: "",
          email: "",
          password: "",
        },
      });
    
    
      const { 
        pinNumber, 
        address, 
        yearOfConstruction, 
        propertyType, 
        propertyPictureUrl, 
        propertyCoordinatesLong, 
        propertyCoordinatesLat, 
        activeState, 
        user} = property;
    
        const onInputChange = (e) => {
            if (e.target.name.startsWith("user")) {
              const nestedField = e.target.name.split(".")[1];
              setProperty({
                ...property,
                user: { ...user, [nestedField]: e.target.value },
            });
            } else {
              setProperty({ ...property, [e.target.name]: e.target.value });
            }
          };
          
    
      const onClick = async (e) => {
        e.preventDefault();
        console.log("Submitting form...");
        try {
          await axios.post('http://localhost:8080/api/property/create', property);
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
      <Modal.Title>Property Details</Modal.Title>
      </Modal.Header>
      <Modal.Body>
      <Form className='modal-form'>

              <Row>
                  <Form.Group controlId="pinNumber">
                    <Form.Label>Property Identification Number</Form.Label>
                    <Form.Control
                      type="number"
                      placeholder="PIN: e.g. 19991109"
                      value={pinNumber}
                      name="pinNumber"
                      onChange={(e) => onInputChange(e)}
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
                <Form.Group controlId="yearOfConstruction">
                  <Form.Label>Year of construction</Form.Label>
                  <Form.Control
                    type="number"
                    placeholder="e.g. Year 1999"
                    value={yearOfConstruction}
                    name="yearOfConstruction"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
            </Row>
            <Row>
                <Form.Group controlId="propertyType">
                    <Form.Label>Type of property</Form.Label>
                    <select
                    className="form-control"
                    id="propertyType"
                    name="propertyType"
                    value={propertyType}
                    onChange={(e) => onInputChange(e)}
                    >
                <option value=''>Select type of property</option>
                <option value='DETACHED_HOUSE'>Detached House</option>
                <option value='MAISONETTE'>Maisonette</option>
                <option value='APARTMENT_BUILDING'>Apartment Building</option>
                    </select>
                </Form.Group>
            </Row>

                <Row>
                <Form.Group controlId="propertyPictureUrl">
                  <Form.Label>Picture Url</Form.Label>
                  <Form.Control
                    type={"text"}
                    placeholder="e.g. https://cat-picture.com"
                    value={propertyPictureUrl}
                    name="propertyPictureUrl"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
              </Row>
              <Row>
                <Form.Group controlId="propertyCoordinatesLong">
                  <Form.Label>Map Location Long</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="e.g. Long: 999"
                    value={propertyCoordinatesLong}
                    name="propertyCoordinatesLong"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
              </Row>
              <Row>
                <Form.Group controlId="propertyCoordinatesLat">
                  <Form.Label>Map Location Lat</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="e.g. Lat: 999"
                    value={propertyCoordinatesLat}
                    name="propertyCoordinatesLat"
                    onChange={(e) => onInputChange(e)}
                  />
                </Form.Group>
              </Row>
              <Row>
                <Form.Group controlId="activeState">
                  <Form.Label>Active State</Form.Label>
                  <select
                    className="form-control"
                    type="text"
                    placeholder="e.g. active state= true or false"
                    value={activeState}
                    name="activeState"
                    onChange={(e) => onInputChange(e)}
                  >
                <option value=''>Choose availability</option>
                <option value='true'>Available</option>
                <option value='false'>Unavailable</option>
                </select>
                </Form.Group>
              </Row>
              <Row>
                <Form.Group controlId="user">
                  <Form.Label>Property Owner</Form.Label>
                  <Form.Control
                    type="number"
                    placeholder="e.g. tin number: 00000"
                    value={user.id}
                    name="user.id"
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