package nz.co.adriley.catchdesgintest.util.net;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.List;

import rx.Subscriber;

/**
 * Created by sgao on 6/12/2021 16:30
 *
 * @author sgao*/
public class GetDataExecute {
    private final static String TAG  = "GetDataExecute";
    public static void getData(Context context) {
        GeneralCommsInterfaceImpl.getDataObservable().subscribe(new Subscriber<List<GeneralCommsResponse>>(){
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(List<GeneralCommsResponse> data) {
                Intent mIntent = new Intent();
                Log.v(TAG, data.get(0).getContent());
            }
        });
    }

}
