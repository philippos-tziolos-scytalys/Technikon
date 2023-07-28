import { Button } from 'react-bootstrap';
import Logo from './Logo/Logo';
import "./NavigationBar.css";

const NavigationBar = () => {
  
  return (

    <div id="navbar">
      <div>
          <Logo/>
      </div>
      <div className="rightSideNavbar">
        <div style={{color: "white", paddingRight: "40px", fontSize: "20px", cursor: "pointer"}}>
            <Button className='login' href='/login'>Login</Button>
        </div> 
      </div>
    </div>
    
  );
}

export default NavigationBar;