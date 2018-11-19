package com.construction.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.calculator.MainActivity;
import com.example.calculator.R;

import net.objecthunter.exp4j.ExpressionBuilder;

public class Expression extends AppCompatActivity {


    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonDot, buttonClear,
            buttonPlus, buttonMinus, buttonDivide, buttonMulti, buttonEqual, buttonPercent, buttonDelete, buttonCal;

    EditText tvResult, tvEpression;
    String operator = null;
    boolean hasDecimal;

    double valueOne = 0.0, valueTwo = 0.0, result = 0.0, data = 0.0;

/*
    public void startCalculator() {

        buttonCal = findViewById(R.id.buttonCalculator);
        buttonCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calMain = new Intent(Expression.this, MainActivity.class);
                startActivity(calMain);
            }
        });

    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expression);


        //   startCalculator();
        initControls();
        // startScience();

        // disable keyboard on edittext boxes
        tvEpression.requestFocus();
        tvEpression.setShowSoftInputOnFocus(false);
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

                String value = String.valueOf(tvEpression.getText());
                char c = value.charAt(0);
                if (c == '.') {
                    setDisplayValue("0.", true);
                } else {
                    setDisplayValue(".", true);
                }

            }
        });


        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue(" + ", false);
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue(" - ", false);
             /*   valueOne = Double.parseDouble(String.valueOf(tvResult.getText()));
                operator = "minus";
                tvResult.setText(null);
                hasDecimal = false;*/
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue(" * ", false);
              /*  valueOne = Double.parseDouble(String.valueOf(tvResult.getText()));
                operator = "multi";
                tvResult.setText(null);
                hasDecimal = false;*/
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue(" / ", false);
             /*   valueOne = Double.parseDouble(String.valueOf(tvResult.getText()));
                operator = "divide";
                tvResult.setText(null);
                hasDecimal = false;*/
            }
        });


        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.parseDouble(tvResult.getText() + "");
                result = valueOne / 100;
                tvResult.setText(String.valueOf(result));
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = tvResult.getText().toString();
                if (result.length() > 0) {
                    tvResult.setText(result.substring(0, result.length() - 1));
                    if (result.isEmpty()) {

                        result = "0";
                        tvResult.setText("0");
                    }

                }

            }
        });


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText("");
                tvEpression.setText("");
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    net.objecthunter.exp4j.Expression exppresionValue = new ExpressionBuilder(tvEpression.getText().toString()).build();
                    Double answer = exppresionValue.evaluate();

                    //   Long fullResult = answer
                    tvResult.setText(String.valueOf(answer));
                } catch (Exception e) {
                    Log.d("Excerption", " message is: " + e.getMessage());
                }
            }
        });

    }

    private void setDisplayValue(String resultText, boolean canClear) {
        String testanswer = String.valueOf(tvEpression.getText());
        if (!tvResult.toString().isEmpty()) {
            tvEpression.setText("");
        }

        if (canClear == false) {
            tvResult.setText("");
            tvEpression.setText(testanswer + resultText);


        } else {
            tvEpression.append(tvResult.getText());
            tvEpression.append(testanswer + resultText);
            tvResult.setText("");
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
        tvEpression = (EditText) findViewById(R.id.TVExpression);
    }

    private double getParseDouble(String s) {
        if (s == null || s.isEmpty())
            return 0.0;
        else
            return Double.parseDouble(s);
    }
}
