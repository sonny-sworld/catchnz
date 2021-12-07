package nz.co.adriley.catchdesgintest.util.view.activity.main;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;

import java.util.List;

import nz.co.adriley.catchdesgintest.R;
import nz.co.adriley.catchdesgintest.databinding.MainActivityBinding;
import nz.co.adriley.catchdesgintest.util.net.GeneralCommsResponse;

/**
 * @author sgao
 */

public class MainActivity extends AppCompatActivity implements RefreshInterface {


    MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewModel(viewModel);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.swipeRefresh.setOnRefreshListener(refreshLayout -> binding.getViewModel().refresh(MainActivity.this));
    }

    @Override
    public void refreshCallback(List<GeneralCommsResponse> data) {
        binding.getViewModel().updateListData(data);
        binding.swipeRefresh.finishRefresh();
        binding.imageView.setVisibility(View.GONE);
    }


}