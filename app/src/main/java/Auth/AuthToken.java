package Auth;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.quizzapp.login;

public class AuthToken {
    public  static  boolean checkAuth(Context context){
        SharedPreferences prefs = context.getSharedPreferences("QuizzApp",Context.MODE_PRIVATE);
        String token = prefs.getString("token",null);
        Log.d("AuthToken", "Token: " + token);
        if(token == null || token.isEmpty()){
            Intent intent = new Intent(context, login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
            return false;
        }
        return true;
    }
    public static void clearToken(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("QuizzApp", Context.MODE_PRIVATE);
        prefs.edit().remove("token").apply();
    }
}
