package com.example.rejestracja;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private EditText mail;
    private EditText password;
    private EditText repeatPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            resultText = findViewById(R.id.resultView);
            mail = findViewById(R.id.mail);
            password = findViewById(R.id.password);
            repeatPassword = findViewById(R.id.repeatPassword);
            findViewById(R.id.buttonId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!mail.getText().toString().contains("@"))
                    {
                        resultText.setText("Niepoprawny mail");
                        return;
                    }

                    if(password.getText() != repeatPassword.getText())
                    {
                        resultText.setText("Hasła nie są takie same");
                        return;
                    }

                    resultText.setText("witaj" + mail.getText());
                }
            });
            return insets;
        });
    }

}