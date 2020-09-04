<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<style>
 #container { width:960px;background:pink;overflow:hidden; }
 .box{ width:200px;float:left; background:gray;text-align:center; padding:10px; margin:10px;color:white; }
 #naver, #daum { background:gray;color:white; width:930px; padding:15px;font-size:25px; }
 .title { width:180px; text-overflow:ellipsis;overflow:hidden;white-space:nowrap; }
</style>
<title>크롤링결과</title>
</head>
<body>
	<h1>[다음날씨]</h1>
	<div id="daum">
		<span id="today"></span>
		<span id="weather"></span>
	</div>
	
	<h1>[영화정보]</h1>
	<div id="cgv">
		<span id="movie"></span>
		<span id="image"></span>
	</div>
	
	<h1>[CGV 영화차트]</h1>
 <div id="container"></div>
 <script id="temp" type="text/x-handlebars-template">
 	{{#each array}}
		<div class="box">
 		<img src="{{image}}" width=180>
 		<div class="title">{{rank}} 제목:{{title}}</div>
 		<div class="date">개봉일:{{date}}</div>
 		</div>
 	{{/each}}
 </script>
</body>
<script>
	getList();
	function getList(){ //영화 목록 출력
		$.ajax({
		type:"get", 
		url:"movie.json", 
		success:function(data) {
			var temp=Handlebars.compile($("#temp").html());
			$("#container").html(temp(data));
			}
		});
	}
	
	//영화 정보 보여주기
	getMovie();
   var movie=[];
   function getMovie(){
      $.ajax({
         type:"get",
         url:"/movie.json",
         dataType:"json",
         success:function(data){
		
            var i=0;
            $(data.array).each(function(){
               var rank=this.rank;
               var title=this.title;
               var image=this.image;
               var date=this.date;
               //console.log(part + ico + temper + wa);
               movie[i]=rank+" "+title+" "+image+date
               i++;
            });
            
            i=0;
            var interval=setInterval(function(){
               $("#movie").html(movie[i]);
               $("#image").html(data.image);
               if(i<movie.length-1){
                  i++;
               }else{
                  i=0;
               }
            },1000);
         }
      })
   }
	//날씨 정보 보여주기
   getWeather();
   var weather=[];
   function getWeather(){
      $.ajax({
         type:"get",
         url:"/weather.json",
         dataType:"json",
         success:function(data){
            $("#today").html(data.date);
            var i=0;
            $(data.array).each(function(){
               var part=this.part;
               var ico=this.ico;
               var temper=this.temper;
               var wa=this.wa;
               //console.log(part + ico + temper + wa);
               weather[i]=part+" "+ico+" "+temper+wa
               i++;
            });
            
            i=0;
            var interval=setInterval(function(){
               $("#weather").html(weather[i]);
               if(i<weather.length-1){
                  i++;
               }else{
                  i=0;
               }
            },1000);
         }
      })
   }
</script>
</html>