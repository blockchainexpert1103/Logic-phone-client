package com.example.pms_client;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyScanManager;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.TextView;
import androidx.annotation.NonNull;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    RadioButton radioSelectApp, radioSelectPhone;
    Button positiveButton;
    TextView txtAppDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button defaultButton = findViewById(R.id.main_start_button);

        defaultButton.setOnClickListener(v -> {
            showSetDefaultDialog();

//            Intent intent = new Intent(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
//            intent.putExtra(TelephonyManager.EXTRA_STATE, TelephonyManager.EXTRA_STATE_RINGING);
//            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
//                // TODO: Consider calling
//                //    ActivityCompat#requestPermissions
//                // here to request the missing permissions, and then overriding
//                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                //                                          int[] grantResults)
//                // to handle the case where the user grants the permission. See the documentation
//                // for ActivityCompat#requestPermissions for more details.
//                return;
//            }
//            sendBroadcast(intent);
        });

//        int INSERT_CONTACT_REQUEST = 2;
//        Intent i = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.STARRED);
//        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Toast.makeText(MainActivity.this, resultCode, Toast.LENGTH_SHORT).show();
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void showSetDefaultDialog() {

        // Inflate the custom dialog layout
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.dialog_set_default, null);

        // Set up the RadioButtons
        radioSelectApp = dialogView.findViewById(R.id.radio_select_app);
        radioSelectPhone = dialogView.findViewById(R.id.radio_select_phone);
        txtAppDescription = dialogView.findViewById(R.id.content_select_app);

        // Initially hide text2
        txtAppDescription.setVisibility(View.GONE);

        // Set radio2 as the default selection
        radioSelectPhone.setChecked(true);

        // Create and display an AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCustomTitle(dialogView);

        // Set up the dialog with a positive and negative button
        builder.setPositiveButton(R.string.confirm_set_default, null);
        builder.setNegativeButton(R.string.cancel_set_default, (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();

        // Reference to the positive button
        positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

        // Initially disable the positive button and set its text color to gray
        positiveButton.setEnabled(false);
        positiveButton.setTextColor(Color.GRAY);

        // Handle RadioButton clicks manually to ensure single selection
        radioSelectApp.setOnClickListener(v -> {

            radioSelectApp.setChecked(true);
            radioSelectPhone.setChecked(false);
            positiveButton.setEnabled(true);  // Enable the positive button
            positiveButton.setTextColor(Color.rgb(72,37,138));  // Change the text color to blue

            // Show text2 when radio1 is selected
            txtAppDescription.setVisibility(View.VISIBLE);
        });

        radioSelectPhone.setOnClickListener(v -> {

            radioSelectApp.setChecked(false);
            radioSelectPhone.setChecked(true);
            positiveButton.setEnabled(false);  // Disable the positive button
            positiveButton.setTextColor(Color.GRAY);  // Change the text color back to gray

            txtAppDescription.setVisibility(View.GONE);
        });

        // Set an onClickListener for the positive button after it is shown
        positiveButton.setOnClickListener(v -> {

            if (radioSelectApp.isChecked()) {

//                Toast.makeText(MainActivity.this, R.string.alert_set_default_app, Toast.LENGTH_SHORT).show();
//                navigateFavoriteContainer();
                Intent intent = new Intent(MainActivity.this, SearchContactsContainer.class);
                startActivity(intent);
            }
            dialog.dismiss();  // Close the dialog after the positive action
        });
    }

//    public void navigateFavoriteContainer() {
//
//        Intent intent = new Intent(MainActivity.this, FavoriteListContainer.class);
//        startActivity(intent);
//    }
//
//    public void navigateHistoryContainer() {
//
//    }
//
//    public void navigateContactsContainer() {
//
//    }


}
