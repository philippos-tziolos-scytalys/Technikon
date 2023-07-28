import './Login.css';
import {Button} from 'react-bootstrap';
import React, {useState} from 'react';
import { useNavigate, Link } from 'react-router-dom';
import axios from 'axios';
import logo from './img/logo.png';
import frame from './img/Frame.png';
import Register from './Register';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function Login() {
const [username, setUsername] = useState("");
const [password, setPassword] = useState("");
const [showModal, setShowModal] = useState(false);
const navigate = useNavigate();
const toggleModal = () => {
  setShowModal((show) => !show);
};

const register = async (fields) => {
  await axios.post(fields);
  toggleModal();
};

async function login(event) {
  event.preventDefault();
  try {
    await axios.post("http://localhost:8080/api/auth/login", {
      username: username,
      password: password
    }).then((res) => {
      console.log(res.data);
      navigate('/customer');
      
/* Refreshing the page because the navbar does not show up after login only upon refresh.
    The issue is on the App.js filtering the navbar's location */
      window.location.reload();
    });
  } catch (error) {
    console.error(error);
    toast.error('Wrong credentials! Please try again.');
  }
}

  return (
    <div className='loginpage'>
    <div className='logo'>
      <img className='me-2' src={logo} alt='logo'></img>
      <img src={frame} alt='frame'></img>
    </div>
    <div className='container'>
      <form >
        <h2 className='form-title'>Login</h2>

        <div className='mb-5'>
        <div className='form-group'>
          <label className='form-label'>Email</label>
          <input 
          type='text' 
          className='form-control' 
          id='userEmail' 
          placeholder='username@gmail.com'
          value={username}
          name="username"
          onChange={(event) => {
            setUsername(event.target.value);
          }}
           />
        </div>
        </div>

        <div className='mb-3'>
        <div className='form-group'>
          <label className='form-label'>Password</label>
          <input type='password' 
          className='form-control' 
          id='userPassword' 
          placeholder='Password'
          value={password}
          name="password"
          onChange={(event) => {
            setPassword(event.target.value);
          }}
         />                  
        </div>
        </div>


        <div className='link'><Link className='fgt' to="/">Forgot password?</Link></div>

        <Button type='button' className='btn btn-primary mb-3' onClick={login}>Sign in</Button>

        <div className='hr-display'>
          <div className='hr-design'></div>

            <div>
              <p>OR</p>
            </div>

          <div className='hr-design'></div>
        </div>

        <Button className='btn btn-primary mt-3' onClick={toggleModal}>Create account</Button>
        <Register
          showModal={showModal}
          toggleModal={toggleModal}
          register={register}
        />
        <ToastContainer />
      </form>
    </div>
    </div>
  );
}


export default Login;
