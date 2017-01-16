package com.mindorks.example.android_dagger2_example.di.module;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.mindorks.example.android_dagger2_example.di.ActivityContext;
import com.mindorks.example.android_dagger2_example.di.PerActivity;
import com.mindorks.example.android_dagger2_example.sample.DependencySample1;

import dagger.Module;
import dagger.Provides;

import static android.content.ContentValues.TAG;

/**
 * Created by janisharali on 08/12/16.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    DependencySample1 provideDependencySample1() {
        Log.d(TAG, "provideDependencySample1: called");
        return new DependencySample1(3);
    }
}
