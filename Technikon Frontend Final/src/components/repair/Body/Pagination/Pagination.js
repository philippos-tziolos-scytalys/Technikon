import { useState } from "react";
import "./Pagination.css";

const Pagination = () => {
    const [active, setActive] = useState(1);

    const max = 25;
    const pages = [...Array(max).keys()].map(i => i+1);

    const increment = () => {
        if (active<25){
            setActive(active+1);
        }
    }
    
    const decrement = () => {
        if (active>1){
            setActive(active-1);
        }
    }
    
    const changeNumber = (i) => {
        setActive(i)

    }

    const showNumbers = () => {
        if (active <= 2){
            return [pages[0], pages[1], pages[2], pages[3], pages[4]];
        }
        else if (active >= max-2) {
            return [pages[max-5], pages[max-4], pages[max-3], pages[max-2], pages[max-1]];
        } 
        else {
            return [pages[active-3], pages[active-2], pages[active-1], pages[active], pages[active+1]];
        }
    }

    return(
        <div className="paginationBar">
            <div className="pagination">
                <div className="pagel" onClick={decrement}>
                    <img src={require('../assets/left.svg').default}/>
                    Prev
                </div>
                {showNumbers().map(i => <div className="pagel" id={i === active ? "active" : "inactive"} onClick={() => changeNumber(i)}> {i} </div>)}
                <div className="pagel" onClick={increment}>
                    Next
                    <img src={require('../assets/right.svg').default}/>
                </div>
            </div>
        </div>
    );
}

export default Pagination;