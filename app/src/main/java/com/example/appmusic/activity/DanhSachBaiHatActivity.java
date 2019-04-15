package com.example.appmusic.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appmusic.R;
import com.example.appmusic.model.BaiHat;
import com.example.appmusic.model.QuangCao;
import com.example.appmusic.service.APIService;
import com.example.appmusic.service.DataService;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhSachBaiHatActivity extends AppCompatActivity {
    private QuangCao quangCao;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Toolbar toolbar;
    private CoordinatorLayout coordinatorLayout;
    private RecyclerView rcv_dsbh;
    private FloatingActionButton floatingActionButton;
    private ImageView imgViewBaiHat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_bai_hat);
        connectView();
        getData();

    }

    private void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

        if (quangCao != null && !TextUtils.isEmpty(quangCao.getHinhBaiHat())){
            setValueInView(quangCao.getTenBaiHat(), quangCao.getHinhBaiHat());
            getDataQuangCao(quangCao.getIDQuangCao());
        }
    }

    private void getDataQuangCao(String idQuangCao) {
        DataService dataService = APIService.getService();
        Call<List<BaiHat>> callBack = dataService.getDSBHQuangCao(idQuangCao);
        callBack.enqueue(new Callback<List<BaiHat>>() {
            @Override
            public void onResponse(Call<List<BaiHat>> call, Response<List<BaiHat>> response) {
                ArrayList<BaiHat> baiHatArrayList = (ArrayList<BaiHat>) response.body();

            }

            @Override
            public void onFailure(Call<List<BaiHat>> call, Throwable t) {

            }
        });
    }

    private void setValueInView(String ten, String hinh) {
        collapsingToolbarLayout.setTitle(ten);
        try {
            URL url = new URL(hinh);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Picasso.with(this)
                .load(hinh)
                .into(imgViewBaiHat);
    }

    private void connectView() {
        imgViewBaiHat = findViewById(R.id.img_dsbh);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        toolbar = findViewById(R.id.toolbar_dsbh);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        rcv_dsbh = findViewById(R.id.rcv_dsbh);
        floatingActionButton = findViewById(R.id.floating_btn_dsbh_hot);
        initView();
    }

    private void getData() {
        Intent intent = getIntent();
        if (intent != null){
            quangCao = (QuangCao) intent.getSerializableExtra("Banner");
            Toast.makeText(this,""+quangCao.getTenBaiHat(),Toast.LENGTH_SHORT).show();
        }
    }
}
