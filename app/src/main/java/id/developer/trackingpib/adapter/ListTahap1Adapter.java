package id.developer.trackingpib.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.developer.trackingpib.R;
import id.developer.trackingpib.model.Tahap1Model;

public class ListTahap1Adapter extends RecyclerView.Adapter<ListTahap1Adapter.ViewHolder> {
    private Context context;
    private List<Tahap1Model> tahapList;
    private Listener listener;

    public ListTahap1Adapter(Context context, Listener listener) {
        this.context = context;
        this.listener = listener;
        tahapList = new ArrayList<>();
    }

    public void setData(List<Tahap1Model> pibList) {
        this.tahapList = pibList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.noPib.setText("Pib number " + tahapList.get(i).getNoPib());
        viewHolder.kpbc.setText("Invoice " + tahapList.get(i).getInvoice());
    }

    @Override
    public int getItemCount() {
        return tahapList == null ? 0 : tahapList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView noPib, kpbc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            noPib = itemView.findViewById(R.id.no_pib);
            kpbc = itemView.findViewById(R.id.kpbc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(tahapList.get(getAdapterPosition()));
        }

    }

    public interface Listener{
        void onClick(Tahap1Model dataPosition);
    }
}
