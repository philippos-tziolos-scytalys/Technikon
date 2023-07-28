import Value from "./Value/Value";
import React, { useState } from "react";
import axios from "axios";
import "./Tuple.css";
import ViewReportDetails from "../../../ViewReportDetails";
import UpdateReportDetails from "../../../UpdateReportDetails";

// Same imports and Value component

const RepairTuple = (props) => {
  console.log("Value Rendered");
  const [showViewReportDetailsModal, setShowViewReportDetailsModal] = useState(false);
  const [showUpdateDetailsModal, setShowUpdateDetailsModal] = useState(false);
  const [selectedReportId, setSelectedReportId] = useState(null);

  const toggleViewReportDetailsModal = (reportId) => {
    setSelectedReportId(reportId);
    setShowViewReportDetailsModal((show) => !show);
  };

  const toggleUpdateDetailsModal = (reportId) => {
    setSelectedReportId(reportId);
  setShowUpdateDetailsModal((show) => !show);
  };

  const deleteReport = async (reportId) => {
    try {
      await axios.delete(`http://localhost:8080/api/reports/delete/${reportId}`);
      // Reload the page after successful deletion
      window.location.reload();
    } catch (error) {
      // Handle the error if the deletion fails
      console.error("Error deleting property:", error);
    }
  };

  console.log("Tuple Rendered");
  console.log("Value Component: ", Value);


  const formattedReportDate = new Date(props.reportDate).toLocaleDateString('en-GB');

  return (
    <div className="tupleBar">
      <div className="tuple">
        <Value value={formattedReportDate} />
        <Value value={props.reportType} />
        <Value value={props.description} />
        <Value value={props.user} />
        <Value
          value={
            <div className="actions">
              <img
                src={require("../../assets/eye_on.svg").default}
                onClick={() => toggleViewReportDetailsModal(props.id)}
              />
              <img
                src={require("../../assets/edit.svg").default}
                onClick={() => toggleUpdateDetailsModal(props.id)}
              />
              <img
                src={require("../../assets/delete.svg").default}
                onClick={() => deleteReport(props.id)}
              />

              {/* Separate state for each modal */}
              {selectedReportId && (
                <ViewReportDetails
                  showModal={showViewReportDetailsModal}
                  toggleModal={() => setShowViewReportDetailsModal(false)}
                  reportId={selectedReportId}
                />
              )}

              {selectedReportId && (
                <UpdateReportDetails
                  showModal={showUpdateDetailsModal}
                  toggleModal={() => setShowUpdateDetailsModal(false)}
                  reportId={selectedReportId}
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
