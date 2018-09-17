package com.zhen.module_user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhen.basecomponent.base.Delegate;
import com.zhen.basecomponent.bottom.BottomItemDelegate;
import com.zhen.basecomponent.utils.RouteUtils;

public class UserDelegate extends BottomItemDelegate implements View.OnClickListener {

    private AppCompatButton btn_login;

    @Override
    protected Object setLayout() {
        return R.layout.delegate_user;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {
        btn_login = rootView.findViewById(R.id.btn_login);
    }

    @Override
    protected void onEvent() {
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            getParentDelegate().start(RouteUtils.getLoginDelegate());
        }
    }
}
