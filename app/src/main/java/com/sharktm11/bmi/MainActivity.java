package com.sharktm11.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText heightFit,weights,heightInch;
        TextView results,bmiResult;
        Button calculator,resets;
        LinearLayout llmain;

        bmiResult=findViewById(R.id.totalBmi);
        heightFit=findViewById(R.id.fit);
        heightInch=findViewById(R.id.inch);
        weights=findViewById(R.id.weight);
        results=findViewById(R.id.result);
        calculator=findViewById(R.id.btn);
        resets=findViewById(R.id.reset);
        llmain=findViewById(R.id.linear);

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ft=Integer.parseInt( heightFit.getText().toString());
                int inch=Integer.parseInt(heightInch.getText().toString());
                int wt=Integer.parseInt(weights.getText().toString());


                int totalInch=ft*12+inch;

                double totalCm=totalInch*2.54;

                double totalMr=totalCm/100;

             double bmi=wt/(totalMr*totalMr);
             bmiResult.setText("BMI : "+bmi);


             if(bmi >25){

                 results.setText(R.string.over);
                 llmain.setBackgroundColor(getResources().getColor(R.color.colorV));
             }

              else if (bmi <=18.5){

                 results.setText(R.string.under);
                 llmain.setBackgroundColor(getResources().getColor(R.color.colorUr));
             }  else{

                 results.setText(R.string.normal);
                 llmain.setBackgroundColor(getResources().getColor(R.color.colorG));
             }


            }


        });
        resets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heightFit.setText("");
                weights.setText("");
                heightInch.setText("");
                results.setText("");
                bmiResult.setText("");
                llmain.setBackgroundColor(getResources().getColor(R.color.cardview_light_background));
            }
        });

    }
}