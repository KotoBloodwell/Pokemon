package com.pokedex.koto.pokedex;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Peticion().execute();
    }

    public static class Peticion extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... params) {
            final String url = "http://pokeapi.co/api/v2/";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            servicePokemon service = retrofit.create(servicePokemon.class);

            Call<List<PokemonResponse>> response = service.listRepos();

            
            try{
                for (PokemonResponse pokemon : response.execute().body()){
                    Log.e( " holi " , String.valueOf(pokemon.getName()));
                }

            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }
    }

}
