import axios from "axios";

// if not use proxy
const apiURL = "https://thatknow.duckdns.org";

// if use proxy
// const apiURL = "";

async function requestGetByURL(requestURL, header) {
  if (header === null) {
    header = {
      headers: {
        "Content-Type": "application/json",
      },
    };
  }

  const response = await axios.get(requestURL, header);

  return response;
}

async function requestPostByURL(requestURL, data, headers) {
  let config = {};

  if (data !== null) {
    config.params = data;
  }

  if (headers === null) {
    config.headers = {
      "Content-Type": "application/json",
    };
  } else {
    config.headers = headers;
  }
  /*
    params: data
    headers: {
        'Content-Type': 'application/json'
    }
  */

  const response = await axios.post(requestURL, null, config);

  return response;
}

export async function loadAllArea() {
  const requestURL = apiURL + "/api/loadAllArea";
  const response = await requestGetByURL(requestURL, null);

  return response;
}

export async function searchAreasBylongitudeAndLatitude(latitude, longitude) {
  // axios
  // .post(
  //     "/api/searchAreasBylongitudeAndLatitude",
  //     {
  //     longitudeSecondsDivide100: longitude,
  //     latitudeSecondsDivide100: latitude,
  //     },
  //     {
  //     headers: {
  //         "Content-Type": "application/x-www-form-urlencoded",
  //     },
  //     }
  // )

  const requestURL = apiURL + "/api/searchAreasBylongitudeAndLatitude";
  const response = await requestPostByURL(
    requestURL,
    {
      longitudeSecondsDivide100: longitude,
      latitudeSecondsDivide100: latitude,
    },
    null
  );

  return response;
}

export async function searchWeatherSuggestionMsgByAreaAndDate(
  state,
  city,
  town,
  startActTime,
  endActTime,
  ATMPCelsiusWeight
) {
  const requestURL = apiURL + "/api/searchWeatherSuggestionMsgByAreaAndDate";

  const requestData = {
    state: state,
    city: city,
    town: town,
    startActTime: startActTime,
    endActTime: endActTime,
    ATMPCelsiusWeight: ATMPCelsiusWeight,
  };

  const response = await requestPostByURL(requestURL, requestData, null);
  return response;
}

export async function searchWeatherSuggestionMsgByGridXYAndDate(
  nx,
  ny,
  startActTime,
  endActTime,
  ATMPCelsiusWeight
) {
  const requestURL = apiURL + "/api/searchWeatherSuggestionMsgByGridXYAndDate";

  const requestData = {
    nx: nx,
    ny: ny,
    startActTime: startActTime,
    endActTime: endActTime,
    ATMPCelsiusWeight: ATMPCelsiusWeight,
  };

  const response = await requestPostByURL(requestURL, requestData, null);
  return response;
}
