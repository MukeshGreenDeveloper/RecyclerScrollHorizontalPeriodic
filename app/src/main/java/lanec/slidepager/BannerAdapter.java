package lanec.slidepager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> implements Filterable {
    private ArrayList<String> rechargeReportModels;

    private ArrayList<String> filteredData = null;
    MainActivity activity;

    public BannerAdapter(MainActivity activity,ArrayList<String> android) {
        this.rechargeReportModels = android;
        this.activity = activity;

        this.filteredData = new ArrayList<String>();
        this.filteredData.addAll(rechargeReportModels);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.banner_view, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapter.ViewHolder viewHolder, int position) {
        viewHolder.imv_banner.setBackgroundResource(position == 0 ? R.drawable.image_one : position == 1 ? R.drawable.image_two : R.drawable.image_three);
//        Glide.with(activity)
//                .load("http://")
//                .centerCrop()
//                .placeholder(position == 0 ? R.drawable.image_one : position == 1 ? R.drawable.image_two : R.drawable.image_three)
//                .into(viewHolder.imv_banner);

    }


    @Override
    public int getItemCount() {
        return rechargeReportModels.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imv_banner;
        public Context mContext;


        public ViewHolder(View view) {
            super(view);
            imv_banner = view.findViewById(R.id.imv_banner);
            mContext = view.getContext();
        }
    }


}
