import ClothingCardComponent from '../component/ClothingCardComponent';
import 'App.css'

const ClothingCardContainer = ({clothing , clothingCardOnClick}) => {

    return(
        <div className='border border-2 rounded m-2'  onClick={clothingCardOnClick}>
            <ClothingCardComponent clothing={clothing} id={clothing.id}/> 
        </div>
    )
}

export default ClothingCardContainer;
