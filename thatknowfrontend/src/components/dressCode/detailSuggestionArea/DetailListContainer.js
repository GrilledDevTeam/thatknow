import React from "react";
import ClothingCardContainer from "./container/ClothingCardContainer";


function DetailListContainer({selectedList , selectedListSetter , selectedListController}){

    var isNull = true;

    const clothingCardOnClick = (e) => {
        const selectId = e.target.id;

        selectedListSetter(selectedList.map( (clothing) => {
            if(clothing.id == selectId)
            {
                return {...clothing, recommended: true};
            }
            else
            {
                return {...clothing, recommended: false};
            }
        }))

        selectedListController(null);
    }   

    return (
        <div className="border border-4 overflow-auto rounded shadow" style={{height: "550px"}}>
            <h1 className="justify-content-center d-flex align-items-center fs-1 fw-bolder">세부 목록</h1>
            <hr className="border border-3" />
            {(() => {
                if (selectedList == null)
                {
                    return <p className="text-center p-2 fs-3 fw-bolder text-muted" style={{height: "300px"}}>미선택</p>
                }
                else
                {
                    isNull = false;
                }
            })()}
            
            {isNull || selectedList.map( (clothing) => {
                        if (!clothing.recommended)
                        {
                            return <ClothingCardContainer clothing={clothing} clothingCardOnClick={clothingCardOnClick} key={clothing.id}/>
                        }
                    })}

            {isNull || (selectedList.every(clothing => clothing.recommended) && (
            <p className="text-center p-2 fs-3 fw-bolder text-muted" style={{height: "300px"}}>추천할 옷이 없습니다.</p>)
        )}
        </div>
    )
}

export default DetailListContainer;