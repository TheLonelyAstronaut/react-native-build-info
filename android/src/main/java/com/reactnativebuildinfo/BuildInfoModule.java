package com.reactnativebuildinfo;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = BuildInfoModule.NAME)
public class BuildInfoModule extends ReactContextBaseJavaModule {
    public static final String NAME = "BuildInfo";

    public BuildInfoModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getBuildTime(Promise promise) {
        promise.resolve(String.valueOf(BuildConfig.TIMESTAMP));
    }
}
