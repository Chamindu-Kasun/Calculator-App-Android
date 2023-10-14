package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editTextN1,editTextN2;

    TextView textViewAnswer;

    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.add_button);
        buttonSub = findViewById(R.id.sub_button);
        buttonMul = findViewById(R.id.mul_button);
        buttonDiv = findViewById(R.id.div_button);

        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);

        textViewAnswer = findViewById(R.id.answer);


        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
    }


    public int getIntFromEditText(EditText editText){
        if(editText.getText().toString().equals("")){
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        }else{
            return Integer.parseInt(editText.getText().toString());
        }
    };

    @Override
    public void onClick(View view) {
       num1 = getIntFromEditText(editTextN1);
       num2 = getIntFromEditText(editTextN2);


        if (view.getId() == R.id.add_button) {
            textViewAnswer.setText("Answer : " + (num1 + num2));
        } else if (view.getId() == R.id.sub_button) {
            textViewAnswer.setText("Answer : " + (num1 - num2));
        } else if (view.getId() == R.id.mul_button) {
            textViewAnswer.setText("Answer : " + (num1 * num2));
        } else if (view.getId() == R.id.div_button) {
            textViewAnswer.setText("Answer : " + ((float) num1 / (float) num2));
        }
    }
}