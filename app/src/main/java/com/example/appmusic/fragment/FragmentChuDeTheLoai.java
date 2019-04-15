package com.example.appmusic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appmusic.R;
import com.example.appmusic.model.ChuDe;
import com.example.appmusic.model.ChuDeTheLoaiTrongNgay;
import com.example.appmusic.model.TheLoai;
import com.example.appmusic.service.APIService;
import com.example.appmusic.service.DataService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentChuDeTheLoai extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView  tvSeeMoreChuDeTheLoai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude_theloai, container, false);
        horizontalScrollView = view.findViewById(R.id.horizontal_scrollView_chude_theloai);
        tvSeeMoreChuDeTheLoai = view.findViewById(R.id.tv_seemore_chude_theloai);
        getData();
        return view;
    }

    private void getData() {
        DataService dataService = APIService.getService();
        Call<ChuDeTheLoaiTrongNgay> calBack = dataService.getChuDeTheLoaiTrongNgay();
        calBack.enqueue(new Callback<ChuDeTheLoaiTrongNgay>() {
            @Override
            public void onResponse(Call<ChuDeTheLoaiTrongNgay> call, Response<ChuDeTheLoaiTrongNgay> response) {
                ChuDeTheLoaiTrongNgay chuDeTheLoaiTrongNgay = response.body();

                final ArrayList<ChuDe> chuDeArrayList = new ArrayList<>();
                chuDeArrayList.addAll(chuDeTheLoaiTrongNgay.getChuDe());

                final ArrayList<TheLoai> theLoaiArrayList = new ArrayList<>();
                theLoaiArrayList.addAll(chuDeTheLoaiTrongNgay.getTheLoai());

                LinearLayout linearLayout = new LinearLayout(getActivity());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(580,250);
                layoutParams.setMargins(10,20,10,30);

                for (int i = 0; i < chuDeArrayList.size(); i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (chuDeArrayList.get(i).getHinhChuDe() != null){
                        Picasso.with(getActivity())
                                .load(chuDeArrayList.get(i).getHinhChuDe())
                                .into(imageView);
                    }
                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                //
                for (int i = 0; i < theLoaiArrayList.size(); i++){
                    CardView cardView = new CardView(getActivity());
                    cardView.setRadius(10);
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    if (theLoaiArrayList.get(i).getHinhTheLoai() != null){
                        Picasso.with(getActivity())
                                .load(theLoaiArrayList.get(i).getHinhTheLoai())
                                .into(imageView);
                    }
                    cardView.setLayoutParams(layoutParams);
                    cardView.addView(imageView);
                    linearLayout.addView(cardView);
                }
                horizontalScrollView.addView(linearLayout);
            }

            @Override
            public void onFailure(Call<ChuDeTheLoaiTrongNgay> call, Throwable t) {

            }
        });

    }
}
