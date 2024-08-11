package com.example.unitconverteroasis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TImeActivity extends AppCompatActivity {
    EditText ans;
    TextView txt1,txt2;
    Button home,min,sec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_time);

        ans = findViewById(R.id.editText);
        txt1 = findViewById(R.id.textView4);
        txt2 = findViewById(R.id.textView3);
        home = findViewById(R.id.button5);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotohome();
            }
        });
        min = findViewById(R.id.button6);
        sec = findViewById(R.id.button7);

        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res1 = ans.getText().toString();
                double r1 = Double.parseDouble(res1);
                double d = toMin(r1);
                txt1.setText("Entered Value: "+r1+" sec");
                txt2.setText("The result is: "+String.format("%.3f",d)+" min");
            }
        });

        sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res1 = ans.getText().toString();
                double r1 = Double.parseDouble(res1);
                double d = toSec(r1);

                txt1.setText("Entered Value: "+r1+" min");
                txt2.setText("The result is: "+String.format("%.3f",d)+" sec");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void gotohome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public double toMin(double val)
    {
        val = val/60;
        return val;
    }
    public double toSec(double val)
    {
        val = val * 60;
        return val;
    }
}