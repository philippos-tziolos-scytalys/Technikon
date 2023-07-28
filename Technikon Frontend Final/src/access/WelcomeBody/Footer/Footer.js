import "./Footer.css";

const Footer = () => {
    return(
        <div className="footerBar">
            <h2>WE GIVE BACK TO THE COMMUNITY</h2>
            <div className="footerText">
                <div className="contact">
                    <h3>Contact Us</h3>
                    <h5>(+30) 210 48 11 111 | info@technikon.co</h5>
                    <h5>Athens | Building 1 Innovtion St., Athens, Greece</h5>
                </div>
                <div className="contact">
                    <h3>Follow Us</h3>
                    <div className="iconBar">
                        <img src={require("../assets/fb.png")}/>
                        <img src={require("../assets/ig.png")}/>
                        <img src={require("../assets/ln.png")}/>
                    </div>
                </div>
                <div className="contact">
                    <h3>Technikon</h3>
                    <h5>“A construction company based in Greece</h5> 
                    <h5>Founded in 2023” © All Rights Reserved</h5>
                </div>
            </div>
        </div>
    );
}

export default Footer;