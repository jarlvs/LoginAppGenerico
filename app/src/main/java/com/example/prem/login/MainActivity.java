package com.example.prem.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private  int counter =5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.Name);
        Password =(EditText) findViewById(R.id.Password);
        Info  = (TextView) findViewById(R.id.Info);
        Login = (Button) findViewById(R.id.Login);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                validate(Name.getText().toString(), Password.getText().toString());
            }

        });

    }

    private  void  validate(String userName, String userPassword){
        if( (userName.equals("Admin") ) && (userPassword.equals("generico"))){
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }

        else {
            counter--;

            Info.setText("No of attempts remaining: "+ String.valueOf(counter));
            if(counter==0){
                Login.setEnabled(false);
            }
        }
    }
}
