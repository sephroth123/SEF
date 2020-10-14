package exchange.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import exchange.dao.ExchangeDao;
import javafx.scene.control.Alert;

public class ExchangeService {
       public void judge() throws SQLException {
    	   ExchangeDao ed = new ExchangeDao();




           judge1(ed);
       }
    HashMap<Integer, ArrayList<String>> c = new HashMap<>();
    String [] d=new String[2];
    String [] f =new String[2];
    boolean flag = false;
    boolean flag1 = false;
    ArrayList<String> PID =new ArrayList<String>();
    ArrayList<String> S1 =new ArrayList<String>();
    ArrayList<String> S2 =new ArrayList<String>();
    ArrayList<String> S3 =new ArrayList<String>();
    ArrayList<String> S4 =new ArrayList<String>();
    ArrayList<String> SID =new ArrayList<String>();
    ArrayList<String> SEX =new ArrayList<String>();
    ArrayList<Integer> experence = new ArrayList<>();
    ArrayList<String> pType =new ArrayList<String>();
    ArrayList<Double> gpa = new ArrayList<>();
          //Get the information exchanged
           public void judge1(ExchangeDao ed ) throws SQLException {

               while (ed.getTeam().next()){
                   PID.add(ed.getTeam().getString("PID"));
                   S1.add(ed.getTeam().getString("SID1"));
                   S2.add(ed.getTeam().getString("SID2"));
                   S3.add(ed.getTeam().getString("SID3"));
                   S4.add(ed.getTeam().getString("SID4"));
        	   }
               while ((ed.getStudent().next())){
                   SID.add(ed.getStudent().getString("SID"));
                   SEX.add(ed.getStudent().getString("gender"));
                   pType.add(ed.getStudent().getString("pType"));
                   experence.add(ed.getStudent().getInt("experence"));
                   gpa.add(ed.getStudent().getDouble("GPA"));
               }

           ArrayList<String> a = new ArrayList<String>();
               if (a.size()==2) {


                   int j=0;

                   for (String A : a) {
                       d[j]=A;

                       //String[] tm = new String[]{PID.get(i-1), S1.get(i-1), S2.get(i-1), S3.get(i-1), S4.get(i-1)};
                       for(int i=0;i<PID.size();i++){
                           ArrayList<String> t = new ArrayList<String>();

                           t.add(S1.get(i));
                           t.add(S2.get(i));
                           t.add(S3.get(i));
                           t.add(S4.get(i));
                           for (int y=0;y<t.size();y++) {
                               if(t.get(y).equals(A)){
                                   f[j]=PID.get(i);
                                   t.remove(t.get(y));
                                   c.put(j,t);
                               }
                           }
                       }
                       j++;
                   }


                   c.get(0).add(d[1]);
                   c.get(1).add(d[0]);

                   exchange(d,flag,flag1,c,SID,SEX,pType,experence,gpa);
               }

       }
       public String exchange(String [] d,boolean flag,boolean flag1,HashMap<Integer,ArrayList<String>> c, ArrayList<String> SID, ArrayList<String> SEX, ArrayList<String> pType, ArrayList<Integer> experence, ArrayList<Double> gpa){
           for (int q=0;q<2;q++) {
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
                               x=x+1;
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
                   /*Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("swap fail");
                   alert.setHeaderText("ERROR");
                   alert.setContentText("Lack of A and B personality types");
                   alert.showAndWait();*/
                   c.get(0).remove(d[1]);
                   c.get(1).remove(d[0]);
                   c.get(0).add(d[0]);
                   c.get(1).add(d[1]);
                   String s="Lack of A and B personality types";
                   return s;

               }
               if (flag1 == false) {
                   /*Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("swap fail");
                   alert.setHeaderText("ERROR");
                   alert.setContentText("Lack of work experience for 5 years");
                   alert.showAndWait();*/
                   c.get(0).remove(d[1]);
                   c.get(1).remove(d[0]);
                   c.get(0).add(d[0]);
                   c.get(1).add(d[1]);
                   String s="Lack of work experience for 5 years";
                   return s;

               }
               if (x > 1) {
                   /*Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("swap fail");
                   alert.setHeaderText("ERROR");
                   alert.setContentText("More than 1 girl");
                   alert.showAndWait();*/
                   c.get(0).remove(d[1]);
                   c.get(1).remove(d[0]);
                   c.get(0).add(d[0]);
                   c.get(1).add(d[1]);
                   String s = "More than 1 girl";
                   return s;

               }
               if (v < 2) {
                   /*Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("swap fail");
                   alert.setHeaderText("ERROR");
                   alert.setContentText("Fewer than 2 students have a gpa of 3");
                   alert.showAndWait();*/
                   c.get(0).remove(d[1]);
                   c.get(1).remove(d[0]);
                   c.get(0).add(d[0]);
                   c.get(1).add(d[1]);
                   String s ="Fewer than 2 students have a gpa of 3";
                   return s;
               }
               if (sum / 4 > 3.5) {
                   Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("swap fail");
                   alert.setHeaderText("ERROR");
                   alert.setContentText("Gpa is greater than 3.5");
                   alert.showAndWait();
                   c.get(0).remove(d[1]);
                   c.get(1).remove(d[0]);
                   c.get(0).add(d[0]);
                   c.get(1).add(d[1]);
                   String s ="Gpa is greater than 3.5";
                   return s;
               }




           }
           String s ="swap successful";
           return s;
       }

}
