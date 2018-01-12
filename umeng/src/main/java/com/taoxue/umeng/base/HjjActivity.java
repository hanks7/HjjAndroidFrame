package com.taoxue.umeng.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.taoxue.umeng.utils.UL;

public class HjjActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        UL.e("activity", getLocalClassName());
    }
}
