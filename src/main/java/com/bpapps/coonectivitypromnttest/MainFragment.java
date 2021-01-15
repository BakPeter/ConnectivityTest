package com.bpapps.coonectivitypromnttest;

import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment implements View.OnClickListener {

    private MainViewModel mViewModel;

    private AppCompatButton mBtnGoWirelessSettings;
    private AppCompatButton mBtnGoToNetworkOperatorSettings;
    private AppCompatButton mBtnGoToWifiSettings;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBtnGoWirelessSettings = view.findViewById(R.id.btnGoToWirelessSettings);
        mBtnGoWirelessSettings.setOnClickListener(this);

        mBtnGoToNetworkOperatorSettings = view.findViewById(R.id.btnGoToNetworkOperatorSettings);
        mBtnGoToNetworkOperatorSettings.setOnClickListener(this);

        mBtnGoToWifiSettings = view.findViewById(R.id.btnGoToWifiSettings);
        mBtnGoToWifiSettings.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGoToWirelessSettings) {
            goConnectivitySettingsActivity(Settings.ACTION_WIRELESS_SETTINGS);
        } else if (v.getId() == R.id.btnGoToNetworkOperatorSettings) {
            goConnectivitySettingsActivity(Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
        } else if (v.getId() == R.id.btnGoToWifiSettings) {
            goConnectivitySettingsActivity(Settings.ACTION_WIFI_SETTINGS);
        }
    }

    private void goConnectivitySettingsActivity(@NonNull String action) {
        startActivity(new Intent(action));
//        startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
//        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
//        startActivity(new Intent(Settings.ACTION_NETWORK_OPERATOR_SETTINGS));
    }
}