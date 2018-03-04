package pharaoh.com.weshare.data;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Comptia Ware on 2/22/2018.
 */

public interface NetworkEndPoint  {

    @FormUrlEncoded
    @POST("/RetrofitExample/insert.php")
    public void insertUser(
            @Field("email") String name,
            @Field("password") String username,
            Callback<Response> callback);



    @GET("/users")
    Call<Response> getRecipes();

}
