<%@ page import="team.service.ExchangeService" %>
<%@ page import="entity.Parameter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>






<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>result</title>


</head>
<body>
<%--<%
    String[]  chk = request.getParameterValues("student");
    ExchangeService service = new ExchangeService();
    if (chk.length==2){
        Parameter parameter= service.judgeSelcetedNumber(chk);
        out.println( service.exchange(parameter.getD(),parameter.isFlag(),parameter.isFlag(),parameter.getC(),parameter.getSID(),parameter.getSEX(),parameter.getpType(),parameter.getExperence(),parameter.getGpa()));
        out.println("<a href=\"http://localhost:8080/WebContent/swap.jsp\">return</a>");
    }
    if (chk.length!=2){
        out.println("Wrong number of students");
        out.println("<a href=\"http://localhost:8080/WebContent/swap.jsp\">return</a>");
    }



%>--%>
<%!
    Connection connection=null;
    String address="jdbc:mysql://localhost:3306/spds?spds?useSSL=false";
    String DateBaseName="root";
    String DateBasepassword="jasongx89O228";


    public void getConnection(){
        if (connection==null){
            try {
               /*  Class.forName("com.mysql.cj.jdbc.Driver"); */
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


    String[]  chk = request.getParameterValues("student");
    System.out.println("----------------");
    System.out.println(chk);

        if (chk.length == 2) {
            {
                HashMap<Integer, ArrayList<String>> c = new HashMap<>();
                String[] d = new String[2];
                String[] f = new String[2];
                int j = 0;
                System.out.println(chk[1]);
                System.out.println(chk[0]);

                for (String A : chk) {
                    d[j] = A;

                    //String[] tm = new String[]{PID.get(i-1), S1.get(i-1), S2.get(i-1), S3.get(i-1), S4.get(i-1)};
                    for (int i = 0; i < PID.size(); i++) {
                        ArrayList<String> t = new ArrayList<String>();

                        t.add(S1.get(i));
                        t.add(S2.get(i));
                        t.add(S3.get(i));
                        t.add(S4.get(i));
                        for (int y = 0; y < t.size(); y++) {
                            if (t.get(y).equals(A)) {
                                f[j] = PID.get(i);
                                t.remove(t.get(y));
                                c.put(j, t);
                            }
                        }
                    }
                    j++;
                }
                boolean flag = false;
                boolean flag1 = false;
                System.out.println(c.get(0));
                c.get(0).add(d[1]);
                c.get(1).add(d[0]);
                for (int q = 0; q < 2; q++) {
                    double sum = 0;
                    int x = 0;
                    int v = 0;
                    for (String e : c.get(q)) {
                        for (int i = 0; i < SID.size(); i++) {
                            ArrayList<String> t = new ArrayList<String>();
                            t.add(SID.get(i));
                            t.add(SEX.get(i));
                            t.add(pType.get(i));
                            t.add(experence.get(i).toString());
                            t.add(gpa.get(i).toString());
                            if (e.equals(t.get(0))) {
                                if (t.get(1).equals("female")) {
                                    x++;
                                }
                                if (t.get(2).equals("A") || t.get(2).equals("B")) {
                                    flag = true;
                                }
                                if (Double.parseDouble(t.get(3)) >= 5) {
                                    flag1 = true;
                                }
                                if (Double.parseDouble(t.get(4)) >= 3) {
                                    v++;
                                }

                                sum = sum + Double.parseDouble(t.get(4));
                            }
                        }
                    }
                    if (flag == false) {

                        c.get(0).remove(d[1]);
                        c.get(1).remove(d[0]);
                        c.get(0).add(d[0]);
                        c.get(1).add(d[1]);
                        out.println("<h1>Lack of A and B personality types</h1>");
                        System.out.println("<a href=\"http://localhost:8080/spds/swap.jsp\">return</a>");
                        return;


                    }
                    if (flag1 == false) {

                        c.get(0).remove(d[1]);
                        c.get(1).remove(d[0]);
                        c.get(0).add(d[0]);
                        c.get(1).add(d[1]);
                        out.println("<h1>Lack of work experience for 5 years</h1>");
                        out.println("<a href=\"http://localhost:8080/spds/swap.jsp\">return</a>");
                        return;

                    }
                    if (x > 1) {

                        c.get(0).remove(d[1]);
                        c.get(1).remove(d[0]);
                        c.get(0).add(d[0]);
                        c.get(1).add(d[1]);
                        out.println("<h1>More than 1 girl");
                        out.println("<a href=\"http://localhost:8080/spds/swap.jsp\">return</a>");
                        return;

                    }
                    if (v < 2) {

                        c.get(0).remove(d[1]);
                        c.get(1).remove(d[0]);
                        c.get(0).add(d[0]);
                        c.get(1).add(d[1]);
                        out.println("<h1>Fewer than 2 students have a gpa of 3</h1>");
                        out.println("<a href=\"http://localhost:8080/spds/swap.jsp\">return</a>");
                        return;
                    }
                    if (sum / 4 > 3.5) {

                        c.get(0).remove(d[1]);
                        c.get(1).remove(d[0]);
                        c.get(0).add(d[0]);
                        c.get(1).add(d[1]);
                        out.println("<h1>Gpa is greater than 3.5</h1>");
                        out.println("<a href=\"http://localhost:8080/spds/swap.jsp\">return</a>");
                        return;
                    }
                }
                out.println("swap successful!");
                out.println("<a href=\"http://localhost:8080/spds/swap.jsp\">return</a>");


                try {


                    String sql2 = "update team set SID1=?,SID2=?,SID3=?,SID4=? where PID=?;";

                    getConnection();
                    PreparedStatement ps = connection.prepareStatement(sql2);

                    ps.setString(1, c.get(0).get(0));
                    ps.setString(2, c.get(0).get(1));
                    ps.setString(3, c.get(0).get(2));
                    ps.setString(4, c.get(0).get(3));
                    ps.setString(5, f[0]);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("The operation failure");
                    e.printStackTrace();
                }

                try {

                    String sql3 = "update team set SID1=?,SID2=?,SID3=?,SID4=? where PID=?;";

                    getConnection();
                    PreparedStatement ps2 = connection.prepareStatement(sql3);

                    ps2.setString(1, c.get(1).get(0));
                    ps2.setString(2, c.get(1).get(1));
                    ps2.setString(3, c.get(1).get(2));
                    ps2.setString(4, c.get(1).get(3));
                    ps2.setString(5, f[1]);
                    ps2.executeUpdate();


                } catch (SQLException e) {
                    System.out.println("The operation failure");
                    e.printStackTrace();

                }


            }
    }if (chk.length!=2){
    out.println("Wrong number of students");
    out.println("<a href=\"http://localhost:8080/spds/swap.jsp\">return</a>");
    }
%>








</body>
</html>
