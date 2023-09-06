import ClothingCell from "../component/ClothingCell"

function OuterCell( {recommendedOuter , onClick} ) {

    var {name , url} = recommendedOuter;

    return (
        <div className="card" style={{height: "7rem"}} onClick={onClick}>
            <div className="card-header" style={{height: "2rem"}}>
                <p style={{objectFit: "cover", margin: "0"}}>외투</p>
            </div>
            <div className="d-flex align-items-center justify-content-center ">
                <ClothingCell name={name} url={url}/>
            </div>
        </div>
    )
}

export default OuterCell