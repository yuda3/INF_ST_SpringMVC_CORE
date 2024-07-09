<%@ page import="springmvc_core.domain.memeber.MemberRepository" %>
<%@ page import="springmvc_core.domain.memeber.Member" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: yuda3
  Date: 2024/07/09
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();

%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">移動</a>
<table>
    <thead>
    <tr>id</tr>
    <tr>username</tr>
    <tr>age</tr>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
            out.write(" <tr>");
            out.write(" <td>" + member.getId() + "</td>");
            out.write(" <td>" + member.getUsername() + "</td>");
            out.write(" <td>" + member.getAge() + "</td>");
            out.write(" </tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>