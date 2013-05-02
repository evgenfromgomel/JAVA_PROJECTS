var inbox = new Array();
var drafts = new Array();
var unread = new Array();
var read = new Array();
var deleted = new Array();
var CURR_MAIL_LIST = 0;




var srchGetFocus = function () {
	 var textField = document.getElementById('search');
	if (textField.getAttribute('value') == 'search'){
		textField.setAttribute('value', ''); 
		textField.style.color = 'black';
	}
}

var srchLooseFocus = function () {
	 var textField = document.getElementById('search');
	if (textField.getAttribute('value') == ""){
		textField.style.color = 'gray';
		textField.setAttribute('value', 'search'); 
	}
}


function eMail(id, name, subject, message, received){
	this.id = id;
	this.name = name;
	this.subject = subject;
	this.message = message;
	this.received = received;
	this.read = false;
}

 var  createMailList = function(mailList) { 
	for(i = 0; i < mailList.length; i++){
		var tempMail = mailList[i];
		var id = tempMail.childNodes[0].firstChild.nodeValue;
		var name = tempMail.childNodes[1].firstChild.nodeValue;
		var subj = tempMail.childNodes[2].firstChild.nodeValue;
		var rec = tempMail.childNodes[4].firstChild.nodeValue;
		var email = new eMail(id, name, subj, null, rec);
		inbox[i] = email;
	}
	for(i = 0; i < mailList.length; i++){
		var tempMail = mailList[i];
		var id = tempMail.childNodes[0].firstChild.nodeValue;
		var name = tempMail.childNodes[1].firstChild.nodeValue;
		var subj = tempMail.childNodes[2].firstChild.nodeValue;
		var rec = tempMail.childNodes[4].firstChild.nodeValue;
		var email = new eMail(id, name, subj, null, rec);
		unread[i] = email;
	}
	createMenu(document.getElementById('menu'));
}
 


	var loadMails = function(){
		var xmlhttp;
		 xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function(){
		  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
			 var  mails = xmlhttp.responseXML.getElementsByTagName("mail");
			 createMailList(mails);
		    }
		  }
		xmlhttp.open("POST","http://localhost:8080/MailClientServer/MessageController",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send(null);
		
		}
	
var loadData = function(){
	loadMails(); 
}

var createMenu = function(menuNode){
	
	menuNode.appendChild(createMenuItem('Inbox', inbox));
	menuNode.appendChild(document.createElement('br'));
	menuNode.appendChild(createMenuItem('Drafts', drafts));
	menuNode.appendChild(document.createElement('hr'));
	menuNode.appendChild(createMenuItem('Unread', unread));
	menuNode.appendChild(document.createElement('br'));
	menuNode.appendChild(createMenuItem('Read', read));
	menuNode.appendChild(document.createElement('hr'));
	menuNode.appendChild(createMenuItem('Deleted', deleted));
}

var createMenuItem = function(itemName, mailList){
	var newMenuItem = document.createElement('a');
	if(mailList == null || mailList.length == 0){
	var textInboxItem = document.createTextNode(itemName);
	}
	else{
	var textInboxItem = document.createTextNode(itemName + '(' + mailList.length + ')');
	}
	listName = itemName.toLowerCase();
	newMenuItem.appendChild(textInboxItem);
	newMenuItem.setAttribute('href','#');
	newMenuItem.setAttribute('id',"'" + listName + "'");
	newMenuItem.onclick = function(){loadTable(itemName.toLowerCase());};
	return newMenuItem;
}

var al = function(id){
	alert('dfdf' + id);
}

var loadTable = function(typeMailList){
	switch(typeMailList){
		case 'inbox':
			CURR_MAIL_LIST = 1;
			createTable(inbox);	
			break;
		case 'drafts':
			CURR_MAIL_LIST = 2;
			createTable(drafts);
			break;
		case 'unread':
			CURR_MAIL_LIST = 3;
			createTable(unread);	
			break;
		case 'read':
			CURR_MAIL_LIST = 4;
			createTable(read);
			break;
		case 'deleted':
			CURR_MAIL_LIST = 5;
			createTable(deleted);	
			break;	
	}
}	

var getCurrentList = function(){
		var currlist = null;
	switch(CURR_MAIL_LIST){
		case 1:
			currlist = inbox;
			break;
		case 2:
			currlist = drafts;
			break;
		case 3:
			currlist = unread;
			break;
		case 4:
			currlist = read;
			break;
		case 5:
			currlist = deleted;
			break;
	}
	return currlist;
}

var createTable = function(mailList){

	var tableRootNode =  document.getElementById('mails');
	var tBody = document.createElement('tbody');
	var numRows = tableRootNode.childNodes.length;
	var tableHeight = 0;
	if(tableRootNode.firstChild.nodeName == "TBODY") delId = 1;
	else delId = 2;
	for(i = delId; i < numRows; i++){
		tableRootNode.removeChild(tableRootNode.childNodes[delId]);
	}
	
	if(mailList == null){
		insertEmptyRows(tableRootNode,0);
	}else{
	
		for(i = 0; i < mailList.length; i++){
			
			var rowNode = document.createElement('tr');
			if(i % 2 != 0){
				rowNode.setAttribute('class', 'alt');
			}
			if(CURR_MAIL_LIST == 1){
				if(!mailList[i].read){
					rowNode.setAttribute('style','font:bold 1.1em "Times New Roman", Times, serif');
				}
			}
			
			var checkBox = document.createElement('input');
			checkBox.setAttribute('type','checkbox');
			checkBox.setAttribute('name','checkMail');
			checkBox.setAttribute('value','chk' + i);
			var cellChkBox = document.createElement('td');
			cellChkBox.appendChild(checkBox);
			var cellName = document.createElement('td');
			cellName.innerHTML = mailList[i].name;
			var cellSubj = document.createElement('td');		
			cellSubj.innerHTML = mailList[i].subject;	
			var cellRcvd = document.createElement('td');
			cellRcvd.innerHTML = mailList[i].received;
			rowNode.onclick = function(e){
				showMessage(e);
			};	
			rowNode.appendChild(cellChkBox);
			rowNode.appendChild(cellName);
			rowNode.appendChild(cellSubj);
			rowNode.appendChild(cellRcvd);
			rowNode.id = i + "";
			tableRootNode.appendChild(rowNode);
			tableRootNode.appendChild(tBody);

		}
		tableHeight += 40;
		
			if(tableHeight < 560){
					insertEmptyRows(tableRootNode, i);
		}
	}
}

var showMessage = function(ev){
	evt = ev || window.event;
	var mailSelected = evt.srcElement || evt.target;
	var id = mailSelected.parentNode.id;
	var currlist = getCurrentList();
		
		var messHeader = document.getElementById('mess_head');
		var textInHeader = "From: " + currlist[id].name + " (" + currlist[id].received + ")";
		var messId = currlist[id].id;
		loadTextMails(messId);
		messHeader.innerHTML = textInHeader;
		if(currlist[id].read == false){
		currlist[id].read = true;
		for(i = 0; i < inbox.length; i++){
			if(inbox[i].id == currlist[id].id){
				inbox[i].read = true;
			}
		}
		if(unread.length > 0){
			read.push(currlist[id]);
		}
		for(k = 0; k < unread.length; k++){
			if(currlist[id].id == unread[k].id){
				unread.splice(k,1);
			}
		}
		createTable(currlist);
		updateMenu();
	}
}


var loadTextMails = function(id){
	var xmlhttp;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","http://localhost:8080/MailClientServer/MessageController",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("id=" + id);
	xmlhttp.onreadystatechange = function(){
	  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
		 var  textMail = xmlhttp.responseXML.getElementsByTagName("message");
		 var text = document.getElementById('text_area');
		 text.innerHTML = textMail[0].firstChild.nodeValue;
	    }
	  }	
	}

var insertEmptyRows = function(tableNode, iterator){
	if (iterator != 0) var i = iterator;
	else {
		var i = 0;
	}
	while(tableNode.clientHeight < 560){
		var rowNode = document.createElement('tr');
		if(i % 2 != 0){
			rowNode.setAttribute('class', 'alt');
		}
		rowNode.style.height = '1.5em';
		var cellChkBox = document.createElement('td');
		cellChkBox.innerHTML = "";
		var cellName = document.createElement('td');
		cellName.innerHTML =  "";
		var cellSubj = document.createElement('td');
		cellSubj.innerHTML = "";		
		var cellRcvd = document.createElement('td');
		cellRcvd.innerHTML = "";
		rowNode.appendChild(cellChkBox);
		rowNode.appendChild(cellName);
		rowNode.appendChild(cellSubj);
		rowNode.appendChild(cellRcvd);
		tableNode.appendChild(rowNode);
		i++;
	}
}

var changeCheking = function(id) {
	var obj = document.getElementById(id);
	var checkBoxes = document.getElementsByName('checkMail');
	if(obj.checked == true){	
		for(i = 0; i < checkBoxes.length; i++){
			checkBoxes[i].checked = true;
		}
	}else {
		for(i = 0; i < checkBoxes.length; i++){
			checkBoxes[i].checked = false;
		}
	}
}

var runSearch = function(id){
	var obj = document.getElementById(id);
	var searchTxt = obj.value;
	loadFilteredMessages(searchTxt);
}

var loadFilteredMessages = function(chars){
	var xmlhttp;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.open("POST","http://localhost:8080/MailClientServer/MessageController",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("char=" + chars);
	xmlhttp.onreadystatechange = function(){
	  if (xmlhttp.readyState == 4 && xmlhttp.status == 200){
		 var  filteredList = xmlhttp.responseXML.getElementsByTagName("mail");
		 createFilteredList(filteredList);
	    }
	  }	
	}

var  createFilteredList = function(mailList) { 
	var filtered = new Array();
	for(i = 0; i < mailList.length; i++){
		var tempMail = mailList[i];
		var id = tempMail.childNodes[0].firstChild.nodeValue;
		var name = tempMail.childNodes[1].firstChild.nodeValue;
		var subj = tempMail.childNodes[2].firstChild.nodeValue;
		var rec = tempMail.childNodes[4].firstChild.nodeValue;
		var email = new eMail(id, name, subj, null, rec);
		filtered[i] = email;
	}
	createTable(filtered);
}
 


var updateMenu = function(){
	var menuNode = document.getElementById('menu');
	var numItems = menuNode.childNodes.length;
	for(i = 0; i < numItems; i++){
		menuNode.removeChild(menuNode.childNodes[0]);
	}
	createMenu(document.getElementById('menu'));
}
	











