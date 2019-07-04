package com.tranduc.smacthuctap.view.MainActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tranduc.smacthuctap.R;
import com.tranduc.smacthuctap.model.MainActivity;

import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    private List<MainActivity> activityList;
    private Context context;
    private OnClickListener onClickListener;

    public void setListener(OnClickListener listener){
        this.onClickListener = listener;
    }

    public MainActivityAdapter(List<MainActivity> activityList1, Context context){
        this.activityList = activityList1;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_button, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final MainActivity mainActivity = activityList.get(position);
        holder.tvItemButton.setText(mainActivity.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener!=null){
                    onClickListener.onClickItem(mainActivity, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvItemButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemButton = itemView.findViewById(R.id.tvItemButton);
        }
    }
    public interface OnClickListener{
        void onClickItem(MainActivity mainActivity, int position);
    }
}
