package com.singtel.espresso.network;

import android.util.Log;
import com.github.kevinsawicki.http.HttpRequest;
import com.singtel.espresso.core.User;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-9-3
 * Time: 下午5:03
 * To change this template use File | Settings | File Templates.
 */
public class httpClient {

    public static boolean Login(User user){
        boolean isLogin = false;
        String response = HttpRequest.get("https://mobi.singtel.com/espresso/share/AuthenticationService.asmx/Login?" +
                "UserName=wenpeng&Password=Good2014&customCredential=&isPersistent=true").body();
        Log.v("Login",response);
        return isLogin;
    }
}
