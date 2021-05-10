package sg.edu.rp.c346.id20025312.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    EditText cusName;
    EditText cusNum;
    EditText size;
    DatePicker dp;
    TimePicker tp;
    Button btnReset;
    Button btnCheck;
    RadioButton sarea;
    RadioButton nsarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cusName = findViewById(R.id.customerName);
        cusNum = findViewById(R.id.customerNum);
        size = findViewById(R.id.sizeOfGrp);
        btnCheck = findViewById(R.id.buttonCheck);
        btnReset = findViewById(R.id.buttonReset);
        sarea = findViewById(R.id.sArea);
        nsarea = findViewById(R.id.nsArea);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timeIs = "Time is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                String dateIs = "Date is " + dp.getDayOfMonth() + "/" + dp.getMonth()+1 + "/" + dp.getYear();

                if (sarea.isChecked()) {
                    String area = sarea.toString();
                    String display = String.format("Name: %s\nMobile Number: %d\nSize of Group: %d\n%s\n%s\nSeating Area:%s",cusName,cusNum,size,dateIs,timeIs,area);
                    Toast.makeText(MainActivity.this, display, Toast.LENGTH_SHORT).show();

                } else {
                    String area = nsarea.toString();
                    String display = String.format("Name: %s\nMobile Number: %d\nSize of Group: %d\n%s\n%s\nSeating Area:%s",cusName,cusNum,size,dateIs,timeIs,area);
                    Toast.makeText(MainActivity.this, display, Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 6,01);
            }
        });

    }
}