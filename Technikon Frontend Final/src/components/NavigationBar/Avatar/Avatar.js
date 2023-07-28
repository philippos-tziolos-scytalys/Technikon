import "./Avatar.css"

const Avatar = () => {
  
  return (
    <div className="avatar">
      <img src={require('../assets/favicon.svg').default}/>
    </div>
  );
}

export default Avatar;