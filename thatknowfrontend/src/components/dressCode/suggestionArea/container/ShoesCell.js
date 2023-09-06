import ClothingCell from "../component/ClothingCell"

function ShoesCell( {recommendedShoes , onClick} ) {

    var {name , url} = recommendedShoes;

    return (
        <div className="card" style={{height: "7rem"}} onClick={onClick}>
            <div className="card-header" style={{height: "2rem"}}>
                <p style={{objectFit: "cover", margin: "0"}}>신발</p>
            </div>
            <div className="d-flex align-items-center justify-content-center ">
                <ClothingCell name={name} url={url}/>
            </div>
        </div>
    )
}

export default ShoesCell