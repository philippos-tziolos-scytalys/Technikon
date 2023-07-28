import React from 'react';
import './menu.css';
import '../../../../node_modules/bootstrap/dist/css/bootstrap.min.css';

const Menu = () => {
  return (
    <div className="dropdown">
      <img src={require('../assets/menuIcon.svg').default} alt='logout' className="btn dropdown-toggle" type="button" data-bs-toggle="dropdown" data-bs-placement="bottom-end" />
      <ul className="dropdown-menu dropdown-menu-end">
        <li><a className="dropdown-item" href="/">Logout</a></li>
      </ul>
    </div>
  );
}

export default Menu;
