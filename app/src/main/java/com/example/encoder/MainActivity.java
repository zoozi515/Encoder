package com.example.encoder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput = editText.getText().toString();

                StringBuffer result= new StringBuffer();
                for(int i = 0; i < userInput.length(); i++){

                    if (Character.isUpperCase(userInput.charAt(i)))
                    {
                        char ch = (char)(((int)userInput.charAt(i) +
                                13 - 65) % 26 + 65);
                        result.append(ch);
                    }
                    else
                    {
                        char ch = (char)(((int)userInput.charAt(i) +
                                13 - 97) % 26 + 97);
                        result.append(ch);
                    }
                }
                System.out.println(result.toString());
                textView.setText(result.toString());
            }
        });
    }
}