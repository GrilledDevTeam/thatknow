
function ClothingCardComponent({clothing}){

    var {name, url} = clothing

    const imageUrl = process.env.PUBLIC_URL + url;

    return(
        
            <div className="row gx-2" id={clothing.id}>
                <div className="col-5" id={clothing.id}>
                    <img className="img-thumbnail detailImage" src={imageUrl} alt={name} id={clothing.id}/>
                </div>
                <div className="col-7 d-flex justify-content-center align-items-center" id={clothing.id}>
                    <p id={clothing.id}>{clothing.message}</p>
                </div>
            </div>
    )
}

export default ClothingCardComponent;