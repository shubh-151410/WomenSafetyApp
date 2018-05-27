package com.example.dell.womensafetyapp;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by DELL on 12-05-2018.
 */

public class Register extends AppCompatActivity {
    EditText editTextName,editTextEmail,editTextPhoneNumber,editTextPassword,editTextCnfPasswd,EditTextPhoneNumber1,EditTextPhoneNumber2;
    EditText EditTextPhoneNumber3,EditTextPhoneNumber4;

    DatabaseReference reference;
    FirebaseDatabase database;
    SharedPreferences prefs;


    Button submit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //myDb = new RegisterDatabaseHelper(this);//instance of the DatabaseHelper class which we created for managing our database
        //once everything is done it will call the constructor of this database:RegisterDatabaseHelper class

        submit = (Button)findViewById(R.id.submitButton);
        editTextName = (EditText)findViewById(R.id.editText);
        editTextEmail = (EditText)findViewById(R.id.editText3);
        editTextPhoneNumber = (EditText)findViewById(R.id.editText4);
        editTextPassword = (EditText)findViewById(R.id.editText6);
        editTextCnfPasswd = (EditText)findViewById(R.id.editText11);
        EditTextPhoneNumber1 = (EditText)findViewById(R.id.editText7);
        EditTextPhoneNumber2 = (EditText)findViewById(R.id.editText8);
        EditTextPhoneNumber3 = (EditText)findViewById(R.id.editText9);
        EditTextPhoneNumber4 = (EditText)findViewById(R.id.editText10);


        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        database = FirebaseDatabase.getInstance().getInstance();
        reference = database.getReference("users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String name = editTextName.getText().toString();
                final String email = editTextEmail.getText().toString();
                final String phoneNumber = editTextPhoneNumber.getText().toString();
                final String passwd = editTextPassword.getText().toString();
                final String cnfpasswd = editTextCnfPasswd.getText().toString();
                final String phoneNumber1 = EditTextPhoneNumber1.getText().toString();
                final String phoneNumber2 = EditTextPhoneNumber2.getText().toString();
                final String phoneNumber3 = EditTextPhoneNumber3.getText().toString();
                final String phoneNumber4 = EditTextPhoneNumber4.getText().toString();
                final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                Query q = reference.orderByChild("username");
                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int flag = 0;
                        String username = "";
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            Users usr = data.getValue(Users.class);
                            username = usr.getName();//**
                        }
                        if (username.equals(name)) {
                            Toast.makeText(Register.this, "please chose another username", Toast.LENGTH_SHORT).show();
                        } else {
                            if (name.equals("") || email.equals("") || phoneNumber.equals("") || passwd.equals("") || cnfpasswd.equals("") || phoneNumber.equals("")|| phoneNumber1.equals("") || phoneNumber2.equals("") ||phoneNumber3.equals("") || phoneNumber4.equals(""))  {
                                flag = 1;
                            }
                            if (flag == 0) {
                                if (email.matches(emailPattern) && phoneNumber.matches("\\d+(?:\\.\\d+)?") && phoneNumber.length() == 10)//checking email validation
                                {
                                    if (passwd.equals(cnfpasswd))//checking password
                                     {
                                        String userid = reference.push().getKey();
                                        reference.child(userid).setValue(new Users(name, email, phoneNumber, passwd, cnfpasswd, phoneNumber1,phoneNumber2,phoneNumber3,phoneNumber4, prefs.getString("KEY_FCMTOKEN", "")));
                                        Toast.makeText(Register.this, "Connection Successful", Toast.LENGTH_LONG).show();
                                        Intent tt = new Intent(getApplicationContext(), Confirmation.class);
                                        startActivity(tt);
                                    } else {
                                        //txt1.setVisibility(View.VISIBLE);
                                    }
                                } else {
                                    //txt2.setVisibility(View.VISIBLE);
                                }
                            } else {
                                Toast.makeText(Register.this, "Please fill all the entries.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                //Intent openActivity = new Intent("com.example.dell.CONFIRMATION");
                //startActivity(openActivity);
            }
        });

    }
}

