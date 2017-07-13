package com.pokedex.koto.pokedex;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by KOTO on 11/07/2017.
 */
public interface PokemonService {
    @GET("pokemon/?limit=151")
    Call<ListResponse> listPokemon();
}