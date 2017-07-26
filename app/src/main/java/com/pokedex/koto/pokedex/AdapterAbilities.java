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

public class AdapterAbilities extends RecyclerView.Adapter<AdapterAbilities.AbilitiesViewHolder> {

   static List<Ability> listAbilities;

    public AdapterAbilities(List<Ability> listAbilities) {
        this.listAbilities = listAbilities;
    }

    @Override
    public AbilitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_abilities,parent,false);
        AbilitiesViewHolder holder = new AbilitiesViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(AbilitiesViewHolder holder, int position) {
        holder.txtNameAbility.setText(listAbilities.get(position).getAbility().getName());
    }

    @Override
    public int getItemCount() {
        return listAbilities.size();
    }

    public static class AbilitiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtNameAbility;

        public AbilitiesViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            txtNameAbility = (TextView) itemView.findViewById(R.id.txtNameAbility);

        }


        @Override
        public void onClick(View v) {

        }
    }

}
