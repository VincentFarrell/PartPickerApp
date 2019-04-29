package app.vfarrell.pcpartpickerapp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.vfarrell.pcpartpickerapp.Constructors.CPU;
import app.vfarrell.pcpartpickerapp.Constructors.MOBO;
import app.vfarrell.pcpartpickerapp.R;

public class MOBOAdapter extends RecyclerView.Adapter<MOBOAdapter.MyViewHolder> {

    private List<MOBO> moboList;




    public MOBOAdapter(List<MOBO> moboList) {
        this.moboList = moboList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_list_rows, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MOBO mobo = moboList.get(position);
        holder.manufacturer.setText(mobo.getMoboManufacturer());
        holder.model.setText(mobo.getMoboModel());
        holder.info1.setText(mobo.getMoboSocketType());
        holder.info2.setText(mobo.getMoboChipset());
        holder.info3.setText(mobo.getMoboFormFactor());
        holder.info4.setText(mobo.getMoboMemoryType());
        holder.info5.setText(mobo.getMoboMemorySlots());
        holder.info6.setText(mobo.getMoboMemoryMax());

    }

    @Override
    public int getItemCount() {
        return moboList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView manufacturer, model, info1, info2, info3, info4, info5, info6;

        public MyViewHolder(View view) {
            super(view);
            manufacturer = (TextView) view.findViewById(R.id.manufac_text);
            model = (TextView) view.findViewById(R.id.model_text);
            info1 = (TextView) view.findViewById(R.id.info1_text);
            info2 = (TextView) view.findViewById(R.id.info2_text);
            info3 = (TextView) view.findViewById(R.id.info3_text);
            info4 = (TextView) view.findViewById(R.id.info4_text);
            info5 = (TextView) view.findViewById(R.id.info5_text);
            info6 = (TextView) view.findViewById(R.id.info6_text);
        }
    }
}