package com.example.mysecondapp;

import static com.example.mysecondapp.R.color.orange;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.login_button);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        TextView welcome = findViewById(R.id.welcome_text);
        TextView enter = findViewById(R.id.enter_text);
        TextView hint = findViewById(R.id.hint_text);
        Button forgotPasswordButton = findViewById(R.id.forgot_password);

        TextView[] invisibleElements = {myButton, email, password, enter, hint, forgotPasswordButton};
        buttonColorChange(email, myButton);
        buttonColorChange(password, myButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Вы успешно зарегистрировались", Toast.LENGTH_LONG);
                    toast.show();
                    for (int i = 0; i < invisibleElements.length; i++) {
                        invisibleElements[i].setVisibility(View.GONE);
                    }
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Неправильный логин и пароль", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


    }

    public void buttonColorChange(EditText editText, Button button) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    button.setBackgroundColor(Color.parseColor("#828282"));
                } else {
                    button.setBackgroundColor(Color.parseColor("#B76D00"));
                }
            }
        });

    }
}