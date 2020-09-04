<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<meta charset="UTF-8">
<style>
* {
	font-size: 10px;
}

body {
	overflow: hidden;
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
	background: #D4F4FA;
}

#container {
	overflow: auto;
	height: 87%;
	margin: 0px;
}

.content {
	overflow: hidden;
	width: 100%;
}

.content_left {
	float: left;
	margin: 5px;
	padding: 7px;
	border-radius: 5px 5px 5px 5px;
	background: white;
}

.content_right {
	float: right;
	margin: 5px;
	padding: 7px;
	border-radius: 5px 5px 5px 5px;
	background: yellow;
}

#bottom {
	position: fixed;
	height: 10%;
	left: 0px;
	right: 0px;
	bottom: 0px;
	padding-top: 15px;
	text-align: center;
}

#txtMessage {
	width: 70%;
	height: 25px;
	margin: 0px;
}

#btnSend {
	height: 25px;
	margin: 0px;
}

small {
	cursor: pointer;
	color: red;
}

.sdate {
	font-size: 8px;
	color: blue;
}
</style>
<title>채팅방</title>
</head>
<body>
	<div id="container"></div>
	<div id="bottom">
		<b><span id="userid">${id}</span></b> <input type="text"
			id="txtMessage"> <input type="button" value="Send"
			id="btnSend">
	</div>
</body>
<script>
	//게스트 문구 띄우기
	if ($("#userid").html() == "") {
		$("#userid").html("GUEST");
	}
	
	var sender = $("#userid").html();
	
	//send 버튼을 눌렀을 때
	$("#btnSend").on("click", function() {
		if ($("#txtMessage").val() == "") {
			alert("내용을 입력하세요!");
		}
	});

	//엔터키를 눌렀을 때
	$("#txtMessage").keydown(function(key) {
		if (key.keyCode == 13) {
			$("#btnSend").click();
		}
	});

	//웹소켓 관련 프로그램시작-----------------------------------------------//
	//웹소켓 생성
	var webSocket = new WebSocket('ws://localhost:8088/websocket');

	//메시지를 보냈을 때 발생
	function sendMessage() {
		var txtMessage = $("#txtMessage").val();
		var html = "<div class='content'>"
		html += "<p class='content_right'>" + txtMessage + "</p>";
		html += "</div>"
		$("#container").append(html);
		$("#container").scrollTop($("#container").prop("scrollHeight"));
		webSocket.send(sender + "|" + txtMessage);
		$("#txtMessage").val("");
	}

	//메시지를 받았을 때 발생
	webSocket.onmessage = function(event) {
		var message = event.data.split("|");
		var sender = message[0];
		var content = message[1];
		var html = "<div class='content'>"
		html += "<p class='content_left'><b>" + sender + "</b>: " + content
				+ "</p>";
		html += "</div>";
		$("#container").append(html);
		$("#container").scrollTop($("#container").prop("scrollHeight"));
	}
</script>
</html>