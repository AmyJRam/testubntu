package com.example.amy.testubntu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by amy on 19/9/17.
 */

public class User_List_Customer_Adopter extends BaseAdapter {
    List<User_Details> user_details;
    Context context;
   public  User_List_Customer_Adopter(Context context, List<User_Details>user_details)
    {
        this.user_details=user_details;
        this.context=context;
    }

    @Override
    public int getCount() {
        return user_details.size();
    }

    @Override
    public Object getItem(int i) {
        return user_details.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            User_Details user_details= (User_Details) getItem(i);
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_user_temp, viewGroup, false);
            TextView textView_user=(TextView)view.findViewById(R.id.textView_user);
            TextView textView_address=(TextView)view.findViewById(R.id.textView_address);
            textView_user.setText(user_details.getUser_name());
            textView_address.setText(user_details.getUser_address());
        return  view;
        }
        return null;
    }
}
