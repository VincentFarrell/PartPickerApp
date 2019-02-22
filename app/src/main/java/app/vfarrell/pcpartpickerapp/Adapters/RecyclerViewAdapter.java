package app.vfarrell.pcpartpickerapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.vfarrell.pcpartpickerapp.Constructors.CPU;
import app.vfarrell.pcpartpickerapp.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<CPU> cpusList;
    private Context context;




    public RecyclerViewAdapter(List<CPU> cpusList, Context context) {
        this.cpusList = cpusList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_list_rows, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CPU cpu = cpusList.get(position);
        holder.manufacturer.setText(cpu.getCpuManufacturer());
        holder.model.setText(cpu.getCpuModel());
        holder.info1.setText(cpu.getCpuCores());
        holder.info2.setText(cpu.getCpuMemory());
        holder.info3.setText(cpu.getCpuClock());
        holder.info4.setText(cpu.getCpuBoost());
        holder.info5.setText(cpu.getCpuTDP());
        holder.info6.setText(cpu.getCpuSocket());

    }

    @Override
    public int getItemCount() {
        return cpusList.size();
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