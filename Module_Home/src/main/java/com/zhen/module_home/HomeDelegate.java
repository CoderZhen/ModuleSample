package com.zhen.module_home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.zhen.basecomponent.delegate.bottom.BottomItemDelegate;
import com.zhen.basecomponent.dialog.ProgressDialog;

public class HomeDelegate extends BottomItemDelegate implements View.OnClickListener {

    private AppCompatButton btn_dialog;
    private ProgressDialog dialog;

    @Override
    protected Object setLayout() {
        return R.layout.delegate_home;
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {
        btn_dialog = rootView.findViewById(R.id.btn_dialog);
    }

    @Override
    protected void onEvent() {
        btn_dialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_dialog) {
            dialog = new ProgressDialog();
            dialog.show(getFragmentManager(),"progress");
        }
    }
}
