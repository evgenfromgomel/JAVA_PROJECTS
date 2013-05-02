
		var servReq = function(){
				var url = "http://localhost:8080/MailClientServer/";
				
					req = new XMLHttpRequest();
				
				req.open("POST", url, true);
				req.onreadystatechange = callback;
				req.send(null);
			}
			
			
		function callback() {
			
			if (req.readyState == 4) {
			alert(req.status);
			if (req.status == 200) {	
				parseMessage();
			}
		}
		function parseMessage() {
				 var message = req.responseXML.getElementsByTagName("message")[0];
				 document.getElementById("body").innerHTML = message.childNodes[0].nodeValue;
				}
		}
