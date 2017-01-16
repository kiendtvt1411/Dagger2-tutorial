package com.mindorks.example.android_dagger2_example.sample;

import android.util.Log;

import com.mindorks.example.android_dagger2_example.di.PerActivity;

import javax.inject.Inject;
import javax.inject.Named;

@PerActivity
public class DependencySample1 {

    private static final String TAG = "DependencySample1";

    private int value;

    @Inject
    public DependencySample1(@Named(value = "DependencySample1_Integer") Integer value) {
        this.value = value;
        Log.d(TAG, "DependencySample1: " + this.hashCode());
    }
}
