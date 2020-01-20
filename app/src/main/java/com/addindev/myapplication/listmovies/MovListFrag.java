package com.addindev.myapplication.listmovies;

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

public class MovListFrag extends Fragment {

    private MovListViMo mViewModel;
    private WatchListAdapter mAdapter;

    public static MovListFrag newInstance() {
        return new MovListFrag();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mov_list_frag, container, false);
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
        mViewModel = ViewModelProviders.of(this).get(MovListViMo.class);

        mViewModel.addMovieModel(getResources().getString(R.string.terminator), getString(R.string.ov_terminator),R.drawable.poster_terminator);
        mViewModel.addMovieModel(getResources().getString(R.string.maleficent), getString(R.string.ov_maleficent),R.drawable.poster_maleficent);
        mViewModel.addMovieModel(getResources().getString(R.string.joker), getString(R.string.ov_joker),R.drawable.poster_joker);
        mViewModel.addMovieModel(getResources().getString(R.string.bohemian), getString(R.string.ov_bohemian),R.drawable.poster_bohemian);
        mViewModel.addMovieModel(getResources().getString(R.string.bumblebee), getString(R.string.ov_bumblebee),R.drawable.poster_bumblebee);
        mViewModel.addMovieModel(getResources().getString(R.string.creed), getString(R.string.ov_creed),R.drawable.poster_creed);
        mViewModel.addMovieModel(getResources().getString(R.string.deadpool), getString(R.string.ov_creed),R.drawable.poster_deadpool);
        mViewModel.addMovieModel(getResources().getString(R.string.dragonball), getString(R.string.ov_dragonball),R.drawable.poster_dragonball);
        mViewModel.addMovieModel(getResources().getString(R.string.venom), getString(R.string.ov_venom),R.drawable.poster_venom);
        mViewModel.addMovieModel(getResources().getString(R.string.premanpensiun), getString(R.string.ov_premanpensiun),R.drawable.poster_preman);
        mViewModel.addMovieModel(getResources().getString(R.string.aquaman), getString(R.string.ov_aquaman),R.drawable.poster_aquaman);
        mViewModel.addMovieModel(getResources().getString(R.string.avenger), getString(R.string.ov_avenger),R.drawable.poster_avengerinfinity);
        mViewModel.addMovieModel(getResources().getString(R.string.birdbox), getString(R.string.ov_birdbox),R.drawable.poster_birdbox);


        mAdapter = new WatchListAdapter(view.getContext(),mViewModel.getModelList());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        mAdapter.SetOnItemClickListener(new WatchListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent goToDetailMovie = new Intent(view.getContext(), MovDetail.class);
                goToDetailMovie.putExtra(MovList.SELECTED_MOVIE,model);
                startActivity(goToDetailMovie);
            }
        });
    }

}

