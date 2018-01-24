<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%> 
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html>
<v:head title='Brouwer info'/>
<body>
<v:links/>
<h1>${brouwer.naam}(${brouwer.adres.gemeente})</h1>

<div class="lijst">
<c:forEach var='bier' items='${bieren}'>

<c:url value='/brouwers/${brouwer.id}/${bier.id}' var='url'/>

<a href='${url}'>${bier.naam}</a>

</c:forEach>
</div>



</body>
</html>