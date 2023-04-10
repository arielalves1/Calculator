package com.github.arielalves1.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numberZero, numberOne, numberTwo, numberThree, numberFour, numberFive,
            numberSix, numberSeven, numberEight, numberNine, sum, subtraction, multiply,
            division, equal, button_Clear, point;

    private TextView txtExpression, txtResult;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitiateComponents();
        getSupportActionBar().hide();

        numberZero.setOnClickListener(this);
        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        point.setOnClickListener(this);
        sum.setOnClickListener(this);
        multiply.setOnClickListener(this);
        division.setOnClickListener(this);
        subtraction.setOnClickListener(this);

        button_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpression.setText("");
                txtResult.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expression = findViewById(R.id.txt_view_expressao);
                String string = expression.getText().toString();

                if(!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpression = string.substring(var0, var1);
                    expression.setText(txtExpression);
                }
                txtResult.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expression = new ExpressionBuilder(txtExpression.getText().toString()).build();
                    double result = expression.evaluate();
                    long longResult = (long) result;

                    if (result == (double) longResult) {
                        txtResult.setText((CharSequence) String.valueOf(longResult));

                    } else {
                        txtResult.setText((CharSequence) String.valueOf(result));
                    }
                } catch (Exception e) {

                }
            }
           });
        }

    private void InitiateComponents(){
        //iniciar componentes

        numberZero = findViewById(R.id.Number_0);
        numberOne = findViewById(R.id.Number_1);
        numberTwo = findViewById(R.id.Number_2);
        numberThree = findViewById(R.id.Number_3);
        numberFour = findViewById(R.id.Number_4);
        numberFive = findViewById(R.id.Number_5);
        numberSix = findViewById(R.id.Number_6);
        numberSeven = findViewById(R.id.Number_7);
        numberEight = findViewById(R.id.Number_8);
        numberNine = findViewById(R.id.Number_9);
        point = findViewById(R.id.Number_Point);
        sum = findViewById(R.id.Button_Sum);
        subtraction = findViewById(R.id.Button_Subtract);
        multiply = findViewById(R.id.Button_Multiply);
        button_Clear = findViewById(R.id.Button_Clear);
        equal = findViewById(R.id.Button_Result);
        division = findViewById(R.id.Button_Division);
        txtExpression = findViewById(R.id.txt_view_expressao);
        txtResult = findViewById(R.id.txt_view_result);
        backspace = findViewById(R.id.Number_backspace);

    }

    public void addExpression(String string, boolean clean_data){
        //acrescentar uma expressao
        if(txtResult.getText().equals("")){
            txtExpression.setText(" ");
        }
        if(clean_data){
            txtResult.setText(" ");
            txtExpression.append(string);
         }else{
            txtExpression.append(txtResult.getText());
            txtExpression.append(string);
            txtResult.setText(" ");

         }

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.Number_0:
                addExpression("0", true);
                break;

            case R.id.Number_1:
                addExpression("1", true);
                break;
            case R.id.Number_2:
                addExpression("2", true);
                break;

            case R.id.Number_3:
                addExpression("3", true);
                break;

            case R.id.Number_4:
                addExpression("4", true);
                break;

            case R.id.Number_5:
                addExpression("5", true);
                break;

            case R.id.Number_6:
                addExpression("6", true);
                break;

            case R.id.Number_7:
                addExpression("7", true);
                break;

            case R.id.Number_8:
                addExpression("8", true);
                break;

            case R.id.Number_9:
                addExpression("9", true);
                break;

            case R.id.Number_Point:
                addExpression(".", true);
                break;
            //operadores
            case R.id.Button_Sum:
                addExpression("+", false);
                break;
            case R.id.Button_Subtract:
                addExpression("-", false);
                break;
            case R.id.Button_Division:
                addExpression("/", false);
                break;
            case R.id.Button_Multiply:
                addExpression("*", false);
                break;

            }










        }
    }
