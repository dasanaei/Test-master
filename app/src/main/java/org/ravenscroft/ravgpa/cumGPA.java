package org.ravenscroft.ravgpa;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class cumGPA extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cum_gp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTheGPAs();
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.cumlayout);
        layout.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent ev)
            {
                hideKeyboard(view);
                return false;
            }

        });
        run();
    }

    public void run(){
        Button btn1 = (Button) findViewById(R.id.button54);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String oldCumString;
                double oldCum;
                String status;
                EditText textView = (EditText) findViewById(R.id.cumGPA123);
                oldCumString = textView.getText().toString();
                Spinner spinner = (Spinner) findViewById(R.id.statusSpinner);
                status = spinner.getSelectedItem().toString();
                SharedPreferences.Editor editor = getSharedPreferences("test44", 0).edit();
                editor.putString("currentCumGPA", oldCumString);
                editor.putString("status", status);
                editor.apply();
                if (!(isNumeric(oldCumString))){
                    int jd = 54;
                }
                else if(oldCumString.equalsIgnoreCase("54")){
                    startActivity(new Intent(cumGPA.this, Mathster.class));
                }
                else if (oldCumString.equalsIgnoreCase("")){
                    int jd = 54;
                }
                else{
                    SharedPreferences prefs;
                    oldCum = Double.parseDouble(oldCumString);
                    prefs = getSharedPreferences("test44", 0);
                    String s1 = prefs.getString("GPA", "");
                    double gpa = Double.parseDouble(s1);
                    int status1 = toSemNum(status);
                    double theGPA = gpa;
                    double x;
                    double y;
                    x = oldCum * status1;
                    y = x + theGPA;
                    double newCumGPA = y/(status1+1);
                    String newCumGPAString = Double.toString(newCumGPA);
                    if (newCumGPAString.length() > 4)
                    {
                        newCumGPAString = newCumGPAString.substring(0,5);
                    }
                    if (newCumGPAString.length() == 3)
                    {
                        newCumGPAString = newCumGPAString.substring(0,3) + "000";
                        newCumGPAString = newCumGPAString.substring(0,4);
                    }
                    if (newCumGPAString.length() == 4)
                    {
                        newCumGPAString = newCumGPAString.substring(0,4) + "000";
                        newCumGPAString = newCumGPAString.substring(0,5);
                    }
                    else {
                        newCumGPAString = newCumGPAString;
                    }
                    TextView mTextView1 = (TextView) findViewById(R.id.newGPA);
                    mTextView1.setTextColor(Color.BLACK);
                    mTextView1.setText(newCumGPAString);
                }

            }
        });

    }

    public int toSemNum(String status){
        if (status.equalsIgnoreCase("First Semester Freshman Year")){
            return 0;
        }
        if (status.equalsIgnoreCase("Second Semester Freshman Year")){
            return 1;
        }
        if (status.equalsIgnoreCase("First Semester Sophomore Year")){
            return 2;
        }
        if (status.equalsIgnoreCase("Second Semester Sophomore Year")){
            return 3;
        }
        if (status.equalsIgnoreCase("First Semester Junior Year")){
            return 4;
        }
        if (status.equalsIgnoreCase("Second Semester Junior Year")){
            return 5;
        }
        if (status.equalsIgnoreCase("First Semester Senior Year")){
            return 6;
        }
        if (status.equalsIgnoreCase("Second Semester Senior Year")){
            return 7;
        }
        else{
            return 0;
        }
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public void setTheGPAs(){
        SharedPreferences prefs = getSharedPreferences("test44", 0);
        String s1 = prefs.getString("GPA", "");
        String s2 = prefs.getString("currentCumGPA", "");
        String s3 = prefs.getString("status", "Enter Status");
        TextView mTextView2 = (TextView) findViewById(R.id.currentGPA);
        mTextView2.setTextColor(Color.BLACK);
        mTextView2.setText("Current Semester GPA: " + s1);

        EditText edittext = (EditText) findViewById(R.id.cumGPA123);
        edittext.setTextColor(Color.BLACK);
        edittext.setText(s2);

        Spinner spinner = (Spinner) findViewById(R.id.statusSpinner);
        spinner.setSelection(nameToNum(s3));
    }

    public int nameToNum(String status){
        if (status.equalsIgnoreCase("First Semester Freshman Year")){
            return 1;
        }
        if (status.equalsIgnoreCase("Second Semester Freshman Year")){
            return 2;
        }
        if (status.equalsIgnoreCase("First Semester Sophomore Year")){
            return 3;
        }
        if (status.equalsIgnoreCase("Second Semester Sophomore Year")){
            return 4;
        }
        if (status.equalsIgnoreCase("First Semester Junior Year")){
            return 5;
        }
        if (status.equalsIgnoreCase("Second Semester Junior Year")){
            return 6;
        }
        if (status.equalsIgnoreCase("First Semester Senior Year")){
            return 7;
        }
        if (status.equalsIgnoreCase("Second Semester Senior Year")){
            return 8;
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_rav_g, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, Settings.class));
                return true;

            case R.id.about:
                startActivity(new Intent(this, About.class));
                return true;

            case R.id.cumGPA123:
                startActivity(new Intent(this, cumGPA.class));
                return true;

            case R.id.semGPA:
                startActivity(new Intent(this, RavGPA.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
