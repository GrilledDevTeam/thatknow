export async function searchGPS() {
  return new Promise((resolve, reject) => {
    if ("geolocation" in navigator) {
      navigator.geolocation.getCurrentPosition(function (position) {
        const newLatitude = position.coords.latitude.toFixed(6);
        const newLongitude = position.coords.longitude.toFixed(6);

        resolve({ latitude: newLatitude, longitude: newLongitude });
      });
    } else {
      reject("Geolocation is not available on this device.");
    }
  });
}

// how to use
// searchGPS()
//   .then((data) => {
//     console.log("성공:", data);
//   })
//   .catch((error) => {                   <--------- reject
//     console.error("오류:", error);
//   });
