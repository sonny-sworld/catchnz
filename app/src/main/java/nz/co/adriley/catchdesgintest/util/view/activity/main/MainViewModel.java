package nz.co.adriley.catchdesgintest.util.view.activity.main;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import java.util.List;

import nz.co.adriley.catchdesgintest.util.CustomApplication;
import nz.co.adriley.catchdesgintest.util.net.GeneralCommsResponse;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sgao on 7/12/2021 10:20
 *
 * @author sgao
 */

public class MainViewModel extends ViewModel {
    private final static String TAG = "ViewModel";

    private ObservableArrayList<GeneralCommsResponse> resDataList = new ObservableArrayList<>();

    public ObservableArrayList<GeneralCommsResponse> getResDataList() {
        return resDataList;
    }

    public void setResDataList(ObservableArrayList<GeneralCommsResponse> resDataList) {
        this.resDataList = resDataList;
    }

    public void refresh(RefreshInterface callback) {
        getApiData(callback);
//        GetDataExecute.getData(callback);
    }

    public void updateListData(List<GeneralCommsResponse> newData) {
        getResDataList().clear();
        getResDataList().addAll(newData);
    }



    private void getApiData(RefreshInterface callback) {
        CustomApplication.getApiInstance().getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GeneralCommsResponse>>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onNext(List<GeneralCommsResponse> data) {
                Log.v(TAG, data.get(0).getContent());
                if (callback != null) {
                    callback.refreshCallback(data);
                }
            }
        });
    }

}
