<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<style>
#main_center {

}



#container{


  width:90%;
  margin :0 auto;

}






</style>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>


<script>
	function display(input,input2) {

		Highcharts
				.chart(
						'container',
						{
							chart : {
								type : 'column'
							},
							title : {
								text : '4차 산업혁명 선도인력 양성과정'
							},
							subtitle : {
								text : '전체출석률'
							},
							xAxis : {
								type : 'category'
							},
							yAxis : {
								title : {
									text : ''
								}

							},
							legend : {
								enabled : false
							},
							plotOptions : {
								series : {
									borderWidth : 0,
									dataLabels : {
										enabled : true,
										format : '{point.y:.1f}%'
									}
								}
							},

							tooltip : {
								headerFormat : '<span style="font-size:11px">{series.name}</span><br>',
								pointFormat : '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.1f}%</b> of total<br/>'
							},

							"series" : [ {
								"name" : "전체 출석률",
								"colorByPoint" : true,
								"data" : input
							} ],
							"drilldown" : {
								"series" : input2

							}
						});

	}

	$(document).ready(function() {
		// Server에 데이터를 요청한다.
		// AJAX

		$.ajax({
			url : '/mv/webview2.do?',
			success : function(data) {

				//

				$.ajax({
					url : '/mv/webview3.do?',
					success : function(data2) {
						display(data,data2);
					},
					error : function() {
						alert('fail');
					}
				});

				//

			},
			error : function() {
				alert('fail');
			}
		});

	});
</script>



<div id="main_center">
	<div id="container"></div>
</div>







