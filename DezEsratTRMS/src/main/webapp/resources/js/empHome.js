window.onload=function(){
	console.log("window");
	getFormByStatus();
}

function getFormByStatus(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		console.log("the ready state has changed");
		if(xhttp.readyState==4 && xhttp.status==200){
			let form = JSON.parse(xhttp.responseText);
			console.log(form);
		}
	}
	xhttp.open("GET","http://localhost:8080/DezEsratTRMS/empHome.json");
	
	xhttp.send();
}
