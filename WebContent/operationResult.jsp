<%@ page import="team.service.ExchangeService" %>
<%@ page import="entity.Parameter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Team" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>






<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>result</title>


</head>
<body>
<%
    String[]  chk = request.getParameterValues("student");
    ExchangeService service = new ExchangeService();
    if (chk.length==2){
        Parameter parameter= service.judgeSelcetedNumber(chk);
        out.println( service.exchange(parameter.getD(),parameter.isFlag(),parameter.isFlag(),parameter.getC(),parameter.getSID(),parameter.getSEX(),parameter.getpType(),parameter.getExperence(),parameter.getGpa()));
        out.println("<a href=\"http://localhost:8080/WebContent/swap.jsp\">return</a>");
        if(service.exchange(parameter.getD(),parameter.isFlag(),parameter.isFlag(),parameter.getC(),parameter.getSID(),parameter.getSEX(),parameter.getpType(),parameter.getExperence(),parameter.getGpa()).equals("swap successful")){
            Team team =new Team();
            team.setP_id(parameter.getC().get(0).get(0));
            team.setS_id1(parameter.getC().get(0).get(1));
            team.setS_id2(parameter.getC().get(0).get(2));
            team.setS_id3(parameter.getC().get(0).get(3));
            team.setS_id3(parameter.getC().get(0).get(4));
            Team team2 =new Team();
            team.setP_id(parameter.getC().get(1).get(0));
            team.setS_id1(parameter.getC().get(1).get(1));
            team.setS_id2(parameter.getC().get(1).get(2));
            team.setS_id3(parameter.getC().get(1).get(3));
            team.setS_id3(parameter.getC().get(1).get(4));
            service.updateTeam(team);
            service.updateTeam(team2);


        }
    }
    if (chk.length!=2){
        out.println("Wrong number of students");
        out.println("<a href=\"http://localhost:8080/WebContent/swap.jsp\">return</a>");
    }



%>









</body>
</html>
