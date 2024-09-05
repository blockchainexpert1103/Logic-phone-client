package com.example.pms_client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.app.KeyguardManager;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class PhoneStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        MyCallStateListener phoneListener = new MyCallStateListener();
        telephony.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
        telephony.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
        if (!intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
            return;
    }

    public class MyCallStateListener extends PhoneStateListener {

        @Override
        public void onCallStateChanged(int state, String phoneNumber) {

            super.onCallStateChanged(state, phoneNumber);
//            Toast.makeText(this, state, Toast.LENGTH_SHORT).show();
            System.out.print(state);
        }
    }
}
