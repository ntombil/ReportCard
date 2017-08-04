package com.example.lisbeth.reportcard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by LISBETH on 2017/07/20.
 */

public class StudentDb extends SQLiteOpenHelper {

    private static final String TABLE_STUDENT="students";
    private final String COLUMN_ID="id";
    private final String COLUMN_STUDENT_NO="studentnumber";
    private final String COLUMN_NAME="name";
    private final String COLUMN_GENDER="gender";
    private final String COLUMN_MARK1="mark1";
    private final String COLUMN_MARK2="mark2" ;
    private final String COLUMN_MARK3="mark3";

    private final  static String DATABASE_NAME="student.db";

    private final static int DATABASE_VERSION=1;

    private  final  String DATABASE_CREATE=" create table " + TABLE_STUDENT + "(" + COLUMN_ID + " integer primary key autoincrement, " + COLUMN_STUDENT_NO  + " text not null, " + COLUMN_NAME + " text not null, " + COLUMN_GENDER + " text not null, " + COLUMN_MARK1 + " text not null, " + COLUMN_MARK2 + " text not null, " + COLUMN_MARK3 + " text not null) " ;

    public StudentDb(Context context) {
        super(context, DATABASE_NAME , null , DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL(DATABASE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion) {
        db.execSQL(" DROP TABLE IF EXIST " + TABLE_STUDENT );
        onCreate(db);
    }

         public void addStudent(Student student){
             SQLiteDatabase db=this.getWritableDatabase();
             ContentValues contentValues=new ContentValues();

           contentValues.put(COLUMN_STUDENT_NO,student.getStudentNo()) ;
           contentValues.put(COLUMN_NAME,student.getName()) ;
           contentValues.put(COLUMN_GENDER,student.getGender());
           contentValues.put(COLUMN_MARK1,student.getMark1()) ;
           contentValues.put(COLUMN_MARK2,student.getMark2()) ;
           contentValues.put(COLUMN_MARK3,student.getMark3()) ;

        db.insert(TABLE_STUDENT, null, contentValues) ;

        }
        public ArrayList<String>getAllStudents(){

            ArrayList<String> students=new ArrayList<>();
             String selectQuery="SELECT * FROM " + TABLE_STUDENT ;
            SQLiteDatabase db =this.getWritableDatabase();
            Cursor cursor =db.rawQuery(selectQuery, null);

             if (cursor.moveToFirst()){
                 do {
                     int id=cursor.getInt(0);
                     String stdNo  = cursor.getString(1);
                     String name  = cursor.getString(2);
                     String gender  = cursor.getString(3);
                     int mak1  = cursor.getInt(4);
                     int mak2  = cursor.getInt(5);
                     int mak3 = cursor.getInt(6);

                     String display =id + "Student No :" + stdNo +" "+" Name :" + " " + name + " " + " gender :" + gender + " " + " Mathematis:" + " " + mak1 + " " + " Physical Science :" + " " + mak2 + " " + " Geography :" + " " + mak3;
                     students.add(display);
                     System.out.println("Student No"+ cursor.getString(1));
                 }
                 while ( cursor.moveToNext());
             }
            return  students;
        }
    public void update(long colomnID, int studnu,String name,String gender,int test1,int test2,int test3) {
        ContentValues values=new ContentValues();

        SQLiteDatabase db=this.getWritableDatabase();
        values.put(COLUMN_STUDENT_NO,studnu);
        values.put(COLUMN_NAME,name);
        values.put(COLUMN_GENDER,gender);
        values.put(COLUMN_MARK1,test1);
        values.put(COLUMN_MARK2,test2);
        values.put(COLUMN_MARK3,test3);

        db.update(TABLE_STUDENT,values,COLUMN_ID + "=" + colomnID,null);
    }

          public Student getStudent(int id){
              Student s = new Student();
              SQLiteDatabase db=this.getWritableDatabase();
              String selectQuery = "SELECT * FROM " + TABLE_STUDENT + " where " + COLUMN_ID + " = ? ";
              String args[] = { String.valueOf(id) };
              Cursor c = db.rawQuery(selectQuery, args);
              if (c.moveToFirst()){

                  s.setStudentNo(c.getInt(c.getColumnIndex(COLUMN_STUDENT_NO)));
                  s.setName(c.getString(c.getColumnIndex(COLUMN_NAME)));
                  s.setGender(c.getString(c.getColumnIndex(COLUMN_GENDER)));
                  s.setMark1(c.getInt(c.getColumnIndex(COLUMN_MARK1)));
                  s.setMark2(c.getInt(c.getColumnIndex(COLUMN_MARK2)));
                  s.setMark3(c.getInt(c.getColumnIndex(COLUMN_MARK3)));
              }
              return s;
          }

          public int delete(String x){
              SQLiteDatabase db=this.getWritableDatabase();
              String[]whereArgs={x};
              int count=db.delete(this.TABLE_STUDENT,this.COLUMN_NAME + "=?",whereArgs);
              return count;


          }
}

