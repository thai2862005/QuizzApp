package API;

import model_SignUp.RequestSignUp;
import model_SignUp.Respone_SignUp;
import model_login.Request;
import model_login.Respone;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/api/login")
    Call<Respone> login(@Body Request request);
    @POST("/api/register")
    Call<Respone_SignUp>  register(@Body RequestSignUp requestSignUp);
}
