import ClothingCell from "../component/ClothingCell"

function InnerCell( {recommendedInner , onClick} ) {

    var {name , url} = recommendedInner;

    return (
        <div className="card" style={{height: "7rem"}} onClick={onClick}>
            <div className="card-header" style={{height: "2rem"}}>
                <p style={{objectFit: "cover", margin: "0"}}>상의</p>
            </div>
            <div className="d-flex align-items-center justify-content-center ">
                <ClothingCell name={name} url={url}/>
            </div>
        </div>
    )
}

export default InnerCell