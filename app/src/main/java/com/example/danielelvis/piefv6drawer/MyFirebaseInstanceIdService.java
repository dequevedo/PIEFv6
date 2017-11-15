package com.example.danielelvis.piefv6drawer;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by DanielElvis on 15/11/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    String token;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        token = FirebaseInstanceId.getInstance().getToken();
        Log.d("NOTICIAS", "Token: " + token);
    }

}
