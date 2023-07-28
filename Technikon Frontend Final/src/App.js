import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import Login from './access/Login';
import Register from './access/Register'

import Home from './access/WelcomeBody/Body';
import LoginNavbar from './access/NavigationBar/LoginNavigationBar'

import NavigationBar from './components/NavigationBar/NavigationBar';
import TabMenu from './components/TabMenu/TabMenu';

import Customer from './components/customer/Body/Body';
import ViewCustDetails from './components/customer/ViewCustDetails';
import UpdateCustDetails from './components/customer/UpdateCustDetails';

import Property from './components/property/Body/Body'
import ViewPropDetails from './components/property/ViewPropDetails'
import UpdatePropDetails from './components/property/UpdatePropDetails'
import CreateProperty from './components/property/CreateProperty'

import Repair from './components/repair/Body/Body'
import ViewRepDetails from './components/repair/ViewRepDetails'
import UpdateRepDetails from './components/repair/UpdateRepDetails'
import CreateRepair from './components/repair/CreateRepair'

import Report from './components/report/Body/Body'
import ViewReportDetails from './components/report/ViewReportDetails'
import UpdateReportDetails from './components/report/UpdateReportDetails'
import CreateReport from './components/report/CreateReport'

import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function App() {
  const isLoginPath = window.location.pathname === '/login';
  const isHomePath = window.location.pathname === '/';

  return (
    <div className="App">

      <Router>
        {!isLoginPath && !isHomePath && (
            <>
              <NavigationBar />
              <TabMenu />
            </>
          )}

        {isHomePath && <LoginNavbar />}

        <Routes>
          <Route exact path="/login" element={<Login />} />
          <Route exact path="/register" element={<Register />} />
          <Route exact path="/" element={<Home />} />

          <Route exact path="/customer" element={<Customer />} />
          <Route exact path="/viewCustomerDetails/:id" element={<ViewCustDetails />} />
          <Route exact path="/updateCustomerdetails/:id" element={<UpdateCustDetails />} />

          <Route exact path="/property" element={<Property />} />
          <Route exact path="/viewPropDetails/:id" element={<ViewPropDetails />} />
          <Route exact path="/updatePropDetails/:id" element={<UpdatePropDetails />} />
          <Route exact path="/createProperty" element={<CreateProperty />} />

          <Route exact path="/repair" element={<Repair />} />
          <Route exact path="/viewRepDetails/:id" element={<ViewRepDetails />} />
          <Route exact path="/updateRepDetails/:id" element={<UpdateRepDetails />} />
          <Route exact path="/createReperty" element={<CreateRepair />} />

          <Route exact path="/report" element={<Report />} />
          <Route exact path="/viewReportDetails/:id" element={<ViewReportDetails />} />
          <Route exact path="/updateReportDetaisls/:id" element={<UpdateReportDetails />} />
          <Route exact path="/createReport" element={<CreateReport />} />
        </Routes>

          <ToastContainer/>
      </Router>

    </div>
  );
}

export default App;
