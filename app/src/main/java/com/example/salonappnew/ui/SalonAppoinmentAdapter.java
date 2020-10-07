package com.example.salonappnew.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.salonappnew.R;
import com.example.salonappnew.models.CustomerAppoinment;

import java.util.ArrayList;

public class SalonAppoinmentAdapter extends BaseAdapter implements Filterable {


    Context c;
    ArrayList<CustomerAppoinment> originalArray,tmpArray;
    ///filter
    CustomFilter cs;
    ///filter
    String type;


    public SalonAppoinmentAdapter(Context c, ArrayList<CustomerAppoinment> originalArray){
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

        View row = inflater.inflate(R.layout.customer_appoinments_list,null);

        TextView txtSalonName =row.findViewById(R.id.txtSalonName);
        TextView txtDate = row.findViewById(R.id.txtDate);
        TextView txtTime = row.findViewById(R.id.txtTime);
        Button btnEdit = row.findViewById(R.id.btnEdit);
        Button btnDelete = row.findViewById(R.id.btnDelete);

        btnEdit.setVisibility(View.GONE);
        btnDelete.setVisibility(View.GONE);



        txtSalonName.setText(originalArray.get(position).getCustomerEmail());


        txtDate.setText(originalArray.get(position).getDate());

        txtTime.setText(originalArray.get(position).getTime());
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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


                ArrayList<CustomerAppoinment> filters = new ArrayList<>();

                for (int i = 0; i < tmpArray.size(); i++) {
                    if (tmpArray.get(i).getDate().toUpperCase().contains(constraint)) {
                        CustomerAppoinment singleRow = new CustomerAppoinment(tmpArray.get(i).getSalonName(),tmpArray.get(i).getDate(),tmpArray.get(i).getTime());



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
            originalArray  = (ArrayList<CustomerAppoinment>)results.values;
            notifyDataSetChanged();
        }
    }
    ///Codes for filter


}
