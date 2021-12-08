package nz.co.adriley.catchdesgintest.util;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import nz.co.adriley.catchdesgintest.util.net.GeneralCommsInterface;
import nz.co.adriley.catchdesgintest.util.net.component.DaggerPostComponent;
import nz.co.adriley.catchdesgintest.util.view.activity.main.MainActivity;

/**
 * Created by sgao on 8/12/2021 08:54
 **/

public class CustomApplication extends Application {


    private static GeneralCommsInterface apiInterface;
    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(mCaughtExceptionHandler);
    }

    public static GeneralCommsInterface getApiInstance() {
        if (apiInterface == null) {
            synchronized (GeneralCommsInterface.class) {
                if (apiInterface == null)
                    apiInterface = DaggerPostComponent.builder().build().getApiInterface();
            }
        }
        return apiInterface;
    }

    private final Thread.UncaughtExceptionHandler mCaughtExceptionHandler = (thread, ex) -> {
        try {
            ex.printStackTrace();
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
            AlarmManager mgr = (AlarmManager) getBaseContext().getSystemService(Context.ALARM_SERVICE);
            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, pendingIntent);
            System.exit(2);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(10);
        }
    };
}





