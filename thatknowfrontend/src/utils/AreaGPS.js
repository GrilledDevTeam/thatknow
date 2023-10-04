// import React, { useState, useEffect } from "react";
// import axios from "axios";

// export default function AreaGPS({
//   latitude,
//   longitude,
//   onGPSDataChange,
//   onLoadingChange,
// }) {
//   useEffect(() => {
//     console.log("내가 GPS로 지역을 가져오고 있단다!");
//     if (latitude && longitude) {
//       onLoadingChange(true);
//       axios
//         .post(
//           "/api/searchAreasBylongitudeAndLatitude",
//           {
//             longitudeSecondsDivide100: longitude,
//             latitudeSecondsDivide100: latitude,
//           },
//           {
//             headers: {
//               "Content-Type": "application/x-www-form-urlencoded",
//             },
//           }
//         )
//         // searchAreasBylongitudeAndLatitude(latitude, longitude)
//         .then((response) => {
//           onGPSDataChange(response.data[0]);
//           onLoadingChange(false);
//         })
//         .catch((error) => {
//           console.error("Error fetching area data:", error);
//         });
//     }
//   }, [latitude, longitude]);

//   return <div></div>;
// }
