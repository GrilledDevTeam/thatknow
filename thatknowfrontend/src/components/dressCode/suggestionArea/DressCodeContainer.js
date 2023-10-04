import 'App.css';
import React from 'react';

function DressCodeContainer({children}) {

    const array = React.Children.toArray(children);

    return (
        <div className="border border-4 rounded shadow p-2" style={{height: "550px"}}>
            <div className='row g-2 fs-6 fw-bold justify-content-center d-flex align-items-center'>
                <div className='col-6 p-2 justify-content-center d-flex align-items-center'>
                    {array[0]}
                </div>
                <div className='col-6 p-2'>
                </div>
                <div className='col-6 p-2 justify-content-center d-flex align-items-center'>
                    {array[1]}
                </div>
                <div className='col-6 p-2 justify-content-center d-flex align-items-center'>
                    {array[2]}
                </div>
                <div className='col-6 p-2 justify-content-center d-flex align-items-center'>
                    {array[3]}
                </div>
                <div className='col-6 p-2 justify-content-center d-flex align-items-center'>
                    {array[5]}
                </div>
                <div className='col-6 p-2 justify-content-center d-flex align-items-center'>
                    {array[4]}
                </div>
                <div className='col-6 p-2'>
                </div>
            </div>
        </div>
        
    );
}

export default DressCodeContainer;