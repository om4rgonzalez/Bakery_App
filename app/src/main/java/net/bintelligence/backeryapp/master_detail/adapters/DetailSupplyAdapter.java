package net.bintelligence.backeryapp.master_detail.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.bintelligence.backeryapp.databinding.DetailSupplyListElementBinding;
import net.bintelligence.backeryapp.databinding.MasterProductListElementBinding;
import net.bintelligence.backeryapp.pojo.Product;

public class DetailSupplyAdapter extends BaseAdapter {
    private Product product;
    private Context context;
    private DetailSupplyListElementBinding binding;

    public DetailSupplyAdapter(Product product, Context context) {
        this.product = product;
        this.context = context;
    }



    @Override
    public int getCount() {
        if(product == null)
            return 0;
        else
            return product.getElaborations().get(0).getSupplies().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        binding =  DetailSupplyListElementBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        binding.txtSupplyName.setText(product.getElaborations().get(0).getSupplies().get(position).getSupplyName());
        binding.txtSupplyQuantity.setText(product.getElaborations().get(0).getSupplies().get(position).getNewMeasureValue());
        binding.txtSupplyUnit.setText(product.getElaborations().get(0).getSupplies().get(position).getMeasureUnit());
        return binding.getRoot();
    }

    public void setProduct(Product product){
        this.product = product;
        notifyDataSetChanged();
    }
}
