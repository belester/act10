package com.example.belester.act10;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Myservice myservice;
    boolean isBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = new Intent(this,Myservice.class);
        bindService(intent,Mconnection, Context.BIND_AUTO_CREATE);
    }
    public void mensaje(View view){
        String message;
        message = myservice.mensaje();
        textView.setText(message);

    }
    private ServiceConnection Mconnection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Myservice.LocalSerice localSerice = (Myservice.LocalSerice)service;
            myservice = localSerice.getSservice();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBind = false;


        }
    };
    protected void onStop(){
        super.onStop();
        if (isBind){
            unbindService(Mconnection);
            isBind = false;
        }
    }
}
