package com.example.appmusic.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appmusic.R;
import com.example.appmusic.adapter.BannerAdapter;
import com.example.appmusic.model.QuangCao;
import com.example.appmusic.service.APIService;
import com.example.appmusic.service.DataService;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentBanner extends Fragment {
    private View view;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private BannerAdapter adapter;
    private Runnable runnable;
    private Handler handler;
    private int currentItem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        getData();
        connectView();
        return view;
    }

    private void connectView() {
        viewPager = view.findViewById(R.id.my_view_pager_banner);
        circleIndicator = view.findViewById(R.id.indicator_default);

    }


    private void getData(){
        DataService dataService = APIService.getService();
        Call<List<QuangCao>> callBack = dataService.getDataBanner();
        callBack.enqueue(new Callback<List<QuangCao>>() {
            @Override
            public void onResponse(Call<List<QuangCao>> call, Response<List<QuangCao>> response) {
                ArrayList<QuangCao> banners = (ArrayList<QuangCao>) response.body();
                Log.e("Banner",""+banners.get(0).getNoiDung());
                adapter = new BannerAdapter(getContext(), banners);
                viewPager.setAdapter(adapter);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem = viewPager.getCurrentItem();
                        currentItem++;
                        if (currentItem > viewPager.getAdapter().getCount()){
                            currentItem = 0;
                        }
                        viewPager.setCurrentItem(currentItem, true);
                        handler.postDelayed(runnable, 4000);
                    }
                };
                handler.postDelayed(runnable, 4000);
            }

            @Override
            public void onFailure(Call<List<QuangCao>> call, Throwable t) {

            }
        });
    }
}
