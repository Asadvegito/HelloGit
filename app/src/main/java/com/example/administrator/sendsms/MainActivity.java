package com.example.administrator.sendsms;

import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edt ;
    TextView tv;
    ListView lv;
    Button send,recieve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = (EditText)findViewById(R.id.editText);
        tv = (TextView)findViewById(R.id.textView);
        lv= (ListView)findViewById(R.id.list);
        send=(Button) findViewById(R.id.send);
        recieve=(Button)findViewById(R.id.rec);
        Toast.makeText(this,"Git hub sync!",Toast.LENGTH_SHORT).show();




    }
    public void  Recieve(View v )
    {
        //Recieving  sms
        Cursor cur = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);

        if (cur.moveToFirst()) { /* false = no sms */
            do {
                String msgInfo = "";

                for (int i = 0; i < cur.getColumnCount(); i++) {
                    msgInfo += " " + cur.getColumnName(i) + ":" + cur.getString(i);
                }
                tv.setText(msgInfo);
               // Toast.makeText(this, msgInfo, Toast.LENGTH_SHORT).show();

            } while (cur.moveToNext());
        }

    }
    public void sent(View v)
    {  try {
        //For Telenor
        String phoneNumber = "667";
        String smsBody = ""+edt.getText();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, smsBody, null, null);

    }
    catch (Exception e)
    {

    }
    }

//    private void sendsms() {
//
//        PendingIntent pi = PendingIntent.getActivity(this, 0,
//                new Intent(this, MainActivity.class), 0);
//        SmsManager sms = SmsManager.getDefault();
//        sms.sendTextMessage("667", null, "MNP", pi, null);
//        //        String phoneNumber = "9999999999";
////        String smsBody = "This is an SMS!";
////
////        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
////
////        smsIntent.setType("vnd.android-dir/mms-sms");
////
////        smsIntent.putExtra("address", phoneNumber);
////
////        smsIntent.putExtra("sms_body", smsBody);
////
////
////        startActivity(smsIntent);
//
//    }
}
