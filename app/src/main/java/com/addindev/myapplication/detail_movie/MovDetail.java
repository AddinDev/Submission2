package com.addindev.myapplication.detail_movie;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.addindev.myapplication.R;
import com.addindev.myapplication.list_movie.MovList;
import com.addindev.myapplication.listmovies.WatchModel;

public class MovDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mov_detail);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvOverview = findViewById(R.id.tv_txt_overview);
        ImageView imgPoster = findViewById(R.id.img_poster);

        WatchModel watchModel = getIntent().getParcelableExtra(MovList.SELECTED_MOVIE);
        tvTitle.setText(watchModel.getTitle());
        tvOverview.setText(watchModel.getOverview());
        imgPoster.setImageResource(watchModel.getPoster());
        setTitle(watchModel.getTitle());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
