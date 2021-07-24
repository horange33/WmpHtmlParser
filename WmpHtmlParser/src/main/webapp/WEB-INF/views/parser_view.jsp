<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>WMP Html Parser</title>
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
<div id="content" style="padding-top:50px;padding-left:50px;vertical-align: middle;display:table-cell;">
	<form name="parserForm" action="/search" method="post">
		<div id="inspace" style="width:320px;height:200px;">
			<h2>[입력]</h2>
			<div id="inspace2">
				<p>URL <input type="text" name="strURL" style="float:right;width:180px;"/></p>
				<p>Type <select name="strType" style="float:right;width:180px;">
					<option value="1">HTML 태그 제외</option>
					<option value="2">Text 전체</option>
				</select>
				</p>
				<p>출력 단위 묶음 <input type="number" name="leng" style="float:right;width:180px;"></p>
				<input type="button" onclick="search()" value="출력" style="float:right;">
			</div>
		</div>
	
	<div id="outspace" style="width:320px;height:250px;">
		<h2>[출력]</h2>
		<div id="outspace2">
			<div style="height:100px;">몫 : ${parserNum1}<textarea style="float:right;resize:none;width:220px;height:80px;" readonly>${parserInfo1}</textarea></div>
			<div style="height:100px;">나머지 : ${parserNum2}<textarea  style="float:right;resize:none;width:220px;height:80px;" readonly>${parserInfo2}</textarea></div>
		</div>
	</div>
	</form>
</div>

</body>

</html>