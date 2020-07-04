package com.example.pglocator;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements Filterable {

    private Context mcontext;
    private List<Tiffin_Information> tiffinservices;
    private List<Tiffin_Information> tiffinservicesFilter;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView rowimageview;
        public TextView rowtextview, rowtextview2;
        ConstraintLayout rowlayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowimageview = itemView.findViewById(R.id.rowimageview);
            rowtextview = itemView.findViewById(R.id.rowtextview);
            rowtextview2 = itemView.findViewById(R.id.rowtextview2);
            rowlayout = itemView.findViewById(R.id.rowid);
        }

    }

    public RecyclerAdapter(Context mcontext, List<Tiffin_Information> tiffinservices) {
        this.mcontext = mcontext;
        this.tiffinservices = tiffinservices;
        this.tiffinservicesFilter = tiffinservicesFilter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //LayoutInflater layoutinflater = LayoutInflater.from(viewGroup.getContext());
        //View view = layoutinflater.inflate(R.layout.row_item, viewGroup, false);
        //ViewHolder viewholder = new ViewHolder(view);
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_tiffin, viewGroup, false);
        ViewHolder evh = new ViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        Tiffin_Information currentItem = tiffinservices.get(i);
        holder.rowtextview.setText(currentItem.getTsname());
        holder.rowtextview2.setText(currentItem.getTslocation());
        holder.rowimageview.setImageResource(currentItem.getThumbnail());

        holder.rowlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent into = new Intent(mcontext, Tiffin_Service_Displayer.class);

                into.putExtra("tsthumbnail", tiffinservices.get(i).getThumbnail());
                into.putExtra("tsname", tiffinservices.get(i).getTsname());
                into.putExtra("tsphonenumber", tiffinservices.get(i).getTsphonenumber());
                into.putExtra("tslocation", tiffinservices.get(i).getTslocation());
                into.putExtra("address", tiffinservices.get(i).getAddress());
                into.putExtra("tsfoodtype", tiffinservices.get(i).getTsfoodtype());
                into.putExtra("tsdescription", tiffinservices.get(i).getTsdescription());
                into.putExtra("tsprices", tiffinservices.get(i).getTsprices());
                into.putExtra("tsadditionalinfo", tiffinservices.get(i).getTsadditionalinfo());

                mcontext.startActivity(into);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tiffinservices.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Tiffin_Information> filteredList = new ArrayList<>();

                if(constraint == null || constraint.length() == 0){
                    filteredList.addAll(tiffinservicesFilter);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();

                    for (Tiffin_Information item: tiffinservicesFilter){
                        if (item.getTsname().toLowerCase().contains(filterPattern)){
                            filteredList.add(item);
                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                tiffinservices.clear();
                tiffinservices.addAll((List) results.values);
                notifyDataSetChanged();
            }
        };
    }

    /*@Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String character = constraint.toString();
                if(character.isEmpty()){
                    tiffinservicesFilter = tiffinservices;
                } else {
                    List<Tiffin_Information> filterList = new ArrayList<>();
                    for(Tiffin_Information tiffinInfo: tiffinservices){
                        if(tiffinInfo.getTsname().toLowerCase().contains(character.toLowerCase())){
                            filterList.add(tiffinInfo);
                        }
                    }
                    tiffinservicesFilter = filterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = tiffinservicesFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                tiffinservicesFilter = (ArrayList<Tiffin_Information>) results.values;
                notifyDataSetChanged();
            }
        };
    }*/

   /* @Override
    public Filter getFilter() {
        return examplefilter;
    }

    private Filter examplefilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Tiffin_Information> filteredlist = new ArrayList<>();

            if(constraint.toString().isEmpty()){
                filteredlist.addAll(tiffinservicescopy);
            }
            else{
                String filterpattern = constraint.toString().toLowerCase();

                for(Tiffin_Information item:tiffinservicescopy){
                    if(item.getTsname().toLowerCase().contains(filterpattern)){
                        filteredlist.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredlist;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
        tiffinservices.clear();
        tiffinservices.addAll((Collection<? extends Tiffin_Information>) results.values);
        notifyDataSetChanged();
        }
    };*/
}
