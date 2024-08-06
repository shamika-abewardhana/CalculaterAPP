package com.mit.calculater;

import android.media.VolumeShaper;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    EditText varnumber1,varnumber2;
    Button buttonAdd, buttonSubtract,buttonMultiply, buttonDivide;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


            varnumber1 = findViewById(R.id.number1);
            varnumber2 = findViewById(R.id.number2);
            buttonAdd = findViewById(R.id.buttonAdd);
            buttonDivide = findViewById(R.id.buttonDivide);
            buttonMultiply = findViewById(R.id.buttonMultiply);
            buttonSubtract = findViewById(R.id.buttonSubtract);
            result = findViewById(R.id.result);

            //Adding
            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    perfromOperation(Operation.ADD);
                }
            });

            buttonDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    perfromOperation(Operation.DIVIDE);
                }
            });

            buttonMultiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    perfromOperation(Operation.MYLTIPLY);
                }
            });

            buttonSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    perfromOperation(Operation.SUBTRACT);
                }
            });




    }

    private void perfromOperation(Operation operation){
        String var_op_num1 = varnumber1.getText().toString();
        String var_op_num2 = varnumber2.getText().toString();


        if (TextUtils.isEmpty(var_op_num1) || TextUtils.isEmpty(var_op_num2)) {
            result.setText("please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(var_op_num1);
        double num2 = Double.parseDouble(var_op_num2);
        double reslt = 0;

        switch (operation){
            case ADD:
            reslt = num1 + num2;
            break;

            case SUBTRACT:
                reslt = num1 - num2;
                break;
            case MYLTIPLY:
                reslt = num1 * num2;
                break;
            case DIVIDE:
                if(num2 !=0){
                    reslt = num1/num2;
                }else {
                    result.setText("Cannot Dived by 0");
                }
                break;
        }

        result.setText(String.valueOf(reslt));


    }

    private  enum Operation{
        ADD, SUBTRACT, MYLTIPLY, DIVIDE
    }
}