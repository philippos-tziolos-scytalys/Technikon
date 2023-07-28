import Carousel from "./Carousel/Carousel";
import CenterPage from "./CenterPage/CenterPage";
import Footer from "./Footer/Footer";
import "./Body.css";

const Body = () => {
    return (
        <div className="body">
            <Carousel/>
            <CenterPage/>
            <Footer/>
        </div>
    );
}

export default Body;