package net.bintelligence.backeryapp.master_detail.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import net.bintelligence.backeryapp.databinding.MasterProductListElementBinding;
import net.bintelligence.backeryapp.databinding.MasterProductListFragmentBinding;
import net.bintelligence.backeryapp.pojo.Product;
import net.bintelligence.backeryapp.pojo.ProductResponse;

public class MasterProductListAdapter extends BaseAdapter {
    private ProductResponse productResponse;
    private Context context;
    private MasterProductListElementBinding binding;

    public MasterProductListAdapter(ProductResponse productResponse, Context context) {
        this.productResponse = productResponse;
        this.context = context;
    }

    @Override
    public int getCount() {
        if(productResponse == null)
            return 0;
        else
            return productResponse.getProducts().size();
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
        binding =  MasterProductListElementBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        binding.txtProductName.setText(productResponse.getProducts().get(position).getProductName());
        return binding.getRoot();
    }

    public void setProductResponse(ProductResponse productResponse){
        this.productResponse = productResponse;
    }


}
