package nz.co.adriley.catchdesgintest.util.net;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sgao on 6/12/2021 16:15
 **/

public class GeneralCommsInterfaceImpl extends GeneralCommsBase {
    public static Observable<List<GeneralCommsResponse>> getDataObservable() {
        return getInstance().getData()
                .timeout(30, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
