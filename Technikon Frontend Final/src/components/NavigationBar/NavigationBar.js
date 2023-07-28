import Search from './Search/Search';
import Logo from './Logo/Logo';
import CreateButton from './CreateButton/CreateButton';
import Avatar from './Avatar/Avatar';
import Notifications from './Notifications/notifications';
import Menu from './Menu/menu';
import "./NavigationBar.css"

const NavigationBar = () => {
  return (
    <div className="navbar">
      <div>
          <Logo/>
      </div>
      <div className="rightSideNavbar">
        <div>
            <Search/>
        </div>
        <div>
            <CreateButton/>
        </div>
        <div>
            <Avatar/>
        </div>
        <div>
            <Notifications/>
        </div>
        <div>
            <Menu/>
        </div>   
      </div>
    </div>
  );
}

export default NavigationBar;
