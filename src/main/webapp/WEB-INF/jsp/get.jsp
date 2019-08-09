<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="longboard.clients.YandexResponceJson" %>
<%@ page import="longboard.clients.DayForecast" %>
<%@ page import="javax.xml.datatype.XMLGregorianCalendar" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="javax.xml.datatype.DatatypeFactory" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<html>
<head><title>Hello world Example</title></head>
<body>
<h1>Current weather is: </h1>
<%!
   public String getStyleTag(boolean isToday, Date nowTime, Date forecastDateStartPeriod, Date forecastDateEndPeriod) {
       if (isToday && nowTime.after(forecastDateStartPeriod) && nowTime.before(forecastDateEndPeriod)) {
         return "style=\"color:red;\"";
      } else if (isToday && nowTime.after(forecastDateEndPeriod)) {
          return "style=\"color:grey;\"";
       } else {
         return "";
      }
   }
%>

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
     nowXmlCal.getDay());
Date nowTime = nowXmlCal.toGregorianCalendar().getTime();%>
<% Calendar calendarStartPeriod = Calendar.getInstance();
calendarStartPeriod.set(Calendar.MINUTE, 0);
calendarStartPeriod.set(Calendar.SECOND, 0);
Calendar calendarEndPeriod = Calendar.getInstance();
calendarEndPeriod.set(Calendar.MINUTE, 0);
calendarEndPeriod.set(Calendar.SECOND, 0);
%>
<% for (DayForecast nextForecast: f) {%>
<% LocalDate forecastLocalDate = LocalDate.of(nextForecast.getDate().getYear(),
     nextForecast.getDate().getMonth(),
     nextForecast.getDate().getDay());
boolean isToday = now.equals(forecastLocalDate);%>
date: <b><%= isToday ? "TODAY: " :
     forecastLocalDate.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"))%></b><br>
<%--for the current forecast we have to style the day part (current or past)--%>
   <% calendarStartPeriod.set(Calendar.HOUR, 0);
      calendarEndPeriod.set(Calendar.HOUR, 6);
      Date forecastDateStartPeriod = calendarStartPeriod.getTime();
      Date forecastDateEndPeriod = calendarEndPeriod.getTime();%>
<span <%= getStyleTag(isToday, nowTime, forecastDateStartPeriod, forecastDateEndPeriod)%> >night: <%= nextForecast.getParts().getNight().getTemp_min()%>~<%= nextForecast.getParts().getNight().getTemp_max()%>,
   <%= nextForecast.getParts().getNight().getCondition()%></span><br>
   <% calendarStartPeriod.set(Calendar.HOUR_OF_DAY, 6);
      calendarEndPeriod.set(Calendar.HOUR_OF_DAY, 12);
      forecastDateStartPeriod = calendarStartPeriod.getTime();
      forecastDateEndPeriod = calendarEndPeriod.getTime();%>
<span <%= getStyleTag(isToday, nowTime, forecastDateStartPeriod, forecastDateEndPeriod)%> >morning - t: <%= nextForecast.getParts().getMorning().getTemp_min()%> -
   <%= nextForecast.getParts().getMorning().getTemp_max()%>,
   condition:<%= nextForecast.getParts().getMorning().getCondition()%></span><br>
   <% calendarStartPeriod.set(Calendar.HOUR_OF_DAY, 12);
      calendarEndPeriod.set(Calendar.HOUR_OF_DAY, 18);
      forecastDateStartPeriod = calendarStartPeriod.getTime();
      forecastDateEndPeriod = calendarEndPeriod.getTime();%>
<span <%= getStyleTag(isToday, nowTime, forecastDateStartPeriod, forecastDateEndPeriod)%> >day - t: <%= nextForecast.getParts().getDay().getTemp_min()%> -
   <%= nextForecast.getParts().getDay().getTemp_max()%>,
   condition:<%= nextForecast.getParts().getDay().getCondition()%></span><br>
   <% calendarStartPeriod.set(Calendar.HOUR_OF_DAY, 18);
      calendarEndPeriod.set(Calendar.HOUR_OF_DAY, 24);
      forecastDateStartPeriod = calendarStartPeriod.getTime();
      forecastDateEndPeriod = calendarEndPeriod.getTime();%>
<span <%= getStyleTag(isToday, nowTime, forecastDateStartPeriod, forecastDateEndPeriod)%> >evening - t: <%= nextForecast.getParts().getEvening().getTemp_min()%> -
   <%= nextForecast.getParts().getEvening().getTemp_max()%>,
   condition:<%= nextForecast.getParts().getEvening().getCondition()%></span><br>
--------------------------------------<br>
<% }%>

</body>
</html>
