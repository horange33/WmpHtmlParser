<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>위메프 과제</title>
</head>

<script type="text/javascript">
		function search(){
			let parserForm = document.parserForm;
			
            if(validation()){
            	parserForm.submit();
            }else{
            	alert("출력 실패하였습니다.");
            }
		}

        function validation(){
        	const regex = /^(((http(s?))\:\/\/)?)([0-9a-zA-Z\-]+\.)+[a-zA-Z]{2,6}(\:[0-9]+)?(\/\S*)?/;
        	const regex2 = /\d/;  
            
        	if(!regex.test(parserForm.strURL.value)){
        		alert("URL형식에 맞게 입력해 주세요.");
        		return false;
        	} else if(!regex2.test(parserForm.leng.value)) {
        		alert("출력 단위 묶음(숫자)을 입력해 주세요.");
        		return false;
        	} else if(parserForm.leng.value <= 0) {
        		alert("출력 단위 묶음(숫자)는 최소 1이상 입력해 주세요.");
        		return false;
        	}
        	return true;
        }
    </script>

<body>
<div id="content" style="margin-top:30px;vertical-align: middle;display:table-cell;">
	<form name="parserForm" action="/" method="GET">
		<div id="inspace">
			<h1>[입력]</h1>
			<p>URL&nbsp;&nbsp;<input type="text" name="strURL"/></p>
			<p>Type&nbsp;&nbsp;<select name="strType">
				<option value="1">HTML 태그 제외</option>
				<option value="2">Text 전체</option>
			</select>
			</p>
			<p>출력&nbsp;단위&nbsp;묶음&nbsp;&nbsp;<input type="number" name="leng"></p>
			<input type="button" onclick="search()" value="출력">
		</div>
	
	<div id="outspace">
		<h1>[출력]</h1>
		<p>몫 : <textarea cols="50" rows="10" readonly>${parserInfo1}</textarea></p>
		<p>나머지 : ${parserInfo2}</p>
	</div>
	</form>
</div>

</body>

</html>