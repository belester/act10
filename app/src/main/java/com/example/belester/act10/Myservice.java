package com.example.belester.act10;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class Myservice extends Service{
    private final IBinder mBinder =new LocalSerice();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
    public class LocalSerice extends Binder{
        Myservice getSservice(){
            return Myservice.this;
        }

    }
    public String mensaje (){
        return "hola mundo";
    }
}
