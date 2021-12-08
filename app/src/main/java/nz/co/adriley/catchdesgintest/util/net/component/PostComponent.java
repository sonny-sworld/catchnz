package nz.co.adriley.catchdesgintest.util.net.component;

import javax.inject.Singleton;

import dagger.Component;
import nz.co.adriley.catchdesgintest.util.net.GeneralCommsInterface;
import nz.co.adriley.catchdesgintest.util.net.module.PostModule;

/**
 * Created by sgao on 9/12/2021 11:21
 **/
@Singleton
@Component(modules = {PostModule.class})
public interface PostComponent {
    GeneralCommsInterface getApiInterface();
}
