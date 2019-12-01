package com.example.androidv10;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {

TextView Y;
TextView Z;

    public String Convert(long T)
    {
        T /= 1000;
        long days = T / (24 * 60 * 60);
        String X = Long.toString(days);
        X += " days \n";
        long hours = T / (60 * 60) % 24;
        X += Long.toString(hours);
        X += " hours \n";
        long minutes = T / (60) % 60;
        X += Long.toString(minutes);
        X += " minutes \n";
        long seconds = T % 60;
        X += Long.toString(seconds);
        X += " seconds \n";
        return X;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Y = (TextView) findViewById (R.id.textView2);
        Z = (TextView) findViewById (R.id.textView);
        Calendar calendar_today = new GregorianCalendar ();
        int year = calendar_today.get(Calendar.YEAR);

        Calendar calendar_year = new GregorianCalendar(year, Calendar.DECEMBER, 31);
        calendar_year.set(Calendar.HOUR, 23);
        calendar_year.set(Calendar.MINUTE, 59);
        calendar_year.set(Calendar.SECOND, 59);
        long diff = (calendar_year.getTimeInMillis() - calendar_today.getTimeInMillis());
        String z = Long.toString (diff);
        Z.setText (z);

        new CountDownTimer (diff, 500) {

            //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
            public void onTick(long millisUntilFinished) {
                String Left_Time = Convert(millisUntilFinished);
                Y.setText ("To the New Year left:");
                Z.setText(Left_Time);
            }
            //Задаем действия после завершения отсчета (высвечиваем надпись "с новым годом!"):
            public void onFinish() {
                Z.setText("Happy New Year!!!");
                Y.setText ("");
            }
        }
                .start();


    }
}
