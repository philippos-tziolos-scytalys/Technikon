import { useEffect, useState } from 'react';
import AttributesBar from "./AttributesBar/AttributesBar";
import Tuple from "./Tuple/PropertyTuple";

const List = () => {
    const [properties, setProperties] = useState([]);
      

    useEffect(() => {
        fetch("http://localhost:8080/api/property/allproperties")
        .then(response => response.json())
        .then(data => setProperties(data))
    }, [])


    return(
        <div className="list">
            <AttributesBar/>
            {
                properties.map(property => 
                <Tuple
                    id = {property.id}
                    pinNumber = {property.pinNumber}
                    address = {property.address}
                    yearOfConstruction = {property.yearOfConstruction}
                    propertyType = {property.propertyType}
                    propertyPictureUrl = {property.propertyPictureUrl}
                    propertyCoordinatesLong = {property.propertyCoordinatesLong}
                    propertyCoordinatesLat = {property.propertyCoordinatesLat}
                    activeState = {property.activeState}
                    user = {property.user.tinNumber}
                />)
            }
        </div>
        
        
    );
}

export default List;