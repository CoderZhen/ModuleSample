package com.zhen.basecomponent.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhen.basecomponent.R;
import com.zhen.basecomponent.delegate.base.Delegate;
import com.zhen.basecomponent.utils.RouteUtils;
import com.zhen.baselibrary.datasource.preference.PreferencesManage;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

@Route(path = RouteUtils.LOGIN)
public class LoginDelegate extends Delegate implements View.OnClickListener {

    private AppCompatEditText et_username, et_password;
    private AppCompatButton btn_login;

    @Override
    protected Object setLayout() {
        return R.layout.delegate_login;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {
        et_username = rootView.findViewById(R.id.et_username);
        et_password = rootView.findViewById(R.id.et_password);
        btn_login = rootView.findViewById(R.id.btn_login);
    }

    @Override
    protected void onEvent() {
        btn_login.setOnClickListener(this);
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_login) {
            PreferencesManage.setLogin(true);
            getSupportDelegate().startWithPop(RouteUtils.getMainDelegate());
        }
    }
}
