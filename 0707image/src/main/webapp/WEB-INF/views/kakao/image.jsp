<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<meta charset="UTF-8">
<title>이미지검색</title>
<style>
	.row {
		width: 200px;
		height: 200px;
		padding: 5px;
		margin: 5px;
		background: #BBD4E5;
		color: white;
		float: left;
		font-size: 15px;
	}
</style>
</head>
<body>
	<h1>이미지검색</h1>
	<input type="text" id="query" value="서예지">
	<button id="btnSearch">검색</button>
	
	<table id="tbl" style=" width:1050px; background: #CFF0F8;"></table>
	<script id="temp" type="text/x-handlebars-template">
	{{#each documents}}
		<tr class="row">
			<td width=200>
				<img src="{{image_url}}" width=150 height=150>
			</td>
			<td>
				<button image="{{image_url}}">📥</button>
			</td>
		</tr>
	{{/each}}
	</script>
</body>
<script>
	getList();
	
	//이미지 url가져와서 이미지 다운로드 하기
	  $("#tbl").on("click",".row button",function(){
	      var image=$(this).attr("image");
	      //alert(image);
	      $.ajax({
	         type:"get",
	         url:"/download",
	         data:{"image":image},
	         success:function(){
	            alert("다운로드 성공!");
	         }
	      });
	   });

	//검색을 눌렀을 때
	$("#btnSearch").on("click", function(){
		getList();	
	});
	
	//Enter key를 눌렀을 때
	   $("#query").keydown(function(key){
	      if(key.keyCode==13){
	         getList();
	      }
	   });
	
	//query 값으로 이미지 검색하는 함수
	function getList(){
	    var query=$("#query").val();
	    $.ajax({
	          type:"get",
	          url:"https://dapi.kakao.com/v2/search/image",
	          headers:{"Authorization":"KakaoAK 4c9947b8b0448265ca15036c39a7fa4e"},
	          dataType:"json",
	          data:{"query":query,"size":30},
	          success:function(data){
	              var template = Handlebars.compile($("#temp").html());
	              $("#tbl").html(template(data));
	          }
	      });
	 }
</script>
</html>