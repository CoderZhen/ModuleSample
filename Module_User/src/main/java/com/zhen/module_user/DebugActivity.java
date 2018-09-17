package com.zhen.module_user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhen.basecomponent.base.BaseDelegate;
import com.zhen.basecomponent.base.ProxyActivity;

public class DebugActivity extends ProxyActivity {
    @Override
    protected BaseDelegate setRootDelegate() {
        return new UserDelegate();
    }
}
