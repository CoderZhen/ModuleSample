package com.zhen.basecomponent.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhen.basecomponent.R;
import com.zhen.basecomponent.base.Delegate;
import com.zhen.basecomponent.utils.RouteUtils;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.DefaultNoAnimator;
import me.yokeyword.fragmentation.anim.DefaultVerticalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

@Route(path = RouteUtils.LOGIN)
public class LoginDelegate extends Delegate {
    @Override
    protected Object setLayout() {
        return R.layout.delegate_login;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    protected void onEvent() {

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }
}
