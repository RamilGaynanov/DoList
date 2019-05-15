package com.example.dolist;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DoListItemTouchHelper.DoListItemTouchHelperListener {

    RecyclerView mDoList;
    DoListAdapter mDoListAdapter;
    List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDoList = findViewById(R.id.doList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mDoList.setLayoutManager(mLayoutManager);
        mDoList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mDoList.setItemAnimator(new DefaultItemAnimator());

        mDoListAdapter = new DoListAdapter(data);
        mDoList.setAdapter(mDoListAdapter);

        /*ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT)  {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        };

        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(mDoList);*/
        new ItemTouchHelper(new DoListItemTouchHelper(0, ItemTouchHelper.LEFT, this)).attachToRecyclerView(mDoList);
    }

    public void add_row_to_top(View view) {
        mDoListAdapter.addData(0, "New Row");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void add_row_to_bottom(View view) {
        mDoListAdapter.addData("New Row");
        mDoList.getLayoutManager().scrollToPosition(data.size()-1);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

    }
}
