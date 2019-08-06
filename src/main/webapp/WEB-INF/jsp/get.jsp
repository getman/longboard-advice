<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="longboard.clients.YandexResponceJson" %>
<%@ page import="longboard.clients.DayForecast" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.xml.datatype.XMLGregorianCalendar" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="javax.xml.datatype.DatatypeFactory" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Collections" %>
<html>
<head><title>Hello world Example</title></head>
<body>
<h1>Current weather is: </h1>
<% YandexResponceJson x = (YandexResponceJson)request.getAttribute("weather");%>
t: <%= x != null ? x.getFact().getTemp() : "undefined"%><br>
feel like: <%=x != null ? x.getFact().getFeels_like() : "undefined"%><br>
condition: <%=x != null ? x.getFact().getCondition() : "undefined"%><br>

<h1>Weather by day part: </h1>
<% List<DayForecast> f = x != null ? x.getForecasts() : Collections.emptyList();%>
<% final GregorianCalendar nowGregCal = new GregorianCalendar();
XMLGregorianCalendar nowXmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(nowGregCal);
LocalDate now = LocalDate.of(nowXmlCal.getYear(),
        nowXmlCal.getMonth(),
        nowXmlCal.getDay());%>
<% for (DayForecast nextForecast: f) {%>
<% LocalDate forecastDate = LocalDate.of(nextForecast.getDate().getYear(),
        nextForecast.getDate().getMonth(),
        nextForecast.getDate().getDay());%>
date: <b><%= now.equals(forecastDate) ? "TODAY: " :
        forecastDate.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"))%></b><br>
night - t: <%= nextForecast.getParts().getNight().getTemp_min()%> -
   <%= nextForecast.getParts().getNight().getTemp_max()%>,
   condition:<%= nextForecast.getParts().getNight().getCondition()%><br>
morning - t: <%= nextForecast.getParts().getMorning().getTemp_min()%> -
   <%= nextForecast.getParts().getMorning().getTemp_max()%>,
   condition:<%= nextForecast.getParts().getMorning().getCondition()%><br>
day - t: <%= nextForecast.getParts().getDay().getTemp_min()%> -
   <%= nextForecast.getParts().getDay().getTemp_max()%>,
   condition:<%= nextForecast.getParts().getDay().getCondition()%><br>
evening - t: <%= nextForecast.getParts().getEvening().getTemp_min()%> -
   <%= nextForecast.getParts().getEvening().getTemp_max()%>,
   condition:<%= nextForecast.getParts().getEvening().getCondition()%><br>
--------------------------------------<br>
<% }%>

</body>
</html>