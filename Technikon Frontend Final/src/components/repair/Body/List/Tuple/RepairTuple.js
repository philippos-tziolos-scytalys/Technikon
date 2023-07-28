import Value from "./Value/Value";
import React, { useState } from "react";
import axios from "axios";
import "./Tuple.css";
import ViewRepDetails from "../../../ViewRepDetails";
import UpdateRepDetails from "../../../UpdateRepDetails";

// Same imports and Value component

const RepairTuple = (props) => {
  console.log("Value Rendered");
  const [showViewRepDetailsModal, setShowViewRepDetailsModal] = useState(false);
  const [showUpdateDetailsModal, setShowUpdateDetailsModal] = useState(false);
  const [selectedRepairId, setSelectedRepairId] = useState(null);

  const toggleViewPropDetailsModal = (repairId) => {
    setSelectedRepairId(repairId);
    setShowViewRepDetailsModal((show) => !show);
  };

  const toggleUpdateDetailsModal = (repairId) => {
    setSelectedRepairId(repairId);
  setShowUpdateDetailsModal((show) => !show);
  };

  const deleteProperty = async (repairId) => {
    try {
      await axios.delete(`http://localhost:8080/api/repairs/delete/${repairId}`);
      // Reload the page after successful deletion
      window.location.reload();
    } catch (error) {
      // Handle the error if the deletion fails
      console.error("Error deleting property:", error);
    }
  };

  console.log("Tuple Rendered");
  console.log("Value Component: ", Value);


  const formattedRepairDate = new Date(props.repairDate).toLocaleDateString('en-GB');
  const formattedCost = `${props.cost} €`;

  return (
    <div className="tupleBar">
      <div className="tuple">
        <Value value={props.repairType} />
        <Value value={props.repairStatus} />
        <Value value={formattedRepairDate} />
        <Value value={formattedCost} />
        <Value value={props.property} />
        <Value value={props.customer} />
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
              {selectedRepairId && (
                <ViewRepDetails
                  showModal={showViewRepDetailsModal}
                  toggleModal={() => setShowViewRepDetailsModal(false)}
                  repairId={selectedRepairId}
                />
              )}

              {selectedRepairId && (
                <UpdateRepDetails
                  showModal={showUpdateDetailsModal}
                  toggleModal={() => setShowUpdateDetailsModal(false)}
                  repairId={selectedRepairId}
                />
              )}
            </div>
          }
        />
      </div>
    </div>
  );
};

export default RepairTuple;
