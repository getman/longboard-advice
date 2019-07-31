<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="longboard.clients.YandexResponceJson" %>
<%@ page import="longboard.clients.DayForecast" %>
<%@ page import="java.util.List" %>
<html>
<head><title>Hello world Example</title></head>
<body>
<h1>Current weather is: </h1>
<% YandexResponceJson x = (YandexResponceJson)request.getAttribute("weather");%>
t: <%= x != null ? x.getFact().getTemp() : "undefined"%><br>
feel like: <%=x != null ? x.getFact().getFeels_like() : "undefined"%><br>
condition: <%=x != null ? x.getFact().getCondition() : "undefined"%><br>

<h1>Weather by day part: </h1>
<% List<DayForecast> f = x.getForecasts();%>
<% for (DayForecast nextForecast: f) {%>
date: <%= nextForecast.getDate()%><br>
night<br>
&#8195   t min: <%= nextForecast.getParts().getNight().getTemp_min()%><br>
&#8195   t max: <%= nextForecast.getParts().getNight().getTemp_max()%><br>
&#8195   condition: <%= nextForecast.getParts().getNight().getCondition()%><br>
morning<br>
&#8195   t min: <%= nextForecast.getParts().getMorning().getTemp_min()%><br>
&#8195   t max: <%= nextForecast.getParts().getMorning().getTemp_max()%><br>
&#8195   condition: <%= nextForecast.getParts().getMorning().getCondition()%><br>
<% }%>

</body>
</html>