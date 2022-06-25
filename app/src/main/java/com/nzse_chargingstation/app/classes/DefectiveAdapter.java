package com.nzse_chargingstation.app.classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nzse_chargingstation.app.R;

import java.util.ArrayList;
import java.util.List;

public class DefectiveAdapter extends RecyclerView.Adapter<DefectiveAdapter.defectiveHolder> {

    public DefectiveAdapter(Context context)
    {
        this.mContext = context;
    }
    private List<Defective> defectiveList = new ArrayList<>();
    private final Context mContext;

    @NonNull
    @Override
    public defectiveHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_defective, parent, false);
        return new defectiveHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull defectiveHolder holder, int position) {
        Defective currentDefective = defectiveList.get(position);
        String distance;
        String name = currentDefective.getDefectiveCs().getStrasse() + ' ' + currentDefective.getDefectiveCs().getHausnummer();
        holder.tvDefectiveAddress.setText(name);
        String city = currentDefective.getDefectiveCs().getPostleitzahl() + ", " + currentDefective.getDefectiveCs().getOrt();
        holder.tvDefectiveCity.setText(city);
        if(ContainerAndGlobal.getCurrentLocation() != null)
            distance = ContainerAndGlobal.df.format(ContainerAndGlobal.calculateLength(currentDefective.getDefectiveCs().getLocation(), ContainerAndGlobal.getCurrentLocation())) + " KM";
        else
            distance = mContext.getResources().getString(R.string.distance) + " : " + mContext.getResources().getString(R.string.unknown);
        holder.tvDefectiveReason.setText(currentDefective.getReason());
        holder.tvDistance.setText(distance);
        if(!currentDefective.isMarked())
            holder.btnMarkToRepair.setText(mContext.getResources().getString(R.string.mark));
        else
            holder.btnMarkToRepair.setText(mContext.getResources().getString(R.string.finish));

        holder.btnMarkToRepair.setOnClickListener(v -> {
            if(!currentDefective.isMarked())
            {
                currentDefective.setMarked(true);
                notifyItemChanged(holder.getAdapterPosition());
                Toast.makeText(v.getContext(), mContext.getResources().getString(R.string.successfully_marked), Toast.LENGTH_SHORT).show();
            }
            else
            {
                ContainerAndGlobal.removeDefective(currentDefective);
                ContainerAndGlobal.saveData(false, v.getContext());
                notifyItemRemoved(holder.getAdapterPosition());
                Toast.makeText(v.getContext(), mContext.getResources().getString(R.string.successfully_repaired), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return defectiveList.size();
    }

    public void setDefectiveList(List<Defective> defectives)
    {
        this.defectiveList = defectives;
        notifyItemRangeChanged(0, defectives.size());
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class defectiveHolder extends RecyclerView.ViewHolder {
        private final TextView tvDefectiveAddress;
        private final TextView tvDefectiveReason;
        private final TextView tvDefectiveCity;
        private final TextView tvDistance;
        private final Button btnMarkToRepair;

        public defectiveHolder(@NonNull View itemView) {
            super(itemView);
            tvDefectiveAddress = itemView.findViewById(R.id.textViewDefectiveAddress);
            tvDefectiveReason = itemView.findViewById(R.id.textViewDefectiveReason);
            tvDefectiveCity = itemView.findViewById(R.id.textViewDefectiveCity);
            tvDistance = itemView.findViewById(R.id.textViewDistance);
            btnMarkToRepair = itemView.findViewById(R.id.buttonMarkToRepair);
        }
    }

}
