	function idCheck(){
		var bid = document.getElementById("bookid");
		var idmsg = document.getElementById("idmsg");
		var b = bid.value;
		if(b==""){idmsg.innerHTML=="图书ID不可为空";}
		else{idmsg.innerHTML=="";}
	}
	function nameCheck(){
		var bid = document.getElementById("bookname");
		var namemsg = document.getElementById("namemsg");
		var b = bid.value;
		if(b==""){idmsg.innerHTML=="图书名字不可为空";}
		else{namemsg.innerHTML=="";}
	}
	function typeCheck(){
		var bid = document.getElementById("booktype");
		var typemsg = document.getElementById("typemsg");
		var b = bid.value;
		if(b==""){idmsg.innerHTML=="图书类型不可为空";}
		else{typemsg.innerHTML=="";}
	}
	function stockCheck(){
		var bid = document.getElementById("bookstock");
		var stockmsg = document.getElementById("stockmsg");
		var b = bid.value;
		if(b==""){idmsg.innerHTML=="图书数量不可为空";}
		else{stockmsg.innerHTML=="";}
	}
	function priceCheck(){
		var bid = document.getElementById("bookprice");
		var pricemsg = document.getElementById("pricemsg");
		var b = bid.value;
		if(b==""){idmsg.innerHTML=="图书单价不可为空";}
		else{pricemsg.innerHTML=="";}
	}
	function subCheck(){
		var iid = document.getElementById("bookid");
		var nid = document.getElementById("bookname");
		var tid = document.getElementById("booktype");
		var sid = document.getElementById("bookstock");
		var pid = document.getElementById("bookprice");
		
		var idmsg = document.getElementById("idmsg");
		var namemsg = document.getElementById("namemsg");
		var typemsg = document.getElementById("typemsg");
		var stockmsg = document.getElementById("stockmsg");
		var pricemsg = document.getElementById("pricemsg");
		var i = iid.value;
		var n = nid.value;
		var t = tid.value;
		var s = sid.value;
		var p = pid.value;
		if(i==""||n==""||t==""||s==""||p==""||idmsg.innerHTML!=""||namemsg.innerHTML!=""||typemsg.innerHTML!=""||stockmsg.innerHTML!=""||pricemsg.innerHTML!=""){
			alert("您所填写的信息不正确，请重新填写！");
			event.preventDefault();
		}
	}