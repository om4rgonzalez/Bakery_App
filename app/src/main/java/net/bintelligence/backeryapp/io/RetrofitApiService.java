package net.bintelligence.backeryapp.io;

import net.bintelligence.backeryapp.pojo.ProductResponse;
import net.bintelligence.backeryapp.pojo.ProductionRequest;
import net.bintelligence.backeryapp.pojo.StandarResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitApiService {

////    @FormUrlEncoded
////    @PUT("/dispositivo/")
////    Call<Telefono> registrarDispositivo(@Field("email") String email, @Field("imei") String imei);
//
    @GET("/products")
    Call<ProductResponse> getProducts();

    @POST("/production/")
    Call<StandarResponse> startProduction(@Body() ProductionRequest production );

//
//    @GET("/productos/")
//    Call<ProductoResponse> getProductos(@Query("id_usuario") int id_usuario);
//
//    @GET("/pedidos/usuario/")
//    Call<ListaPedidoResponse> getPedidosUsuario(@Query("id_usuario") int id_usuario);
////
////
////    @FormUrlEncoded
////    @POST("auth/login/v1")
////    Call<LoginResponse> login(@Field("email") String email, @Field("password") String password);
////
//
//    /////////////// llamadas al api gateway ///////////////
//    @FormUrlEncoded
//    @POST("/ml/login/")
//    Call<LoginResponse> login(@Field("email") String email, @Field("google_id") String google_id, @Field("origen") String origen);
//
//    @GET("/ml/cliente/configuraciones/")
//    Call<ConfiguracionesResponse> getConfiguracionesNuevoCliente();
//
//    @POST("/ml/cliente/")
//    Call<StandarResponse> insertCustomerAccount(@Body() CustomerSend customerSend);
//
//    @POST("/ml/vendedor/primer_login/")
//    Call<LoginResponse> firstLogin(@Body() CustomerSend customerSend);
//
//    @GET("/ml/cliente/configuraciones_post_login/")
//    Call<AdressResponse> getDatosDireccion();
//
//    @POST("/ml/cliente/post_primer_login/")
//    Call<StandarResponse> postFirstLogin(@Body() CustomerSend customerSend);
//
//    @GET("/ml/familia_productos/")
//    Call<ProductFamilyResponse> getProductsFamily();
//
//    @GET("/ml/productos_por_familia/")
//    Call<ProductFromFamilyResponse> getProductsByFamily(@Query("idFamilia") int idFamilia);
//
//    @POST("/ml/pedido/")
//    Call<NewOrderResponse> newOrder(@Body() OrderSend orderSend);
//
//    @GET("/ml/proveedor/dias_envio/")
//    Call<DeliveryDaysResponse> getDeliveryDays(@Query("idCuenta") int idCuenta);
//
//    @GET("/ml/pedidos/vendedor/")
//    Call<SellerOrderResponse> getSellerOrders(@Query("id_cuenta_vendedora") int idCuenta, @Query("id_pedido_estado") int idEstado, @Query("filtro") String filtro);
//
//    @GET("/ml/pedidos/comprador/")
//    Call<CustomerOrdersResponse> getCustomerOrders(@Query("id_cuenta_compradora") int idCuenta, @Query("id_pedido_estado") int idEstado, @Query("filtro") String filtro);
//
//    @GET("/ml/pedido/detalle")
//    Call<OrderDetailResponse> getOrderDetail(@Query("id_pedido") int orderId);
//
//    @PUT("/ml/pedido/")
//    Call<StandarResponse> changeOrderStatus(@Body() OrderStatusChangeSend orderStatuschangeSend);

}
