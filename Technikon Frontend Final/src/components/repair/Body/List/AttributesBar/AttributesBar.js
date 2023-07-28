import Attribute from "./Attribute/Attribute";
import "./AttributesBar.css";

const AttributesBar = () => {
    return(
        <div className="attributesBar">
            <Attribute attribute = {"Repair type"}/>
            <Attribute attribute = {"Repair status"}/>
            <Attribute attribute = {"Reapir date"}/>
            <Attribute attribute = {"Repair cost"}/>
            <Attribute attribute = {"Property PIN"}/>
            <Attribute attribute = {"Customer TIN"}/>
            <Attribute attribute = {"Actions"}/>
        </div>
    );
}

export default AttributesBar;