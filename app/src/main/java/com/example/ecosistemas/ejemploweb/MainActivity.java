package com.example.ecosistemas.ejemploweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SeekBar;

import com.deezer.sdk.model.Permissions;
import com.deezer.sdk.model.RadioCategory;
import com.deezer.sdk.network.connect.DeezerConnect;
import com.deezer.sdk.network.connect.SessionStore;
import com.deezer.sdk.network.request.AsyncDeezerTask;
import com.deezer.sdk.network.request.DeezerRequest;
import com.deezer.sdk.network.request.DeezerRequestFactory;
import com.deezer.sdk.network.request.event.RadioCategoriesRequestListener;
import com.deezer.sdk.player.PlayerWrapper;
import com.deezer.sdk.player.RadioPlayer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv_play_list;
    private PlayListAdapter playList;

    public DeezerConnect deezerConnect;

    private Carga c;

    private List<RadioCategory> categories = new ArrayList<>();
    private RadioPlayer radio;

    private PlayerWrapper mPlayer;

    private SeekBar mSeekBar;


/*
    private void searchAllRadioCategory() {
        DeezerRequest request = DeezerRequestFactory.requestRadiosCategories();
        AsyncDeezerTask task = new AsyncDeezerTask(deezerConnect,
                new RadioCategoriesRequestListener() {

                    @SuppressWarnings("unchecked")
                    @Override
                    public void onResult(final Object result, final Object requestId) {

                    }

                    @Override
                    public void onException(final Exception exception,
                                            final Object requestId) {

                    }


                });
        task.execute(request);
    }

*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // replace with your own Application ID
        String applicationID = "300244";
        deezerConnect = new DeezerConnect(MainActivity.this, applicationID);

        new SessionStore().restore(deezerConnect, this);

        // c = new Carga(this , deezerConnect);

        // searchAllRadioCategory();

        //  c.start();

        //Inicializacion de elementos...............................................................
        playList = new PlayListAdapter(this);
        lv_play_list = findViewById(R.id.lv_play_list);


        //Fin de Inicializacion de elementos--------------------------------------------------------
        lv_play_list.setAdapter(playList);

        PlayList pista = new PlayList("PlayList 1", "Anonimo", "12");

        pista.agregarCancion(new Cancion("Me fui", "No lose", "10"));
        pista.agregarCancion(new Cancion("Me fui", "No lose", "10"));
        pista.agregarCancion(new Cancion("Me fui", "No lose", "10"));

        PlayList pista2 = new PlayList("PlayList 2", "Anonimo", "1");

        Cancion cancion2 = new Cancion("Nombre de cancion", "Varios", "100");

        pista2.agregarCancion(cancion2);


        playList.agregar(pista);
        playList.agregar(pista2);


        // The set of Deezer Permissions needed by the app
        String[] permissions = new String[]{
                Permissions.BASIC_ACCESS,
                Permissions.MANAGE_LIBRARY,
                Permissions.LISTENING_HISTORY};

        // the request listener

        System.out.println("Mensaja-----------------------------------------------------------------------");
        System.out.println(deezerConnect);


    }

    private void searchAllRadioCategory() {

        new SessionStore().restore(deezerConnect, this);

        RadioCategoriesRequestListener solicitud = new RadioCategoriesRequestListener() {

            @Override
            public void onResult(Object result, Object requestId) {

                categories.addAll((List<RadioCategory>) result);

            }

            @Override
            public void onException(Exception e, Object o) {

            }

        };
        AsyncDeezerTask task = new AsyncDeezerTask(deezerConnect, solicitud);
        DeezerRequest request = DeezerRequestFactory.requestRadiosCategories();

        task.execute(request);

    }




}


