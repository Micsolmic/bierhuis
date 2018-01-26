<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%> 
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html>
<v:head title='Bestelling successvol!'/>
<body>
<div id='links'>
<a href='<c:url value="/"/>'>Welkom</a>
<a href='<c:url value="/brouwers"/>'>Brouwers</a>

</div>

<h1>Je winkelwagentje is bevestigd als bestelbon nummer ${bestelbonid}</h1>


</body>
</html>