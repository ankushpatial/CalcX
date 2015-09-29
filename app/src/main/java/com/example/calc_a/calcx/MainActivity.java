package com.example.calc_a.calcx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    EditText e_bill;
    RadioGroup rgb_RsType;
    Button   b_result;
    TextView t_st, t_sc, t_vat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_bill = (EditText)findViewById(R.id.AmountInput);

        rgb_RsType = (RadioGroup)findViewById(R.id.Rtype);

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
                    // get selected radio button from radioGroup
                    int selectedId = rgb_RsType.getCheckedRadioButtonId();

                    n1 = Double.parseDouble(e_bill.getText().toString());

                    switch(selectedId)
                    {
                        case R.id.AC:
                            Log.v(LOG_TAG, "AC button clicked");
                            temp = n1 / 1.31384;
                            n2 = temp / 10;
                            n4 = (temp + n2) * 0.145;
                            n3 = ((temp + n2) * 0.4) * 0.1236;
                            break;
                        case R.id.NonAC:
                            Log.v(LOG_TAG, "NonAC button clicked");

                            n3 = 0;
                          // Ninjas rule
                            break;
                    }


                    if (TextUtils.isEmpty(e_bill.getText().toString())) {
                        return;
                    }



                    t_sc.setText(String.format(" %.2f", n2));
                    t_st.setText(String.format(" %.2f", n3));
                    t_vat.setText(String.format(" %.2f", n4));


                }  catch (Exception e) {


                }
            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.AC:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.NonAC:
                if (checked)
                    // Ninjas rule
                    break;
        }
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
