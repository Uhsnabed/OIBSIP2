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

import java.text.DecimalFormat;

public class LengthActivity extends AppCompatActivity {
   EditText ans;
    TextView txt1,txt2;
  Button home,cm,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_length);

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

        cm = findViewById(R.id.button6);
        m = findViewById(R.id.button7);

        cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res1 = ans.getText().toString();
                double r1 = Double.parseDouble(res1);
                double d = toCm(r1);
                txt1.setText("Entered Value: "+r1+" m");
                txt2.setText("The result is: "+String.format("%.3f",d)+" cm");
            }
        });
             m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res1 = ans.getText().toString();
                double r1 = Double.parseDouble(res1);
                double d = toM(r1);

                txt1.setText("Entered Value: "+r1+" cm");
               txt2.setText("The result is: "+String.format("%.3f",d)+" m");
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

    public double toCm(double val)
    {
        val = val * 100;
        return val;
    }
    public double toM(double val)
    {
        val = val/100;
        return val;
    }

}