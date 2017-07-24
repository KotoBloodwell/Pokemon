package com.pokedex.koto.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonDetailsActivity extends AppCompatActivity {
    private String url = "http://pokeapi.co/api/v2/";
    private Retrofit retrofit;
    PokemonDetail pokemonDetail;
    private PokemonDetailService service;
    TextView txtName, txtWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        txtName = (TextView) (TextView) findViewById(R.id.txtNamePokemon);
        txtWeight = (TextView) (TextView) findViewById(R.id.txtWeight);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        int id = Integer.parseInt(extras.getString("id"));

        service = retrofit.create(PokemonDetailService.class);
        service.PokemonDetail(id).enqueue(new Callback<PokemonDetail>() {
            @Override
            public void onResponse(Call<PokemonDetail> call, Response<PokemonDetail> response) {
                String name = response.body().getName();
               txtName.setText(Character.toUpperCase(name.charAt(0)) + name.substring(1,name.length()));


                txtWeight.setText(Long.toString(response.body().getWeight()));

            }

            @Override
            public void onFailure(Call<PokemonDetail> call, Throwable t) {
              //  Toast.makeText(MainActivity.this, "Request failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
