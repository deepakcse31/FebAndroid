package com.example.febandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(isAirplaneModeEnabled(context.getApplicationContext())){
            Toast.makeText(context,"Airplane Mode Enabled",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context,"Airplane Mode Disabled",Toast.LENGTH_LONG).show();
        }
    }

    private static boolean isAirplaneModeEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
}
