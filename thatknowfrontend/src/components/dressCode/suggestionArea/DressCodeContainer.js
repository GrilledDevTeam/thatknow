import 'App.css';
import React from 'react';

function DressCodeContainer({children}) {

    const array = React.Children.toArray(children);

    return (
        <div className="text-center fs-6 fw-bold" >
            <div className='row'>
                <div className='row g-2'>
                    <div className='col-4'>
                    </div>
                    <div className='col-4'>
                        {array[0]}
                    </div>
                    <div className='col-4'>
                    </div>
                    <div className='col-4'>
                        {array[2]}
                    </div>
                    <div className='col-4'>
                        {array[1]}
                    </div>
                    <div className='col-4'>
                        {array[5]}
                    </div>
                    <div className='col-4'>
                    </div>
                    <div className='col-4'>
                        {array[3]}
                    </div>
                    <div className='col-4'>
                    </div>
                    <div className='col-4'>
                    </div>
                    <div className='col-4'>
                        {array[4]}
                    </div>
                    <div className='col-4'>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default DressCodeContainer;