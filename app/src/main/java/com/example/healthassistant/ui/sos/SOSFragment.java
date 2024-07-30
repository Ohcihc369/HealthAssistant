package com.example.healthassistant.ui.sos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthassistant.R;
import com.example.healthassistant.databinding.FragmentSosBinding;


public class SOSFragment extends Fragment {

    private FragmentSosBinding binding;
    private static final int REQUEST_SMS_PERMISSION = 123;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setTitle(R.string.menu_sos);
        // Initialize the button
        Button buttonSendSOS = binding.buttonSendSOS;
        buttonSendSOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSOSMessage();
            }
        });

        // Set click listener for the button
        buttonSendSOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call a method to send the SOS message
                sendSOSMessage();
            }
        });

        return root;
    }
    private void requestSmsPermissionAndSendSOS() {
        // Check if the app has the SMS permission
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            // Request the SMS permission
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.SEND_SMS}, REQUEST_SMS_PERMISSION);
        } else {
            // If permission is already granted, send SOS message
            sendSOSMessage();
        }
    }

    private void sendSOSMessage() {
        // Replace "123456789" with the actual emergency number
        String phoneNumber = "+260977229860";

        // Replace "I need medical help" with your desired SOS message
        String message = "I need medical help";

        // Create an Intent to send an SMS
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber));
        intent.putExtra("sms_body", message);

        // Start the SMS application
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_SMS_PERMISSION) {
            // Check if the permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, send SOS message
                sendSOSMessage();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}