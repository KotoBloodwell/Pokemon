package com.pokedex.koto.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AdapterViewAnimator;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

    ListView listViewAbilities;

    AdapterAbilities adapterAbilities;
    List<Ability> listAbilities;
    RecyclerView rv;

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
     //   Spinner spinner = (Spinner) findViewById(R.id.spinnerAbilities);
        listViewAbilities = (ListView) findViewById(R.id.listViewAbilities);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        listAbilities = new ArrayList<>();

        adapterAbilities = new AdapterAbilities(listAbilities);
        rv = (RecyclerView)findViewById(R.id.RecView);
        rv.setAdapter(adapterAbilities);
        LinearLayoutManager llm = new LinearLayoutManager(PokemonDetailsActivity.this);
        rv.setLayoutManager(llm);

        int id = Integer.parseInt(extras.getString("id"));

        service = retrofit.create(PokemonDetailService.class);
        service.PokemonDetail(id).enqueue(new Callback<PokemonDetail>() {
            @Override
            public void onResponse(Call<PokemonDetail> call, Response<PokemonDetail> response) {
                String name = response.body().getName();
               txtName.setText(Character.toUpperCase(name.charAt(0)) + name.substring(1,name.length()));
              //  spinner.setAdapter(new ArrayAdapter<Abili>(this, android.R.layout.simple_spinner_item, response.body().getAbilities()));
                txtWeight.setText(Long.toString(response.body().getWeight()));

                listAbilities.add(response.body().getAbilities());

            }

            @Override
            public void onFailure(Call<PokemonDetail> call, Throwable t) {
              //  Toast.makeText(MainActivity.this, "Request failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
