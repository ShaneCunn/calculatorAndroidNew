package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.construction.calculator.ScienceActivity;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonDot, buttonClear,
            buttonPlus, buttonMinus, buttonDivide, buttonMulti, buttonEqual, buttonPercent, buttonDelete, buttonScience;

    boolean hasDecimal;

    EditText tvResult, tvExpression;



    public void startScience() {

        buttonScience = findViewById(R.id.buttonScience);
        buttonScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent science = new Intent(MainActivity.this, ScienceActivity.class);
                startActivity(science);
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initControls();
        startScience();

        // disable keyboard on edit text boxes
        tvExpression.requestFocus();
        tvExpression.setShowSoftInputOnFocus(false);
        tvResult.requestFocus();
        tvResult.setShowSoftInputOnFocus(false);


        //Numbers
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("1", true);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("2", true);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("3", true);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("4", true);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("5", true);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("6", true);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("7", true);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("8", true);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("9", true);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("0", true);
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = String.valueOf(tvExpression.getText());
                char c = value.charAt(0);

                // check to see if there is one period/decimal place
                if (hasDecimal == false) {
                    if (c == '.') {
                        setDisplayValue("0.", true);
                        hasDecimal = true;
                    } else {
                        setDisplayValue(".", true);
                        hasDecimal = true;

                    }
                }


            }
        });

        // Operators
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue(" + ", false);
                hasDecimal = false;
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue(" - ", false);
                hasDecimal = false;
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue(" x ", false);
                hasDecimal = false;
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue(" \u00F7 ", false);
                hasDecimal = false;
            }
        });


        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    com.udojava.evalex.Expression expression =
                            new com.udojava.evalex.Expression(tvExpression.getText().toString());

                    BigDecimal beforeResult = expression.eval();

                    BigDecimal perc = new BigDecimal("100");
                    BigDecimal result = beforeResult.divide(perc, 2, BigDecimal.ROUND_FLOOR);
                    tvResult.setText(String.valueOf(result));
                } catch (Exception e) {
                    Log.d("Exception", " message is: " + e.getMessage());
                }

            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = tvExpression.getText().toString();
                if (result.length() > 0) {
                    tvExpression.setText(result.substring(0, result.length() - 1));
                    if (result.isEmpty()) {

                        tvExpression.setText("0");
                    }

                }

            }
        });


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("");
                tvExpression.setText("");
                hasDecimal = false;
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mathEvaluation();

            }
        });

    }

    private void setDisplayValue(String resultText, boolean canClear) {
        String testanswer = String.valueOf(tvExpression.getText());

        if (!tvResult.toString().isEmpty()) {
            tvExpression.setText("");
            mathEvaluation();
        }

        if (canClear == false) {
            tvResult.setText("");
            tvExpression.setText(testanswer + resultText);

            mathEvaluation();
        } else {
            tvExpression.setText(tvResult.getText());
            tvExpression.setText(testanswer + resultText);
            tvResult.setText("");

            mathEvaluation();
        }


    }

    private void initControls() {
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
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonMulti = (Button) findViewById(R.id.buttonMulti);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonPercent = (Button) findViewById(R.id.buttonPercent);
        buttonDelete = (Button) findViewById(R.id.buttonDel);
        tvResult = (EditText) findViewById(R.id.tvDisplay);
        tvExpression = (EditText) findViewById(R.id.TVExpression);
    }

    private void mathEvaluation() {

        String input = tvExpression.getText().toString();

        if (input.contains("x")) {

            input = input.replaceAll("x", "*");
        }

        if (input.contains("\u00F7")) {

            input = input.replaceAll("\u00F7", "/");
        }
        try {
            com.udojava.evalex.Expression expression =
                    new com.udojava.evalex.Expression(input);

            BigDecimal result = expression.eval();
            tvResult.setText(String.valueOf(result));
        } catch (Exception e) {
            Log.d("Exception", " message is: " + e.getMessage());
        }
    }


}
