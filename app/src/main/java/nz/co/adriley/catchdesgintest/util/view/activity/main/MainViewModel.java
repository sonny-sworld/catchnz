package nz.co.adriley.catchdesgintest.util.view.activity.main;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModel;

import java.util.List;

import nz.co.adriley.catchdesgintest.util.net.GeneralCommsResponse;
import nz.co.adriley.catchdesgintest.util.net.GetDataExecute;

/**
 * Created by sgao on 7/12/2021 10:20
 *
 * @author sgao
 */

public class MainViewModel extends ViewModel {
    private ObservableArrayList<GeneralCommsResponse> resDataList = new ObservableArrayList<>();

    public ObservableArrayList<GeneralCommsResponse> getResDataList() {
        return resDataList;
    }

    public void setResDataList(ObservableArrayList<GeneralCommsResponse> resDataList) {
        this.resDataList = resDataList;
    }

    public void refresh(RefreshInterface callback) {
        GetDataExecute.getData(callback);
    }

    public void updateListData(List<GeneralCommsResponse> newData) {
        getResDataList().clear();
        getResDataList().addAll(newData);
    }

}
