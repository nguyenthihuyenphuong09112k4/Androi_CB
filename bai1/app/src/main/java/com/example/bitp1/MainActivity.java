package com.example.bitp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView kq;
    EditText so1,so2;
    Button btnCong,btnTru,btnNhan,btnChia,btnChiaLayDu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        so1 =findViewById(R.id.so1);
        so2= findViewById(R.id.so2);
        kq = findViewById(R.id.kq);

        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnChiaLayDu = findViewById(R.id.btnChialaydu);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("/");
            }
        });

        btnChiaLayDu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("%");
            }
        });
    }
    private void performOperation(String operator) {
        String num1Str = so1.getText().toString();
        String num2Str = so2.getText().toString();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            try {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result = 0;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            kq.setText("Không thể chia cho 0");
                            return;
                        }
                        break;
                    case "%":
                        if (num2 != 0) {
                            result = num1 % num2;
                        } else {
                            kq.setText("Không thể chia cho 0");
                            return;
                        }
                        break;
                }

                kq.setText(String.valueOf(result));
            } catch (NumberFormatException e) {
                kq.setText("Dữ liệu không hợp lệ");
            }
        } else {
            kq.setText("Vui lòng nhập đủ hai số");
        }
    }
}