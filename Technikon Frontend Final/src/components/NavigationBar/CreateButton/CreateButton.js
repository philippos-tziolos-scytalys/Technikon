import "./CreateButton.css";
import {Button} from 'react-bootstrap';
import React, {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Register from '../../../access/Register';

const CreateButton = () => {
    const [showModal, setShowModal] = useState(false);
    const toggleModal = () => {
      setShowModal((show) => !show);
    };

    const register = async (fields) => {
        await axios.post(fields);
        toggleModal();
      };




    return(
        <div className="dropdown">
            <button className="dropdownButton">
                <img class="plusIcon" src={require('../assets/plus.svg').default}/>
                <div>Create user</div>
            </button>
            <div className="dropdownContent">
                <a id="up" href="#">Create admin</a>
                <Button id="down" onClick={toggleModal}>Create customer</Button>
                <Register
                showModal={showModal}
                toggleModal={toggleModal}
                register={register}
                />
            </div>
        </div>
    );

}

export default CreateButton;


<button class="btn btn-outline-secondary" type="submit">Create User</button>
