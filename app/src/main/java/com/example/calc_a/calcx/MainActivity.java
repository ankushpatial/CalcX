package com.example.calc_a.calcx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String Tag = "message";
    EditText e_bill;
    RadioGroup rgb_RsType;
    RadioButton rb_ac, rb_nac;
    Button   b_result;
    TextView t_st, t_sc, t_vat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_bill = (EditText)findViewById(R.id.AmountInput);

        rb_ac =(RadioButton)findViewById(R.id.AC);
        //rb_nac=(RadioButton)findViewById(R.id.NonAC);

        b_result = (Button)findViewById(R.id.button3);

        t_st = (TextView)findViewById(R.id.ST2);
        t_sc = (TextView)findViewById(R.id.SC2);
        t_vat = (TextView)findViewById(R.id.vt2);


         b_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                     try {


                        double n1 = 0;
                        double n2 = 0;
                        double n3 = 0;
                        double n4 = 0;
                        double temp = 0;
                        if (TextUtils.isEmpty(e_bill.getText().toString())) {
                            return;
                        }

                        n1 = Double.parseDouble(e_bill.getText().toString());
                        n2 = n1 / 10;
                        n3 = ((n1 + n2) * 0.4) * 0.1236;
                        n4 = temp * 0.1236;
                        n4 = (n1 + n2) * 0.145;

                        t_sc.setText(" " + n2);
                        t_st.setText(" " + n3);
                        t_vat.setText(" " + n4);


                }  catch (Exception e) {


                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
