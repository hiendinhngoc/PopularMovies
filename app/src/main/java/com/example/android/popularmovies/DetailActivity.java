package com.example.android.popularmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(DetailFragment.DETAIL_MOVIE,
                    getIntent().getParcelableExtra(DetailFragment.DETAIL_MOVIE));

            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.movie_detail, fragment)
                    .commit();
        }
    }
}
