<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page import="java.util.ArrayList" %>



<%@ page import="java.sql.*" %>
<%@ page import="java.util.HashMap" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>exchange student</title>
	</head>
	<body>


   <%!



       Connection connection=null;

         String address="jdbc:mysql://localhost:3306/lotus?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
         String DateBaseName="zelong";
         String DateBasepassword="wzlWZL123";

        public void getConnection(){
            if (connection==null){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection= DriverManager.getConnection(address,DateBaseName,DateBasepassword);
                }
                catch (Exception e1){
                    e1.printStackTrace();
                    System.out.println("connect fail");
                }
            }
        }

    %>


   <%
                ArrayList<String> a =new ArrayList<String>();
                ArrayList<String> strings = new ArrayList<String>();
                Statement statement =null;
                Statement statement2 =null;
                ArrayList<String> PID =new ArrayList<String>();
                ArrayList<String> S1 =new ArrayList<String>();
                ArrayList<String> S2 =new ArrayList<String>();
                ArrayList<String> S3 =new ArrayList<String>();
                ArrayList<String> S4 =new ArrayList<String>();
                ArrayList<String> SID =new ArrayList<String>();
                ArrayList<String> SEX =new ArrayList<String>();
                ArrayList<Double> experence = new ArrayList<>();
                ArrayList<String> pType =new ArrayList<String>();
                ArrayList<Double> gpa = new ArrayList<>();

                try{

                    getConnection();
                    String sql = "select * from team;";
                    statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql);

                    while (resultSet.next()){
                        PID.add(resultSet.getString("PID"));
                        S1.add(resultSet.getString("SID1"));
                        S2.add(resultSet.getString("SID2"));
                        S3.add(resultSet.getString("SID3"));
                        S4.add(resultSet.getString("SID4"));

                    }
                    String sql2="select * from student;";
                    statement2 = connection.createStatement();

                    ResultSet resultSet2 = statement.executeQuery(sql2);
                    while ((resultSet2.next())){
                        SID.add(resultSet2.getString("SID"));
                        SEX.add(resultSet2.getString("gender"));
                        pType.add(resultSet2.getString("pType"));
                        experence.add(resultSet2.getDouble("experence"));
                        gpa.add(resultSet2.getDouble("GPA"));
                    }
                }catch (Exception e){
                    e.printStackTrace();

                }
                String test ="";
                String test1="";
                test +="<form action=\"operationResult.jsp\" method=\"get\" id=\"passForm\" style=\"width: 100%\";>";
                test +="<div style=\"flaot:left;width: 1200px;height: 500px\">";
                for (int i=0;i<PID.size();i++){

                    strings.add("Team" + (i+1));
                    // strings1.add(entry.getKey().toString());
                    ArrayList<String> rr = new ArrayList<>();

                    rr.add(PID.get(i));
                    rr.add(S1.get(i));
                    rr.add(S2.get(i));
                    rr.add(S3.get(i));
                    rr.add(S4.get(i));

                    test +="<div style=\"margin:20px;float:left;width: 200px;height: 300px;background-color: aqua;\">";
                    test +=strings.get(i);
                    for (int j=0;j<(rr.size()-1);j++) {
                        test +="<br>";
                        test +="<input type=\"checkbox\" name=\"student\" value=\""+ rr.get(j+1) +"\">";
                        test +="<input id = \"test2\" type = \"hidden\" name=\"test2\" value=\""+ rr.get(j+1) +"\">";
                        test +=rr.get(j+1);
                        test +="</br>";

                    }
                    test +="</div>";
                }

                test+=" <div style=\"clear:both\">";
                test+="</div>";
                test +="<input type=\"submit\"  onclick=\"ExportData()\" value=\"swap\"style=\"margin-left:850px;margin-top: 65px;\">";
                test +="</div>";
                test +="</form>";
                %>
            <%=test%>

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

   <input type="button"  value="return"style="margin-left:850px;">
    </body>
</html>
