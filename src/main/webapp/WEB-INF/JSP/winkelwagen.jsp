<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%> 
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html>
<v:head title='Winkelwagen'/>
<body>
<v:links/>
<h1>Winkelwagen</h1>
<table>
<tr><th>Bier</th><th>Prijs</th><th>Aantal</th><th>Te betalen</th></tr>
<c:forEach var='bier' items='${bieren}'>

<tr><td>${bier.naam}</td>${bier.prijs}<td></td><td></td><td></td></tr>

</c:forEach>

</table>




</body>
</html>