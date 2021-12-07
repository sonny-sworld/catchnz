package nz.co.adriley.catchdesgintest.util.view.activity.main;

import java.util.List;

import nz.co.adriley.catchdesgintest.util.net.GeneralCommsResponse;

/**
 * Created by sgao on 7/12/2021 11:13
 **/
public interface RefreshInterface {

    void refreshCallback(List<GeneralCommsResponse> data);

}
