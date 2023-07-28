import axios from "axios";
import React, { useEffect, useState } from "react";
import { Modal, Button } from 'react-bootstrap';


export default function ViewPropDetails ({ showModal, toggleModal, repairId }) {

  const [repair, setRepair] = useState({
    id: "",
    repairType: "",
    repairStatus: "",
    description: "",
    repairDate: "",
    cost: "",
    property: {
      id: "",
      pinNumber: "",
      address:"",
        user: {
            id: "",
            tinNumber: "",
            name: "",
            lastname:""
        },
        },
  });


  useEffect(() => {
    if (repairId) {
      loadRepair();
    }
  }, [repairId]);

  const loadRepair = async () => {
    try {
      const result = await axios.get(`http://localhost:8080/api/repairs/search/${repairId}`);
      setRepair(result.data);
    } catch (error) {
      console.error("Error fetching user data:", error);
    }
  };

  return (
    <>
    <Modal className='modal' show={showModal} onHide={toggleModal}>
      <Modal.Header closeButton>
      <Modal.Title>Repair Details</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <div className="container">
          <div className="row">
              <h2 className="text-center m-4">Repair Details</h2>

              <div className="card">
            <div className="card-header">
              Repair ID : {repair.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Type of repair: </b>
                  {repair.repairType}
                </li>
                <li className="list-group-item">
                  <b>Repair Status: </b>
                  {repair.repairStatus}
                </li>
                <li className="list-group-item">
                  <b>Description: </b>
                  {repair.description}
                </li>
                <li className="list-group-item">
                  <b>Pick a date: </b>
                  {repair.repairDate}
                </li>
                <li className="list-group-item">
                  <b>Address for Repair: </b>
                  {repair.property.address}
                </li>
                <li className="list-group-item">
                  <b>Property ID for Repair: </b>
                  {repair.property.pinNumber}
                </li>
                <li className="list-group-item">
                  <b>User Property Details: </b>
                  {repair.property.user.name} {repair.property.user.lastname} ({repair.property.user.tinNumber})
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