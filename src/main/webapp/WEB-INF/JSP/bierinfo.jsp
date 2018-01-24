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
<h1>${bier.naam}</h1>

<b>Alcohol</b><br>
<spring:eval expression='bier.alcohol'/> %
<br><br>
<b>Prijs</b><br>
<spring:eval expression='bier.prijs'/> &#8364;
<br><br>
<b>Soort</b><br>
${bier.soort.naam}
<br><br>
<b>Brouwer</b><br>
${bier.brouwernaam}
<br><br>

<form  method='post'>
<label for='aantal'><b>Aantal:</b></label><br>
<input name='aantal' type='number' min='0' max='100'/><br>
<input name='bierid' value='${bierid}' hidden='true'/>
<input type='submit' value='Toevoegen' class='submitKnop'>
</form>


</body>
</html>