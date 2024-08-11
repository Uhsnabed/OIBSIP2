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

public class WeightActivity extends AppCompatActivity {

    EditText ans;
    TextView txt1,txt2;
    Button home,kg,g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weight);

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
        kg = findViewById(R.id.button6);
        g = findViewById(R.id.button7);

        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res1 = ans.getText().toString();
                double r1 = Double.parseDouble(res1);
                double d = toKg(r1);
                txt1.setText("Entered Value: "+r1+" g");
                txt2.setText("The result is: "+String.format("%.3f",d)+" kg");
            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res1 = ans.getText().toString();
                double r1 = Double.parseDouble(res1);
                double d = toG(r1);

                txt1.setText("Entered Value: "+r1+" kg");
                txt2.setText("The result is: "+String.format("%.3f",d)+" g");
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

    public double toKg(double val)
    {
        val = val/1000;
        return val;
    }
    public double toG(double val)
    {
        val = val * 1000;
        return val;
    }
}