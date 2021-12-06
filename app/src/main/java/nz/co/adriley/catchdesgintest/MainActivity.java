package nz.co.adriley.catchdesgintest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import nz.co.adriley.catchdesgintest.util.net.GetDataExecute;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetDataExecute.getData(this);
    }
}