package com.example.amy.testubntu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amy on 18/9/17.
 */

public class DB_Helper  extends SQLiteOpenHelper {
    public static  DB_Helper db_helper;
    SQLiteDatabase sqLiteDatabase;

    private  DB_Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static DB_Helper getInstance(Context context)
    {
        if(db_helper==null)
        {

            db_helper=new DB_Helper(context,Constant.DBNAME,null,Constant.VERSION);
        }
        return  db_helper;
    }

    @Override
    public void onOpen(SQLiteDatabase sqLiteDatabase) {
        super.onOpen(sqLiteDatabase);
        this.sqLiteDatabase=sqLiteDatabase;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE = "CREATE TABLE " + Constant.TABLENAME + "("
                + Constant.USERIDKEY + " INTEGER  PRIMARY KEY AUTOINCREMENT ," + Constant.USERKEY + " TEXT[100],"
                + Constant.ADDRESSKEY + " TEXT[100]" + ")";
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<User_Details>fetch_all_user()
    {
        List<User_Details> user_detailses=new ArrayList<>();
        try
        {
            sqLiteDatabase=db_helper.getWritableDatabase();
            String select_query="SELECT * from "+Constant.TABLENAME;

            Cursor cursor=sqLiteDatabase.rawQuery(select_query,null);
            if(cursor.moveToFirst())
            {
                do {
                    User_Details user_details=new User_Details();
                    user_details.setUser_name(cursor.getString(0));
                    user_details.setUser_name(cursor.getString(1));
                    user_detailses.add(user_details);
                }while (cursor.moveToNext());
            }
        }
        catch (Exception e)
        {
            Log.i("Fecth_Error",e.getMessage());
        }
        return user_detailses;
    }

    public long Add_User_Details(String user_name,String Address)
    {
        sqLiteDatabase=db_helper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        /*contentValues.put(Constant.USERIDKEY,1);*/
        contentValues.put(Constant.USERKEY,user_name);
        contentValues.put(Constant.ADDRESSKEY,Address);
      long id=  sqLiteDatabase.insert(Constant.TABLENAME,null,contentValues);
        sqLiteDatabase.close();
        return  id;
    }
}
