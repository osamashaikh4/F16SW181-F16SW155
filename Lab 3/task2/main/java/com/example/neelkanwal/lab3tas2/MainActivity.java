package com.example.neelkanwal.lab3tas2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button call, camera, contact, browser, calllog, gallery, dialpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText);
        call = findViewById(R.id.call);
        camera = findViewById(R.id.camera);
        contact = findViewById(R.id.contact);
        browser = findViewById(R.id.browser);
        calllog = findViewById(R.id.calllog);
        gallery = findViewById(R.id.gallery);
        dialpad = findViewById(R.id.dialpad);
    }

    public void OnBrowser(View view) {
        String search;
        search = et1.getText().toString();
            Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/search?="+search));
            startActivity(in);



    }

    public void OnCamera(View v) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }

    public void OnCall(View v) {
        String phone = et1.getText().toString();
        Intent iq = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(iq);

    }
    // browser camera call done, contact, gallery and dialpad remaining pick one
    public void OnDialpad (View v){
        String phone=et1.getText().toString();
        Intent ia = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
        startActivity(ia);
    }
    public void OnCalllog (View v){
        Intent showCallLog = new Intent();
        showCallLog.setAction(Intent.ACTION_VIEW);
        showCallLog.setType(CallLog.Calls.CONTENT_TYPE);
        startActivity(showCallLog);
    }
    public void OnGallery (View v){
        Intent intent =  new Intent(Intent.ACTION_VIEW);
        intent.setType("video/*, images/*");
        startActivity(intent);
    }

    public void OnContact (View v){
        Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
        startActivity(in);
    }
}
