import "./Logo.css";

const Logo = () => {
  
  return (

    <div className="logo">
      <div>
        <img  src={require('../assets/favicon.svg').default}/>
      </div>
      <div>
        <img src={require('../assets/logo.svg').default}/>
      </div>
    </div>

  );
}

export default Logo;