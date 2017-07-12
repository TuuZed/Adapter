package com.tuuzed.adapter.simple.provider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tuuzed.adapter.ItemProvider;
import com.tuuzed.adapter.simple.R;

/**
 * Created by LYH on 2017/2/22.
 *
 * @author LYH
 */
public class IntegerItemProvider extends ItemProvider<Integer, IntegerItemProvider.ViewHolder> {


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Integer item, int position) {
        holder.textView.setText("INTEGR =>" + item);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.item_integer, parent, false);
        return new IntegerItemProvider.ViewHolder(view);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
