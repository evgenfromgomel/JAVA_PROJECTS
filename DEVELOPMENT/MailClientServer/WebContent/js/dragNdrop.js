	function defineEvent(e) {
	
		e = e || window.event;
		
		if ( e.pageX == null && e.clientX != null ) {
			var html = document.documentElement;
			var body = document.body;
			e.pageX = e.clientX + (html && html.scrollLeft || body && body.scrollLeft || 0) - (html.clientLeft || 0);
			e.pageY = e.clientY + (html && html.scrollTop || body && body.scrollTop || 0) - (html.clientTop || 0);
		}
		
		if (!e.which && e.button) {
			e.which = e.button & 1 ? 1 : ( e.button & 2 ? 3 : ( e.button & 4 ? 2 : 0 ) );
		}
		return e;
	}

var toInt = function(str){
	return parseInt(str.split('px')[0]);
}
var dragController = (function() {

	var dragObject;
	var mouseOffset;

	function getMouseOffset(target, e) {
		var docPos	= getPosition(target);
		return {x:e.pageX - docPos.x, y:e.pageY - docPos.y};
	}

	function mouseUp(){
		
		var newPos = dragObject.offsetLeft;
		dragObject = null;
		var shift = newPos - dndPos;
		document.getElementById('menu').style.width = (document.getElementById('menu').clientWidth + shift) + 'px';
		document.getElementById('mail_bar').style.width = (document.getElementById('mail_bar').clientWidth - shift) + 'px';
		document.getElementById('mail_bar').style.left = (mail_barPos + shift) + 'px';
		document.getElementById('drag').style.background = "black";
		document.getElementById('drag2').style.display = "none";
		document.getElementById('drag2').style.left = (mail_barPos + shift - 2) + 'px';
		document.onmousemove = null;
		document.onmouseup = null;
		document.ondragstart = null;
		document.body.onselectstart = null;
	}

	function mouseMove(e){
		e = defineEvent(e);
		document.getElementById('drag').style.cursor = "w-resize";
		with(dragObject.style) {
			position = 'absolute';
		var currPos = e.pageX - mouseOffset.x + 'px';
			if(currPos < '217px'){
				var newPos = dragObject.offsetLeft;
				var shift = newPos - dndPos;
				document.getElementById('menu').style.width = (document.getElementById('menu').clientWidth + shift) + 'px';
			 	document.getElementById('mail_bar').style.width = (document.getElementById('mail_bar').clientWidth - shift) + 'px';
				document.getElementById('mail_bar').style.left = (mail_barPos + shift) + 'px';
				document.getElementById('drag').style.background = "black";
				document.getElementById('drag2').style.display = "none";
				document.getElementById('drag2').style.left = (mail_barPos + shift - 2) + 'px';
				dragObject = null; 
				return; 
			}
			else if(currPos > '800px') {
				var newPos = dragObject.offsetLeft;
				var shift = newPos - dndPos;
				document.getElementById('menu').style.width = (document.getElementById('menu').clientWidth + shift) + 'px';
			 	document.getElementById('mail_bar').style.width = (document.getElementById('mail_bar').clientWidth - shift) + 'px';
				document.getElementById('mail_bar').style.left = (mail_barPos + shift) + 'px';
				document.getElementById('drag').style.background = "black";
				document.getElementById('drag2').style.display = "none";
				document.getElementById('drag2').style.left = (mail_barPos + shift) + 'px';
				dragObject = null; 
				return; 
			}
			else if(currPos > '217px' && currPos < '800px') { left = e.pageX - mouseOffset.x + 'px'; }
			
			
		}
		
		return false;
	}

	function mouseDown(e) {
		e = defineEvent(e);
		if (e.which!=1) return;

		dragObject  = this;
		dndPos = dragObject.offsetLeft;
		mail_barPos = document.getElementById('mail_bar').offsetLeft - 2;
		document.getElementById('drag2').style.display = "block";
		document.getElementById('drag').style.background = "#E9E9E9";
		

		mouseOffset = getMouseOffset(this, e);

		document.onmousemove = mouseMove;
		document.onmouseup = mouseUp;

		document.ondragstart = function() { return false; };
		document.body.onselectstart = function() { return false; };

		return false;
	}

	return {
		makeDraggable: function(element){
			element.onmousedown = mouseDown;
		}
	}

}());

function getPosition(e){
	var left = 0;
	var top  = 0;

	while (e.offsetParent){
		left += e.offsetLeft;
		top  += e.offsetTop;
		e	 = e.offsetParent;
	}

	left += e.offsetLeft;
	top  += e.offsetTop;

	return {x:left, y:top};
}