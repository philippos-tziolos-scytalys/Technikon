import axios from "axios";
import React, { useEffect, useState } from "react";
import { Modal, Form, Button, Row } from "react-bootstrap";

export default function UpdateCustDetails({
  showModal,
  toggleModal,
  repairId,
}) {
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
      address: "",
      user: {
        id: "",
        tinNumber: "",
        name: "",
        lastname: "",
      },
    },
  });

  const { repairType, repairStatus, description, repairDate, cost, property } =
    repair;

  const onInputChange = (e) => {
    const { name, value } = e.target;
    setRepair((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  useEffect(() => {
    if (repairId) {
      loadRepair();
    }
  }, [repairId]);

  const onClick = async (e) => {
    e.preventDefault();
    console.log("Submitting form...");
    try {
      await axios.put(
        `http://localhost:8080/api/repairs/update/${repairId}`,
        repair
      );
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

  const loadRepair = async () => {
    try {
      const result = await axios.get(
        `http://localhost:8080/api/repairs/search/${repairId}`
      );
      setRepair(result.data);
    } catch (error) {
      console.error("Error fetching user data:", error);
    }
  };
  return (
    <>
      <Modal className="modal" show={showModal} onHide={toggleModal}>
        <Modal.Header closeButton>
          <Modal.Title>Update Repair Details</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form className="modal-form">
            <Row>
              <Form.Group controlId="repairType">
                <Form.Label>Type of repair</Form.Label>
                <select
                  className="form-control"
                  id="repairType"
                  name="repairType"
                  value={repairType}
                  onChange={(e) => onInputChange(e)}
                >
                  <option value="">Select type of repair</option>
                  <option value="PAINTING">Painting</option>
                  <option value="INSULATION">Insulation</option>
                  <option value="FRAMES">Frames</option>
                  <option value="PLUMBING">Plumbing</option>
                  <option value="ELECTRICAL_WORK">Electrical Work</option>
                </select>
              </Form.Group>
            </Row>
            <Row>
              <Form.Group controlId="repairStatus">
                <Form.Label>Repair Status</Form.Label>
                <select
                  className="form-control"
                  id="repairStatus"
                  name="repairStatus"
                  value={repairStatus}
                  onChange={(e) => onInputChange(e)}
                >
                  <option value="">Select repair status</option>
                  <option value="PENDING">Pending</option>
                  <option value="SCHEDULED">Scheduled</option>
                  <option value="IN_PROGRESS">In Progress</option>
                  <option value="COMPLETED">Completed</option>
                </select>
              </Form.Group>
            </Row>
            <Row>
              <Form.Group controlId="description">
                <Form.Label>Description</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Enter a description"
                  value={description}
                  name="description"
                  onChange={(e) => onInputChange(e)}
                />
              </Form.Group>
            </Row>

            <Row>
              <Form.Group controlId="repairDate">
                <Form.Label>Pick a date</Form.Label>
                <Form.Control
                  type="date"
                  placeholder="e.g. MM/DD/YYYY"
                  value={repairDate}
                  name="repairDate"
                  onChange={(e) => onInputChange(e)}
                />
              </Form.Group>
            </Row>
            <Row>
              <Form.Group controlId="cost">
                <Form.Label>Enter a cost</Form.Label>
                <Form.Control
                  type="number"
                  placeholder="Enter a cost"
                  value={cost}
                  name="cost"
                  onChange={(e) => onInputChange(e)}
                />
              </Form.Group>
            </Row>
            <Row>
              <Form.Group controlId="property">
                <Form.Label>Property Identification Number</Form.Label>
                <Form.Control
                  type="number"
                  placeholder="e.g. tin number: 00000"
                  value={property.pinNumber}
                  name="property.pinNumber"
                  onChange={(e) => onInputChange(e)}
                />
              </Form.Group>
            </Row>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <div className="button-container" type="submit">
            <Button className="btn btn-primary" onClick={(e) => onClick(e)}>
              Update repair
            </Button>
            <Button className="btn btn-secondary" onClick={toggleModal}>
              Cancel
            </Button>
          </div>
        </Modal.Footer>
      </Modal>
    </>
  );
}
