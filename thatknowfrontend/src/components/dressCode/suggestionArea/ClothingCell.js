import 'App.css'


function ClothingCell ({name , url}) {

    const imageUrl = process.env.PUBLIC_URL + url;

    return (
        <img src={imageUrl} alt={name} className='img-thumbnail' style={{width: " 105px", height: "105px", objectFit: "cover"}}/>
    )
}

export default ClothingCell