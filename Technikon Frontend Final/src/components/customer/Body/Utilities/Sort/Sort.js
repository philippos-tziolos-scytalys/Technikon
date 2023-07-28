import { useState } from 'react';
import './Sort.css';

const Sort = () => {
    const [sorting, setSorting] = useState("A - Z");

    return(
        <div className="sortBar">
            <div className="sort">
                <button>
                    <img src={require('../../assets/down.svg').default}/>
                </button>
                <div className="sortBy">
                    <a id="up" onClick={() => setSorting("A - Z")}>A - Z</a>
                    <a id="middle" onClick={() => setSorting("DATE CREATED")}>Date Created</a>
                    <a id="down" onClick={() => setSorting("DATE EDITED")}>Date Edited</a>
                </div>
            </div>
            <div>
                {sorting}
            </div>
            <div className="sortLabel">
                Sort:
            </div>
            <img src={require('../../assets/sort.svg').default}/>
        </div>
    );
}

export default Sort;