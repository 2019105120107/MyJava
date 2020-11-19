
	function codeCheck2(){
		var cid = document.getElementById("newpwd");
		var c = cid.value;
		var codemsg2 = document.getElementById("codemsg2");
		if(c.length<8||c.length>20){codemsg2.innerHTML="密码太短或太长";}
		else{codemsg2.innerHTML="";}
	}
	function codeCheck3(){
		var cid = document.getElementById("newpwd");
		var c = cid.value;
		var cidr = document.getElementById("code3");
		var cr = cidr.value;
		var codemsg = document.getElementById("codemsg3");
		if(c==cr){codemsg.innerHTML="";}
		else{codemsg.innerHTML="两次密码不一致，请重新输入！";}
	}