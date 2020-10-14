package exchange.test;

import entity.Student;
import entity.Team;
import exchange.service.ExchangeService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ExchangeTest {
    @Test
    public void testTest1() {
        ExchangeService exchangeService = new ExchangeService();

        boolean flag = false;
        boolean flag1 = false;
        String[] d = new String[2];
        ArrayList<String> SID = new ArrayList<String>();
        ArrayList<String> SEX = new ArrayList<String>();
        ArrayList<Integer> experence = new ArrayList<>();
        ArrayList<String> pType = new ArrayList<String>();
        ArrayList<Double> gpa = new ArrayList<>();


        Student student1 = new Student("S1", "male", "A", 3, 4);
        Student student2 = new Student("S2", "male", "B", 5, 3);
        Student student3 = new Student("S3", "male", "C", 3, 4);
        Student student4 = new Student("S4", "female", "D", 3, 2);
        Student student5 = new Student("S5", "male", "A", 3, 3);
        Student student6 = new Student("S6", "male", "B", 3, 3);
        Student student7 = new Student("S7", "male", "C", 5, 2);
        Student student8 = new Student("S8", "female", "D", 3, 2);


        SID.add(student1.getSid());
        SEX.add(student1.getGender());
        SID.add(student2.getSid());
        SEX.add(student1.getGender());
        SID.add(student3.getSid());
        SEX.add(student1.getGender());
        SID.add(student4.getSid());
        SEX.add(student1.getGender());
        SID.add(student5.getSid());
        SEX.add(student1.getGender());
        SID.add(student6.getSid());
        SEX.add(student1.getGender());
        SID.add(student7.getSid());
        SEX.add(student1.getGender());
        SID.add(student8.getSid());
        SEX.add(student1.getGender());
        experence.add(student1.getExperience());
        experence.add(student2.getExperience());
        experence.add(student3.getExperience());
        experence.add(student4.getExperience());
        experence.add(student5.getExperience());
        experence.add(student6.getExperience());
        experence.add(student7.getExperience());
        experence.add(student8.getExperience());
        pType.add(student1.getPersonalityType());
        pType.add(student2.getPersonalityType());
        pType.add(student3.getPersonalityType());
        pType.add(student4.getPersonalityType());
        pType.add(student5.getPersonalityType());
        pType.add(student6.getPersonalityType());
        pType.add(student7.getPersonalityType());
        pType.add(student8.getPersonalityType());
        gpa.add(student1.getGpa());
        gpa.add(student2.getGpa());
        gpa.add(student3.getGpa());
        gpa.add(student4.getGpa());
        gpa.add(student5.getGpa());
        gpa.add(student6.getGpa());
        gpa.add(student7.getGpa());
        gpa.add(student8.getGpa());
        ArrayList<String> c1 = new ArrayList<>();
        ArrayList<String> c2 = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> c = new HashMap<Integer, ArrayList<String>>();

        d[1] = student1.getSid();
        d[0] = student5.getSid();
        c1.add(student1.getSid());
        c1.add(student2.getSid());
        c1.add(student3.getSid());
        c1.add(student4.getSid());
        c.put(0, c1);
        c2.add(student5.getSid());
        c2.add(student6.getSid());
        c2.add(student7.getSid());
        c2.add(student8.getSid());
        c.put(1, c2);


        String s = exchangeService.exchange(d, flag, flag1, c, SID, SEX, pType, experence, gpa);

        assertEquals(s, "swap successful");
    }

    @Test
    public void testTest2() {
        ExchangeService exchangeService = new ExchangeService();

        boolean flag = false;
        boolean flag1 = false;
        String[] d = new String[2];
        ArrayList<String> SID = new ArrayList<String>();
        ArrayList<String> SEX = new ArrayList<String>();
        ArrayList<Integer> experence = new ArrayList<>();
        ArrayList<String> pType = new ArrayList<String>();
        ArrayList<Double> gpa = new ArrayList<>();


        Student student1 = new Student("S1", "male", "A", 3, 4);
        Student student2 = new Student("S2", "male", "B", 5, 3);
        Student student3 = new Student("S3", "male", "C", 3, 4);
        Student student4 = new Student("S4", "female", "D", 3, 2);
        Student student5 = new Student("S5", "male", "A", 3, 3);
        Student student6 = new Student("S6", "male", "B", 3, 3);
        Student student7 = new Student("S7", "male", "C", 5, 2);
        Student student8 = new Student("S8", "female", "D", 3, 2);


        SID.add(student1.getSid());
        SEX.add(student1.getGender());
        SID.add(student2.getSid());
        SEX.add(student1.getGender());
        SID.add(student3.getSid());
        SEX.add(student1.getGender());
        SID.add(student4.getSid());
        SEX.add(student1.getGender());
        SID.add(student5.getSid());
        SEX.add(student1.getGender());
        SID.add(student6.getSid());
        SEX.add(student1.getGender());
        SID.add(student7.getSid());
        SEX.add(student1.getGender());
        SID.add(student8.getSid());
        SEX.add(student1.getGender());
        experence.add(student1.getExperience());
        experence.add(student2.getExperience());
        experence.add(student3.getExperience());
        experence.add(student4.getExperience());
        experence.add(student5.getExperience());
        experence.add(student6.getExperience());
        experence.add(student7.getExperience());
        experence.add(student8.getExperience());
        pType.add(student1.getPersonalityType());
        pType.add(student2.getPersonalityType());
        pType.add(student3.getPersonalityType());
        pType.add(student4.getPersonalityType());
        pType.add(student5.getPersonalityType());
        pType.add(student6.getPersonalityType());
        pType.add(student7.getPersonalityType());
        pType.add(student8.getPersonalityType());
        gpa.add(student1.getGpa());
        gpa.add(student2.getGpa());
        gpa.add(student3.getGpa());
        gpa.add(student4.getGpa());
        gpa.add(student5.getGpa());
        gpa.add(student6.getGpa());
        gpa.add(student7.getGpa());
        gpa.add(student8.getGpa());
        ArrayList<String> c1 = new ArrayList<>();
        ArrayList<String> c2 = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> c = new HashMap<Integer, ArrayList<String>>();

        d[1] = student2.getSid();
        d[0] = student6.getSid();
        c1.add(student1.getSid());
        c1.add(student2.getSid());
        c1.add(student3.getSid());
        c1.add(student4.getSid());
        c.put(0, c1);
        c2.add(student5.getSid());
        c2.add(student6.getSid());
        c2.add(student7.getSid());
        c2.add(student8.getSid());
        c.put(1, c2);


        String s = exchangeService.exchange(d, flag, flag1, c, SID, SEX, pType, experence, gpa);

        assertEquals("swap successful",s );
    }

    @Test
    public void testTest3() {
        ExchangeService exchangeService = new ExchangeService();

        boolean flag = false;
        boolean flag1 = false;
        String[] d = new String[2];
        ArrayList<String> SID = new ArrayList<String>();
        ArrayList<String> SEX = new ArrayList<String>();
        ArrayList<Integer> experence = new ArrayList<>();
        ArrayList<String> pType = new ArrayList<String>();
        ArrayList<Double> gpa = new ArrayList<>();


        Student student1 = new Student("S1", "male", "A", 3, 4);
        Student student2 = new Student("S2", "male", "B", 5, 3);
        Student student3 = new Student("S3", "female", "C", 3, 4);
        Student student4 = new Student("S4", "male", "D", 3, 2);
        Student student5 = new Student("S5", "male", "A", 3, 3);
        Student student6 = new Student("S6", "male", "B", 3, 3);
        Student student7 = new Student("S7", "male", "C", 5, 2);
        Student student8 = new Student("S8", "female", "D", 3, 2);


        SID.add(student1.getSid());
        SEX.add(student1.getGender());
        SID.add(student2.getSid());
        SEX.add(student1.getGender());
        SID.add(student3.getSid());
        SEX.add(student1.getGender());
        SID.add(student4.getSid());
        SEX.add(student1.getGender());
        SID.add(student5.getSid());
        SEX.add(student1.getGender());
        SID.add(student6.getSid());
        SEX.add(student1.getGender());
        SID.add(student7.getSid());
        SEX.add(student1.getGender());
        SID.add(student8.getSid());
        SEX.add(student1.getGender());
        experence.add(student1.getExperience());
        experence.add(student2.getExperience());
        experence.add(student3.getExperience());
        experence.add(student4.getExperience());
        experence.add(student5.getExperience());
        experence.add(student6.getExperience());
        experence.add(student7.getExperience());
        experence.add(student8.getExperience());
        pType.add(student1.getPersonalityType());
        pType.add(student2.getPersonalityType());
        pType.add(student3.getPersonalityType());
        pType.add(student4.getPersonalityType());
        pType.add(student5.getPersonalityType());
        pType.add(student6.getPersonalityType());
        pType.add(student7.getPersonalityType());
        pType.add(student8.getPersonalityType());
        gpa.add(student1.getGpa());
        gpa.add(student2.getGpa());
        gpa.add(student3.getGpa());
        gpa.add(student4.getGpa());
        gpa.add(student5.getGpa());
        gpa.add(student6.getGpa());
        gpa.add(student7.getGpa());
        gpa.add(student8.getGpa());
        ArrayList<String> c1 = new ArrayList<>();
        ArrayList<String> c2 = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> c = new HashMap<Integer, ArrayList<String>>();

        d[1] = student4.getSid();
        d[0] = student7.getSid();
        c1.add(student5.getSid());
        c1.add(student6.getSid());
        c1.add(student8.getSid());
        c1.add(student4.getSid());
        c.put(0, c1);
        c2.add(student1.getSid());
        c2.add(student2.getSid());
        c2.add(student7.getSid());
        c2.add(student3.getSid());
        c.put(1, c2);


        String s = exchangeService.exchange(d, flag, flag1, c, SID, SEX, pType, experence, gpa);

        assertEquals("Lack of work experience for 5 years",s );
    }


    @Test
    public void testTest4(){
        ExchangeService exchangeService=new ExchangeService();

        boolean flag = false;
        boolean flag1 = false;
        String [] d=new String[2];
        ArrayList<String> SID =new ArrayList<String>();
        ArrayList<String> SEX =new ArrayList<String>();
        ArrayList<Integer> experence = new ArrayList<>();
        ArrayList<String> pType =new ArrayList<String>();
        ArrayList<Double> gpa = new ArrayList<>();



        Student student1 = new Student("S1","male","A",3,4);
        Student student2 = new Student("S2","male","B",5,3);
        Student student3 = new Student("S3","male","C",3,4);
        Student student4 = new Student("S4","female","D",3,2);
        Student student5 = new Student("S5","male","A",3,3);
        Student student6 = new Student("S6","male","B",5,3);
        Student student7 = new Student("S7","male","C",5,2);
        Student student8 = new Student("S8","female","D",3,2);


        SID.add(student1.getSid());SEX.add(student1.getGender());
        SID.add(student2.getSid());SEX.add(student1.getGender());
        SID.add(student3.getSid());SEX.add(student1.getGender());
        SID.add(student4.getSid());SEX.add(student1.getGender());
        SID.add(student5.getSid());SEX.add(student1.getGender());
        SID.add(student6.getSid());SEX.add(student1.getGender());
        SID.add(student7.getSid());SEX.add(student1.getGender());
        SID.add(student8.getSid());SEX.add(student1.getGender());
        experence.add( student1.getExperience());
        experence.add( student2.getExperience());
        experence.add(student3.getExperience());
        experence.add( student4.getExperience());
        experence.add( student5.getExperience());
        experence.add( student6.getExperience());
        experence.add( student7.getExperience());
        experence.add( student8.getExperience());
        pType.add(student1.getPersonalityType());
        pType.add(student2.getPersonalityType());
        pType.add(student3.getPersonalityType());
        pType.add(student4.getPersonalityType());
        pType.add(student5.getPersonalityType());
        pType.add(student6.getPersonalityType());
        pType.add(student7.getPersonalityType());
        pType.add(student8.getPersonalityType());
        gpa.add(student1.getGpa());
        gpa.add(student2.getGpa());
        gpa.add(student3.getGpa());
        gpa.add(student4.getGpa());
        gpa.add(student5.getGpa());
        gpa.add(student6.getGpa());
        gpa.add(student7.getGpa());
        gpa.add(student8.getGpa());
        ArrayList<String> c1 =new ArrayList<>();
        ArrayList<String> c2 =new ArrayList<>();
        HashMap<Integer, ArrayList<String>> c = new HashMap<Integer, ArrayList<String>>();

        d[1]=student4.getSid();d[0]=student5.getSid();
        c1.add(student7.getSid());
        c1.add(student6.getSid());
        c1.add(student8.getSid());
        c1.add(student4.getSid());
        c.put(0,c1);
        c2.add(student1.getSid());
        c2.add(student2.getSid());
        c2.add(student5.getSid());
        c2.add(student3.getSid());
        c.put(1,c2);


        String s =exchangeService.exchange(d,flag,flag1,c,SID,SEX,pType,experence,gpa);

        assertEquals("Fewer than 2 students have a gpa of 3",s);
    }

}
