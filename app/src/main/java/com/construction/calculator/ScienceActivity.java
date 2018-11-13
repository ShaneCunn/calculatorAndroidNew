package com.construction.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculator.MainActivity;
import com.example.calculator.R;

public class ScienceActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonDot, buttonClear, buttonPlus, buttonMinus, buttonDivide, buttonMulti, buttonEqual, buttonPercent, buttonDelete, buttonScience;
    EditText editTextDisplay;

    boolean hasDecimal, add, minus, divide, multi;

    double valueOne = 0.0, valueTwo = 0.0, result = 0.0, data = 0.0;

    Button buttonCal;


    public void startCalculator() {

        buttonScience = (Button) findViewById(R.id.buttonScience);
        buttonScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calMain = new Intent(ScienceActivity.this, MainActivity.class);
                startActivity(calMain);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        startCalculator();
    }
}
