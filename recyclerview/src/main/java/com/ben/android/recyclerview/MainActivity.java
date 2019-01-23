package com.ben.android.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IconTouchListener, ItemTouchHelperCallback.OnItemMoveListener {

    private RecyclerView recyclerView;
    private ItemTouchHelper touchHelper;
    private NewsAdapter adapter;
    private List<New> newList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.id_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        newList = DataUtil.getNews();
        adapter = new NewsAdapter(newList);
        adapter.setIconTouchListener(this);
        recyclerView.setAdapter(adapter);

        touchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(this));
        touchHelper.attachToRecyclerView(recyclerView);


    }

    @Override
    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        touchHelper.startDrag(viewHolder);
    }

    @Override
    public boolean onMove(int fromPosition, int toPosition) {
        //reset item
        Collections.swap(newList,fromPosition,toPosition);
        adapter.notifyItemMoved(fromPosition,toPosition);
        return true;
    }

    @Override
    public void onRemove(int position) {
        newList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
