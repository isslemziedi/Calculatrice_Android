package com.example.calculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button calculateButton;
    private TextView resultTextView;
    private RadioButton addRadioButton;
    private RadioButton subtractRadioButton;
    private RadioButton multiplyRadioButton;
    private RadioButton divideRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calculatrice), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editText1 = findViewById(R.id.editTextText);
        editText2 = findViewById(R.id.editTextText2);
        calculateButton = findViewById(R.id.btn);
        resultTextView = findViewById(R.id.editTextText3);
        addRadioButton = findViewById(R.id.r1);
        subtractRadioButton = findViewById(R.id.r2);
        multiplyRadioButton = findViewById(R.id.r3);
        divideRadioButton = findViewById(R.id.r4);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = editText1.getText().toString().trim();
                String value2 = editText2.getText().toString().trim();


                if (isEmpty(value1) || isEmpty(value2)) {
                    Toast.makeText(MainActivity.this, "Champs vide", Toast.LENGTH_SHORT).show();
                } else {
                    double num1 = Double.parseDouble(value1);
                    double num2 = Double.parseDouble(value2);
                    double result = 0;


                    if (addRadioButton.isChecked()) {
                        result = num1 + num2;
                    } else if (subtractRadioButton.isChecked()) {
                        result = num1 - num2;
                    } else if (multiplyRadioButton.isChecked()) {
                        result = num1 * num2;
                    } else if (divideRadioButton.isChecked()) {
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            Toast.makeText(MainActivity.this, "Division par zéro", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    resultTextView.setText(String.valueOf(result));
                }
            }
        });
    }


    private boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
