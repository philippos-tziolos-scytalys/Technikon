import Value from "./Value/Value";
import React, { useState } from "react";
import axios from "axios";
import "./Tuple.css";
import ViewCustDetails from "../../../ViewCustDetails";
import UpdateCustDetails from "../../../UpdateCustDetails";

// Same imports and Value component

const CustomerTuple = (props) => {
  const [showViewDetailsModal, setShowViewDetailsModal] = useState(false);
  const [showUpdateDetailsModal, setShowUpdateDetailsModal] = useState(false);
  const [selectedUserId, setSelectedUserId] = useState(null);

  const toggleViewDetailsModal = (userId) => {
    setSelectedUserId(userId);
    setShowViewDetailsModal((show) => !show);
  };

  const toggleUpdateDetailsModal = (userId) => {
    setSelectedUserId(userId);
    setShowUpdateDetailsModal((show) => !show);
  };

  const deleteUser = async (userId) => {
    try {
      await axios.delete(`http://localhost:8080/api/users/delete/${userId}`);
      // Reload the page after successful deletion
      window.location.reload();
    } catch (error) {
      // Handle the error if the deletion fails
      console.error("Error deleting user:", error);
    }
  };

  console.log("Tuple Rendered");

  return (
    <div className="tupleBar">
      <div className="tuple">
        <Value
          value={
            <div style={{ display: "flex", alignItems: "center", gap: "12px" }}>
              {props.photo}
              {props.name}
            </div>
          }
        />
  
        <Value value={props.lastname} />
        <Value value={props.username} />
        <Value value={props.email} />
        <Value value={props.phoneNumber} />
        <Value
          value={
            <div className="actions">
              <img
                src={require("../../assets/eye_on.svg").default}
                onClick={() => toggleViewDetailsModal(props.id)}
              />
              <img
                src={require("../../assets/edit.svg").default}
                onClick={() => toggleUpdateDetailsModal(props.id)}
              />
              <img
                src={require("../../assets/delete.svg").default}
                onClick={() => deleteUser(props.id)}
              />

              {/* Separate state for each modal */}
              {selectedUserId && (
                <ViewCustDetails
                  showModal={showViewDetailsModal}
                  toggleModal={() => setShowViewDetailsModal(false)}
                  userId={selectedUserId}
                />
              )}

              {selectedUserId && (
                <UpdateCustDetails
                  showModal={showUpdateDetailsModal}
                  toggleModal={() => setShowUpdateDetailsModal(false)}
                  userId={selectedUserId}
                />
              )}
            </div>
          }
        />
      </div>
    </div>
  );
};

export default CustomerTuple;
