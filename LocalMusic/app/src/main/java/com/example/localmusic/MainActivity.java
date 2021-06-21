package com.example.localmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView nextIv, playIv, lastIv;
    TextView songTv, singerTv;
    RecyclerView menuRv;

    List<LocalMusicBean>mDatas; // 数据源
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mDatas = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_iv_bottom_next:

                break;
            case R.id.main_iv_bottom_play:

                break;
            case R.id.main_iv_bottom_last:

                break;
        }
    }

    private void initView() {
        nextIv = findViewById(R.id.main_iv_bottom_next);
        playIv = findViewById(R.id.main_iv_bottom_play);
        lastIv = findViewById(R.id.main_iv_bottom_last);
        songTv = findViewById(R.id.main_tv_bottom_song);
        singerTv = findViewById(R.id.main_tv_bottom_singer);
        menuRv = findViewById(R.id.main_rv_menu);
        nextIv.setOnClickListener(this);
        playIv.setOnClickListener(this);
        lastIv.setOnClickListener(this);
    }   // 初始化控件
}