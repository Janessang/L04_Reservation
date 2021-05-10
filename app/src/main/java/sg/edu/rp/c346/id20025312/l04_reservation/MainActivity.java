package sg.edu.rp.c346.id20025312.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText cusName;
    EditText cusNum;
    EditText size;
    DatePicker dp;
    TimePicker tp;
    Button btnReset;
    Button btnReserve;
    CheckBox sArea;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cusName = findViewById(R.id.customerName);
        cusNum = findViewById(R.id.customerNum);
        size = findViewById(R.id.sizeOfGrp);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);
        sArea = findViewById(R.id.sArea);
        tvDisplay = findViewById(R.id.textViewDisplay);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timeIs = "Time is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                String dateIs = "Date is " + dp.getDayOfMonth() + "/" + dp.getMonth()+1 + "/" + dp.getYear();
                if (sArea.isChecked()) {
                    tvDisplay.setText("Seating Area: Smoking Area");

                } else {
                    tvDisplay.setText("Seating Area: Non-Smoking Area");
                }

                tvDisplay.setText("Name: " + cusName + "\nMobile Number: " + cusNum + "\nSize of Group: " + size + "\n" + dateIs + "\n" + timeIs + "\nSeating Area: " + sArea);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 5,01);
            }
        });

    }
}