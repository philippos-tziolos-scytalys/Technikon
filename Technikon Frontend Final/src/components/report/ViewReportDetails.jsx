import axios from "axios";
import React, { useEffect, useState } from "react";
import { Modal, Button } from 'react-bootstrap';


export default function ViewPropDetails ({ showModal, toggleModal, reportId }) {

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

  useEffect(() => {
    if (reportId) {
      loadReport();
    }
  }, [reportId]);

  const loadReport = async () => {
    try {
      const result = await axios.get(`http://localhost:8080/api/reports/search/${reportId}`);
      setReport(result.data);
    } catch (error) {
      console.error("Error fetching user data:", error);
    }
  };

  return (
    <>
    <Modal className='modal' show={showModal} onHide={toggleModal}>
      <Modal.Header closeButton>
      <Modal.Title>Report Details</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <div className="container">
          <div className="row">
              <h2 className="text-center m-4">Report Details</h2>

              <div className="card">
            <div className="card-header">
              Property ID : {report.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Report Date: </b>
                  {report.reportDate}
                </li>
                <li className="list-group-item">
                  <b>Type of report: </b>
                  {report.reportType}
                </li>
                <li className="list-group-item">
                  <b> Description: </b>
                  {report.reportDescription}
                </li>
                <li className="list-group-item">
                  <b>Report for owner: </b>
                  {report.user.name} {report.user.lastname} ({report.user.tinNumber})
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