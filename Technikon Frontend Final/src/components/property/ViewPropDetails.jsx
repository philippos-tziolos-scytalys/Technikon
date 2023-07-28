import axios from "axios";
import React, { useEffect, useState } from "react";
import { Modal, Button } from 'react-bootstrap';


export default function ViewPropDetails ({ showModal, toggleModal, propertyId }) {

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
          roles: []
        },
      });

  useEffect(() => {
    if (propertyId) {
      loadProperty();
    }
  }, [propertyId]);

  const loadProperty = async () => {
    try {
      const result = await axios.get(`http://localhost:8080/api/property/search/${propertyId}`);
      setProperty(result.data);
    } catch (error) {
      console.error("Error fetching user data:", error);
    }
  };

  return (
    <>
    <Modal className='modal' show={showModal} onHide={toggleModal}>
      <Modal.Header closeButton>
      <Modal.Title>Property Details</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <div className="container">
          <div className="row">
              <h2 className="text-center m-4">Property Details</h2>

              <div className="card">
            <div className="card-header">
              Property ID : {property.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Property Identification Number: </b>
                  {property.pinNumber}
                </li>
                <li className="list-group-item">
                  <b>Address: </b>
                  {property.address}
                </li>
                <li className="list-group-item">
                  <b>Year of construction: </b>
                  {property.yearOfConstruction}
                </li>
                <li className="list-group-item">
                  <b>Type of property: </b>
                  {property.propertyType}
                </li>
                <li className="list-group-item">
                  <b>Picture Url: </b>
                  {property.propertyPictureUrl}
                </li>
                <li className="list-group-item">
                  <b>Map Location: </b>
                  {property.propertyCoordinatesLong}
                </li>
                <li className="list-group-item">
                  <b>Map Location: </b>
                  {property.propertyCoordinatesLat}
                </li>
                <li className="list-group-item">
                  <b>Active State </b>
                  {property.activeState ? "Available" : "Unavailable"}
                </li>
                <li className="list-group-item">
                  <b>Property Owner: </b>
                  {property.user.name} {property.user.lastname} ({property.user.tinNumber})
                </li>

              </ul>
            </div>
          </div>
          </div>
        </div>
    </Modal.Body>
    <Modal.Footer>
    <Button className='btn btn-primary mt-3' onClick={toggleModal}>Back home</Button>
    </Modal.Footer>
    </Modal>
    </>
  );
}