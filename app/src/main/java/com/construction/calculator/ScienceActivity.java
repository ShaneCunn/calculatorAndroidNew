package com.construction.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculator.MainActivity;
import com.example.calculator.R;

import java.math.BigDecimal;

public class ScienceActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonDot, buttonClear,
            buttonPlus, buttonMinus, buttonDivide, buttonMulti, buttonEqual, buttonPercent, buttonDelete, buttonCal,
            buttonSqRoot;

    EditText tvResult, tvExpression;

    boolean hasDecimal;
    String input;

    public void startCalculator() {

        buttonCal = findViewById(R.id.buttonCalculator);
        buttonCal.setOnClickListener(new View.OnClickListener() {
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
        initControls();


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


                    setDisplayValue("% ", false);
                    hasDecimal = false;


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

                input = tvExpression.getText().toString();

                if (input.contains("x")) {

                    input = input.replaceAll("x", "*");
                }


                if (input.contains("\u00F7")) {

                    input = input.replaceAll("\u00F7", "/");
                }

                if (input.contains("\u221a")) {

                    input = input.replaceAll("\u221a", "SQRT");
                }
                try {
                    com.udojava.evalex.Expression expression =
                            new com.udojava.evalex.Expression(input);

                    BigDecimal result = expression.eval();
                    tvExpression.setText(String.valueOf(result));
                    tvResult.setText(String.valueOf(""));
                } catch (Exception e) {
                    Log.d("Exception", " message is: " + e.getMessage());
                }

            }
        });

        buttonSqRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("\u221a", false);


                //  Log.d("input", " message is: sqrt" );

            /*    try {
                    com.udojava.evalex.Expression expression =
                            new com.udojava.evalex.Expression("SQRT(12)");

                    BigDecimal result = expression.eval();
                    tvExpression.setText(String.valueOf("SQRT(12)"));
                    tvResult.setText(String.valueOf(result));
                } catch (Exception e) {
                    Log.d("Exception", " message is: " + e.getMessage());
                }*/

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
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonDot = findViewById(R.id.buttonDot);
        buttonClear = findViewById(R.id.buttonAC);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMulti = findViewById(R.id.buttonMulti);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonDelete = findViewById(R.id.buttonDel);

        buttonSqRoot = findViewById(R.id.buttonSqX);

        tvResult = findViewById(R.id.tvDisplay);
        tvExpression = findViewById(R.id.TVExpression);
    }

    private void mathEvaluation() {

        input = tvExpression.getText().toString();

        if (input.contains("x")) {

            input = input.replaceAll("x", "*");
        }

        if (input.contains("\u00F7")) {

            input = input.replaceAll("\u00F7", "/");
        }

        if (input.contains("\u221a")) {

            input = input.replaceAll("\u221a", "SQRT( " + input + " )");
            Log.d("input", " message is: sqrt2");
        }

        //    input = "SQRT(12)";
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

