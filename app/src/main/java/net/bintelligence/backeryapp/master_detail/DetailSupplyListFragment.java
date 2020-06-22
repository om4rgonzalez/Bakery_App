package net.bintelligence.backeryapp.master_detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.bintelligence.backeryapp.R;
import net.bintelligence.backeryapp.databinding.DetailSupplyListFragmentBinding;
import net.bintelligence.backeryapp.master_detail.adapters.DetailProcessAdapter;
import net.bintelligence.backeryapp.master_detail.adapters.DetailSupplyAdapter;
import net.bintelligence.backeryapp.master_detail.viewmodel.ProductViewModel;
import net.bintelligence.backeryapp.pojo.Elaboration;
import net.bintelligence.backeryapp.pojo.Process;
import net.bintelligence.backeryapp.pojo.Product;
import net.bintelligence.backeryapp.pojo.ProductResponse;
import net.bintelligence.backeryapp.pojo.Supply;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailSupplyListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailSupplyListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DetailSupplyListFragmentBinding binding;
    private DetailSupplyAdapter detailSupplyAdapter;
    private Product product;
    private ProductViewModel productViewModel;

    public DetailSupplyListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailSupplyListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailSupplyListFragment newInstance(String param1, String param2) {
        DetailSupplyListFragment fragment = new DetailSupplyListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DetailSupplyListFragmentBinding.inflate(getLayoutInflater());
        detailSupplyAdapter = new DetailSupplyAdapter(product, getContext());
        binding.listSupplyItem.setAdapter(detailSupplyAdapter);
        productViewModel = new ViewModelProvider(getActivity()).get(ProductViewModel.class);
        final Observer<Product> observer = product -> {
            detailSupplyAdapter.setProduct(product);
            detailSupplyAdapter.notifyDataSetChanged();
        };
        productViewModel.getProduct().observe(getActivity(), observer);
        return binding.getRoot();
    }
}