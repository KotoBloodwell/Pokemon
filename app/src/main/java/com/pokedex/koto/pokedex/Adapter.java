package com.pokedex.koto.pokedex;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by KOTO on 13/07/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.PokemonViewHolder> {

   static List<PokemonItem> listPokemon;

    public Adapter(List<PokemonItem> listPokemon) {
        this.listPokemon = listPokemon;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item,parent,false);
      PokemonViewHolder holder = new PokemonViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        holder.txtName.setText(listPokemon.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return listPokemon.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtName;

        public PokemonViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            txtName = (TextView) itemView.findViewById(R.id.txtName);

        }


        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick " + getPosition() + " " + itemView);
            Intent i = new Intent(itemView.getContext(), PokemonDetailsActivity.class);
            String url = listPokemon.get(getPosition()).getUrl();
            i.putExtra("id", url.substring(url.length() -2, url.length() -1) );
            itemView.getContext().startActivity(i);
        }
    }

}
