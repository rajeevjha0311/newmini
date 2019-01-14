package com.example.rajeevjha.mini;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg,_btnlogin;
    EditText _txtfname,_txtlname,_txtpass,_txtmail,_txtphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper=new DatabaseHelper(this);
        _btnreg=(Button)findViewById(R.id.btnreg);
        _txtfname=(EditText)findViewById(R.id.txtfname);
        _txtlname=(EditText)findViewById(R.id.txtlname);
        _txtpass=(EditText)findViewById(R.id.txtpass);
        _txtmail=(EditText)findViewById(R.id.txtmail);
        _txtphone=(EditText)findViewById(R.id.txtphone);
       // _btnlogin=(Button)findViewById();
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SQLiteDatabase db=openHelper.getWritableDatabase();
                String fname=_txtfname.getText().toString();
                String lname=_txtlname.getText().toString();
                String pass=_txtpass.getText().toString();
                String mail=_txtmail.getText().toString();
                String phone=_txtphone.getText().toString();
                insertdata(fname,lname,pass,mail,phone);
                Toast.makeText(getApplicationContext(),"registered succesfully",Toast.LENGTH_LONG).show();



            }
        });


    }
    public void insertdata(String fname,String lname,String pass, String mail,String phone)
    {
        long id;
        ContentValues contentValues=new ContentValues();
        //contentValues.put(DatabaseHelper.COL_1,id);
        contentValues.put(DatabaseHelper.COL_2,fname);
        contentValues.put(DatabaseHelper.COL_3,lname);
        contentValues.put(DatabaseHelper.COL_4,pass);
        contentValues.put(DatabaseHelper.COL_5,mail);
        contentValues.put(DatabaseHelper.COL_6,phone);
         id=db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }
}

