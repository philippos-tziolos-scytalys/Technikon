
import "./TabMenu.css";
import { Link } from 'react-router-dom';

const TabMenu = () => {

  
  return (


    <div className="tabMenu">
      <Link className="content" to="/customer">Users</Link>
      <Link className="content" to="/property">Property</Link>
      <Link className="content" to="/repair">Repairs</Link>
      <Link className="content" to="/report">Reports</Link>
    </div>
    
  );
}

export default TabMenu;