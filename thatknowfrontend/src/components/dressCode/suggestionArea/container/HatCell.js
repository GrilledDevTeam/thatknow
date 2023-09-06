import ClothingCell from "../component/ClothingCell"
import 'App.css'

function HatCell( {recommendedHat , onClick} ) {

    var {name , url} = recommendedHat;

    return (
        <div className="card" style={{height: "7rem"}} onClick={onClick}>
            <div className="card-header" style={{height: "2rem"}}>
                <p style={{objectFit: "cover", margin: "0"}}>모자</p>
            </div>
            <div className="d-flex align-items-center justify-content-center ">
                <ClothingCell name={name} url={url}/>
            </div>
        </div>
    )
}

export default HatCell