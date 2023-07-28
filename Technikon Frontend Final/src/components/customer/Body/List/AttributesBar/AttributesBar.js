import Attribute from "./Attribute/Attribute";
import "./AttributesBar.css";

const AttributesBar = () => {
    return(
        <div className="attributesBar">
            <Attribute attribute = {"Name"}/>
            <Attribute attribute = {"Last Name"}/>
            <Attribute attribute = {"User Name"}/>
            <Attribute attribute = {"Email"}/>
            <Attribute attribute = {"Phone"}/>
            <Attribute attribute = {"Actions"}/>
        </div>
    );
}

export default AttributesBar;