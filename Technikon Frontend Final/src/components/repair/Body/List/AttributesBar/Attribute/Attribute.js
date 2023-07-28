import "./Attribute.css";

const Attribute = (props) => {

    return(
        <a className="attribute" href="#">
            <div >{props.attribute}</div>
        </a>
    );
}

export default Attribute;