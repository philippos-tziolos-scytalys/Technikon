import Sort from "./Sort/Sort";
import Filter from "./Filter/Filter";
import Download from "./Download/Download"
import CreateItem from "./CreateItem/CreateItem";
import "./Utilities.css";

const Utilities = () => {
    return(
        <div className="utilities">
            <div className="leftSideUtilities">
                <Filter/>
                <Sort/>
            </div>
            <div className="rightSideUtilities">
                <CreateItem/>
                <Download/>
            </div>
        </div>
    );
}

export default Utilities;