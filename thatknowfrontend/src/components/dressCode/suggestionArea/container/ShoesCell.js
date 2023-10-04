import ClothingCell from "../ClothingCell"

function ShoesCell( {recommendedShoes , onClick} ) {

    var {name , url} = recommendedShoes;

    return (
        <div className="row bg-white border border-3 rounded border-muted" onClick={onClick}>
            <div className="col-3 border-end border-3 d-flex justify-content-center align-items-center" style={{backgroundColor: "rgb(240,240,240)", height: "105px"}}>
                신발
            </div>
            <div className="col-9 d-flex justify-content-center align-items-center">
                <ClothingCell name={name} url={url}/>
            </div>
        </div>
    )
}

export default ShoesCell