package nz.co.adriley.catchdesgintest.util.view.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import nz.co.adriley.catchdesgintest.databinding.ItemViewBinding;
import nz.co.adriley.catchdesgintest.util.net.GeneralCommsResponse;

/**
 * Created by sgao on 7/12/2021 11:55
 *
 * @author sgao
 */


public class ListHolder extends RecyclerView.ViewHolder {
    ItemViewBinding binding;

    public ListHolder(@NonNull View itemView, ItemViewBinding binding) {
        super(itemView);
        this.binding = binding;

    }

    public void bindHolder(GeneralCommsResponse response) {
        this.binding.setViewModel(response);
        this.binding.executePendingBindings();
    }
}
