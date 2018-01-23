package org.androidtown.myapplication;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private  final static int MYREQUEST_CODE = 1001;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("rrrr", "onReceive: ");
        Toast.makeText(context,"ttt",Toast.LENGTH_SHORT).show();
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Intent myIntent = new Intent(context, SampleBroadcastActivity.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            /*Intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            Intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);*/
            Log.i("rrrr", "offfffffffffffffff ");

            Bundle bundle = intent.getExtras();
            String str = "";
            if(bundle != null){
                Object pdus[] = (Object [])bundle.get("pdus");
                SmsMessage msgs[] = new SmsMessage[pdus.length];
                for(int i=0; i<msgs.length; i++){
                    msgs[i] = SmsMessage.createFromPdu((byte [])pdus[i]);
                    str += msgs[i].getOriginatingAddress() + "에게 문자왔음, " + msgs[i].getMessageBody().toString() + "\n";
                }
                Toast toast = new Toast(context);

                toast.makeText(context,  str, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.RIGHT,140,40);
                toast.show();
            }
            myIntent.putExtra("msg",str);
            context.startActivity(myIntent);
        }
    /*    if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            Log.i("rrrr","화면꺼짐");
        }
        if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            Log.i("rrrr","화면킴");
        }*/
    }
}
