import { useEffect, useState } from 'react';
import AttributesBar from "./AttributesBar/AttributesBar";
import Tuple from "./Tuple/CustomerTuple";

const List = () => {
    const [users, setUsers] = useState([]);
      

    useEffect(() => {
        fetch("http://localhost:8080/api/users/allusers")
        .then(response => response.json())
        .then(data => setUsers(data))
    }, [])


    return(
        <div className="list">
            <AttributesBar/>
            {
                users.map(user => 
                <Tuple
                    id = {user.id}
                    photo = {<img src={require("../assets/plus.svg").default}/>}
                    username = {user.username}
                    name = {user.name}
                    lastname = {user.lastname}
                    email = {user.email}
                    phoneNumber = {user.phoneNumber}
                    dateCreated = {user.dateCreated}
                    dateEdited = {user.dateEdited}
                />)
            }
        </div>
        
        
    );
}

export default List;