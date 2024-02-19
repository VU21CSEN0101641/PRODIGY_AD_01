package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare constants for button IDs
    private static final int BUTTON_ADD_ID = R.id.btn_add;
    private static final int BUTTON_SUB_ID = R.id.btn_sub;
    private static final int BUTTON_MUL_ID = R.id.btn_mul;
    private static final int BUTTON_DIV_ID = R.id.btn_div;

    Button buttonadd, buttonsub, buttonmul, buttondiv;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonadd = findViewById(R.id.btn_add);
        buttonsub = findViewById(R.id.btn_sub);
        buttonmul = findViewById(R.id.btn_mul);
        buttondiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonadd.setOnClickListener(this);
        buttonsub.setOnClickListener(this);
        buttonmul.setOnClickListener(this);
        buttondiv.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    @Override
    public void onClick(View v) {
        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);

        if (v.getId() == BUTTON_ADD_ID) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (v.getId() == BUTTON_SUB_ID) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (v.getId() == BUTTON_MUL_ID) {
            textView.setText("Answer = " + (num1 * num2));
        } else if (v.getId() == BUTTON_DIV_ID) {
            if (num2 == 0) {
                textView.setText("Cannot divide by zero");
            } else {
                textView.setText("Answer = " + ((float) num1 / num2));
            }
        }
    }
