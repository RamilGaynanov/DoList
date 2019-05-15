package com.example.dolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DoListAdapter extends RecyclerView.Adapter<DoListAdapter.DoListViewHolder> {
    private List<String> data;

    public DoListAdapter(List<String> data){
        this.data = data;
    }
    public class DoListViewHolder extends RecyclerView.ViewHolder{
        EditText etDoText;
        TextView tvDoText;
        RelativeLayout view_foreground, view_background;

        public DoListViewHolder(@NonNull View itemView) {
            super(itemView);
            /*view_foreground = itemView.findViewById(R.id.view_foreground);
            view_background = itemView.findViewById(R.id.view_background);*/

           /* etDoText = (EditText) itemView.findViewById(R.id.do_text);
            etDoText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    data.set(getAdapterPosition(), s.toString());
                }
            });*/
            tvDoText = itemView.findViewById(R.id.do_text);
            /*ImageButton btn = itemView.findViewById(R.id.iBtnDelete);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    data.remove(position);
                    notifyItemRemoved(position);
                }
            });*/
        }
    }
    @NonNull
    @Override
    public DoListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.do_list_row, parent, false);

        return new DoListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DoListViewHolder holder, int position) {
        String row = data.get(position);
        holder.tvDoText.setText(row);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addData(int index, String s){
        data.add(index, s);
        notifyItemInserted(index);
        notifyDataSetChanged();
    }
    public void addData(String s){
        data.add(s);
        notifyItemInserted(data.size()-1);
    }
}
