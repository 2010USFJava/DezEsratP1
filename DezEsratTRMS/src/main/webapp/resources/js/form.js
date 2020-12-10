function calReqAmount(){

	var reqAmt=document.getElementById("reqAmount").value;
	var event=document.getElementById("event").value;
	console.log(reqAmt);
	console.log(event);

	switch (event) {
		case "1":
			reqAmt = parseFloat((reqAmt * .80)).toFixed(2);
			
			
			break;
		case "2":
			reqAmt = parseFloat((amount * .60)).toFixed(2);
			
			
			break;
		case "3":
			reqAmt = parseFloat((amount * .75)).toFixed(2);
			
			
		
			break;
		case "4":
			reqAmt = parseFloat((amount * .100)).toFixed(2);
			
			
			break;
		case "5":
			reqAmt = parseFloat((amount * .90)).toFixed(2);
			
			
			break;
		case "6":
			reqAmt = parseFloat((amount * .30)).toFixed(2);
			
			
			break;
		default:
			console.log("Error caught calculating reimbursement amount in form.js");
	}

}
