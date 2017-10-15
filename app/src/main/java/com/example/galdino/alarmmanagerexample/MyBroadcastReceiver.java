package com.example.galdino.alarmmanagerexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

/**
 * Created by Galdino on 14/10/2017.
 */

public class MyBroadcastReceiver extends BroadcastReceiver
{
    private MediaPlayer mMediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent)
    {
        mMediaPlayer = MediaPlayer.create(context,R.raw.alrm2);
        mMediaPlayer.start();
        Toast.makeText(context, "Acordaaaaa", Toast.LENGTH_SHORT).show();
    }
}
