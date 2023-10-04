import "App.css";

function MessageSuggestion( { messageData } ) {

    return (
        <div className="row justify-content-center d-flex align-items-center fw-bold h-100" style={{fontFamily:"monospace"}}>
            <div className="col-8 col-lg-10 rounded bg-white shadow h-25 justify-content-center d-flex align-items-center text-wrap">
                {messageData["tmpmessage"]}
            </div>
            <div className="col-8 col-lg-10 rounded bg-white shadow h-25 justify-content-center d-flex align-items-center text-wrap">
                {messageData["windMessage"]}
            </div>
            <div className="col-8 col-lg-10 rounded bg-white shadow h-25 justify-content-center d-flex align-items-center text-wrap">
                {messageData["weatherMessage"]}
            </div>
        </div>
    );
}

export default MessageSuggestion;