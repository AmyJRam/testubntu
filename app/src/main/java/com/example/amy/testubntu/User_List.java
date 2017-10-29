package com.example.amy.testubntu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

/**
 * Created by amy on 19/9/17.
 */

public class User_List extends AppCompatActivity {
    ListView listView;
    DB_Helper db_helper;
    Context context;
    User_List_Customer_Adopter user_list_customer_adopter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init();
    }
    public void init()
    {
        context=this;
        db_helper=DB_Helper.getInstance(context);
        listView=(ListView)findViewById(R.id.user_list);
        List<User_Details> user_details=db_helper.fetch_all_user();
        user_list_customer_adopter=new User_List_Customer_Adopter(context,user_details);
        listView.setAdapter(user_list_customer_adopter);

    }
}
