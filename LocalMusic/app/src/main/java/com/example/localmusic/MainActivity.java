package com.example.localmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView nextIv, playIv, lastIv;
    TextView songTv, singerTv;
    RecyclerView menuRv;
    //    数据源
    List<LocalMusicBean> mDatas;
    private LocalMusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mDatas = new ArrayList<>();
//        适配器对象
        adapter = new LocalMusicAdapter(this, mDatas);
        menuRv.setAdapter(adapter);
//        设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        menuRv.setLayoutManager(layoutManager);

        loadLocalMusicData();
    }

    private void loadLocalMusicData() {
        // 加载本地音乐文件
//        获取ContentResolver
        ContentResolver resolver = getContentResolver();
//        获取本地音乐uri地址
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//        开始查询
        Cursor cursor = resolver.query(uri, null, null, null, null);
//        遍历Cursor
        int id = 0;
        while (cursor.moveToNext()) {
            String song = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
            id++;
            String sid = String.valueOf(id);
            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
            SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
            String time = sdf.format(new Date(duration));

            LocalMusicBean bean = new LocalMusicBean(sid, song, singer, album, time, path);
            mDatas.add(bean);
        }
//        数据源发生变化， 提示适配器更新
        adapter.notifyDataSetChanged();
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