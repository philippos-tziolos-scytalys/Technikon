import { useState } from 'react';
import './Filter.css';

const Filter = () => {
    const [filtering, setFiltering] = useState("ALL");

    return(
        <div className="filterBar">
            <div className="filter">
                <button>
                    <img src={require('../../assets/down.svg').default}/>
                </button>
                <div className="filterBy">
                    <a id="up" onClick={() => setFiltering("ALL")}>ALL</a>
                    <a id="middle" onClick={() => setFiltering("ADMIN")}>ADMIN</a>
                    <a id="down" onClick={() => setFiltering("CUSTOMER")}>CUSTOMER</a>
                </div>
            </div>
            <div>
                {filtering}
            </div>
            <div className="filterLabel">
                Filter:
            </div>
            <img src={require('../../assets/filter.svg').default}/>
        </div>
    );
}

export default Filter;