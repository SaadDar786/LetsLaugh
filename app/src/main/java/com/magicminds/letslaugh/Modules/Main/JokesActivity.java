package com.magicminds.letslaugh.Modules.Main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.magicminds.letslaugh.Modules.Main.Adapter.JokesAdapter;
import com.magicminds.letslaugh.R;
import com.magicminds.letslaugh.Utilities.Utils;
import com.magicminds.letslaugh.WebService.Jokes.Facade.JokeUICallBack;
import com.magicminds.letslaugh.WebService.Jokes.Facade.JokesFacade;
import com.magicminds.letslaugh.WebService.Jokes.Model.Joke;

import java.util.ArrayList;
import java.util.List;

public class JokesActivity extends AppCompatActivity implements JokeUICallBack {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recycleView;
    private JokesAdapter adapter;
    private LinearLayoutManager manager;
    private ArrayList<Joke> jokeList = new ArrayList<Joke>();
    private JokesFacade jokesFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        recycleView = (RecyclerView) findViewById(R.id.joke_recycle_view);

        recycleView.setHasFixedSize(true);

        manager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(manager);


        adapter = new JokesAdapter(jokeList);
        recycleView.setAdapter(adapter);

        refreshLayout.setOnRefreshListener(new RefreshLayoutControl());

        jokesFacade = new JokesFacade(this);

        loadJokes();

    }

    @Override
    public void updateUIWithJokes(List<Joke> list) {

        refreshLayout.setRefreshing(false);
        if(list != null && list.size() >0){
            jokeList.clear();
            jokeList.addAll((ArrayList)list);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void noJokesToUpdateUI(String err) {
        refreshLayout.setRefreshing(false);
        Toast.makeText(this, R.string.service_err, Toast.LENGTH_LONG).show();

    }

    public class RefreshLayoutControl implements SwipeRefreshLayout.OnRefreshListener{

        @Override
        public void onRefresh() {
            loadJokes();
        }
    }

    public void loadJokes() {

        if(Utils.isNetworkAvailable(getApplicationContext())) {

            if(!refreshLayout.isRefreshing())
                refreshLayout.setRefreshing(true);

            jokesFacade.getRandomJokes();
        }
        else {

            Toast.makeText(this, R.string.network_err,
                    Toast.LENGTH_LONG).show();
        }

    }
}
