<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<html>
<head>
<%
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String date = sdf.format(new Date());
%>
</head>
<body>
<p>Hello!  The time is now <%=date%></p>
</body>
</html>