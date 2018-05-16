<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style>
table {
	border-collapse: collapse;
	line-height: 1.5;
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
	margin-bottom: 20px;
	font-size: 0.8em;
	width:95%;
	text-align: center;
}

th {
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	background: rgba(239, 244, 249, 0.5);
	border-bottom: 1.5px solid #e6e8ed;
	border-top: 1.5px solid #e6e8ed;
}

td {
	padding: 10px;
	vertical-align: top;
	border-bottom: 1.5px solid #e6e8ed;
}

tbody tr:nth-child(even) {
	background-color: rgba(247, 248, 249, 0.5);
}
</style>

<body>

	<table id="tab">
		<!-- 		<tr>
			<th>번호</th>
			<th width=50%;>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr> -->

		<tbody>
			<tr>
				<th>현재 단위기간</td>
				<th>${unit}단위 (${start}~${end})</td>
			</tr>
			
		   <tr>
				<th>단위 수업일수</td>
				<th>${sum}일</td>
			</tr>

			<tr>
				<td>지각(단위 기준)</td>
				<td>${ji}</td>
			</tr>

			<tr>
				<td>조퇴(단위 기준)</td>
				<td>${jo}</td>
			</tr>

			<tr>
				<td>결석(단위 기준)</td>
				<td>${gyul}</td>
			</tr>
			
			<tr>
			    <td>출석(단위 기준)</td>
				<td>${chul}</td>
			</tr>

			<tr>
				<td>전체 출석률</td>
				<td>${total}%</td>
			</tr>


		</tbody>

	</table>




</body>


</html>