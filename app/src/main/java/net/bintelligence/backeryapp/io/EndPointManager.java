package net.bintelligence.backeryapp.io;

import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import net.bintelligence.backeryapp.master_detail.viewmodel.ProductViewModel;
import net.bintelligence.backeryapp.pojo.Product;
import net.bintelligence.backeryapp.pojo.ProductResponse;
import net.bintelligence.backeryapp.pojo.ProductionRequest;
import net.bintelligence.backeryapp.pojo.StandarResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EndPointManager {

    public static void getProducts(ProductViewModel viewModel){
        Call<ProductResponse> call = RetrofitApiAdapter.getApiService().getProducts();
        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(response.isSuccessful()){
                    ProductResponse productResponse =response.body();
                    viewModel.setProductResponseMutableLiveData(productResponse);
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                viewModel.setProductResponseMutableLiveData(null);
            }
        });
    }

    public static void startProduction(ProductionRequest productionRequest){
        Call<StandarResponse> call = RetrofitApiAdapter.getApiService().startProduction(productionRequest);
        call.enqueue(new Callback<StandarResponse>() {
            @Override
            public void onResponse(Call<StandarResponse> call, Response<StandarResponse> response) {
            }

            @Override
            public void onFailure(Call<StandarResponse> call, Throwable t) {
            }
        });

    }
}
