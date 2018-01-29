package com.example.dowhaa.clcalutoerswish;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.icu.util.TimeUnit;
import android.os.Build;
import android.os.CountDownTimer;
import android.preference.DialogPreference;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
       EditText ednun1,ednum2,etime,edate;
       Button btn;
    private  static CountDownTimer countDownTimer;
    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etime=(EditText)findViewById(R.id.txttime);
        edate=(EditText)findViewById(R.id.txtdate);
        final Calendar c=Calendar.getInstance();
        final  int Years=c.get(Calendar.YEAR);
        final  int Months=c.get(Calendar.MONTH)+1;
        final int Day=c.get(Calendar.DAY_OF_MONTH);
        edate.setText(Years+"/"+Months+"/"+Day);
        edate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void OnDateset(DatePicker view, int Year, int MonthefYear, int dayofMonth){



                        edate.setText(Year + "/" + MonthefYear+1 + "/" + dayofMonth);
                    }
                }, Years, Months, Day);


                datePicker.setTitle("Choose Date");
                datePicker.show();
            }
        });

        new CountDownTimer(TimeUnit.SECONDS.toMillis(10000000), 1000){
          @Override
          public void onTick(long  millsUnitlFinished ) {
              final Calendar c=Calendar.getInstance();
              final int houers = c.get(Calendar.HOUR);
              final int Minmtels = c.get(Calendar.MINUTE);
              final int second = c.get(Calendar.SECOND);
              etime.setText(houers + ":" + Minmtels + ":" + second);

          }

            @Override
            public void  onFinish(){


            }
        }.start();

        ednun1=(EditText)findViewById(R.id.txtnum1);
        ednum2=(EditText)findViewById( R.id.txtnum2);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater LayoutInflater = android.view.LayoutInflater.from(MainActivity.this);
                View promotview = LayoutInflater.inflate(R.layout.input_dillog, null);
                AlertDialog.Builder alertDialgBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialgBuilder.setView(promotview);
                final EditText mohamed = (EditText) promotview.findViewById(R.id.txthuores);
                alertDialgBuilder.setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int id) {
                                double num1, num2, result=0;
                                String sign;
                                num1 = Double.parseDouble(ednun1.getText().toString());
                                num2 = Double.parseDouble(ednum2.getText().toString());
                                sign = mohamed.getText().toString();
                                 switch (sign)
                                 {
                                     case "+":
                                     result=num1+num2;
                                     break;
                                     case "-":
                                         result=num1-num2;
                                         break;
                                     case "*":
                                         result=num1*num2;
                                         break;
                                     case "/":
                                         result=num1/num2;
                                         break;
                                     default:
                                         Toast.makeText(getApplication(),"Invaild sing",Toast.LENGTH_LONG).show();
                                 }
                                Toast.makeText(getApplication(),"result is:"+result,Toast.LENGTH_LONG).show();

                            }

                        })


                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int id) {


                                        dialog.cancel();
                                    }

                                });
                AlertDialog alert = alertDialgBuilder.create();
                alert.show();
            }

        });
        }
        }








