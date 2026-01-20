package com.example.godziny_otwarcia;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timePicker);
        btnCheck = findViewById(R.id.btnCheck);


        timePicker.setIs24HourView(true);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkOpeningHours();
            }
        });
    }

    private void checkOpeningHours() {

        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();


        LocalTime selectedTime = LocalTime.of(hour, minute);
        LocalTime openingTime = LocalTime.of(8, 0);
        LocalTime closingTime = LocalTime.of(16, 0);


        boolean isOpen = !selectedTime.isBefore(openingTime) && selectedTime.isBefore(closingTime);


        if (isOpen) {
            Toast.makeText(this, "Otwarte, zapraszamy!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Zamknięte", Toast.LENGTH_LONG).show();
        }
    }
}