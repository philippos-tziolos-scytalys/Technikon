import "./CenterPage.css";

const CenterPage = () => {
    return(
        <div>
            <div className="centerVision">
                <h2>“Combining our expertise with your vision,</h2>
                <h2>we are able to process your case quickly</h2>
                <h2>and with the best possible outcome.”</h2>
            </div>
            <div className="centerImg">
                <img src={require("../assets/00.jpg")}/>
                <div className="centerText">
                    <div className="left">
                        <h1>Effectiveness</h1>
                        <h3>We renovate our client's properties guided by their vision and our knowledge</h3>
                    </div>
                    <div className="middle">
                        <h1>Reliability</h1>
                        <h3>We are a group of highly skilled engineers with experience in the construction and design sector</h3>
                    </div>
                    <div className="right">
                        <h1>Quality</h1>
                        <h3>We use both eco-friendly and high quality material based on the client's needs</h3>
                    </div>
                </div>
            </div>
            <div className="centerPageText">
                    <div className="centerPagelogo">
                        <img id="favicon" src={require("../../NavigationBar/assets/favicon.svg").default}/>
                        <img id="logo" src={require("../../NavigationBar/assets/logo.svg").default}/>
                    </div>
                    <div className="quote">
                        <h2> “If you look at history, innovation doesn’t come just from giving people incentives;</h2>
                        <h2> it comes from creating environments where their ideas can connect.” </h2>
                        <h6>Steven Johnson (born 1968), Science author & media theorist</h6>
                    </div>
            </div>
        </div>
    );
}

export default CenterPage;
