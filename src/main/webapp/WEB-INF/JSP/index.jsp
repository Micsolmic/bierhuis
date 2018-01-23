<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%> 
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html>
<v:head title='Beginpagina'/>
<body>
<v:links/>
<h1>Welkom in het huis van de Belgische bieren</h1>
<img src='/bierhuis/images/bierhuis.jpg' alt='afbeelding niet beschikbaar' title='bieren'/>
<br>
<p>We hebben momenteel 1186 bieren</p>
<hr>
<h1>index page</h1>
<form:form  commandName='persoon' method='get'> 
<form:label path='naam'>naam: <form:errors path='naam'/> </form:label> 
<form:input path='naam' autofocus='autofocus'/> 
<form:label path='leeftijd'>leeftijd: <form:errors path='leeftijd'/> </form:label>
<form:input path='leeftijd'/>
<input type='submit' value='submit'> 
</form:form>
<h2>${bindingresult}</h2>

</body>
</html>