package com.zhen.module_user;

import com.zhen.basecomponent.delegate.base.BaseDelegate;
import com.zhen.basecomponent.delegate.base.ProxyActivity;

public class DebugActivity extends ProxyActivity {
    @Override
    protected BaseDelegate setRootDelegate() {
        return new UserDelegate();
    }
}
