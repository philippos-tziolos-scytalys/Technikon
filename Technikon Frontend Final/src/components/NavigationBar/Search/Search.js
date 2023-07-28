import "./Search.css"

const Search = () => {

    return(
        <form id="searchBar">
            <img class="search-icon" src={require('../assets/search.svg').default}/>
            <input class="search-bar" type="search" placeholder="Search"></input>
        </form>
    );

}

export default Search;
