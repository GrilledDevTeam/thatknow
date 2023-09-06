import 'App.css'


function ClothingCell ({name , url}) {

    const imageUrl = process.env.PUBLIC_URL + url;

    return (
        <img src={imageUrl} alt={name} className='card-img-top img-thumbnail suggestionImage'/>
    )
}

export default ClothingCell