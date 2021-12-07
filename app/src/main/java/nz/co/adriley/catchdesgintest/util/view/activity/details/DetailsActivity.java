package nz.co.adriley.catchdesgintest.util.view.activity.details;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import nz.co.adriley.catchdesgintest.R;
import nz.co.adriley.catchdesgintest.databinding.DetailsActivityBinding;
import nz.co.adriley.catchdesgintest.util.net.GeneralCommsResponse;

/**
 * @author sgao
 */

public class DetailsActivity extends AppCompatActivity {

    public static final String INTENT_DETAILS_DATA_TAG = "intent_details_data_tag";
    DetailsActivityBinding binding;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.details_activity);
        bundle = getIntent().getExtras();
        bundle.get(INTENT_DETAILS_DATA_TAG);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (bundle.get(INTENT_DETAILS_DATA_TAG) instanceof GeneralCommsResponse) {
            if (getSupportActionBar() != null)
                getSupportActionBar().setTitle(((GeneralCommsResponse) bundle.get(INTENT_DETAILS_DATA_TAG)).title);
            binding.textView.setText(((GeneralCommsResponse) bundle.get(INTENT_DETAILS_DATA_TAG)).content);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}