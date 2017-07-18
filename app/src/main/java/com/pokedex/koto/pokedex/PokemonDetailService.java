package com.pokedex.koto.pokedex;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by KOTO on 18/07/2017.
 */

public interface PokemonDetailService {
        @GET("pokemon/{id}")
        Call<PokemonDetail> PokemonDetail(@Path("id") int groupId);
}
