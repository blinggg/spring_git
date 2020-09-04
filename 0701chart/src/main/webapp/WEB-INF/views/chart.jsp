<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <title>구글 차트 라이브러리</title>
    <!-- 라이브러리 Load -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<select id="selChart" style="height:25px;">
	<option value="/chart/sum1">강좌별 평균</option>
	<option value="/chart/sum2">학생별 평균</option>
	<option value="/chart/sum3">강좌별 수강신청인원수</option>
	<option value="/chart/sum4">학생별 수강신청과목수</option>
	<option value="/chart/sum5">학생별 평균,수강신청과목수</option>
	<option value="/chart/sum6">강좌별 신청인원, 최고점수, 최저점수, 평균</option>
	<option value="/chart/sum7">학과별 인원 수</option>
</select>
<select id="selChart1" style="height:25px;">
	<option>선택해주세요!</option>
	<option value="/chart/sum7">학과별 인원 수</option>
	<option value="/chart/sum3">강좌별 수강인원 수</option>
</select>
    <div id="chart_div" style="width:600px; height:500px;"></div>
    <div id="chart_div1" style="width:800px; height:500px;"></div>
</body>
<script type="text/javascript">
	var url="/chart/sum1";
	var title="강좌별 평균";
	changeChart();
	
	$("#selChart").change(function() {
		url=$("#selChart").val();
		title= $("#selChart option:checked").text();
		changeChart();
	});
	$("#selChart1").change(function() {
		url=$("#selChart1").val();
		title= $("#selChart1 option:checked").text();
		changeChart2();
	});
	
   
    function changeChart(){
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawVisualization);
        function drawVisualization() { 
            $.ajax({
                type:"get",
                url:url,
                dataType:"json",
                success:function(result){
                    /* 데이터 셋팅 */
                    var data = google.visualization.arrayToDataTable(result);

                    /* 옵션 셋팅 */
                    var options = {
                        title : title,
                        seriesType: 'bars',
                        series:{3:{type:'line'}}
                    };

                    /* 차트 그리기 */
                    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
                    chart.draw(data, options);
                }
            });
        }
    }
    
    function changeChart2(){
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawVisualization);
        function drawVisualization() { 
            $.ajax({
                type:"get",
                url:url,
                dataType:"json",
                success:function(result){
                    /* 데이터 셋팅 */
                    var data = google.visualization.arrayToDataTable(result);

                    /* 옵션 셋팅 */
                    var options = {
                        title : title,
                        pieHole: 0.4,
                        slices: {  5: {offset: 0.2}
               			   }
                    };

                    /* 차트 그리기 */
                    var chart = new google.visualization.PieChart(document.getElementById('chart_div1'));
                    chart.draw(data, options);
                }
            });
        }
    }
</script>
</html>