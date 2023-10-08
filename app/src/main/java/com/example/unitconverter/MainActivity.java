package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.text.DecimalFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_main);
        Spinner fromcont = findViewById(R.id.fromcont);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        Spinner tocont = findViewById(R.id.tocont);
        EditText fromval = findViewById(R.id.fromval);
        TextView toval = findViewById(R.id.toval);
        Button convertbtn = findViewById(R.id.convertbtn);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        fromcont.setAdapter(adapter);
        tocont.setAdapter(adapter);
        convertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = fromval.getText().toString();
                String from = fromcont.getSelectedItem().toString();
                String to = tocont.getSelectedItem().toString();
                double a=Double.parseDouble(s);
                double ans=0.0;

                if (s.equals("")){
                    Toast.makeText(MainActivity.this, "The value cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else if (from.equals(to)) {
                    Toast.makeText(MainActivity.this, "Cannot convert between units of samy type!", Toast.LENGTH_SHORT).show();
                }
//                From Gram
                else if (from.equals("Gram(g)")){
                    if (to.equals("Kilogram(Kg)")){
                        ans=a/1000;
                    }
                    else if (to.equals("Milligram(mg)")){
                        ans=a*1000;
                    }
                    else if (to.equals("Ounce(oz)")){
                        ans=a/28.35;
                    }
                    else {
                        ans=a/453.6;
                    }
                }
//                From Kilogram
                else if (from.equals("Kilogram(Kg)")){
                    if (to.equals("Gram(g)")){
                        ans=a*1000;
                    }
                    else if (to.equals("Milligram(mg)")){
                        ans=a*1000000;
                    }
                    else if (to.equals("Ounce(oz)")){
                        ans=a*35.274;
                    }
                    else {
                        ans=a*2.205;
                    }
                }
//                From Milligram
                else if (from.equals("Milligram(mg)")){
                    if (to.equals("Kilogram(Kg)")){
                        ans=a/1000000;
                    }
                    else if (to.equals("Gram(g)")){
                        ans=a/1000;
                    }
                    else if (to.equals("Ounce(oz)")){
                        ans=a/28350;
                    }
                    else {
                        ans=a/453600;
                    }
                }
//                From Ounce
                else if (from.equals("Ounce(oz)")){
                    if (to.equals("Kilogram(Kg)")){
                        ans=a/35.274;
                    }
                    else if (to.equals("Milligram(mg)")){
                        ans=a*28350;
                    }
                    else if (to.equals("Pound(lb)")){
                        ans=a/16;
                    }
                    else {
                        ans=a*28.35;
                    }
                }
//                From Pound
                else if (from.equals("Pound(lb)")){
                    if (to.equals("Kilogram(Kg)")){
                        ans=a/2.205;
                    }
                    else if (to.equals("Milligram(mg)")){
                        ans=a*453600;
                    }
                    else if (to.equals("Ounce(oz)")){
                        ans=a*16;
                    }
                    else {
                        ans=a*453.6;
                    }
                }
                DecimalFormat df = new DecimalFormat("#.###");
                ans = Double.parseDouble(df.format(ans));
                toval.setText(""+ans);
          }
        });
    }
}