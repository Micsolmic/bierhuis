<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%> 
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html>
<head>
<title></title>
</head>
<body>

<h1>index page</h1>
<form:form  commandName='persoon' method='get'> 
<form:label path='naam'>input1:</form:label> 
<form:input path='naam' autofocus='autofocus'/> 
<form:label path='leeftijd'>input2:</form:label>
<form:input path='leeftijd'/>
<input type='submit' value='submit'> 
</form:form>
<h2>${bindingresult}</h2>

</body>
</html>