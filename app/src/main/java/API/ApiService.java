package API;

import Model_account.AccountResponse;
import model_SignUp.RequestSignUp;
import model_SignUp.Respone_SignUp;
import model_User.UserResponse;
import model_login.Request;
import model_login.Respone;
import model_quizz.QuizzRespone;
import model_save.RequestSubmitScore;
import model_save.ResponeSave;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Header;

public interface ApiService {
    @GET("/api/account")
    Call<AccountResponse> getAccount();

    @GET("/api/top-7-10-scores")
    Call<UserResponse> getTopScoresNext();

    @GET("/api/top-scores")
    Call<UserResponse> getTopScore();

    @GET("/api/quizzes")
    Call<QuizzRespone> getQuizzRespone();

    @POST("/api/login")
    Call<Respone> login(@Body Request request);

    @POST("/api/Your-results")
    Call<ResponeSave> saveScore(
            @Header("Authorization") String token,
            @Body RequestSubmitScore body
    );

    @POST("/api/register")
    Call<Respone_SignUp> register(@Body RequestSignUp requestSignUp);
}
