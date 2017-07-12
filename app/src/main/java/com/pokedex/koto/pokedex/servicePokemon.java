package com.pokedex.koto.pokedex;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by KOTO on 11/07/2017.
 */

public interface  servicePokemon {
    @GET("pokemon/?limit=151")
    Call<List<PokemonResponse>> listRepos();
}