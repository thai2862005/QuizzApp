package API;

import model.Request;
import model.Respone;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/api/login")
    Call<Respone> login(@Body Request request);

}
