import Value from "./Value/Value";
import React, { useState } from "react";
import axios from "axios";
import "./Tuple.css";
import ViewPropDetails from "../../../ViewPropDetails";
import UpdatePropDetails from "../../../UpdatePropDetails";

// Same imports and Value component

const PropertyTuple = (props) => {
  console.log("Value Rendered");
  const [showViewPropDetailsModal, setShowViewPropDetailsModal] = useState(false);
  const [showUpdateDetailsModal, setShowUpdateDetailsModal] = useState(false);
  const [selectedPropertyId, setSelectedPropertyId] = useState(null);

  const toggleViewPropDetailsModal = (propertyId) => {
    setSelectedPropertyId(propertyId);
    setShowViewPropDetailsModal((show) => !show);
  };

  const toggleUpdateDetailsModal = (propertyId) => {
  setSelectedPropertyId(propertyId);
  setShowUpdateDetailsModal((show) => !show);
  };

  const deleteProperty = async (propertyId) => {
    try {
      await axios.delete(`http://localhost:8080/api/property/delete/${propertyId}`);
      // Reload the page after successful deletion
      window.location.reload();
    } catch (error) {
      // Handle the error if the deletion fails
      console.error("Error deleting property:", error);
    }
  };

  console.log("Tuple Rendered");
  console.log("Value Component: ", Value);


  return (
    <div className="tupleBar">
      <div className="tuple">
        <Value value={props.pinNumber} />
        <Value value={props.address} />
        <Value value={props.yearOfConstruction} />
        {/* <Value value={props.propertyType} /> */}
        <Value value={props.propertyPictureUrl} />
        {/* <Value value={props.propertyCoordinatesLong} />
        <Value value={props.propertyCoordinatesLat} /> */}
        <Value value={props.user} />
        <Value value={props.activeState ? "Available" : "Unavailable"} style={{ color: props.activeState ? "green" : "red" }} />
        <Value
          value={
            <div className="actions">
              <img
                src={require("../../assets/eye_on.svg").default}
                onClick={() => toggleViewPropDetailsModal(props.id)}
              />
              <img
                src={require("../../assets/edit.svg").default}
                onClick={() => toggleUpdateDetailsModal(props.id)}
              />
              <img
                src={require("../../assets/delete.svg").default}
                onClick={() => deleteProperty(props.id)}
              />

              {/* Separate state for each modal */}
              {selectedPropertyId && (
                <ViewPropDetails
                  showModal={showViewPropDetailsModal}
                  toggleModal={() => setShowViewPropDetailsModal(false)}
                  propertyId={selectedPropertyId}
                />
              )}

              {selectedPropertyId && (
                <UpdatePropDetails
                  showModal={showUpdateDetailsModal}
                  toggleModal={() => setShowUpdateDetailsModal(false)}
                  propertyId={selectedPropertyId}
                />
              )}
            </div>
          }
        />
      </div>
    </div>
  );
};

export default PropertyTuple;
