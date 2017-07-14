package com.pokedex.koto.pokedex;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String url = "http://pokeapi.co/api/v2/";
    private Retrofit retrofit;
    private PokemonService service;
    Adaptador adapter;
    List<PokemonItem> pokemonItems;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        adapter = new Adaptador(pokemonItems);
        rv = (RecyclerView)findViewById(R.id.RecView);
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(llm);


        service = retrofit.create(PokemonService.class);
        service.listPokemon().enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                List<PokemonItem> pokemonItems = response.body().getResults();

                String loadedMessage = "Loaded " + pokemonItems.size() + " Pokémon";
                Toast.makeText(MainActivity.this, loadedMessage, Toast.LENGTH_SHORT).show();

                adapter.notifyDataSetChanged();
          /*      for (PokemonItem pokemon : pokemonItems){
                    Log.d( " holi " , String.valueOf(pokemon.getName()));
                }*/

            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
