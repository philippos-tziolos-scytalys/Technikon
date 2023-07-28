import React from 'react';
import ReactDOM from 'react-dom/client';
import LoginNavigationBar from './NavigationBar/LoginNavigationBar'
import Body from './WelcomeBody/Body';
const App = () => (
  <div>
    <LoginNavigationBar />
    <Body/>
  </div>
);


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<React.StrictMode><App /></React.StrictMode>);
