<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 class="head">Delete Raw Material</h1>
	<form  >

        <label for="rId">Raw Material Id:</label>
        <input type="number" id="accno" name="accno" readonly="readonly" value="<%=request.getAttribute("rid")%>">
        <br><br>
        <input type="submit" value="Delete">
    </form>

</body>
</html>