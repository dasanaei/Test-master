package org.ravenscroft.ravgpa;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static org.ravenscroft.ravgpa.RavGPA.bump1;
import static org.ravenscroft.ravgpa.RavGPA.bump2;
import static org.ravenscroft.ravgpa.RavGPA.bump3;
import static org.ravenscroft.ravgpa.RavGPA.bump4;
import static org.ravenscroft.ravgpa.RavGPA.bump5;
import static org.ravenscroft.ravgpa.RavGPA.bump6;
import static org.ravenscroft.ravgpa.RavGPA.bump7;


public class Settings extends AppCompatActivity {

    public static String class1;
    public static String class2;
    public static String class3;
    public static String class4;
    public static String class5;
    public static String class6;
    public static String class7;
    private static int bluby;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_settings);
        setTheCheckMarks();
        setTheClasses();
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_settings);
        layout.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent ev)
            {
                hideKeyboard(view);
                return false;
            }
        });
        Button btn2 = (Button) findViewById(R.id.donebutton);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)  {
                class1 = getText1();
                class2 = getText2();
                class3 = getText3();
                class4 = getText4();
                class5 = getText5();
                class6 = getText6();
                class7 = getText7();
                bump1 = box1();
                bump2 = box2();
                bump3 = box3();
                bump4 = box4();
                bump5 = box5();
                bump6 = box6();
                bump7 = box7();
                SharedPreferences.Editor editor = getSharedPreferences("test44", 0).edit();
                editor.putString("class1", getClass1());
                editor.putString("class2", getClass2());
                editor.putString("class3", getClass3());
                editor.putString("class4", getClass4());
                editor.putString("class5", getClass5());
                editor.putString("class6", getClass6());
                editor.putString("class7", getClass7());
                editor.apply();
                getTheCheckMarks();
                start1();
                startActivity(new Intent(Settings.this,RavGPA.class));
            }
        });
        setTitle("Edit Classes");


    }
    public static int start(){

        return bluby;
    }
    public static void start1(){
        bluby = 1;
    }
    public double box1(){
        CheckBox check1ap = (CheckBox) findViewById(R.id.ap1);
        CheckBox check1h = (CheckBox) findViewById(R.id.h1);
        if (check1ap.isChecked())
        {
            return 1;
        }
        if (check1h.isChecked()){
            return .5;
        }
        else
        {
            return 0;
        }
    }
    public double box2(){
        CheckBox check2ap = (CheckBox) findViewById(R.id.ap2);
        CheckBox check2h = (CheckBox) findViewById(R.id.h2);
        if (check2ap.isChecked())
        {
            return 1;
        }
        if (check2h.isChecked()){
            return .5;
        }
        else
        {
            return 0;
        }
    }
    public double box3(){
        CheckBox check3ap = (CheckBox) findViewById(R.id.ap3);
        CheckBox check3h = (CheckBox) findViewById(R.id.h3);
        if (check3ap.isChecked())
        {
            return 1;
        }
        if (check3h.isChecked()){
            return .5;
        }
        else
        {
            return 0;
        }
    }
    public double box4(){
        CheckBox check4ap = (CheckBox) findViewById(R.id.ap4);
        CheckBox check4h = (CheckBox) findViewById(R.id.h4);
        if (check4ap.isChecked())
        {
            return 1;
        }
        if (check4h.isChecked()){
            return .5;
        }
        else
        {
            return 0;
        }
    }
    public double box5(){
        CheckBox check5ap = (CheckBox) findViewById(R.id.ap5);
        CheckBox check5h = (CheckBox) findViewById(R.id.h5);
        if (check5ap.isChecked())
        {
            return 1;
        }
        if (check5h.isChecked()){
            return .5;
        }
        else
        {
            return 0;
        }
    }
    public double box6(){
        CheckBox check6ap = (CheckBox) findViewById(R.id.ap6);
        CheckBox check6h = (CheckBox) findViewById(R.id.h6);
        if (check6ap.isChecked())
        {
            return 1;
        }
        if (check6h.isChecked()){
            return .5;
        }
        else
        {
            return 0;
        }
    }
    public double box7(){
        CheckBox check7ap = (CheckBox) findViewById(R.id.ap7);
        CheckBox check7h = (CheckBox) findViewById(R.id.h7);
        if (check7ap.isChecked())
        {
            return 1;
        }
        if (check7h.isChecked()){
            return .5;
        }
        else
        {
            return 0;
        }
    }

    public String getText1(){
        EditText textView1 = (EditText) findViewById(R.id.EC1);
        return textView1.getText().toString();
    }
    public String getText2(){
        EditText textView2 = (EditText) findViewById(R.id.EC2);
        return textView2.getText().toString();
    }
    public String getText3(){
        EditText textView3 = (EditText) findViewById(R.id.EC3);
        return textView3.getText().toString();
    }
    public String getText4(){
        EditText textView4 = (EditText) findViewById(R.id.EC4);
        return textView4.getText().toString();
    }
    public String getText5(){
        EditText textView5 = (EditText) findViewById(R.id.EC5);
        return textView5.getText().toString();
    }
    public String getText6(){
        EditText textView6 = (EditText) findViewById(R.id.EC6);
        return textView6.getText().toString();
    }
    public String getText7(){
        EditText textView7 = (EditText) findViewById(R.id.EC7);
        return textView7.getText().toString();
    }

    public static String getClass1(){
        return class1;
    }
    public static String getClass2(){
        return class2;
    }
    public static String getClass3(){
        return class3;
    }
    public static String getClass4(){
        return class4;
    }
    public static String getClass5(){
        return class5;
    }
    public static String getClass6(){
        return class6;
    }
    public static String getClass7(){
        return class7;
    }

    private void setTheClasses() {
        SharedPreferences prefs = getSharedPreferences("test44", 0);
        String name1 = prefs.getString("class1", "Class 1");//"No name defined" is the default value.
        String name2 = prefs.getString("class2", "Class 2");//"No name defined" is the default value.
        String name3 = prefs.getString("class3", "Class 3");//"No name defined" is the default value.
        String name4 = prefs.getString("class4", "Class 4");//"No name defined" is the default value.
        String name5 = prefs.getString("class5", "Class 5");//"No name defined" is the default value.
        String name6 = prefs.getString("class6", "Class 6");//"No name defined" is the default value.
        String name7 = prefs.getString("class7", "Class 7");//"No name defined" is the default value.

        TextView mTextView1 = (TextView) findViewById(R.id.EC1);
        mTextView1.setTextColor(Color.BLACK);
        mTextView1.setText(name1);

        TextView mTextView2 = (TextView) findViewById(R.id.EC2);
        mTextView2.setTextColor(Color.BLACK);
        mTextView2.setText(name2);

        TextView mTextView3 = (TextView) findViewById(R.id.EC3);
        mTextView3.setTextColor(Color.BLACK);
        mTextView3.setText(name3);

        TextView mTextView4 = (TextView) findViewById(R.id.EC4);
        mTextView4.setTextColor(Color.BLACK);
        mTextView4.setText(name4);

        TextView mTextView5 = (TextView) findViewById(R.id.EC5);
        mTextView5.setTextColor(Color.BLACK);
        mTextView5.setText(name5);

        TextView mTextView6 = (TextView) findViewById(R.id.EC6);
        mTextView6.setTextColor(Color.BLACK);
        mTextView6.setText(name6);

        TextView mTextView7 = (TextView) findViewById(R.id.EC7);
        mTextView7.setTextColor(Color.BLACK);
        mTextView7.setText(name7);

    }

    public void getTheCheckMarks(){
        SharedPreferences.Editor editor = getSharedPreferences("test44", 0).edit();
        CheckBox check1ap = (CheckBox) findViewById(R.id.ap1);
        CheckBox check1h = (CheckBox) findViewById(R.id.h1);
        CheckBox check2ap = (CheckBox) findViewById(R.id.ap2);
        CheckBox check2h = (CheckBox) findViewById(R.id.h2);
        CheckBox check3ap = (CheckBox) findViewById(R.id.ap3);
        CheckBox check3h = (CheckBox) findViewById(R.id.h3);
        CheckBox check4ap = (CheckBox) findViewById(R.id.ap4);
        CheckBox check4h = (CheckBox) findViewById(R.id.h4);
        CheckBox check5ap = (CheckBox) findViewById(R.id.ap5);
        CheckBox check5h = (CheckBox) findViewById(R.id.h5);
        CheckBox check6ap = (CheckBox) findViewById(R.id.ap6);
        CheckBox check6h = (CheckBox) findViewById(R.id.h6);
        CheckBox check7ap = (CheckBox) findViewById(R.id.ap7);
        CheckBox check7h = (CheckBox) findViewById(R.id.h7);
        editor.putBoolean("AP1", check1ap.isChecked());
        editor.putBoolean("H2", check1h.isChecked());
        editor.putBoolean("AP2", check2ap.isChecked());
        editor.putBoolean("H2", check2h.isChecked());
        editor.putBoolean("AP3", check3ap.isChecked());
        editor.putBoolean("H3", check3h.isChecked());
        editor.putBoolean("AP4", check4ap.isChecked());
        editor.putBoolean("H4", check4h.isChecked());
        editor.putBoolean("AP5", check5ap.isChecked());
        editor.putBoolean("H5", check5h.isChecked());
        editor.putBoolean("AP6", check6ap.isChecked());
        editor.putBoolean("H6", check6h.isChecked());
        editor.putBoolean("AP7", check7ap.isChecked());
        editor.putBoolean("H7", check7h.isChecked());
        editor.apply();
    }
    public void setTheCheckMarks(){
        SharedPreferences prefs = getSharedPreferences("test44", 0);
        boolean AP1 = prefs.getBoolean("AP1", false);
        boolean H1 = prefs.getBoolean("H1", false);
        boolean AP2 = prefs.getBoolean("AP2", false);
        boolean H2 = prefs.getBoolean("H2", false);
        boolean AP3 = prefs.getBoolean("AP3", false);
        boolean H3 = prefs.getBoolean("H3", false);
        boolean AP4 = prefs.getBoolean("AP4", false);
        boolean H4 = prefs.getBoolean("H4", false);
        boolean AP5 = prefs.getBoolean("AP5", false);
        boolean H5 = prefs.getBoolean("H5", false);
        boolean AP6 = prefs.getBoolean("AP6", false);
        boolean H6 = prefs.getBoolean("H6", false);
        boolean AP7 = prefs.getBoolean("AP7", false);
        boolean H7 = prefs.getBoolean("H7", false);
        if (AP1){
            CheckBox Checkboxap1 = (CheckBox) findViewById(R.id.ap1);
            Checkboxap1.setChecked(true);
        }
        if (H1){
            CheckBox Checkboxh1 = (CheckBox) findViewById(R.id.h1);
            Checkboxh1.setChecked(true);
        }
        if (AP2){
            CheckBox Checkboxap2 = (CheckBox) findViewById(R.id.ap2);
            Checkboxap2.setChecked(true);
        }
        if (H2){
            CheckBox Checkboxh2 = (CheckBox) findViewById(R.id.h2);
            Checkboxh2.setChecked(true);
        }
        if (AP3){
            CheckBox Checkboxap3 = (CheckBox) findViewById(R.id.ap3);
            Checkboxap3.setChecked(true);
        }
        if (H3){
            CheckBox Checkboxh3 = (CheckBox) findViewById(R.id.h3);
            Checkboxh3.setChecked(true);
        }
        if (AP4){
            CheckBox Checkboxap4 = (CheckBox) findViewById(R.id.ap4);
            Checkboxap4.setChecked(true);
        }
        if (H4){
            CheckBox Checkboxh4 = (CheckBox) findViewById(R.id.h4);
            Checkboxh4.setChecked(true);
        }
        if (AP5){
            CheckBox Checkboxap5 = (CheckBox) findViewById(R.id.ap5);
            Checkboxap5.setChecked(true);
        }
        if (H5){
            CheckBox Checkboxh6 = (CheckBox) findViewById(R.id.h5);
            Checkboxh6.setChecked(true);
        }
        if (AP6){
            CheckBox Checkboxap6 = (CheckBox) findViewById(R.id.ap6);
            Checkboxap6.setChecked(true);
        }
        if (H6){
            CheckBox Checkboxh6 = (CheckBox) findViewById(R.id.h6);
            Checkboxh6.setChecked(true);
        }if (AP7){
            CheckBox Checkboxap7 = (CheckBox) findViewById(R.id.ap7);
            Checkboxap7.setChecked(true);
        }
        if (H7){
            CheckBox Checkboxh7 = (CheckBox) findViewById(R.id.h7);
            Checkboxh7.setChecked(true);
        }
    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}




