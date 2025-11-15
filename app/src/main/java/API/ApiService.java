package API;

import Model_account.AccountResponse;
import model_SignUp.RequestSignUp;
import model_SignUp.Respone_SignUp;
import model_User.UserResponse;
import model_login.Request;
import model_login.Respone;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("/api/account")
    Call<AccountResponse> getAccount();
    @GET("/api/top-7-10-scores")
    Call<UserResponse> getTopScoresNext();

    @POST("/api/login")
    Call<Respone> login(@Body Request request);

    @POST("/api/register")
    Call<Respone_SignUp> register(@Body RequestSignUp requestSignUp);
}
