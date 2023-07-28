import Attribute from "./Attribute/Attribute";
import "./AttributesBar.css";

const AttributesBar = () => {
    return(
        <div className="attributesBar">
            <Attribute attribute = {"PIN Number"}/>
            <Attribute attribute = {"Address"}/>
            <Attribute attribute = {"Year of Constr."}/>
            <Attribute attribute = {"Image URL"}/>
            <Attribute attribute = {"Owner"}/>
            <Attribute attribute = {"Availability"}/>
            <Attribute attribute = {"Actions"}/>
        </div>
    );
}

export default AttributesBar;