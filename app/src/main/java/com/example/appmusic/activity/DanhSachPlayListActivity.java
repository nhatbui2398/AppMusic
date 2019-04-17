package com.example.appmusic.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.appmusic.R;
import com.example.appmusic.adapter.AllPlayListAdapter;
import com.example.appmusic.adapter.PLayListAdapter;
import com.example.appmusic.model.PlayList;
import com.example.appmusic.service.APIService;
import com.example.appmusic.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachPlayListActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private AllPlayListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_play_list);
        connectView();
        getData();
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<PlayList>> callBack = dataService.getAllPlayList();
        callBack.enqueue(new Callback<List<PlayList>>() {
            @Override
            public void onResponse(Call<List<PlayList>> call, Response<List<PlayList>> response) {
                ArrayList<PlayList> arrayList = (ArrayList<PlayList>) response.body();
                adapter = new AllPlayListAdapter(getApplicationContext(), arrayList);
                recyclerView.setAdapter(adapter);
                GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2,GridLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<List<PlayList>> call, Throwable t) {

            }
        });
    }

    private void connectView() {
        toolbar = findViewById(R.id.toolbar_dspl);
        recyclerView = findViewById(R.id.rcv_dspl);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.playListTitle);
        toolbar.setTitleTextColor(getResources().getColor(R.color.purple));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
