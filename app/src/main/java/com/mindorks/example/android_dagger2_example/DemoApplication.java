package com.mindorks.example.android_dagger2_example;

import android.app.Application;
import android.content.Context;

import com.mindorks.example.android_dagger2_example.data.DataManager;
import com.mindorks.example.android_dagger2_example.di.component.ApplicationComponent;
import com.mindorks.example.android_dagger2_example.di.component.DaggerApplicationComponent;
import com.mindorks.example.android_dagger2_example.di.module.ApplicationModule;
import com.mindorks.example.android_dagger2_example.sample.DependencySample1;

import javax.inject.Inject;

/**
 * Created by janisharali on 25/12/16.
 */

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;
    private DependencySample1 dependencySample1;

    @Inject
    DependencySample1 dependencySample1Instance1;
    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                                    .builder()
                                    .applicationModule(new ApplicationModule(this))
                                    .build();
        applicationComponent.inject(this);
        dependencySample1 = applicationComponent.getDependencySample1();
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
