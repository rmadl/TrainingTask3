package com.example.android.trainingtask3;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

public class InformationDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Set custom title dialog bar
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View customTitle = inflater.inflate(R.layout.custom_title_dialog, null);

        // Build Dialog Window
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCustomTitle(customTitle)
                .setPositiveButton(R.string.yes_button, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        // Open a webpage in browser
                        Uri webpage = Uri.parse(getString(R.string.forum_url));

                        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(intent);
                        }

                    }
                })
                .setNegativeButton(R.string.no_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }

}
