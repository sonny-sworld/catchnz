package nz.co.adriley.catchdesgintest.util.view.adapter;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nz.co.adriley.catchdesgintest.util.net.GeneralCommsResponse;

/**
 * Created by sgao on 7/12/2021 12:14
 *
 * @author sgao*/


public class BindingAdapters {
    @BindingAdapter("resDataList")
    public static void bindBooks(final RecyclerView view,  ObservableArrayList<GeneralCommsResponse> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(layoutManager);
        view.setAdapter(new ListViewAdapter(list, view.getContext()));
    }

}
