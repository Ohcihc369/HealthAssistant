package com.example.healthassistant.ui.bmicalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.widget.Button;
import android.widget.EditText;

import com.example.healthassistant.R;

public class BMICalculatorFragment extends Fragment {

    private EditText editTextWeight;
    private EditText editTextHeight;
    private Button buttonCalculateBMI;
    private TextView textViewResult;
    private Button buttonClear;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_bmicalculator, container, false);

        editTextWeight = root.findViewById(R.id.editTextWeight);
        editTextHeight = root.findViewById(R.id.editTextHeight);
        buttonCalculateBMI = root.findViewById(R.id.buttonCalculateBMI);
        textViewResult = root.findViewById(R.id.textViewResult);
        buttonClear = root.findViewById(R.id.buttonClear);

        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearBMIResult();
            }
        });

        return root;
    }

    private void calculateBMI() {
        // Get weight and height values from EditText
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            textViewResult.setText("Please enter weight and height.");
            return;
        }

        // Convert weight and height to double
        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);

        // Perform BMI calculation
        double bmi = weight / (height * height);

        // Determine BMI category
        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 24.9) {
            category = "Normal Weight";
        } else if (bmi < 29.9) {
            category = "Overweight";
        } else {
            category = "Obese, please visit a health centre for consultation or send an sos message";
        }

        // Display the result
        String resultText = "BMI: " + bmi + "\nComment: " + category;
        textViewResult.setText(resultText);
    }

    private void clearBMIResult() {
        // Clear the result
        textViewResult.setText("");
        // Clear weight and height EditText
        editTextWeight.setText("");
        editTextHeight.setText("");
    }
}
