import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import "./Carousel.css";


const Carousel = () => {
    return(
        <div>
            <div id="feature-carousel" class="carousel slide" data-bs-ride="carousel">
                <div className="carousel-indicators">
                    <button type="button" data-bs-target="#feature-carousel" data-bs-slide-to="0" class="active"></button>
                    <button type="button" data-bs-target="#feature-carousel" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#feature-carousel" data-bs-slide-to="2"></button>
                    <button type="button" data-bs-target="#feature-carousel" data-bs-slide-to="3"></button>
                    <button type="button" data-bs-target="#feature-carousel" data-bs-slide-to="4"></button>
                </div>
                
                <div className="carousel-inner">
                    <div className="carousel-item active">
                        <div className="item">
                            <div className="text">
                                <h1>Electrical</h1>
                                <h4>
                                    “Invention is the most important product of man's creative brain. 
                                    The ultimate purpose is the complete mastery of mind over the material 
                                    world, the harnessing of human nature to human needs.”
                                </h4>
                                <h6>
                                    Nikola Tesla
                                </h6>
                            </div>
                            <img src={require("../assets/1.jpg")}/>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="item">
                            <div className="text">
                                <h1>Plumbing</h1>
                                <h4>
                                    “If you are a plumber, there is an objective way to establish 
                                    whether you put together a great piping system or not.”
                                </h4>
                                <h6>
                                    Maurizio Cattelan
                                </h6>
                            </div>
                            <img src={require("../assets/2.jpg")}/>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="item">
                            <div className="text">
                                <h1>Painting</h1>
                                <h4>
                                    “I dream of painting and then I paint my dream.”
                                </h4>
                                <h6>
                                    Vincent Van Gogh
                                </h6>
                            </div>
                            <img src={require("../assets/3.jpg")}/>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="item">
                            <div className="text">
                                <h1>Frames</h1>
                                <h4>
                                    “Good timber does not grow with ease:
                                    The stronger wind, the stronger trees;
                                    The further sky, the greater length;
                                    The more the storm, the more the strength.
                                    By sun and cold, by rain and snow,
                                    In trees and men good timbers grow.”
                                </h4>
                                <h6>
                                    Douglas Malloch
                                </h6>
                            </div>
                            <img src={require("../assets/4.jpg")}/>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <div className="item">
                            <div className="text">
                                <h1>Insulation</h1>
                                <h4>
                                    “Home is where we should feel secure and comfortable.”
                                </h4>
                                <h6>
                                    Catherine Pulsifer
                                </h6>
                            </div>
                            <img src={require("../assets/5.jpg")}/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Carousel;