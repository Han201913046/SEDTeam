<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="id"/>
<jsp:setProperty name="user" property="pw"/>
<jsp:setProperty name="user" property="name" />
<jsp:setProperty name="user" property="phoneNumber" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>SE-DTEAM</title>
</head>
<body>
	<%
		String id = null;
	
		if (session.getAttribute("id") != null) {
			id = (String)session.getAttribute("id");
		}
		if (id != null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인이 되어 있습니다.')");
			script.println("location.href = 'index.jsp'");
			script.println("</script>");
		}
	
		if (user.getId() == null || user.getPw() == null || user.getName() == null || user.getPhoneNumber() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안된 사항이 있습니다.')");
			
			script.println("history.back()");
			script.println("</script>");
		} else {
			UserDAO userDAO = new UserDAO();
			int result = userDAO.insertUser(user);

			if (result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미 존재하는 아이디입니다.')");
				script.println("history.back()");
				script.println("</script>");
			} else {
				session.setAttribute("id", user.getId());
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href = 'index.jsp'");
				script.println("</script>");
			}
		}
			
	%>
</body>
</html>