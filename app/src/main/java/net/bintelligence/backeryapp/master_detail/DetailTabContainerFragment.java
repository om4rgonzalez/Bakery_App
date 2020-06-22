package net.bintelligence.backeryapp.master_detail;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import net.bintelligence.backeryapp.R;
import net.bintelligence.backeryapp.databinding.DetailTabContainerFragmentBinding;
import net.bintelligence.backeryapp.master_detail.adapters.DetailSupplyAdapter;
import net.bintelligence.backeryapp.master_detail.adapters.ViewPagerAdapter;
import net.bintelligence.backeryapp.master_detail.viewmodel.ProductViewModel;
import net.bintelligence.backeryapp.pojo.Elaboration;
import net.bintelligence.backeryapp.pojo.Process;
import net.bintelligence.backeryapp.pojo.Product;
import net.bintelligence.backeryapp.pojo.ProductResponse;
import net.bintelligence.backeryapp.pojo.Supply;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailTabContainerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailTabContainerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DetailTabContainerFragmentBinding binding;
    private DetailProcessProductListFragment detailProcessProductListFragment;
    private DetailSupplyListFragment detailSupplyListFragment;
    private ProductViewModel productViewModel;
    private ViewPagerAdapter viewPagerAdapter;
    private Product product;

    public DetailTabContainerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabContainerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailTabContainerFragment newInstance(String param1, String param2) {
        DetailTabContainerFragment fragment = new DetailTabContainerFragment();
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
        // Inflate the layout for this fragment
        binding = DetailTabContainerFragmentBinding.inflate(getLayoutInflater());
        productViewModel = new ViewModelProvider(getActivity()).get(ProductViewModel.class);
        viewPagerAdapter = new ViewPagerAdapter(getActivity());
        detailProcessProductListFragment = new DetailProcessProductListFragment();
        detailSupplyListFragment = new DetailSupplyListFragment();
        viewPagerAdapter.addFragment(detailSupplyListFragment, getString(R.string.txtTabSupplyList));
        viewPagerAdapter.addFragment(detailProcessProductListFragment, getString(R.string.txtTabProcessList));

        binding.viewPager2.setAdapter(viewPagerAdapter);
        TabLayoutMediator mediator = new TabLayoutMediator(binding.tab, binding.viewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText(getText(R.string.txtSupplyTab));
                    tab.setIcon(R.drawable.ic_supply_2);
                    break;
                case 1:
                    tab.setText(getText(R.string.txtProessTab));
                    tab.setIcon(R.drawable.ic_process);
                    break;
            }
        });
        mediator.attach();
        binding.txtProductionQuantity.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productViewModel.calculateSuppliesForProduction(Double.parseDouble(binding.txtProductionQuantity.getEditText().getText().toString()));
            }
        });
        binding.txtProductionQuantity.getEditText().setText("1");
        productViewModel.calculateSuppliesForProduction(Double.parseDouble(binding.txtProductionQuantity.getEditText().getText().toString()));

        return binding.getRoot();
    }


}