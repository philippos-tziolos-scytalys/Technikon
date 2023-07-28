import "./Download.css";

const Download = () => {
    return(
        <div className="downloadLabel">
            <div>
                Download
            </div>
            <img src={require('../../assets/download.svg').default}/>
        </div>
    );
}

export default Download;