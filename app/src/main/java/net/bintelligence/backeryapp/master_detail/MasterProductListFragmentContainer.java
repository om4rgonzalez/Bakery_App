package net.bintelligence.backeryapp.master_detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.bintelligence.backeryapp.databinding.MasterProductListFragmentContainerBinding;
import net.bintelligence.backeryapp.master_detail.adapters.MasterProductListAdapter;
import net.bintelligence.backeryapp.master_detail.viewmodel.ProductViewModel;
import net.bintelligence.backeryapp.pojo.ProductResponse;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MasterProductListFragmentContainer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MasterProductListFragmentContainer extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MasterProductListFragmentContainerBinding binding;

    private ProductResponse productResponse;
    private ProductViewModel productViewModel;
    private MasterProductListAdapter adapter;

    public MasterProductListFragmentContainer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MasterProductListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MasterProductListFragmentContainer newInstance(String param1, String param2) {
        MasterProductListFragmentContainer fragment = new MasterProductListFragmentContainer();
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
        binding = MasterProductListFragmentContainerBinding.inflate(getLayoutInflater());

//        productViewModel = new ViewModelProvider(getActivity()).get(ProductViewModel.class);
//        adapter = new MasterProductListPortraidAdapter(productResponse, getContext());
//        binding.ProductList.setAdapter(adapter);
//        final Observer<ProductResponse> observer = productResponse -> {
//                adapter.setProductResponse(productResponse);
//                adapter.notifyDataSetChanged();
//        };
//        productViewModel.getProductResponse().observe(getActivity(), observer);
//        productViewModel.getMaster();
//
//        binding.ProductList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.v(" Master", "Set product in "+position);
//                productViewModel.setProduct(position);
//                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
//                    Navigation.findNavController(view).navigate(R.id.action_masterProductListFragment_to_detailTabContainerFragment);
//                }
//            }
//        });
//
//        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
//            productViewModel.setProduct(0);
//        }
//        else{
//            productViewModel.setProduct(-1);
//        }


        return binding.getRoot();
    }


}