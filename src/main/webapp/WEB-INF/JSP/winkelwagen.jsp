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
<c:forEach var='bier' items='${mandje.inhoud}'>

<tr><td>${bier.naam}</td><td>${bier.prijs} </td><td>${bier.aantal}</td><td>${bier.prijs*bier.aantal} </td><td></td></tr>

</c:forEach>
<tr><td></td><td></td><td></td><td><b>${mandje.totaal} &#8364;</b></td></tr>
</table>
<form:form action='' commandName='bestelbon' id='bestelform' method='post'>
<form:label path='naam'>Naam<form:errors path='naam'/></form:label> <br>
<form:input path='naam' autofocus='autofocus' required='required' maxlength='50'/> <br>
<form:label path='adres.straat'>Straat<form:errors path='adres.straat'/></form:label> <br>
<form:input path='adres.straat' autofocus='autofocus' required='required' maxlength='50'/> <br>
<form:label path='adres.huisNr'>Huisnummer<form:errors path='adres.huisNr'/></form:label> <br>
<form:input path='adres.huisNr' autofocus='autofocus' required='required' maxlength='50'/> <br>
<form:label path='adres.postcode'>Postcode<form:errors path='adres.postcode'/></form:label> <br>
<form:input path='adres.postcode' autofocus='autofocus' required='required' maxlength='50'/> <br>
<form:label path='adres.gemeente'>Gemeente<form:errors path='adres.gemeente'/></form:label> <br>
<form:input path='adres.gemeente' autofocus='autofocus' required='required' maxlength='50'/> <br>

<input type='submit' value='Als bestelbon bevestigen' id='submitknop'> 
</form:form>

</body>
</html>