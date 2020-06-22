package net.bintelligence.backeryapp.master_detail;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import net.bintelligence.backeryapp.R;
import net.bintelligence.backeryapp.databinding.MasterProductListFragmentBinding;
import net.bintelligence.backeryapp.master_detail.adapters.MasterProductListAdapter;
import net.bintelligence.backeryapp.master_detail.viewmodel.ProductViewModel;
import net.bintelligence.backeryapp.pojo.ProductResponse;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MasterProductListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MasterProductListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private MasterProductListFragmentBinding binding;
    private ProductResponse productResponse;
    private ProductViewModel productViewModel;
    private MasterProductListAdapter adapter;

    public MasterProductListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MasterProductListLandFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MasterProductListFragment newInstance(String param1, String param2) {
        MasterProductListFragment fragment = new MasterProductListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = MasterProductListFragmentBinding.inflate(getLayoutInflater());


        productViewModel = new ViewModelProvider(getActivity()).get(ProductViewModel.class);
        adapter = new MasterProductListAdapter(productResponse, getContext());
        binding.ProductList.setAdapter(adapter);
        final Observer<ProductResponse> observer = productResponse -> {
            adapter.setProductResponse(productResponse);
            adapter.notifyDataSetChanged();
            this.productResponse = productResponse;
        };
        productViewModel.getProductResponse().observe(getActivity(), observer);
        binding.ProductList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                productViewModel.setProduct(position);
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                    Bundle b = new Bundle();
                    b.putSerializable("product", productResponse.getProducts().get(position));
                    Navigation.findNavController(view).navigate(R.id.action_masterProductListFragment_to_detailTabContainerFragment, b);
                }
            }
        });

        productViewModel.getMaster(productViewModel);


        return binding.getRoot();
    }
}