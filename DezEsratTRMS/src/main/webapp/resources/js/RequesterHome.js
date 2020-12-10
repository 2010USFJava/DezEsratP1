window.onload = function() {
	console.log("window");
	getFormById();
	//createTableFromJson(getFormById());
}

function getFormById() {
	console.log("inside the form");
	//	var obj, dbParam, form, txt = "";
	//	obj = { table: "form", limit: 20 };
	//	dbParam = JSON.stringify(obj);
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		console.log("the ready state has changed");
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let form = JSON.parse(xhttp.responseText);//we add this line later
			console.log(form);
			createTableFromJson(form);
		}
	}
	xhttp.open("GET", "http://localhost:8080/DezEsratTRMS/requesterHome.json");
	xhttp.send();
}
//			txt += "<table border='1'>"
//			for (i in form) {
//				txt += "<tr><td>" + form[i].formID + form[i].reqDate + form[i].reqAmount + form[i].status + form[i].finalGrade + "</td></tr>";
//			}
//			txt += "</table>"
//			document.getElementById("formByIdTable").innerHTML = txt;
//		}
//	}
//	xhttp.open("POST", "http://localhost:8080/DezEsratTRMS/requesterHome.json", true);
//	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//	xhttp.send("x=" + dbParam);
//}

function createTableFromJson(form) {
	console.log(form);
	var col = [];// this is our table header we don't need all colum
	for (var i = 0; i < form.length; i++) {
		for (var key in form[i]) {
			if (key !== 'empID' && key !== 'eventDate' && key !== 'eventID' && key !== 'gradeID' && col.indexOf(key) === -1) {
				console.log(key)
				col.push(key);
			}
			//col= [form[i].formID + form[i].reqDate + form[i].reqAmount + form[i].status + form[i].finalGrade];
		}

       }
		// CREATE DYNAMIC TABLE.

		var table = document.createElement("table");
		// CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.
		var tr = table.insertRow(-1);                   // TABLE ROW.
		for (var i = 0; i < col.length; i++) {
			var th = document.createElement("th");      // TABLE HEADER.
			th.innerHTML = col[i];
			tr.appendChild(th);
		}


		// ADD JSON DATA TO THE TABLE AS ROWS.
		for (var i = 0; i < form.length; i++) {
			tr = table.insertRow(-1);
			for (var j = 0; j < col.length; j++) {
				var tabCell = tr.insertCell(-1);
				tabCell.innerHTML = form[i][col[j]];
			}
		}

		// FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
		var divContainer = document.getElementById("formByIdTable");
		divContainer.innerHTML = "";
		divContainer.appendChild(table);

	}