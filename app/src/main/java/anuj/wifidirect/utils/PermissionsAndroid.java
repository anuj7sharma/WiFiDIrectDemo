/*
 *
 *
 *  * Copyright © 2016, Mobilyte Inc. and/or its affiliates. All rights reserved.
 *  *
 *  * Redistribution and use in source and binary forms, with or without
 *  * modification, are permitted provided that the following conditions are met:
 *  *
 *  * - Redistributions of source code must retain the above copyright
 *  *    notice, this list of conditions and the following disclaimer.
 *  *
 *  * - Redistributions in binary form must reproduce the above copyright
 *  * notice, this list of conditions and the following disclaimer in the
 *  * documentation and/or other materials provided with the distribution.
 *
 * /
 */

package anuj.wifidirect.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;


/**
 * Created by Mobilyte on 14/01/16.
 */
public class PermissionsAndroid {

    static PermissionsAndroid permissionsAndroid;

    public static PermissionsAndroid getInstance() {
        if (permissionsAndroid == null)
            permissionsAndroid = new PermissionsAndroid();
        return permissionsAndroid;
    }

    private PermissionsAndroid() {

    }

    // Request Code for request Permissions Must be between 0 to 255.
    //Write External Storage Permission.
    public static final int WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 100;

    public boolean checkWriteExternalStoragePermission(Activity activity) {
        return boolValue(ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE));
    }

    public void requestForWriteExternalStoragePermission(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(activity, "Allow Write External Storage Permission to use this functionality.", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE);
        }
    }

    public void requestForWriteExternalStoragePermission(Fragment fragment) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(fragment.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(fragment.getActivity(), "Allow Write External Storage Permission to use this functionality.", Toast.LENGTH_SHORT).show();
            fragment.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE);
        } else {
            fragment.requestPermissions( new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE);
        }
    }
    //Write External Storage Permission.


    //Record Audio Permission.
    public static final int RECORD_AUDIO_PERMISSION_REQUEST_CODE = 101;

    public boolean checkRecordAudioPermission(Activity activity) {
        return boolValue(ContextCompat.checkSelfPermission(activity, Manifest.permission.RECORD_AUDIO));
    }

    public void requestForRecordAudioPermission(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.RECORD_AUDIO)) {
            Toast.makeText(activity, "Allow Record Audio Permission to use this functionality.", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_AUDIO_PERMISSION_REQUEST_CODE);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_AUDIO_PERMISSION_REQUEST_CODE);
        }
    }
    //Record Audio Permission.
    public void requestForRecordAudioPermission(Fragment fragment) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(fragment.getActivity(), Manifest.permission.RECORD_AUDIO)) {
            Toast.makeText(fragment.getActivity(), "Allow Record Audio Permission to use this functionality.", Toast.LENGTH_SHORT).show();
            fragment.requestPermissions( new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_AUDIO_PERMISSION_REQUEST_CODE);
        } else {
            fragment.requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO}, RECORD_AUDIO_PERMISSION_REQUEST_CODE);
        }
    }


    // Camera Permission
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 102;

    public boolean checkCameraPermission(Activity activity) {
        return boolValue(ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA));
    }

    public void requestForCameraPermission(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.CAMERA)) {
            Toast.makeText(activity, "Allow Camera Permission to use this functionality.", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_PERMISSION_REQUEST_CODE);
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_PERMISSION_REQUEST_CODE);

        }
    }

    public void requestForCameraPermission(Fragment fragment) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(fragment.getActivity(), Manifest.permission.CAMERA)) {
            Toast.makeText(fragment.getActivity(), "Allow Camera Permission to use this functionality.", Toast.LENGTH_SHORT).show();
            fragment.requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_PERMISSION_REQUEST_CODE);
        } else {
            fragment.requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE}, CAMERA_PERMISSION_REQUEST_CODE);

        }
    }
    // Camera Permission

    // Location Permission
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 103;

    public boolean checkLocationPermission(Activity activity) {
        return boolValue(ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION));
    }

    public void requestForLocationPermission(Fragment fragment) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(fragment.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
            fragment.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            Toast.makeText(fragment.getActivity(), "Allow Location Permission to use this functionality.", Toast.LENGTH_SHORT).show();
        } else {
            fragment.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);

        }
    }
    // Location Permission
    public void requestForLocationPermission(Activity activity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.ACCESS_FINE_LOCATION)) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            Toast.makeText(activity, "Allow Location Permission to use this functionality.", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);

        }
    }

    // function to return true or false based on the permission result
    private boolean boolValue(int value) {
        if (value == PackageManager.PERMISSION_GRANTED)
            return true;
        else
            return false;
    }

}
