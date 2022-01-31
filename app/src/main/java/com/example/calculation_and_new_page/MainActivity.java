package com.example.calculation_and_new_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private TextView textViewTv;
    private double firstVar;
    private double secondVar;
    private boolean isOperationClick;
    private String operation;
    private Button out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTv = findViewById(R.id.tv_result);
        out = findViewById(R.id.btn_next);

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, secondActivity.class);

                String text = textViewTv.getText().toString();
                intent.putExtra("key1", text);
                startActivity(intent);
            }
        });
    }


    public void onNuberClick(View view) {
        out.setVisibility(View.INVISIBLE);
        switch (view.getId()) {
            case R.id.btn_one:
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                setNumbers("1");
                break;
            case R.id.two_number:
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                setNumbers("2");
                break;
            case R.id.three_btn:
                setNumbers("3");
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                break;
            case R.id.four_btn:
                setNumbers("4");
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                break;
            case R.id.five_btn:
                setNumbers("5");
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                break;
            case R.id.six_btn:
                setNumbers("6");
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                break;
            case R.id.seven_btn:
                setNumbers("7");
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                break;
            case R.id.eight_btn:
                setNumbers("8");
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                break;
            case R.id.iam_btn:
                setNumbers("9");
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                break;
            case R.id.null_btn:
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }

                if (textViewTv.getText().toString().equals("0")) {
                    textViewTv.setText("0");
                } else {
                    textViewTv.append("0");

                }

                break;
            case R.id.clear_text:
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                textViewTv.setText("0");
                firstVar = 0;
                secondVar = 0;
                break;
            case R.id.dot_btn:
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                if (textViewTv.toString().endsWith(".")) {
                    break;
                } else {
                    textViewTv.append(".");
                }
                break;

        }

    }

    private void setNumbers(String numbers) {
        if (textViewTv.getText().toString().equals("0")) {
            textViewTv.setText(numbers);
        } else if (isOperationClick) {
            textViewTv.setText(numbers);
        } else {
            textViewTv.append(numbers);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        out.setVisibility(View.INVISIBLE);
        switch (view.getId()) {
            case R.id.plus_btn:
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                firstVar = Double.parseDouble(textViewTv.getText().toString());
                operation = "+";
                isOperationClick = true;
                break;


            case R.id.delenie_btn:
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                firstVar = Double.parseDouble(textViewTv.getText().toString());
                operation = "/";
                isOperationClick = true;
                break;
            case R.id.umnojenie_btn:
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);
                }
                firstVar = Double.parseDouble(textViewTv.getText().toString());
                operation = "x";
                isOperationClick = true;
                break;
            case R.id.equals_btn:
                out.setVisibility(View.VISIBLE);
                if (secondVar == 0 && firstVar == 0) {
                    out.setVisibility(View.VISIBLE);
                } else {
                    if (out.getAlpha() == 1) {
                        out.animate().alpha(0);
                    }

                    if (out.getAlpha() == 0) {
                        out.animate().alpha(1);
                    }
                    secondVar = Double.parseDouble(textViewTv.getText().toString());
                    Double result1 = Double.valueOf(0);
                    switch (operation) {
                        case "-":
                            result1 = firstVar - secondVar;
                            break;
                        case "+":
                            result1 = firstVar + secondVar;
                            break;
                        case "/":
                            result1 = firstVar / secondVar;
                            break;
                        case "x":
                            result1 = firstVar * secondVar;
                            break;
                        case ".":
                            String str = textViewTv.getText().toString().trim();
                            if (textViewTv.toString().endsWith(".")) {
                                break;
                            } else {
                                textViewTv.append(".");
                            }
                    }

                    textViewTv.setText(new DecimalFormat("##.#####").format(result1));
                    isOperationClick = true;
                    break;
                }
            case R.id.minus_btn:
                if (out.getAlpha() == 1) {
                    out.animate().alpha(0);

                }
                firstVar = Double.parseDouble(textViewTv.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;

        }


    }
}

