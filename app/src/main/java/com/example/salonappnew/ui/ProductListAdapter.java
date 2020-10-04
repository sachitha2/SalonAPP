package com.example.salonappnew.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.salonappnew.R;
import com.example.salonappnew.models.CustomerAppoinment;
import com.example.salonappnew.models.Product;

import java.util.ArrayList;

public class ProductListAdapter extends BaseAdapter implements Filterable {


    Context c;
    ArrayList<Product> originalArray,tmpArray;
    ///filter
    CustomFilter cs;
    ///filter



    public ProductListAdapter(Context c, ArrayList<Product> originalArray){
        this.c = c;
        this.originalArray = originalArray;
        this.tmpArray = originalArray;
    }


    @Override
    public Object getItem(int position) {
        return originalArray.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.product_list,null);

        TextView productName =row.findViewById(R.id.txtProductName);


        productName.setText(originalArray.get(position).getpName());
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //TODO setup on click
            }
        });

        return row;
    }

    @Override
    public int getCount() {
        return originalArray.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    ///Codes for filter
    @Override
    public Filter getFilter() {

        if(cs == null){
            cs = new CustomFilter();
        }

        return cs;
    }

    class CustomFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if(constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();


                ArrayList<Product> filters = new ArrayList<>();

                for (int i = 0; i < tmpArray.size(); i++) {
                    if (tmpArray.get(i).getpName().toUpperCase().contains(constraint)) {
                        Product singleRow = new Product(tmpArray.get(i).getpName(),"",50,"","");
                        filters.add(singleRow);


                    }



                }
                results.count = filters.size();
                results.values = filters;

            }else {
                results.count = tmpArray.size();
                results.values = tmpArray;

            }
            return results;
        }


        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            originalArray  = (ArrayList<Product>)results.values;
            notifyDataSetChanged();
        }
    }
    ///Codes for filter


}
