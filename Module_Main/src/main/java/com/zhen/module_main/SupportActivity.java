package com.zhen.module_main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhen.basecomponent.base.BaseDelegate;
import com.zhen.basecomponent.base.ProxyActivity;
import com.zhen.basecomponent.splash.SplashDelegate;

public class SupportActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
    }

    @Override
    protected BaseDelegate setRootDelegate() {
        return new SplashDelegate();
    }
}
