	function userCheck(){
		var zid = document.getElementById("useraccount");
		var z = zid.value;
		var zmsg = document.getElementById("usermsg");
		if(z==""){zmsg.innerHTML="账号不能为空！";}
		else{zmsg.innerHTML="";}
	}
	function codeCheck(){
		var cid = document.getElementById("userpassword");
		var c = cid.value;
		var cidr = document.getElementById("userpasswordr");
		var cr = cidr.value;
		var codemsg = document.getElementById("codemsg");
		if(c==cr){codemsg.innerHTML="";}
		else{codemsg.innerHTML="两次密码不一致，请重新输入！";}
	}	
	function codeCheck2(){
		var cid = document.getElementById("userpassword");
		var c = cid.value;
		var codemsg0 = document.getElementById("codemsg0");
		if(c.length<8||c.length>20){codemsg0.innerHTML="密码太短或太长";}
		else{codemsg0.innerHTML="";}
	}
	function phoneCheck(){
		var zid = document.getElementById("phone");
		var z = zid.value;
		var zmsg = document.getElementById("phonemsg");
		if(z==""){zmsg.innerHTML="手机号不能为空！";}
		else{zmsg.innerHTML="";}
	}
	function addrCheck(){
		var zid = document.getElementById("address");
		var z = zid.value;
		var zmsg = document.getElementById("addrmsg");
		if(z==""){zmsg.innerHTML="地址不能为空！";}
		else{zmsg.innerHTML="";}
	}
	function subCheck(){
		var zid = document.getElementById("useraccount");
		var cid = document.getElementById("userpassword");
		var cidr = document.getElementById("userpasswordr");
		var codemsg = document.getElementById("codemsg");
		var codemsg0 = document.getElementById("codemsg0");
		var z = zid.value;
		var c = cid.value;
		var cr = cidr.value;
		if(z==""||c==""||cr==""||codemsg.innerHTML!=""||codemsg0.innerHTML!=""){
			alert("您所填写的信息不正确，请重新填写！");
			event.preventDefault();
		}
	}
