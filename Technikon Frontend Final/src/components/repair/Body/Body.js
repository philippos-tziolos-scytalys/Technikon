import ListName from "./ListName/ListName";
import Utilities from "./Utilities/Utilities";
import List from "./List/List";
import Pagination from "./Pagination/Pagination";
import "./Body.css";

const Body = () => {
    return (
        <div className="body">
            <ListName/>
            <Utilities/>
            <List/>
            <Pagination/>
        </div>
    );
}

export default Body;