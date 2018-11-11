package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonDot, buttonClear;
    EditText editTextDisplay;

    boolean hasDecimal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonClear = (Button) findViewById(R.id.buttonAC);

        editTextDisplay = (EditText) findViewById(R.id.displayTV);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (test.contentEquals("0")) {
                    editTextDisplay.setText("1");
                } else {
                    editTextDisplay.setText(editTextDisplay.getText() + "1");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (test.contentEquals("0")) {
                    editTextDisplay.setText("2");
                } else {
                    editTextDisplay.setText(editTextDisplay.getText() + "2");
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (test.contentEquals("0")) {
                    editTextDisplay.setText("3");
                } else {
                    editTextDisplay.setText(editTextDisplay.getText() + "3");
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (test.contentEquals("0")) {
                    editTextDisplay.setText("4");
                } else {
                    editTextDisplay.setText(editTextDisplay.getText() + "4");
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (test.contentEquals("0")) {
                    editTextDisplay.setText("5");
                } else {
                    editTextDisplay.setText(editTextDisplay.getText() + "5");
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (test.contentEquals("0")) {
                    editTextDisplay.setText("6");
                } else {
                    editTextDisplay.setText(editTextDisplay.getText() + "6");
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (test.contentEquals("0")) {
                    editTextDisplay.setText("7");
                } else {
                    editTextDisplay.setText(editTextDisplay.getText() + "7");
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (test.contentEquals("0")) {
                    editTextDisplay.setText("8");
                } else {
                    editTextDisplay.setText(editTextDisplay.getText() + "8");
                }
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (test.contentEquals("0")) {
                    editTextDisplay.setText("9");
                } else {
                    editTextDisplay.setText(editTextDisplay.getText() + "9");
                }
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (test.contentEquals("0")) {
                    editTextDisplay.setText("0");
                } else {
                    editTextDisplay.setText(editTextDisplay.getText() + "0");
                }
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test = editTextDisplay.getText().toString();
                if (hasDecimal == false) {
                    // editTextDisplay.setText("0");
                    editTextDisplay.setText(editTextDisplay.getText() + ".");
                    hasDecimal = true;
                }


            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextDisplay.setText("0");
                hasDecimal = false;
            }
        });
    }
}
