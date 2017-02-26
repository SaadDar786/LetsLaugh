package com.magicminds.letslaugh.Modules.Main.Adapter;

/**
 * Created by saaddar on 2/26/17.
 */

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magicminds.letslaugh.R;
import com.magicminds.letslaugh.WebService.Jokes.Model.Joke;

import java.util.ArrayList;

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.ViewHolder> {
    private ArrayList<Joke> mDataset;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView jokeTxtView;

        public ViewHolder(View v) {
            super(v);
            jokeTxtView = (TextView) v.findViewById(R.id.joke);
        }
    }

    public void add(int position, Joke item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }

    public JokesAdapter(ArrayList<Joke> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public JokesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.jokelayout, parent, false);
        ViewHolder view = new ViewHolder(v);
        return view;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Joke joke = mDataset.get(position);

        holder.jokeTxtView.setText(Html.fromHtml(joke.getJoke()));
        holder.jokeTxtView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the row selection
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
