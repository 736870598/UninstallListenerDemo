package com.sxy.uninstalllistenerdemo;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


        findViewById(R.id.gotoView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showView(Build.VERSION.SDK_INT);
            }
        });

        findViewById(R.id.listenerView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unInstallListener(Build.VERSION.SDK_INT,"/data/data/" + getPackageName());
            }
        });

    }


    static {
        System.loadLibrary("native-lib");
    }

    public native void showView(int sdk);
    public native void unInstallListener(int sdk, String path);
}
