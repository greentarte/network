<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
#main_center{
	margin:0 20px;
	width:760px;
	height:480px;
	background:white;
}
</style>    
<script>
//'#F45B5B' '#8085E9'
function display(category, input1, input2){
	Highcharts.theme = {
			   colors: ['#2b908f', '#90ee7e', '#f45b5b', '#7798BF', '#aaeeee', '#ff0066',
			      '#eeaaee', '#55BF3B', '#DF5353', '#7798BF', '#aaeeee'],
			   chart: {
			      backgroundColor: {
			         linearGradient: { x1: 0, y1: 0, x2: 1, y2: 1 },
			         stops: [
			            [0, '#2a2a2b'],
			            [1, '#3e3e40']
			         ]
			      },
			      plotBorderColor: '#606063'
			   },
			   title: {
			      style: {
			         color: '#E0E0E3',
			         textTransform: 'uppercase',
			         fontSize: '20px'
			      }
			   },
			   subtitle: {
			      style: {
			         color: '#E0E0E3',
			         textTransform: 'uppercase'
			      }
			   },
			   xAxis: {
			      gridLineColor: '#707073',
			      labels: {
			         style: {
			            color: '#E0E0E3'
			         }
			      },
			      lineColor: '#707073',
			      minorGridLineColor: '#505053',
			      tickColor: '#707073',
			      title: {
			         style: {
			            color: '#A0A0A3'

			         }
			      }
			   },
			   yAxis: {
			      gridLineColor: '#707073',
			      labels: {
			         style: {
			            color: '#E0E0E3'
			         }
			      },
			      lineColor: '#707073',
			      minorGridLineColor: '#505053',
			      tickColor: '#707073',
			      tickWidth: 1,
			      title: {
			         style: {
			            color: '#A0A0A3'
			         }
			      }
			   },
			   tooltip: {
			      backgroundColor: 'rgba(0, 0, 0, 0.85)',
			      style: {
			         color: '#F0F0F0'
			      }
			   },
			   plotOptions: {
			      series: {
			         dataLabels: {
			            color: '#B0B0B3'
			         },
			         marker: {
			            lineColor: '#333'
			         }
			      },
			      boxplot: {
			         fillColor: '#505053'
			      },
			      candlestick: {
			         lineColor: 'white'
			      },
			      errorbar: {
			         color: 'white'
			      }
			   },
			   legend: {
			      itemStyle: {
			         color: '#E0E0E3'
			      },
			      itemHoverStyle: {
			         color: '#FFF'
			      },
			      itemHiddenStyle: {
			         color: '#606063'
			      }
			   },
			   credits: {
			      style: {
			         color: '#666'
			      }
			   },
			   labels: {
			      style: {
			         color: '#707073'
			      }
			   },

			   drilldown: {
			      activeAxisLabelStyle: {
			         color: '#F0F0F3'
			      },
			      activeDataLabelStyle: {
			         color: '#F0F0F3'
			      }
			   },

			   navigation: {
			      buttonOptions: {
			         symbolStroke: '#DDDDDD',
			         theme: {
			            fill: '#505053'
			         }
			      }
			   },

			   // scroll charts
			   rangeSelector: {
			      buttonTheme: {
			         fill: '#505053',
			         stroke: '#000000',
			         style: {
			            color: '#CCC'
			         },
			         states: {
			            hover: {
			               fill: '#707073',
			               stroke: '#000000',
			               style: {
			                  color: 'white'
			               }
			            },
			            select: {
			               fill: '#000003',
			               stroke: '#000000',
			               style: {
			                  color: 'white'
			               }
			            }
			         }
			      },
			      inputBoxBorderColor: '#505053',
			      inputStyle: {
			         backgroundColor: '#333',
			         color: 'silver'
			      },
			      labelStyle: {
			         color: 'silver'
			      }
			   },

			   navigator: {
			      handles: {
			         backgroundColor: '#666',
			         borderColor: '#AAA'
			      },
			      outlineColor: '#CCC',
			      maskFill: 'rgba(255,255,255,0.1)',
			      series: {
			         color: '#7798BF',
			         lineColor: '#A6C7ED'
			      },
			      xAxis: {
			         gridLineColor: '#505053'
			      }
			   },

			   scrollbar: {
			      barBackgroundColor: '#808083',
			      barBorderColor: '#808083',
			      buttonArrowColor: '#CCC',
			      buttonBackgroundColor: '#606063',
			      buttonBorderColor: '#606063',
			      rifleColor: '#FFF',
			      trackBackgroundColor: '#404043',
			      trackBorderColor: '#404043'
			   },

			   // special colors for some of the
			   legendBackgroundColor: 'rgba(0, 0, 0, 0.5)',
			   background2: '#505053',
			   dataLabelsColor: '#B0B0B3',
			   textColor: '#C0C0C0',
			   contrastTextColor: '#F0F0F3',
			   maskColor: 'rgba(255,255,255,0.3)'
			};

			// Apply the theme
	Highcharts.setOptions(Highcharts.theme);
	
	Highcharts.chart('container', {
	    chart: {
	        zoomType: 'xy'
	    },
	    title: {
	        text: '녹지 만족도와 일반 녹지현황'
	    },
	    subtitle: {
	        text: 'Source: 서울시 공공데이터'
	    },
	    xAxis: [{
	        categories: category,
	        crosshair: true
	    }],
	    yAxis: [{ // Primary yAxis
	        labels: {
	            format: '{value}',
	            style: {
	                color: Highcharts.getOptions().colors[1]
	            }
	        },
	        title: {
	            text: '녹지 공간',
	            style: {
	                color: Highcharts.getOptions().colors[1]
	            }
	        }
	    }, { // Secondary yAxis
	        title: {
	            text: '녹지 만족도',
	            style: {
	                color: Highcharts.getOptions().colors[0]
	            }
	        },
	        labels: {
	            format: '{value}',
	            style: {
	                color: Highcharts.getOptions().colors[0]
	            }
	        },
	        opposite: true
	    }],
	    tooltip: {
	        shared: true
	    },
	    legend: {
	        layout: 'vertical',
	        align: 'left',
	        x: 120,
	        verticalAlign: 'top',
	        y: 100,
	        floating: true,
	        backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
	    },
	    series: [{
	        name: '만족도',
	        type: 'column',
	        yAxis: 1,
	        data: input1,
	        tooltip: {
	            valueSuffix: '5개 선호도 계산 추출'
	        }

	    }, {
	        name: '녹지 공간',
	        type: 'spline',
	        data: input2,
	        tooltip: {
	            valueSuffix: '개'
	        }
	    }]
	});
	
}

$(document).ready(function(){
	// Server에 데이터를 요청한다.
	// AJAX로
	$.ajax({
		url:'chart4impl.do',
		success:function(data){
			$.ajax({
				url:'chart4impl2.do',
				success:function(data2){
					$.ajax({
						url:'chart4impl3.do',
						success:function(data3){
							display(data, data2, data3);
						},
						error:function(){
							alert('fail');
						}
					});
				},
				error:function(){
					alert('fail');
				}
			});
		},
		error:function(){
			alert('fail');
		}
	}); 

/* 	var datas =[
				{"name":"1월","y":233144},
				{"name":"4월","y":250085},
				{"name":"2월","y":233511},
				{"name":"3월","y":272779}
				];
	display(datas); */
	
	/* var datas = [
		{name:'지훈',y:70},
		{name:'다혜',y:90},
		{name:'용원',y:80},
		{name:'영무',y:60},
		{name:'란영',y:99},
		{name:'선빈',y:40},
		{name:'호진',y:50},
		{name:'유정',y:80},
		{name:'상우',y:70},
		{name:'현경',y:90}
		]; */
		
});
</script>
<div id="main_center">
<h1>Chart4</h1>
<div id="container" style="min-width: 300px; height: 400px; margin: 0 auto"></div>

</div>







