package com.addindev.myapplication.listtvshow;

import androidx.lifecycle.ViewModel;

import com.addindev.myapplication.listmovies.WatchModel;

import java.util.ArrayList;

public class TvListShowViMo extends ViewModel {

    private ArrayList<WatchModel> modelList = new ArrayList<>();

    public void addTvShowModel(String title, String overview, Integer poster){
        this.modelList.add(new WatchModel(title, overview, poster));
    }

    public ArrayList<WatchModel> getTvShowList() {
        return modelList;
    }

}
