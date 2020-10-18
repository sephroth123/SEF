<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="entity.*"%>
<%@ page import="team.service.ExchangeService" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>exchange student</title>
</head>
<body>
<%

    ExchangeService es =new ExchangeService();
    ArrayList<Team> teamList=es.findTeam();
    request.setAttribute("teamList",teamList);

    String test ="";
    String test1="";
    test +="<form action=\"operationResult.jsp\" method=\"get\" id=\"passForm\" style=\"width: 100%\";>";
    test +="<div style=\"flaot:left;width: 1200px;height: 500px\">";

    for (int j=0;j<(teamList.size());j++) {
        test +="<div style=\"margin:20px;float:left;width: 200px;height: 300px;background-color: aqua;\">";
        test +=teamList.get(j).getP_id();
        test +="<br>";
        test +="<input type=\"checkbox\" name=\"student\" value=\""+ teamList.get(j).getS_id1()+"\">";
        test +=teamList.get(j).getS_id1();
        test +="</br>";
        test +="<input type=\"checkbox\" name=\"student\" value=\""+ teamList.get(j).getS_id2() +"\">";
        test +=teamList.get(j).getS_id2();
        test +="</br>";
        test +="<input type=\"checkbox\" name=\"student\" value=\""+teamList.get(j).getS_id3()+"\">";
        test +=teamList.get(j).getS_id3();
        test +="</br>";
        test +="<input type=\"checkbox\" name=\"student\" value=\""+ teamList.get(j).getS_id4() +"\">";
        test +=teamList.get(j).getS_id4();
        test +="</br>";
        test +="</div>";

    }



    test+=" <div style=\"clear:both\">";
    test+="</div>";
    test +="<input type=\"submit\"  onclick=\"ExportData()\" value=\"swap\"style=\"margin-left:850px;margin-top: 65px;\">";
    test +="</div>";
    test +="</form>";
%>
<%=test%>

<%--<form action="operationResult.jsp" method="get" id="passForm" style="width: 100%";>
    <div style="flaot:left;width: 1200px;height: 500px">
<c:forEach items="${teamList}" var="team">
<div style="margin:20px;float:left;width: 200px;height: 300px;background-color: aqua;">
        <td>${team.p_id}</td>
    <br>
             <input type="checkbox" name="student" value="${team.s_id1}">
    <td> ${team.s_id1}</td>
    <br>
             <input type="checkbox" name="student" value="${team.s_id2}">
    <td> ${team.s_id2}</td>
    <br>
             <input type="checkbox" name="student" value="${team.s_id3}">
    <td>${team.s_id3}</td>
    <br>
             <input type="checkbox" name="student" value="${team.s_id4}">
    <td>${team.s_id4}</td>

</div>
<div style="clear:both"></div>


</c:forEach>
    </div>
    <input type="submit"  onclick="ExportData()" value="swap"style="margin-left:850px;margin-top: 65px;">
</form>--%>







<script type="text/javascript">
    var check_val;
    function fun() {
        var obj=document.getElementsByName("student");

        for (var k=0;k<obj.length;k++){
            if(obj[k].cached)
                check_val.push(obj[k].nextSibling.nodeValue);
        }
    }

    function  ExportData() {
        var obj=document.getElementsByName("student");

        for (var k=0;k<obj.length;k++){
            if(obj[k].checked)
                check_val.push(obj[k].value);
        }
        var h =JSON.stringify(check_val);
        console.log(h);
    }

    var h =JSON.stringify(check_val);
</script>
<%!





