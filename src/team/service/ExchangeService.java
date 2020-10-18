package team.service;

import entity.Parameter;
import entity.Student;
import entity.Team;
import team.dao.ExchangeDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ExchangeService {
    ExchangeDao exchangeDao = new ExchangeDao();
    public ArrayList findTeam() throws SQLException {
        ArrayList<Team> teamList = new ArrayList<Team>();
        String sql ="select * from team";
        teamList=exchangeDao.findTeamBySql(sql);
        return teamList;
    }


    public ArrayList findStudent() throws SQLException {
        ArrayList<Student> studentList = new ArrayList<>();
        String sql ="select * from student";
        studentList=exchangeDao.findStudentBySql(sql);
        return studentList;
    }



    public Parameter judgeSelcetedNumber(String[] chk) throws SQLException {
        boolean flag3=false;
        HashMap<Integer, ArrayList<String>> c = new HashMap<>();
        String [] d=new String[2];
        String [] f =new String[2];
        boolean flag = false;
        boolean flag1 = false;



            int j=0;

            for (String A : chk) {
                d[j] = A;
                for (int i = 0; i < findTeam().size(); i++) {
                    Team team = (Team) findTeam().get(i);
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(team.getS_id1());
                    arrayList.add(team.getS_id2());
                    arrayList.add(team.getS_id3());
                    arrayList.add(team.getS_id4());
                    for (int y = 0; y < arrayList.size(); y++) {
                        if (arrayList.get(y).equals(A)) {
                            arrayList.remove(arrayList.get(y));
                            c.put(j, arrayList);
                        }
                    }
                }
                j++;
            }
            ArrayList<String> SID =new ArrayList<String>();
            ArrayList<String> SEX =new ArrayList<String>();
            ArrayList<Integer> experence = new ArrayList<>();
            ArrayList<String> pType =new ArrayList<String>();
            ArrayList<Double> gpa = new ArrayList<>();
            for (int i=0;i<findStudent().size();i++){
                Student student=(Student)findStudent().get(i);
                SID.add(student.getSid());
                SEX.add(student.getGender());
                experence.add(student.getExperience());
                pType.add(student.getPersonalityType());
                gpa.add(student.getGpa());
            }



            c.get(0).add(d[1]);
            c.get(1).add(d[0]);
            Parameter parameter=new Parameter(d,flag,flag1,c,SID,SEX,pType,experence,gpa);
            return  parameter;


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

                c.get(0).remove(d[1]);
                c.get(1).remove(d[0]);
                c.get(0).add(d[0]);
                c.get(1).add(d[1]);
                String s="Lack of A and B personality types";
                return s;

            }
            if (flag1 == false) {

                c.get(0).remove(d[1]);
                c.get(1).remove(d[0]);
                c.get(0).add(d[0]);
                c.get(1).add(d[1]);
                String s="Lack of work experience for 5 years";
                return s;

            }
            if (x > 1) {

                c.get(0).remove(d[1]);
                c.get(1).remove(d[0]);
                c.get(0).add(d[0]);
                c.get(1).add(d[1]);
                String s = "More than 1 girl";
                return s;

            }
            if (v < 2) {

                c.get(0).remove(d[1]);
                c.get(1).remove(d[0]);
                c.get(0).add(d[0]);
                c.get(1).add(d[1]);
                String s ="Fewer than 2 students have a gpa of 3";
                return s;
            }
            if (sum / 4 > 3.5) {

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
