package com.example.appmusic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appmusic.R;
import com.example.appmusic.adapter.BaiHatHotAdapter;
import com.example.appmusic.model.BaiHat;
import com.example.appmusic.service.APIService;
import com.example.appmusic.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBaiHatHot extends Fragment {
    View view;
    RecyclerView rcvBatHatHot;
    BaiHatHotAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihat_yeuthich,container,false);
        connectView();
        getData();
        return view;
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callBack = dataService.getBaiHatHot();
        callBack.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                ArrayList<BaiHat> baiHatArrayList = (ArrayList<BaiHat>) response.body();
                adapter = new BaiHatHotAdapter(getActivity(), baiHatArrayList);
                rcvBatHatHot.setAdapter(adapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()
                        ,LinearLayoutManager.VERTICAL
                        ,false);
                rcvBatHatHot.setLayoutManager(layoutManager);

            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }

    private void connectView() {
        rcvBatHatHot = view.findViewById(R.id.rcv_baihat_yeuthich);
    }
}
