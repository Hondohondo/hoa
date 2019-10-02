
// document.querySelector('.test').addEventListener('click', function() {
//   // alert("Image is loaded");
//   console.log("We're cooking");

//   var settings = {
//     "async": true,
//     "crossDomain": true,
//     "url": "http://moses.ngrok.io/services/ticket/microservices/ticket_crud_service/?name=Test%20Name&email=@name.name&phoneNumber=216-789-0000&subject=Test%20Message&ticketMessage=Test%20Message",
//     "method": "POST",
//     "headers": {
//       "User-Agent": "PostmanRuntime/7.17.1",
//       "Accept": "*/*",
//       "Cache-Control": "no-cache",
//       "Postman-Token": "b80159d6-6390-450a-9e58-2b4d2cf43e2f,809e23e5-8dbe-46d9-938d-778f0705cea5",
//       "Host": "moses.ngrok.io",
//       "Accept-Encoding": "gzip, deflate",
//       "Content-Length": "0",
//       "Connection": "keep-alive",
//       "cache-control": "no-cache"
//     }
//   }
  
//   $.ajax(settings).done(function (response) {
//     console.log(response);
//   });

// });

document.querySelector('.test').addEventListener('click', function() {
  // alert("Image is loaded");
  console.log("We're cooking");

  var data = null;

  var xhr = new XMLHttpRequest();
  xhr.withCredentials = true;
  
  xhr.addEventListener("readystatechange", function () {
    if (this.readyState === 4) {
      console.log(this.responseText);
    }
  });
  
  xhr.open("POST", "http://moses.ngrok.io/services/ticket/microservices/ticket_crud_service/?name=Test%20Name&email=@name.name&phoneNumber=216-789-0000&subject=Test%20Message&ticketMessage=Test%20Message");
  xhr.setRequestHeader("User-Agent", "PostmanRuntime/7.17.1");
  xhr.setRequestHeader("Accept", "*/*");
  xhr.setRequestHeader("Cache-Control", "no-cache");
  xhr.setRequestHeader("Postman-Token", "28d49107-e4e8-4634-a0b2-9c8e46b84380,104df2cd-b8fa-426f-944f-bd11ad885a5b");
  xhr.setRequestHeader("Host", "moses.ngrok.io");
  xhr.setRequestHeader("Accept-Encoding", "gzip, deflate");
  xhr.setRequestHeader("Content-Length", "0");
  xhr.setRequestHeader("Connection", "keep-alive");
  xhr.setRequestHeader("cache-control", "no-cache");
  
  xhr.send(data);

});



