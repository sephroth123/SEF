package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Parameter {
    private String [] d;
    private boolean flag;
    private boolean flag1;

    public String[] getD() {
        return d;
    }

    public void setD(String[] d) {
        this.d = d;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag1() {
        return flag1;
    }

    public void setFlag1(boolean flag1) {
        this.flag1 = flag1;
    }

    public HashMap<Integer, ArrayList<String>> getC() {
        return c;
    }

    public void setC(HashMap<Integer, ArrayList<String>> c) {
        this.c = c;
    }

    public ArrayList<String> getSID() {
        return SID;
    }

    public void setSID(ArrayList<String> SID) {
        this.SID = SID;
    }

    public ArrayList<String> getSEX() {
        return SEX;
    }

    public void setSEX(ArrayList<String> SEX) {
        this.SEX = SEX;
    }

    public ArrayList<String> getpType() {
        return pType;
    }

    public void setpType(ArrayList<String> pType) {
        this.pType = pType;
    }

    public ArrayList<Integer> getExperence() {
        return experence;
    }

    public void setExperence(ArrayList<Integer> experence) {
        this.experence = experence;
    }

    public ArrayList<Double> getGpa() {
        return gpa;
    }

    public void setGpa(ArrayList<Double> gpa) {
        this.gpa = gpa;
    }

    private HashMap<Integer,ArrayList<String>> c;
    private ArrayList<String> SID;
    private ArrayList<String> SEX;
    private ArrayList<String> pType;
    private ArrayList<Integer> experence;
    private ArrayList<Double> gpa;
    public Parameter(String[] d, boolean flag, boolean flag1, HashMap<Integer, ArrayList<String>> c, ArrayList<String> SID, ArrayList<String> SEX, ArrayList<String> pType, ArrayList<Integer> experence, ArrayList<Double> gpa){
        this.d=d;
        this.flag=flag;
        this.flag1=flag1;
        this.c=c;
        this.SID=SID;
        this.SEX=SEX;
        this.pType=pType;
        this.experence=experence;
        this.gpa=gpa;
    }
}
