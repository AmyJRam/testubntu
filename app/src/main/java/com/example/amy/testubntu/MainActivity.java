package com.example.amy.testubntu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DB_Helper db_helper;
    EditText editText_name,editText_address;
    Button button_save;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    public void init()
    {
        context=this;
        editText_address=(EditText)findViewById(R.id.editText_name);
        editText_name=(EditText)findViewById(R.id.editText_address);
        button_save=(Button)findViewById(R.id.button_save);
        db_helper=DB_Helper.getInstance(context);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_name=editText_name.getText().toString();
                String address=editText_address.getText().toString();
               long id= db_helper.Add_User_Details(user_name,address);
                if(id>0)
                {
                    Toast.makeText(context, "Data Added"+id, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(context, "Fail to Add"+id, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
