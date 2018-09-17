package com.zhen.module_find;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.zhen.basecomponent.base.Delegate;
import com.zhen.basecomponent.bottom.BottomItemDelegate;

public class FindDelegate extends BottomItemDelegate {
    @Override
    protected Object setLayout() {
        return R.layout.delegate_find;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    protected void onEvent() {

    }
}
