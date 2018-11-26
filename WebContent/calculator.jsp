<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="cal" method="post">

	<div>
		<input type="text" name="total" value="${total}" /><br> 
		<!-- <input type="text" name="total" value="total" /><br> -->
		
		<input type="submit" name="cmd" value="c"/>
		<input type="submit" name="cmd" value="<-"/>
		<input type="submit" name="cmd" value="/"/><br> 
		
		<input type="submit" name="cmd" value="7"/>
		<input type="submit" name="cmd" value="8"/>
		<input type="submit" name="cmd" value="9"/>
		<input type="submit" name="cmd" value="*"/><br> 
	
		
		 
		<input type="submit" name="cmd" value="4"/>
		<input type="submit" name="cmd" value="5"/>
		<input type="submit" name="cmd" value="6"/>
		<input type="submit" name="cmd" value="-"/><br> 
	
		 
		 
		<input type="submit" name="cmd" value="1"/>
		<input type="submit" name="cmd" value="2"/>
		<input type="submit" name="cmd" value="3"/>
		<input type="submit" name="cmd" value="+"/><br> 
	
		<input type="submit" name="cmd" value="0"/>
		<input type="submit" name="cmd" value="="/>
	</div>

</form>



</body>
</html>