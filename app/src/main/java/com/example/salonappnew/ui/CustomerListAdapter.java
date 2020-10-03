package com.example.salonappnew.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salonappnew.R;
import com.example.salonappnew.models.Company;

import java.util.ArrayList;

public class CustomerListAdapter extends BaseAdapter implements Filterable {


    Context c;
    ArrayList<Company> originalArray,tmpArray;
    ///filter
    CustomFilter cs;
    ///filter



    public CustomerListAdapter(Context c, ArrayList<Company> originalArray){
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

        View row = inflater.inflate(R.layout.customer_list,null);

        TextView textView =(TextView)row.findViewById(R.id.id);
        TextView textAge = row.findViewById(R.id.txtCID);
        TextView textNic = row.findViewById(R.id.txtNic);
        TextView textArea = row.findViewById(R.id.txtArea);


        textView.setText(originalArray.get(position).getAddress());
        textAge.setText(originalArray.get(position).getCompanyName());

        textNic.setText(originalArray.get(position).getEmail());
        textArea.setText(originalArray.get(position).getPhone());
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intentCustomerProfile = new Intent(c, CustomerData.class);
//
//
//
//                //TODO Config putExtra variables here
//                intentCustomerProfile.putExtra("customerId", originalArray.get(position).getAge());
//                c.startActivity(intentCustomerProfile);
//                Toast.makeText(c, originalArray.get(position).getName() + " was clicked", Toast.LENGTH_SHORT).show();
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


                ArrayList<Company> filters = new ArrayList<>();

                for (int i = 0; i < tmpArray.size(); i++) {
                    if (tmpArray.get(i).getCompanyName().toUpperCase().contains(constraint)) {
                        Company singleRow = new Company(tmpArray.get(i).getCompanyName(),tmpArray.get(i).getCompanyName(),tmpArray.get(i).getPhone(),tmpArray.get(i).getEmail());



                        filters.add(singleRow);




                    }

                    if (tmpArray.get(i).getPhone().toUpperCase().contains(constraint)) {
                        Company singleRow = new Company(tmpArray.get(i).getCompanyName(),tmpArray.get(i).getCompanyName(),tmpArray.get(i).getPhone(),tmpArray.get(i).getEmail());



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
            originalArray  = (ArrayList<Company>)results.values;
            notifyDataSetChanged();
        }
    }
    ///Codes for filter
}
