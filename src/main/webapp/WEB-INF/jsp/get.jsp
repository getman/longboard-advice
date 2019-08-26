<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.xml.datatype.XMLGregorianCalendar" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="javax.xml.datatype.DatatypeFactory" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.*" %>
<%@ page import="longboard.util.HtmlStyle" %>
<%@ page import="static longboard.advice.Advisor.getAdvice" %>
<%@ page import="longboard.model.Weather" %>
<%@ page import="longboard.model.Condition" %>
<%@ page import="longboard.model.DayForecast" %>
<html>
<head><title>Hello world Example</title></head>
<body>
<h1>Current weather is: </h1>

<% Weather weather = (Weather)request.getAttribute("weather");%>
<% Condition x = ((Weather)request.getAttribute("weather")).getNow();%>
t: <%= x != null ? x.getTemp() : "undefined"%><br>
feel like: <%=x != null ? x.getFeelsLike() : "undefined"%><br>
condition: <%=x != null ? x.getRainAndCloud() : "undefined"%><br>

advice: <%=getAdvice(weather)%><br>
<% List<DayForecast> f = weather != null ? weather.getForecasts() : Collections.emptyList();%>
<% final GregorianCalendar nowGregCal = new GregorianCalendar();
XMLGregorianCalendar nowXmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(nowGregCal);
LocalDate now = LocalDate.of(nowXmlCal.getYear(),
     nowXmlCal.getMonth(),
     nowXmlCal.getDay());
Date nowTime = nowXmlCal.toGregorianCalendar().getTime();%>

<%--check if we have the cached data or actual--%>
<% Calendar nowCallTimeCalendar = Calendar.getInstance();
   Calendar serviceResponseTimeCalendar = Calendar.getInstance();
   serviceResponseTimeCalendar.setTime(
           ((Weather)request.getAttribute("weather")).getServiceCallSuccessTime());
   serviceResponseTimeCalendar.add(Calendar.SECOND, 5);
%>
<%if (serviceResponseTimeCalendar.before(nowCallTimeCalendar)) {%>
<span style="color:darkgreen;font-weight: bold">Using cached data you help polar bears to survive. This cache created at
      <%=serviceResponseTimeCalendar.getTime().toString()%></span>
<%}
%>

<% Calendar calendarStartPeriod = Calendar.getInstance();
calendarStartPeriod.set(Calendar.MINUTE, 0);
calendarStartPeriod.set(Calendar.SECOND, 0);
Calendar calendarEndPeriod = Calendar.getInstance();
calendarEndPeriod.set(Calendar.MINUTE, 0);
calendarEndPeriod.set(Calendar.SECOND, 0);
%>
<h1>Weather by day part: </h1>
<% for (DayForecast nextForecast: f) {%>
<% LocalDate forecastLocalDate = nextForecast.getDate();
boolean isToday = now.equals(forecastLocalDate);%>
date: <b><%= isToday ? "TODAY: " :
     forecastLocalDate.format(DateTimeFormatter.ofPattern("dd-MM-uuuu"))%></b><br>
<%--for the current forecast we have to style the day part (current or past)--%>
   <% calendarStartPeriod.set(Calendar.HOUR_OF_DAY, 0);
      calendarEndPeriod.set(Calendar.HOUR_OF_DAY, 6);
      Date forecastDateStartPeriod = calendarStartPeriod.getTime();
      Date forecastDateEndPeriod = calendarEndPeriod.getTime();%>
<span <%= HtmlStyle.getDayPartStyleTag(isToday, nowTime, forecastDateStartPeriod, forecastDateEndPeriod)%> >night:
   <%= nextForecast.getNight().getTMin()%>~<%= nextForecast.getNight().getTMax()%>,
   <%= nextForecast.getNight().getRainAndCloud()%></span><br>
   <% calendarStartPeriod.set(Calendar.HOUR_OF_DAY, 6);
      calendarEndPeriod.set(Calendar.HOUR_OF_DAY, 12);
      forecastDateStartPeriod = calendarStartPeriod.getTime();
      forecastDateEndPeriod = calendarEndPeriod.getTime();%>
<span <%= HtmlStyle.getDayPartStyleTag(isToday, nowTime, forecastDateStartPeriod, forecastDateEndPeriod)%> >morning:
   <%= nextForecast.getMorning().getTMin()%>~<%= nextForecast.getMorning().getTMax()%>,
   <%= nextForecast.getMorning().getRainAndCloud()%></span><br>
   <% calendarStartPeriod.set(Calendar.HOUR_OF_DAY, 12);
      calendarEndPeriod.set(Calendar.HOUR_OF_DAY, 18);
      forecastDateStartPeriod = calendarStartPeriod.getTime();
      forecastDateEndPeriod = calendarEndPeriod.getTime();%>
<span <%= HtmlStyle.getDayPartStyleTag(isToday, nowTime, forecastDateStartPeriod, forecastDateEndPeriod)%> >day:
   <%= nextForecast.getDay().getTMin()%>~<%= nextForecast.getDay().getTMax()%>,
   <%= nextForecast.getDay().getRainAndCloud()%></span><br>
   <% calendarStartPeriod.set(Calendar.HOUR_OF_DAY, 18);
      calendarEndPeriod.set(Calendar.HOUR_OF_DAY, 24);
      forecastDateStartPeriod = calendarStartPeriod.getTime();
      forecastDateEndPeriod = calendarEndPeriod.getTime();%>
<span <%= HtmlStyle.getDayPartStyleTag(isToday, nowTime, forecastDateStartPeriod, forecastDateEndPeriod)%> >evening:
   <%= nextForecast.getEvening().getTMin()%>~<%= nextForecast.getEvening().getTMax()%>,
   <%= nextForecast.getEvening().getRainAndCloud()%></span><br>
--------------------------------------<br>
<% }%>

</body>
</html>
