<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 class="head">Delete Processed Item</h1>
		<form >
	
	        <label for="pId">Processed Item Id:</label>
	        <input type="number" id="pId" name="pid" readonly="readonly" value="<%=request.getAttribute("pid")%>">
	        <br><br>
	        <input type="submit" value="Delete">
	    </form>

</body>
</html>