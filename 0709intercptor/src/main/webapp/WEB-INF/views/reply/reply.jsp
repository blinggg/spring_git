<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>댓글목록</title>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<style>
		.divContent{width:500px;padding:10px;margin-bottom:10px;
			background:gray;color:white;border:1px solid black;
			font-size:10px;}
		#divInput{width:500px;padding:10px;margin-bottom:10px;
			background:gray;color:white;font-size:10px;}	
		button{font-size:10px;}
		a{text-decoration:none;}
		.active{color:red;}
	</style>
</head>
<body>
	<div id="divInput">
		게시글수:<span id="count"></span>&nbsp;&nbsp;
		<input type="text" id="txtReply" size=50>
		<button id="btnInsert">입력</button>
	</div>
	<div id="tbl"></div>
	<script id="temp" type="text/x-handlebars-template">
	{{#each list}}
		<div class="divContent">
			<div class="replydate">
				{{replydate}}
				[<b>{{replyer}}</b>]
				<button rno={{rno}} style="{{printStyle replyer}}">삭제</button>
			</div>
			<div class="reply">{{reply}}</div>
		</div>
	{{/each}}
	</script>
	<div id="pagination"></div>
</body>
<script>

		
	var replyer="${id}";
	var bno="${vo.bno}";
	var page=1;
	
	//댓글작성자와 로그인한 사람이 다를때 삭제버튼을 보이지 않게 하기
	Handlebars.registerHelper("printStyle",function(writer){
		   var src;
		   if(replyer!=writer) src="display:none";
		   return src;
		});
	
	$("#tbl").on("click", ".replydate button", function(){
		var rno=$(this).attr("rno");
		if(!confirm(rno + " 댓글을 삭제?")) return;
		$.ajax({
			type:"post",
			url:"/reply/delete",
			data:{"rno":rno},
			success:function(){
				alert("삭제완료!");
				getList();
			}
		});
	});
	
	$("#txtReply").keydown(function(key){
		if(key.keyCode==13){
			$("#btnInsert").click();
		}	
	});
	
	$("#btnInsert").on("click", function(){
		var reply=$("#txtReply").val();
		if(reply==""){
			alert("댓글 내용을 입력하세요!");
			return;
		}
		$.ajax({
			type:"post",
			url:"/reply/insert",
			data:{"bno":bno,"reply":reply,"replyer":replyer},
			success:function(){
				alert("댓글입력!");
				$("#txtReply").val("");
				getList();
			}
		});
	});
	
	getList();
	function getList(){
		$.ajax({
			type:"get",
			url:"/reply/list",
			data:{"bno":bno, "page":page},
			dataType:"json",
			success:function(data){
				var temp=Handlebars.compile($("#temp").html());
                $("#tbl").html(temp(data));
                $("#count").html(data.count);
                
              	//페이지 리스트 출력
                var str="";
                if(data.pm.prev){
                    str += "<a href='" + (data.pm.startPage-1) + "'>◀</a>"
                }
                for(var i=data.pm.startPage; i<= data.pm.endPage; i++){
                    if(data.pm.cri.page == i){
                        str += "[<a href='" + i + "' class='active'>" + i + "</a>]";
                    }else{
                        str += "[<a href='" + i + "'>" + i + "</a>]";
                    }
                }
                if(data.pm.next){
                    str += "<a href='" + (data.pm.endPage+1)  +  "'>▶</a>"
                }
                $("#pagination").html(str);
			}
		});
		
	    //페이지 번호를 클릭했을 경우
	    $("#pagination").on("click", "a", function(event){
	        event.preventDefault();
	        page = $(this).attr("href");
	        getList();
	    });
	}
</script>
</html>