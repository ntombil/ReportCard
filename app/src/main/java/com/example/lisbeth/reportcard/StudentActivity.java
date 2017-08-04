package com.example.lisbeth.reportcard;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.jar.Attributes;

public class StudentActivity extends AppCompatActivity {

    private    StudentDb db;


    static   private    EditText studentNo;
    private    EditText Name,id;
    private    EditText mark1;
    private    EditText mark2;
    private    EditText mark3;
    Spinner gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        db = new StudentDb(this);
        studentNo =(EditText)findViewById(R.id.Student_edit_text) ;
        Name=  (EditText)findViewById(R.id.name_edit_text) ;
        id=(EditText)findViewById(R.id.id_edit_text);
        mark1 =(EditText)findViewById(R.id.mark1_edit_text);
        mark2=(EditText)findViewById(R.id.mark2_edit_text);
        mark3=(EditText)findViewById(R.id.mark3_edit_text);
        gender=(Spinner)findViewById(R.id.gender_spinner);

    }
     public void addStudent(View view){
        long i=0;

    String StudentNo=studentNo.getText().toString();
    String name= Name.getText().toString();
    String Mark1=mark1.getText().toString();
    String Mark2=(mark2.getText().toString());
    String Mark3=mark3.getText().toString();
    String MyGender=gender.getSelectedItem().toString();

    Student student =new Student(Integer.parseInt(StudentNo), name , MyGender,Integer.parseInt(Mark1),Integer.parseInt(Mark2),Integer.parseInt(Mark3) );
        db.addStudent(student);

             Intent intent =new Intent(this,MainActivity.class);
             startActivity(intent);
         }

     public void  updateStudent(View view) {

         long colomnID= Long.parseLong(id.getText().toString());
         String name =String.valueOf( Name.getText().toString() );
         String genders= gender.getSelectedItem().toString();
         int studnu= Integer.parseInt(studentNo.getText().toString());
         int test1= Integer.parseInt(mark1.getText().toString());
         int test2= Integer.parseInt(mark2.getText().toString());
         int test3= Integer.parseInt(mark3.getText().toString());

         db.update(colomnID,studnu,name,genders ,test1,test2,test3);
         Intent intent=new Intent(this,MainActivity.class);
         startActivity(intent);

     }
    public  void deleteStudent(View view){
        String name = Name.getText().toString();
    db.delete(name);

    Intent intent=new Intent(this,MainActivity.class);
    startActivity(intent);
}}




