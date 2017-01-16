package com.mindorks.example.android_dagger2_example.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.mindorks.example.android_dagger2_example.di.ApplicationContext;
import com.mindorks.example.android_dagger2_example.di.DatabaseInfo;
import com.mindorks.example.android_dagger2_example.sample.DependencySample1;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by janisharali on 25/12/16.
 */

@Module
public class ApplicationModule {

    private static final String TAG = "ApplicationModule";
    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    DependencySample1 provideDependencySample1() {
        Log.d(TAG, "provideDependencySample1: provideDependencySample1 called");
        return new DependencySample1(3);
    }

    @Provides
    @Named(value = "DependencySample1_Integer")
    Integer provideDependencySample1Integer() {
        Log.d(TAG, "provideDependencySample1: provideDependencySample1Integer called");
        return 3;
    }
}
