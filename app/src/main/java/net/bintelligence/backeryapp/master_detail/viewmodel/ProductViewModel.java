package net.bintelligence.backeryapp.master_detail.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import net.bintelligence.backeryapp.io.EndPoint;
import net.bintelligence.backeryapp.pojo.Elaboration;
import net.bintelligence.backeryapp.pojo.Process;
import net.bintelligence.backeryapp.pojo.Product;
import net.bintelligence.backeryapp.pojo.ProductResponse;
import net.bintelligence.backeryapp.pojo.Supply;

import java.util.ArrayList;

public class ProductViewModel extends ViewModel {
    private MutableLiveData<ProductResponse> productResponseMutableLiveData;
    private MutableLiveData<Product> productMutableLiveData;
    private String TAG = "viewModel";

    public ProductViewModel() {
        this.productResponseMutableLiveData = new MutableLiveData<>();
        this.productMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<ProductResponse> getProductResponse() {
        return productResponseMutableLiveData;
    }

    public LiveData<Product> getProduct(){
        return productMutableLiveData;
    }

    public Product getProduct_(){
        return productMutableLiveData.getValue();
    }

    public void setProductResponseMutableLiveData(ProductResponse productResponse){
        productResponseMutableLiveData.setValue(productResponse);
        if(productResponse.isOk()){
            if(productResponse.getProducts().size()> 0){
                productMutableLiveData.setValue(productResponse.getProducts().get(0));
                calculateSuppliesForProduction(1);
            }
        }
    }

    public void getMaster(ProductViewModel productViewModel){
        EndPoint.getProducts(productViewModel);
    }

    public void setProduct(int index){
        if(index == -1){
            productMutableLiveData.setValue(null);
        }
        else{
            productMutableLiveData.setValue(productResponseMutableLiveData.getValue().getProducts().get(index));
        }

    }

    public void calculateSuppliesForProduction(double q){
        if(productMutableLiveData.getValue() != null){
            ArrayList<Supply> supplies = new ArrayList<>();
            for(Supply supply: productMutableLiveData.getValue().getElaborations().get(0).getSupplies()){
                supply.setNewMeasureValue(String.valueOf(Double.parseDouble(supply.getMeasureValue()) * q));
                supplies.add(supply);
            }
            productMutableLiveData.getValue().getElaborations().get(0).setSupplies(supplies);
            productMutableLiveData.setValue(productMutableLiveData.getValue());
        }

    }

    private ProductResponse getProductResponse_(){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setOk(true);
        productResponse.setMessage("Mensaje de prueba");
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Elaboration> elaborations = new ArrayList<>();

        Elaboration e = new Elaboration();
        e.setElaborationId(1);
        e.setElaborationName("ELABORACION DEL FELIPE");

        Process pro = new Process();
        pro.setProcessId(1);
        pro.setProcessName("AMASADO");
        pro.setWorkingUnit("MINUTOS");
        pro.setWorkingValue("20");

        Process pro1 = new Process();
        pro1.setProcessId(2);
        pro1.setProcessName("ESTIRADO");
        pro1.setWorkingUnit("MINUTOS");
        pro1.setWorkingValue("20");

        Process pro2 = new Process();
        pro2.setProcessId(3);
        pro2.setProcessName("LEUDADO");
        pro2.setWorkingUnit("HORAS");
        pro2.setWorkingValue("3");

        Process pro3 = new Process();
        pro3.setProcessId(4);
        pro3.setProcessName("HORNEADO");
        pro3.setWorkingUnit("MINUTOS");
        pro3.setWorkingValue("30");

        ArrayList<Process> processes = new ArrayList<>();
        processes.add(pro);
        processes.add(pro1);
        processes.add(pro2);
        processes.add(pro3);

        Supply s = new Supply();
        s.setSupplyId(1);
        s.setSupplyName("HARINA 00000");
        s.setMeasureUnit("KG");
        s.setMeasureValue("1");

        Supply s1 = new Supply();
        s1.setSupplyId(2);
        s1.setSupplyName("SAL");
        s1.setMeasureUnit("GRAMO");
        s1.setMeasureValue("100");

        Supply s2 = new Supply();
        s2.setSupplyId(3);
        s2.setSupplyName("AGUA");
        s2.setMeasureUnit("LITRO");
        s2.setMeasureValue("1");

        Supply s3 = new Supply();
        s3.setSupplyId(4);
        s3.setSupplyName("LEVADURA");
        s3.setMeasureUnit("GRAMO");
        s3.setMeasureValue("25");

        Supply s4 = new Supply();
        s4.setSupplyId(5);
        s4.setSupplyName("GRASA");
        s4.setMeasureUnit("KG");
        s4.setMeasureValue("1");

        ArrayList<Supply> supplies = new ArrayList<>();
        supplies.add(s);
        supplies.add(s1);
        supplies.add(s2);
        supplies.add(s3);
        supplies.add(s4);

        e.setProcess(processes);
        e.setSupplies(supplies);

        elaborations.add(e);

        Product p = new Product();
        p.setProductId(1);
        p.setProductName("FELIPE");
        p.setDescription("FELIPE");
        p.setElaborations(elaborations);

        products.add(p);

        productResponse.setProducts(products);

        return productResponse;
    }
}
