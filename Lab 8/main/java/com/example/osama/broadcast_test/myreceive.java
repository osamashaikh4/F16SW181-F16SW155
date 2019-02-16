package com.example.neelkanwal.broadcast_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class myreceive extends BroadcastReceiver {
    public myreceive(){ }
    public String asd;
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            for (SmsMessage smsmessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                asd = smsmessage.getMessageBody();
            }

        }
            if (asd.equals("Hello")){
                Toast.makeText(context, "Hello", Toast.LENGTH_LONG).show();
            }
        }

}
