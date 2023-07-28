import React, {useState} from "react";
import "./CreateItem.css";
import axios from 'axios';
import CreateReport from '../../../CreateReport'

const CreateItem = () => {
    const [showModal, setShowModal] = useState(false);
    const toggleModal = () => {
      setShowModal((show) => !show);
    };
    
    const createReport = async (fields) => {
        await axios.post(fields);
        toggleModal();
    }
    return(
    <>
        <div className="createItemLabel" onClick={toggleModal}>
            <div className="createItem">
                Create Report
            </div>
            <img src={require('../../assets/plus.svg').default}
            />
        </div>
        <CreateReport
            showModal={showModal}
            toggleModal={toggleModal}
            CreateReport={createReport}
        />
    </>
    );
}

export default CreateItem;