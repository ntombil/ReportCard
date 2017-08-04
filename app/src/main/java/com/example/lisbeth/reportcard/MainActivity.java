package com.example.lisbeth.reportcard;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final  static String DATABASE_NAME="student.db";
    private final  static String UPDATE="update";
    private StudentDb db=new StudentDb(this);
    private  int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String>students=db.getAllStudents();
        ListView studentView=(ListView)findViewById(R.id.listView) ;

        final  Student student=new Student();

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,students);
        studentView.setAdapter(arrayAdapter);

        studentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Student Results");
        dialog.setMessage(" \n  Are you sure you want to?");
        dialog.setNegativeButton("delete",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            } });
             dialog .setPositiveButton("Update", new DialogInterface.OnClickListener() {


            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, StudentActivity.class);
                startActivity(intent);
            }
        });
             dialog.show() ;
            }
    });}
public void add(View view){
    Intent intent = new Intent(this, StudentActivity.class);
    startActivity(intent);
}

  public  void update(View view) {
      Intent intent = new Intent(this, StudentActivity.class);
      startActivity(intent);
  }

public void delete(View view){
    Intent intent = new Intent(this, StudentActivity.class);
    startActivity(intent);
}
    }
