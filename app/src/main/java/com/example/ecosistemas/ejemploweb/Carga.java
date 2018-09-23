package com.example.ecosistemas.ejemploweb;

import android.app.Activity;
import android.os.AsyncTask;

import com.deezer.sdk.model.RadioCategory;
import com.deezer.sdk.network.connect.DeezerConnect;
import com.deezer.sdk.network.request.AsyncDeezerTask;
import com.deezer.sdk.network.request.DeezerRequest;
import com.deezer.sdk.network.request.DeezerRequestFactory;
import com.deezer.sdk.network.request.event.RadioCategoriesRequestListener;
import com.deezer.sdk.player.RadioPlayer;


import com.deezer.sdk.network.request.event.DeezerError;

import java.util.ArrayList;
import java.util.List;

public class Carga extends AsyncTask<String, Integer, String[]> implements Runnable {

    private RadioPlayer mRadioPlayer;
    private DeezerConnect deezerConnect;

    Thread hilo;
    private Activity activity;
    private List<RadioCategory> mRadioCategoryList;

    public Carga(Activity activity, DeezerConnect deezerConnect) {
        hilo = new Thread(this);
        this.activity = activity;
        this.deezerConnect = deezerConnect;
        mRadioCategoryList = new ArrayList<RadioCategory>();
        hilo.start();
    }


    @Override
    public void run() {
        System.out.println("---------------------------------------------------------DFSFSDF------------AAAA---------------------------");
        try {
            searchAllRadioCategory();
        } catch (DeezerError deezerError) {
            deezerError.printStackTrace();
        }
        System.out.println("---------------------------------------------------------DFSFSDF------------AAAA---------------------------");
    }


    private List<RadioCategory> RadioCategoryList = new ArrayList<RadioCategory>();
    private void searchAllRadioCategory() throws DeezerError{
        DeezerRequest request = DeezerRequestFactory.requestRadiosCategories();
        AsyncDeezerTask task = new AsyncDeezerTask(deezerConnect,
                new RadioCategoriesRequestListener() {

                    @SuppressWarnings("unchecked")
                    @Override
                    public void onResult(final Object result, final Object requestId) {

                        RadioCategoryList.clear();

                        try {
                            RadioCategoryList.addAll((List<RadioCategory>) result);
                        } catch (ClassCastException e) {
                            // handleError(e);
                        }



                    }

                    @Override
                    public void onException(final Exception exception, final Object requestId) {
                        //handleError(exception);
                    }


                });

            task.execute(request);

        System.out.println("Solicitud--------------------------------------------------------------------------------------");
    }



    @Override
    protected String[] doInBackground(String... strings) {
        String[]a = new String[1];
        a[0] = "";
        return a;
    }
}

