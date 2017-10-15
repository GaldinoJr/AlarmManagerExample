package com.example.galdino.alarmmanagerexample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.galdino.alarmmanagerexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding mBnding;
    private static final int REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadControls();
    }

    private void loadControls() {
        mBnding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mBnding.btStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        startAlert();
    }

    private void startAlert() {
        int timeInSecondsToWakeUp = getSeconds();
        if(timeInSecondsToWakeUp < 0)
        {
            return;
        }
        int timeInMilliSecondsToWakeUp = timeInSecondsToWakeUp * 1000;
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,REQUEST_CODE,intent,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + timeInMilliSecondsToWakeUp ,pendingIntent);
        Toast.makeText(this, "Alarme agendado para daqui " + timeInSecondsToWakeUp + " segundos",Toast.LENGTH_LONG).show();
    }

    public int getSeconds() {
        int time;
        try {
            time = Integer.parseInt(mBnding.etTime.getText().toString());
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Por favor, digite apenas numeros", Toast.LENGTH_SHORT).show();
            time = -1;
        }
        return time;
    }
}
