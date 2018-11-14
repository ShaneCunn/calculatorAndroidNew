package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.construction.calculator.ScienceActivity;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonDot, buttonClear, buttonPlus, buttonMinus, buttonDivide, buttonMulti, buttonEqual, buttonPercent, buttonDelete, buttonScience;
    EditText editTextDisplay, editTextExpression;

    boolean hasDecimal;

    double valueOne = 0.0, valueTwo = 0.0, result = 0.0, data = 0.0;
    String operator = null, expression;

    public void startScience() {

        buttonScience = (Button) findViewById(R.id.buttonScience);
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

        //Numbers
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayValue("0");
            }
        });


        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = Double.parseDouble(editTextDisplay.getText().toString());
                if (hasDecimal == false) {
                    // editTextDisplay.setText("0");
                    editTextDisplay.setText(editTextDisplay.getText() + ".");
                    hasDecimal = true;
                }


            }
        });


        //Operators
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.parseDouble(String.valueOf(editTextDisplay.getText()));
                operator = "add";
                editTextDisplay.setText(null);

                expression = String.valueOf(editTextExpression.getText());
            /*    if (expression == "0") {
                    expression = "";
                }*/
                if (TextUtils.isEmpty(expression)) {
                    editTextExpression.append(valueOne + " +");

                } else {

                    editTextExpression.append(" " + valueOne + " +");

                }
                hasDecimal = false;
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.parseDouble(String.valueOf(editTextDisplay.getText()));
                operator = "minus";
                editTextDisplay.setText(null);
                editTextExpression.setText(valueOne + " -");
                hasDecimal = false;
            }
        });
        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.parseDouble(String.valueOf(editTextDisplay.getText()));
                operator = "multi";
                editTextDisplay.setText(null);
                editTextExpression.setText(valueOne + " x");
                hasDecimal = false;
            }
        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.parseDouble(String.valueOf(editTextDisplay.getText()));
                operator = "divide";
                editTextDisplay.setText(null);
                editTextExpression.setText(valueOne + " \u00F7");
                hasDecimal = false;
            }
        });

        // controls
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTwo = Double.parseDouble(String.valueOf(editTextDisplay.getText()));
                // add = true;
                switch (operator) {
                    case "add":
                        result = valueOne + valueTwo;
                        break;
                    case "minus":
                        result = valueOne - valueTwo;
                        break;
                    case "multi":
                        result = valueOne * valueTwo;
                        break;
                    case "divide":
                        result = valueOne / valueTwo;
                        break;
                }
                editTextDisplay.setText(String.valueOf(result));
                hasDecimal = false;
                operator = "";


            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextDisplay.setText("0");
                editTextExpression.setText("");
                hasDecimal = false;
            }
        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.parseDouble(editTextDisplay.getText() + "");
                result = valueOne / 100;
                editTextDisplay.setText(String.valueOf(result));
            }
        });


        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = editTextDisplay.getText().toString();
                if (result.length() > 0) {
                    editTextDisplay.setText(result.substring(0, result.length() - 1));
                    if (result.isEmpty()) {
                        result = "0";
                        editTextDisplay.setText("0");
                    }

                }

            }
        });
    }

    private void setDisplayValue(String s) {
        //  data = Double.parseDouble(editTextDisplay.getText().toString());
        data = getParseDouble(editTextDisplay.getText().toString());
        if (data == 0) {
            editTextDisplay.setText(s);
        } else {
            editTextDisplay.setText(editTextDisplay.getText() + s);
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
        editTextDisplay = (EditText) findViewById(R.id.displayTV);
        editTextExpression = (EditText) findViewById(R.id.TVExpression);
    }

    private double getParseDouble(String s) {
        if (s == null || s.isEmpty())
            return 0.0;
        else
            return Double.parseDouble(s);
    }


    /*public static void appendOnExpresstion(string:String, canClear:Boolean) {
    }*/
}
