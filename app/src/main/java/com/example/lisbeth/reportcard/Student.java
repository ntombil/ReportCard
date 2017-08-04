package com.example.lisbeth.reportcard;

import android.widget.EditText;

/**
 * Created by LISBETH on 2017/07/20.
 */

public class Student {
    private int studentNo;
    private int id;
    private String Name;
    private String Gender;
    private int Mark1;
    private int Mark2;
    private int Mark3;

    public Student() {
    }

    public int getStudentNo() {
        return studentNo;
    }

    public Student(int studentNo, String name, String gender, int mark1, int mark2, int mark3) {
        this.studentNo = studentNo;
        Name = name;
        Gender = gender;
        Mark1 = mark1;
        Mark2 = mark2;
        Mark3 = mark3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getMark1() {
        return Mark1;
    }

    public void setMark1(int mark1) {
        Mark1 = mark1;
    }

    public int getMark2() {
        return Mark2;
    }

    public void setMark2(int mark2) {
        Mark2 = mark2;
    }

    public int getMark3() {
        return Mark3;
    }

    public void setMark3(int mark3) {
        Mark3 = mark3;
    }
}
