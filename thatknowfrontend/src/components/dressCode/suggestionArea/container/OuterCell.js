import ClothingCell from "../ClothingCell"

function OuterCell( {recommendedOuter , onClick} ) {

    var {name , url} = recommendedOuter;

    return (
        <div className="row bg-white border border-3 rounded border-muted" onClick={onClick}>
            <div className="col-3 border-end border-3 d-flex justify-content-center align-items-center" style={{backgroundColor: "rgb(240,240,240)", height: "105px"}}>
                외투
            </div>
            <div className="col-9 d-flex justify-content-center align-items-center">
                <ClothingCell name={name} url={url}/>
            </div>
        </div>
    )
}

export default OuterCell