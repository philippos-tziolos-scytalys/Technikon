import React, {useState} from "react";
import "./CreateItem.css";
import axios from 'axios';
import CreateRepair from '../../../CreateRepair'

const CreateItem = () => {
    const [showModal, setShowModal] = useState(false);
    const toggleModal = () => {
      setShowModal((show) => !show);
    };
    
    const createRepair = async (fields) => {
        await axios.post(fields);
        toggleModal();
    }
    return(
    <>
        <div className="createItemLabel" onClick={toggleModal}>
            <div className="createItem">
                Create Repair
            </div>
            <img src={require('../../assets/plus.svg').default}
            />
        </div>
        <CreateRepair
            showModal={showModal}
            toggleModal={toggleModal}
            CreateRepair={createRepair}
        />
    </>
    );
}

export default CreateItem;