package com.nzse_chargingstation.app.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.nzse_chargingstation.app.R;
import com.nzse_chargingstation.app.activities.TechnicianActivity;
import com.nzse_chargingstation.app.classes.ContainerAndGlobal;
import com.nzse_chargingstation.app.classes.LocaleHelper;

/**
 * A fragment to show the setting, such as dark mode and language, and also a button to access technician site.
 */
public class SettingsFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            Button btnTechnicianSite =  view.findViewById(R.id.buttonTechnicianSite);
            Button btnDarkmode = view.findViewById(R.id.buttonDarkMode);
            Button btnLanguageSwitch =  view.findViewById(R.id.buttonLanguageSwitch);

            // Saving state of our app
            // using SharedPreferences
            SharedPreferences sharedPreferences = this.requireActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = sharedPreferences.edit();

            // When user reopens the app
            // after applying dark/light mode
            if (ContainerAndGlobal.isDarkmode()) {
                btnDarkmode.setText(R.string.disable_darkmode);
            }
            else {
                btnDarkmode.setText(R.string.enable_darkmode);
            }

            // When user reopens the app after changing language;
            btnLanguageSwitch.setText(R.string.language_button);

            // Implementation of dark mode button
            btnDarkmode.setOnClickListener(v -> {
                if (ContainerAndGlobal.isDarkmode()) {
                    // if dark mode is on it
                    // will turn it off
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    // it will set isDarkModeOn
                    // boolean to false
                    editor.putBoolean("isDarkModeOn", false);
                    editor.apply();
                    // change text of Button
                    btnDarkmode.setText(R.string.enable_darkmode);
                }
                else {
                    // if dark mode is off
                    // it will turn it on
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    // it will set isDarkModeOn
                    // boolean to true
                    editor.putBoolean("isDarkModeOn", true);
                    editor.apply();
                    // change text of Button
                    btnDarkmode.setText(R.string.disable_darkmode);
                }
                ContainerAndGlobal.setChangedSetting(true);
            });

            // Implementation of button to login site from techniker
            btnTechnicianSite.setOnClickListener(v -> startActivity(new Intent(getActivity(), TechnicianActivity.class)));

            // Implementation of language switch button
            btnLanguageSwitch.setOnClickListener(v -> {
                LocaleHelper.setLocale(requireContext(), getResources().getString(R.string.language_toggle));
                requireActivity().recreate();
                ContainerAndGlobal.setChangedSetting(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}