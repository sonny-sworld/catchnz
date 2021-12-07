package nz.co.adriley.catchdesgintest.util.net;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by sgao on 6/12/2021 16:07
 *
 * @author sgao
 */

public interface GeneralCommsInterface {
    @GET("data.json")
    Observable<List<GeneralCommsResponse>> getData();
}
