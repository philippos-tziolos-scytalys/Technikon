import React, {useState} from "react";
import "./CreateItem.css";
import axios from 'axios';
import CreateUser from '../../../../../access/Register'

const CreateItem = () => {
    const [showModal, setShowModal] = useState(false);
    const toggleModal = () => {
      setShowModal((show) => !show);
    };

    const createUser = async (fields) => {
        await axios.post(fields);
        toggleModal();
    }

    return(
        <>
        <div className="createItemLabel" onClick={toggleModal}>
            <div className="createItem">
                Create User
            </div>
            <img src={require('../../assets/plus.svg').default}/>
        </div>
        <CreateUser 
            showModal={showModal}
            toggleModal={toggleModal}
            createUser={createUser} 
            />
        </>
    );
}

export default CreateItem;