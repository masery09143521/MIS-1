<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
            <%@ page import="java.util.List" %>
    <%@ page import="com.opensymphony.xwork2.ActionContext" %>
    <%@ page import="Entity.Guitar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查询结果</title>
</head>
<body>
${sessionScope.result }
<a href="search">返回</a>
<table>
	<tr>
		<td>serialNumber</td>
		<td>price</td>
		<td>builder</td>
		<td>model</td>
		<td>type</td>
		<td>backWood</td>
		<td>topWood</td>
	</tr>
	<%ActionContext a=ActionContext.getContext();
	List<Guitar> list = (List)a.getSession().get("list");
	for(Guitar g : list){%>
	<tr>
		<td><%=g.getSerialNumber() %></td>
		<td><%=g.getPrice() %></td>
		<td><%=g.getBuilder() %></td>
		<td><%=g.getModel() %></td>
		<td><%=g.getType() %></td>
		<td><%=g.getBackWood() %></td>
		<td><%=g.getTopWood() %></td>
	</tr>
	<%} %>
</table>
</body>
</html>