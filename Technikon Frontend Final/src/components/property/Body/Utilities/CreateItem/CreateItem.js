import React, {useState} from "react";
import "./CreateItem.css";
import axios from 'axios';
import CreatePorperty from '../../../CreateProperty'

const CreateItem = () => {
    const [showModal, setShowModal] = useState(false);
    const toggleModal = () => {
      setShowModal((show) => !show);
    };
    
    const createProperty = async (fields) => {
        await axios.post(fields);
        toggleModal();
    }
    return(
    <>
        <div className="createItemLabel" onClick={toggleModal}>
            <div className="createItem">
                Create Property
            </div>
            <img src={require('../../assets/plus.svg').default}
            />
        </div>
        <CreatePorperty
            showModal={showModal}
            toggleModal={toggleModal}
            createProperty={createProperty}
        />
    </>
    );
}

export default CreateItem;