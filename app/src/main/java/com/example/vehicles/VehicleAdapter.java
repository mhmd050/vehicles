package com.example.vehicles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ViewHolder> {
    private ArrayList<com.example.vehicles.Vehicle>vehicles;
    ItemSelected activity;
    public interface ItemSelected{
        void onItemClicked(int Index);
    }
    public VehicleAdapter(Context context,ArrayList<com.example.vehicles.Vehicle> list){
        this.vehicles=list;
        activity=(ItemSelected)context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName =itemView.findViewById(R.id.tvName);
            imageView=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(vehicles.indexOf(view.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public VehicleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(vehicles.get(i));
        viewHolder.tvName.setText(vehicles.get(i).getName());
        viewHolder.imageView.setImageResource(vehicles.get(i).getImg());
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }

}

