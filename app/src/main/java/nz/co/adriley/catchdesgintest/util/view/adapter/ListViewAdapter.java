package nz.co.adriley.catchdesgintest.util.view.adapter;

import static nz.co.adriley.catchdesgintest.util.view.activity.details.DetailsActivity.INTENT_DETAILS_DATA_TAG;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import nz.co.adriley.catchdesgintest.R;
import nz.co.adriley.catchdesgintest.databinding.ItemViewBinding;
import nz.co.adriley.catchdesgintest.util.net.GeneralCommsResponse;
import nz.co.adriley.catchdesgintest.util.view.activity.details.DetailsActivity;

/**
 * Created by sgao on 7/12/2021 12:06
 *
 * @author sgao
 */


public class ListViewAdapter extends RecyclerView.Adapter<ListHolder> {

    List<GeneralCommsResponse> listData;
    Context context;
    ItemViewBinding binding;
    LayoutInflater inflater;

    public ListViewAdapter(List<GeneralCommsResponse> listData, Context context) {
        super();
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(context);
        }
        binding = DataBindingUtil.inflate(inflater, R.layout.item_view, parent, false);
        return new ListHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.bindHolder(listData.get(position));
        holder.binding.itemRecyclerView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra(INTENT_DETAILS_DATA_TAG, listData.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listData != null ? listData.size() : 0;
    }
}
