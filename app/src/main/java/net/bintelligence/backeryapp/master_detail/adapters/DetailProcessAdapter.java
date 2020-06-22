package net.bintelligence.backeryapp.master_detail.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import net.bintelligence.backeryapp.MainActivity;
import net.bintelligence.backeryapp.databinding.DetailProcessListElementBinding;
import net.bintelligence.backeryapp.master_detail.viewmodel.ProductViewModel;
import net.bintelligence.backeryapp.pojo.Product;

public class DetailProcessAdapter extends BaseAdapter {
    private Product product;
    private Context context;
    private DetailProcessListElementBinding binding;
    private ProductViewModel productViewModel;

    public DetailProcessAdapter(Product product, Context context) {
        this.product = product;
        this.context = context;
    }

    @Override
    public int getCount() {
        if(product == null){
            return 0;
        }
        else{
            return product.getElaborations().get(0).getProcess().size();
        }

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
        binding = DetailProcessListElementBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        binding.txtOrderId.setText(String.valueOf(position + 1));
        binding.txtProcessName.setText(product.getElaborations().get(0).getProcess().get(position).getProcessName());
        binding.txtProcessQuantity.setText(product.getElaborations().get(0).getProcess().get(position).getWorkingValue());
        binding.txtProcessUnit.setText(product.getElaborations().get(0).getProcess().get(position).getWorkingUnit());
        return binding.getRoot();
    }

    public void setProduct(Product product){
        this.product = product;
        this.notifyDataSetChanged();
    }
}
