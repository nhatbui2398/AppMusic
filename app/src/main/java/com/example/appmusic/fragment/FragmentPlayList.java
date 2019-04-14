package com.example.appmusic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.appmusic.R;
import com.example.appmusic.adapter.PLayListAdapter;
import com.example.appmusic.model.PlayList;
import com.example.appmusic.service.APIService;
import com.example.appmusic.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentPlayList extends Fragment {
    private View view;
    private ListView listViewPlayList;
    private TextView tvPlayListName, tvSeeMorePlayList;
    private PLayListAdapter adapter;
    private ArrayList<PlayList> lists;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_list,container,false);
        getData();
        connectView();
        return view;
    }

    private void connectView() {
        tvPlayListName = view.findViewById(R.id.tv_playList_name);
        listViewPlayList = view.findViewById(R.id.listview_playlist);
        tvSeeMorePlayList = view.findViewById(R.id.tv_view_more_play_list);
    }

    private void getData(){
        DataService dataService = APIService.getService();
        Call<List<PlayList>> callBack = dataService.getPlayListCurrentDay();
        callBack.enqueue(new Callback<List<PlayList>>() {
            @Override
            public void onResponse(Call<List<PlayList>> call, Response<List<PlayList>> response) {
                ArrayList<PlayList> playLists = (ArrayList<PlayList>) response.body();
                Log.e("PlayList",""+playLists.get(0).getTenPlayList());
                lists = playLists;
                adapter = new PLayListAdapter(getContext(), android.R.layout.simple_list_item_1, lists);
                listViewPlayList.setAdapter(adapter);
                setListViewHeightBasedOnChildren(listViewPlayList);
            }

            @Override
            public void onFailure(Call<List<PlayList>> call, Throwable t) {

            }
        });
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
