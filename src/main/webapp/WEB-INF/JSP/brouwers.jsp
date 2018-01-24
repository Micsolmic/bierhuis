<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%> 
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html>
<v:head title='Brouwers alfabetisch'/>
<body>
<v:links/>
<h1>Brouwers</h1>

<div id="brouwerslijst">
<c:forEach var='brouwer' items='${brouwers}'>

<c:url value='/brouwers/${brouwer.id}' var='url'/>

<a href='${url}'>${brouwer.naam} (${brouwer.adres.gemeente})</a>

</c:forEach>
</div>



</body>
</html>