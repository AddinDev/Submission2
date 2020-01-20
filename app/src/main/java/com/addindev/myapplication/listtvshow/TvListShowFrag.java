package com.addindev.myapplication.listtvshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.addindev.myapplication.R;
import com.addindev.myapplication.detail_movie.MovDetail;
import com.addindev.myapplication.list_movie.MovList;
import com.addindev.myapplication.list_movie.WatchListAdapter;
import com.addindev.myapplication.listmovies.WatchModel;

public class TvListShowFrag extends Fragment {

    private TvListShowViMo mViewModel;
    private WatchListAdapter mAdapter;

    public static TvListShowFrag newInstance(){
        return new TvListShowFrag();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tv_show_list_frag, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        mViewModel = ViewModelProviders.of(this).get(TvListShowViMo.class);

        mViewModel.addTvShowModel(getResources().getString(R.string.t_911), getString(R.string.ov_911),R.drawable.poster_911);
        mViewModel.addTvShowModel(getResources().getString(R.string.bwwd), getString(R.string.ov_bwwd),R.drawable.bestworstweekendever);
        mViewModel.addTvShowModel(getResources().getString(R.string.brit), getString(R.string.ov_brit),R.drawable.britannia);
        mViewModel.addTvShowModel(getResources().getString(R.string.cr), getString(R.string.ov_cr),R.drawable.castlerock);
        mViewModel.addTvShowModel(getResources().getString(R.string.fbi), getString(R.string.ov_fbi),R.drawable.fbi);
        mViewModel.addTvShowModel(getResources().getString(R.string.jr), getString(R.string.ov_jr),R.drawable.jackryan);
        mViewModel.addTvShowModel(getResources().getString(R.string.k), getString(R.string.ov_k),R.drawable.krypton);
        mViewModel.addTvShowModel(getResources().getString(R.string.ram), getString(R.string.ov_ram),R.drawable.rickandmorty);
        mViewModel.addTvShowModel(getResources().getString(R.string.tr), getString(R.string.ov_tr),R.drawable.theresident);
        mViewModel.addTvShowModel(getResources().getString(R.string.t), getString(R.string.ov_t),R.drawable.titans);


        mAdapter = new WatchListAdapter(view.getContext(), mViewModel.getTvShowList());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        mAdapter.SetOnItemClickListener(new WatchListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent intent = new Intent(view.getContext(), MovDetail.class);
                intent.putExtra(MovList.SELECTED_MOVIE,model);
                startActivity(intent);
            }
        });

    }


}






































