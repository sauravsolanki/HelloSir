package com.example.hp.hellosir.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.hp.hellosir.R;

/**
 * Created by hp on 31-03-2018.
 */

public class StudentProvider extends ContentProvider {

    SQLiteDatabase myDb;

    private static final String DB_NAME="cuk";
    private static final String DB_TABLE="student";
    private static final int DB_VER=1;

    public StudentProvider() {
    }

    public static final String AUTHORITY="com.cuk.android.project";
    public static final Uri CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/stu");

    public static int STU=1;
    public static int STU_ID=2;

    static UriMatcher myUri=new UriMatcher(UriMatcher.NO_MATCH);

    static {
        myUri.addURI(AUTHORITY,"stu",STU);
        myUri.addURI(AUTHORITY,"stu/#",STU_ID);//??????????????????????????
    }

    private class StudentDatabse extends SQLiteOpenHelper{

        public StudentDatabse(Context context){
            super(context,DB_NAME,null,DB_VER);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table "+DB_TABLE+" ( _id varchar(20) primary key ,name varchar(30),photo integer,year integer,dept varchar(15),school varchar(30));");


            //2013 Batch Student
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2013IEN01','Abhishek R G',"+ R.drawable.pro6+",2013,'CADMA','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2013IEN02','Afshan Nausheen',"+ R.drawable.pro5+",2013,'PEE','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2013IEN03','AISHWARYA M CHITTAWADGI',"+ R.drawable.pro3+",2013,'CADMA','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2013IEN14','ALURI SRIHARSHA',"+ R.drawable.pro4+",2013,'CADMA','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2013IEN05','ANIKETAN MATH',"+ R.drawable.pro5+",2013,'CT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2013IEN06','ANUSHREE MATH',"+ R.drawable.pro3+",2013,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2013IEN07','APOORVA JOSHI',"+ R.drawable.pro6+",2013,'ICT','Engg')");

            //2014 Batch Student
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2014DEN0047','Anil',"+ R.drawable.pro6+",2014,'CST','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2014DEN0055','Gaurav Chatterjee',"+ R.drawable.pro5+",2014,'CST','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2014DEN0056','Kartikeya Singh Gour',"+ R.drawable.pro3+",2014,'CST','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2014DEN0074','Priya',"+ R.drawable.pro4+",2014,'CST','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2014DEN0051','Chandana Ronad',"+ R.drawable.pro5+",2014,'PEE','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2014DEN0079','Samvedana Benkin',"+ R.drawable.pro3+",2014,'PEE','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2014DEN0062','Naveen Sagar',"+ R.drawable.pro6+",2014,'CADMA','Engg')");


            //2015 Batch Student
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2015IEN01','Adulla Sai Teja Reddy',"+ R.drawable.pro6+",2015,'CST','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2015IEN02','Ajith',"+ R.drawable.pro5+",2015,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2015IEN03','Akshata',"+ R.drawable.pro3+",2015,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2015IEN04','Ambresh',"+ R.drawable.pro4+",2015,'PEE','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2015IEN05','Ankita',"+ R.drawable.pro5+",2015,'CADMA','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2015IEN06','Anusha',"+ R.drawable.pro3+",2015,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2015IEN07','Atmadeep',"+ R.drawable.pro6+",2015,'CST','Engg')");


            //2016 Batch Student
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2016IEC02','Arohi',"+ R.drawable.pro6+",2016,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2016IEC03','Bhargav Sai Barala',"+ R.drawable.pro5+",2016,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2016IEC04','C. Lohith Kumar',"+ R.drawable.pro3+",2016,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2016IEC05','Geetanjali',"+ R.drawable.pro4+",2016,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2016IEE01','Akshara',"+ R.drawable.pro5+",2016,'PEE','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2016IEE02','Anandjith S',"+ R.drawable.pro3+",2016,'PEE','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2016IEE03','Aniket Waman Salve',"+ R.drawable.pro6+",2016,'PEE','Engg')");

            //2017 Batch Student
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2017IEN01','Abdul Khadar M A',"+ R.drawable.pro6+",2017,'CST','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2017IEN02','Abhay U',"+ R.drawable.pro5+",2017,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2017IEN03','Adwaith S',"+ R.drawable.pro3+",2017,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2017IEN04','Akula Rahul',"+ R.drawable.pro4+",2017,'PEE','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2017IEN05','Ankita',"+ R.drawable.pro5+",2017,'CADMA','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2017IEN06','Arun',"+ R.drawable.pro3+",2017,'ICT','Engg')");
            sqLiteDatabase.execSQL("insert into "+ DB_TABLE +"(_id,name,photo,year,dept,school) values ('2017IEN07','Ashwini N Desai',"+ R.drawable.pro6+",2017,'CST','Engg')");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("Drop table if exists "+DB_TABLE);
        }
    }
    @Override
    public boolean onCreate() {
        StudentDatabse myHelper = new StudentDatabse(getContext());
        myDb = myHelper.getWritableDatabase();
        if (myDb!=null){
            return true;
        }else {
            return false;
        }
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projections, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteQueryBuilder myQuery=new SQLiteQueryBuilder();
        myQuery.setTables(DB_TABLE);
        Cursor cr=myQuery.query(myDb,null,selection,selectionArgs,null,null,sortOrder);


        // throw new UnsupportedOperationException("Not yet implemented");
        cr.setNotificationUri(getContext().getContentResolver(),uri);
        return cr;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        long row= myDb.insert(DB_TABLE,null,contentValues);
        if (row>0){
            uri= ContentUris.withAppendedId(CONTENT_URI,row);
            getContext().getContentResolver().notifyChange(uri,null);
        }

        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
