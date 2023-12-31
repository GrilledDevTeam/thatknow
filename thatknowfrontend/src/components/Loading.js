import React from 'react';
import FadeLoader from 'react-spinners/FadeLoader';

export default function Loading() {
    return (
        <div className="loading-spinner">
            <div
                style={{
                    position: "fixed",
                    top: "50%",
                    left: "50%",
                    transform: "translate(-50%, -50%)"
                }}
            >
                <FadeLoader 
                    color="#C63DEE"
                    height={15}
                    width={5}
                    radius={2}
                    margin={2}
                />
            </div>
        </div>
    );
}