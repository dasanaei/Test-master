package org.ravenscroft.ravgpa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import static org.ravenscroft.ravgpa.Settings.start;


public class RavGPA extends AppCompatActivity implements blub {
    private String Grade1;
    private String Grade2;
    private String Grade3;
    private String Grade4;
    private String Grade5;
    private String Grade6;
    private String Grade7;
    public static double bump1;
    public static double bump2;
    public static double bump3;
    public static double bump4;
    public static double bump5;
    public static double bump6;
    public static double bump7;
    private String theGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!(start()==1)){
            startActivity(new Intent(RavGPA.this,Settings.class));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rav_gp);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setClasses();
        getFinalGPA();
        setTheSpinners();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getBaseContext(), "Confused? Use the drop down menu in the top right in order to change class settings or find your cumulative GPA", Toast.LENGTH_LONG);
                TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                if (v != null) v.setGravity(Gravity.CENTER);
                toast.show();
            }
        });
    }

    public void setClasses() {
        SharedPreferences prefs = getSharedPreferences("test44", 0);
        String name1 = prefs.getString("class1", "Class 1");
        String name2 = prefs.getString("class2", "Class 2");
        String name3 = prefs.getString("class3", "Class 3");
        String name4 = prefs.getString("class4", "Class 4");
        String name5 = prefs.getString("class5", "Class 5");
        String name6 = prefs.getString("class6", "Class 6");
        String name7 = prefs.getString("class7", "Class 7");

        TextView mTextView1 = (TextView) findViewById(R.id.textViewCL1);
        mTextView1.setTextColor(Color.BLACK);
        mTextView1.setText(name1);

        TextView mTextView2 = (TextView) findViewById(R.id.textViewCL2);
        mTextView2.setTextColor(Color.BLACK);
        mTextView2.setText(name2);

        TextView mTextView3 = (TextView) findViewById(R.id.textViewCL3);
        mTextView3.setTextColor(Color.BLACK);
        mTextView3.setText(name3);

        TextView mTextView4 = (TextView) findViewById(R.id.textViewCL4);
        mTextView4.setTextColor(Color.BLACK);
        mTextView4.setText(name4);

        TextView mTextView5 = (TextView) findViewById(R.id.textViewCL5);
        mTextView5.setTextColor(Color.BLACK);
        mTextView5.setText(name5);

        TextView mTextView6 = (TextView) findViewById(R.id.textViewCL6);
        mTextView6.setTextColor(Color.BLACK);
        mTextView6.setText(name6);

        TextView mTextView7 = (TextView) findViewById(R.id.textViewCL7);
        mTextView7.setTextColor(Color.BLACK);
        mTextView7.setText(name7);
    }

    public void getFinalGPA() {
        Button btn1 = (Button) findViewById(R.id.testbut);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Spinner spinnerC1 = (Spinner) findViewById(R.id.spinnerCL1);
                Grade1 = spinnerC1.getSelectedItem().toString();

                Spinner spinnerC2 = (Spinner) findViewById(R.id.spinnerCL2);
                Grade2 = spinnerC2.getSelectedItem().toString();

                Spinner spinnerC3 = (Spinner) findViewById(R.id.spinnerCL3);
                Grade3 = spinnerC3.getSelectedItem().toString();

                Spinner spinnerC4 = (Spinner) findViewById(R.id.spinnerCL4);
                Grade4 = spinnerC4.getSelectedItem().toString();

                Spinner spinnerC5 = (Spinner) findViewById(R.id.spinnerCL5);
                Grade5 = spinnerC5.getSelectedItem().toString();

                Spinner spinnerC6 = (Spinner) findViewById(R.id.spinnerCL6);
                Grade6 = spinnerC6.getSelectedItem().toString();

                Spinner spinnerC7 = (Spinner) findViewById(R.id.spinnerCL7);
                Grade7 = spinnerC7.getSelectedItem().toString();

                GPA obj = new GPA(Grade1, Grade2, Grade3, Grade4, Grade5, Grade6, Grade7);
                String GPA = obj.getGPA();
                theGPA = GPA;
                SharedPreferences.Editor editor1 = getSharedPreferences("test44", 0).edit();
                editor1.putString("GPA", theGPA);
                editor1.apply();
                //Toast.makeText(getBaseContext(), GPA , Toast.LENGTH_LONG ).show();
                TextView mTextView100 = (TextView) findViewById(R.id.gpatext);
                mTextView100.setTextColor(Color.BLACK);
                mTextView100.setText(GPA);

                SharedPreferences.Editor editor = getSharedPreferences("spinners", 0).edit();
                editor.putString("spinner1", Grade1);
                editor.putString("spinner2", Grade2);
                editor.putString("spinner3", Grade3);
                editor.putString("spinner4", Grade4);
                editor.putString("spinner5", Grade5);
                editor.putString("spinner6", Grade6);
                editor.putString("spinner7", Grade7);
                editor.apply();
            }
        });
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

    public void setTheSpinners() {
        SharedPreferences prefs = getSharedPreferences("spinners", 0);
        String S1 = prefs.getString("spinner1", " ");
        String S2 = prefs.getString("spinner2", " ");
        String S3 = prefs.getString("spinner3", " ");
        String S4 = prefs.getString("spinner4", " ");
        String S5 = prefs.getString("spinner5", " ");
        String S6 = prefs.getString("spinner6", " ");
        String S7 = prefs.getString("spinner7", " ");
        Spinner spinner1 = (Spinner) findViewById(R.id.spinnerCL1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinnerCL2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinnerCL3);
        Spinner spinner4 = (Spinner) findViewById(R.id.spinnerCL4);
        Spinner spinner5 = (Spinner) findViewById(R.id.spinnerCL5);
        Spinner spinner6 = (Spinner) findViewById(R.id.spinnerCL6);
        Spinner spinner7 = (Spinner) findViewById(R.id.spinnerCL7);
        spinner1.setSelection(nameToNum(S1));
        spinner2.setSelection(nameToNum(S2));
        spinner3.setSelection(nameToNum(S3));
        spinner4.setSelection(nameToNum(S4));
        spinner5.setSelection(nameToNum(S5));
        spinner6.setSelection(nameToNum(S6));
        spinner7.setSelection(nameToNum(S7));

    }

    public int nameToNum(String G1) {
        if (G1.equalsIgnoreCase(" ")) {
            return 0;
        }
        if (G1.equalsIgnoreCase("A+")) {
            return 1;
        }
        if (G1.equalsIgnoreCase("A")) {
            return 2;
        }
        if (G1.equalsIgnoreCase("A-")) {
            return 3;
        }
        if (G1.equalsIgnoreCase("B+")) {
            return 4;
        }
        if (G1.equalsIgnoreCase("B")) {
            return 5;
        }
        if (G1.equalsIgnoreCase("B-")) {
            return 6;
        }
        if (G1.equalsIgnoreCase("C+")) {
            return 7;
        }
        if (G1.equalsIgnoreCase("C")) {
            return 8;
        }
        if (G1.equalsIgnoreCase("D+")) {
            return 9;
        }
        if (G1.equalsIgnoreCase("D")) {
            return 10;
        }
        else {
            return 0;
        }

    }
}
