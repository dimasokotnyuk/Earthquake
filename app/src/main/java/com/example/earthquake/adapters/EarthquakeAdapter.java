package com.example.earthquake.adapters;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.earthquake.model.Earthquake;
import com.example.earthquake.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder> {

    private List<Earthquake> earthquakes;

    private Context context;

    private static final String LOCATION_SEPARATOR = " of ";

    OnEarthquakeClickListener onEarthquakeClickListener;



    public interface OnEarthquakeClickListener{
        void onEarthquakeClickListener(int position);
    }

    public void setOnEarthquakeClickListener(OnEarthquakeClickListener onEarthquakeClickListener) {
        this.onEarthquakeClickListener = onEarthquakeClickListener;
    }

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
        notifyDataSetChanged();
    }

    public EarthquakeAdapter(Context context) {
        super();
        this.context=context;
    }

    @NonNull
    @Override
    public EarthquakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EarthquakeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.earthquake_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EarthquakeViewHolder holder, int position) {
        Earthquake earthquake = earthquakes.get(position);
        getMagnitudeColor(holder,earthquake,context);
        holder.tvMagnitude.setText(Double.toString((double) Math.round(earthquake.getMagnitude() * 10) / 10));
        if (earthquake.getLocation().contains(LOCATION_SEPARATOR)) {
            String[] parts = earthquake.getLocation().split(" of ");
            String[] partsSecond = parts[1].split(",");
            holder.tvLocationOffset.setText(parts[0] + LOCATION_SEPARATOR);
            holder.tvLocationPrimary.setText(partsSecond[0] + ","  + partsSecond[1]);
        } else {
            holder.tvLocationOffset.setText(R.string.near_the);
            holder.tvLocationPrimary.setText(earthquake.getLocation());
        }
        Date dateObject = new Date(earthquake.getTime());
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd MMMM yyyy");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
        String formattedDate = sdfDate.format(dateObject);
        String formattedTime = sdfTime.format(dateObject);
        holder.tvDate.setText(formattedDate);
        holder.tvTime.setText(formattedTime);
    }

    @Override
    public int getItemCount() {
        return earthquakes == null ? 0 : earthquakes.size();
    }

    class EarthquakeViewHolder extends RecyclerView.ViewHolder {

        private TextView tvMagnitude;
        private TextView tvLocationOffset;
        private TextView tvLocationPrimary;
        private TextView tvDate;
        private TextView tvTime;

        private GradientDrawable magnitudeCircle ;

        public EarthquakeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMagnitude = itemView.findViewById(R.id.tvMagnitude);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvLocationPrimary = itemView.findViewById(R.id.tvLocationPrimary);
            tvLocationOffset = itemView.findViewById(R.id.tvLocationOffset);
            tvTime = itemView.findViewById(R.id.tvTime);
            magnitudeCircle= (GradientDrawable) tvMagnitude.getBackground();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onEarthquakeClickListener!=null){
                        onEarthquakeClickListener.onEarthquakeClickListener(getAdapterPosition());
                    }
                }
            });
        }
    }

    private void getMagnitudeColor(EarthquakeViewHolder holder, Earthquake earthquake,Context context) {
        switch ((int) earthquake.getMagnitude()) {
            case 0:
            case 1:
                holder.magnitudeCircle.setColor(context.getResources().getColor(R.color.magnitude1));
                break;
            case 2:
                holder.magnitudeCircle.setColor(context.getResources().getColor(R.color.magnitude2));
                break;
            case 3:
                holder.magnitudeCircle.setColor(context.getResources().getColor(R.color.magnitude3));
                break;
            case 4:
                holder.magnitudeCircle.setColor(context.getResources().getColor(R.color.magnitude4));
                break;
            case 5:
                holder.magnitudeCircle.setColor(context.getResources().getColor(R.color.magnitude5));
                break;
            case 6:
                holder.magnitudeCircle.setColor(context.getResources().getColor(R.color.magnitude6));
                break;
            case 7:
                holder.magnitudeCircle.setColor(context.getResources().getColor(R.color.magnitude7));
                break;
            case 8:
                holder.magnitudeCircle.setColor(context.getResources().getColor(R.color.magnitude8));
                break;
            case 9:
                holder.magnitudeCircle.setColor(context.getResources().getColor(R.color.magnitude9));
                break;
            default:
                holder.magnitudeCircle.setColor(context.getResources().getColor(R.color.magnitude10plus));
                break;
        }
    }
}


