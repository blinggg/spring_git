<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <title>구글 차트 라이브러리</title>
    <!-- 라이브러리 Load -->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
    <div id="chart_div" style="width:600px; height:500px;"></div>
</body>
<script type="text/javascript">
    changeChart();
    function changeChart(){
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawVisualization);
        function drawVisualization() { 
            $.ajax({
                type:"get",
                url:"/stu/chartEnroll",
                dataType:"json",
                data:{"scode":scode},
                success:function(result){
                    /* 데이터 셋팅 */
                    var data = google.visualization.arrayToDataTable(result);

                    /* 옵션 셋팅 */
                    var options = {
                        title : '강좌별 평균 점수',
                        seriesType: 'bars'
                    };

                    /* 차트 그리기 */
                    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
                    chart.draw(data, options);
                }
            });
        }
    }
</script>
</html>