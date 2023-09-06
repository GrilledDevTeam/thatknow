import React , {useEffect, useState} from "react";
import DressCodeContainer from "./suggestionArea/DressCodeContainer";
import HatCell from "./suggestionArea/container/HatCell";
import InnerCell from "./suggestionArea/container/InnerCell";
import OuterCell from "./suggestionArea/container/OuterCell";
import BottomCell from "./suggestionArea/container/BottomCell";
import ShoesCell from "./suggestionArea/container/ShoesCell";
import ExtraCell from "./suggestionArea/container/ExtraCell";
import DetailListContainer from "./detailSuggestionArea/DetailListContainer";

function DressCodeSuggestion( { clothingData , messageData } ) {

    const [hatList, setHatList] = useState(null);
    const [innerList, setInnerList] = useState(null);
    const [outerList, setOuterList] = useState(null);
    const [bottomList, setBottomList] = useState(null);
    const [shoesList, setShoesList] = useState(null);
    const [extraList, setExtraList] = useState(null);
    
    const [selectedList, setSelectedList] = useState(null);

    const [recommendedHat, setRecommendedHat] = useState(null);
    const [recommendedInner, setRecommendedInner] = useState(null);
    const [recommendedOuter, setRecommendedOuter] = useState(null);
    const [recommendedBottom, setRecommendedBottom] = useState(null);
    const [recommendedShoes, setRecommendedShoes] = useState(null);
    const [recommendedExtra, setRecommendedExtra] = useState(null);

    useEffect(() => {
        setHatList(clothingData['hatList']);
        setInnerList(clothingData['innerList']);
        setOuterList(clothingData['outerList']);
        setBottomList(clothingData['bottomList']);
        setShoesList(clothingData['shoesList']);
        setExtraList(clothingData['extraList']);
    }
    ,[clothingData])


    useEffect(() => {
        setRecommendedHat(hatList && hatList.filter(hat => hat.recommended)[0]);
    },[hatList])

    useEffect(() => {
        setRecommendedInner(innerList && innerList.filter(inner => inner.recommended)[0]);
    },[innerList])

    useEffect(() => {
        setRecommendedOuter(outerList && outerList.filter(outer => outer.recommended)[0]);
    },[outerList])

    useEffect(() => {
        setRecommendedBottom(bottomList && bottomList.filter(bottom => bottom.recommended)[0]);
    },[bottomList])

    useEffect(() => {
        setRecommendedShoes(shoesList && shoesList.filter(shoes => shoes.recommended)[0]);
    },[shoesList])

    useEffect(() => {
        setRecommendedExtra(extraList && extraList.filter(extra => extra.recommended)[0]);
    },[extraList])


    const selectHatList = () => {
        setSelectedList("hatList");
    }

    const selectInnerList = () => {
        setSelectedList("innerList");
    }

    const selectOuterList = () => {
        setSelectedList("outerList");
    }

    const selectBottomList = () => {
        setSelectedList("bottomList");
    }

    const selectShoesList = () => {
        setSelectedList("shoesList");
    }

    const selectExtraList = () => {
        setSelectedList("extraList");
    }


    return (
        <div className="row gy-5 p-2">
            <div className="col-lg-6">
                <DressCodeContainer>
                    {recommendedHat && <HatCell recommendedHat={recommendedHat} onClick={selectHatList}/>}
                    {recommendedInner && <InnerCell recommendedInner={recommendedInner} onClick={selectInnerList}/>}
                    {recommendedOuter && <OuterCell recommendedOuter={recommendedOuter} onClick={selectOuterList}/>}
                    {recommendedBottom && <BottomCell recommendedBottom={recommendedBottom} onClick={selectBottomList}/>}
                    {recommendedShoes && <ShoesCell recommendedShoes={recommendedShoes} onClick={selectShoesList}/>}
                    {recommendedExtra && <ExtraCell recommendedExtra={recommendedExtra} onClick={selectExtraList}/>}
                </DressCodeContainer>
            </div>
            <div className="col-lg-6">
                {(() => {
                    switch (selectedList) {
                        case "hatList":
                            return <DetailListContainer selectedList={hatList} selectedListSetter={setHatList} selectedListController={setSelectedList}/>
                        case "innerList":
                            return <DetailListContainer selectedList={innerList} selectedListSetter={setInnerList} selectedListController={setSelectedList}/>
                        case "outerList":
                            return <DetailListContainer selectedList={outerList} selectedListSetter={setOuterList} selectedListController={setSelectedList}/>
                        case "bottomList":
                            return <DetailListContainer selectedList={bottomList} selectedListSetter={setBottomList} selectedListController={setSelectedList}/>
                        case "shoesList":
                            return <DetailListContainer selectedList={shoesList} selectedListSetter={setShoesList} selectedListController={setSelectedList}/>
                        case "extraList":
                            return <DetailListContainer selectedList={extraList} selectedListSetter={setExtraList} selectedListController={setSelectedList}/>
                        default:
                            return <DetailListContainer selectedList={null} selectedListSetter={null} selectedListController={null}/>
                    }
                })()}
            </div>
        </div>
    )
}

export default DressCodeSuggestion;