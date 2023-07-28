import Attribute from "./Attribute/Attribute";
import "./AttributesBar.css";

const AttributesBar = () => {
    return(
        <div className="attributesBar">
            <Attribute attribute = {"Report date"}/>
            <Attribute attribute = {"Report type"}/>
            <Attribute attribute = {"Report Description"}/>
            <Attribute attribute = {"Report customer"}/>
            <Attribute attribute = {"Actions"}/>
        </div>
    );
}

export default AttributesBar;