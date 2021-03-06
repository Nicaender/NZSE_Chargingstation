package com.nzse_chargingstation.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nzse_chargingstation.app.R;
import com.nzse_chargingstation.app.classes.ChargingStationDistanceComparator;
import com.nzse_chargingstation.app.classes.ContainerAndGlobal;
import com.nzse_chargingstation.app.classes.FavoriteAdapter;

/**
 * A Fragment to show the list of favorite charging station.
 */
public class FavoritesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            if(ContainerAndGlobal.getCurrentLocation() != null)
                ContainerAndGlobal.getFavoriteList().sort(new ChargingStationDistanceComparator());
            RecyclerView recyclerView = view.findViewById(R.id.rvFavoriteList);
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            recyclerView.setHasFixedSize(true);

            FavoriteAdapter adapter = new FavoriteAdapter(requireContext());
            recyclerView.setAdapter(adapter);

            adapter.setFavoriteList(ContainerAndGlobal.getFavoriteList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}