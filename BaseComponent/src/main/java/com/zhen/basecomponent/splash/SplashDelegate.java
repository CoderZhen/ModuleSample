package com.zhen.basecomponent.splash;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.zhen.basecomponent.R;
import com.zhen.basecomponent.delegate.base.Delegate;
import com.zhen.basecomponent.utils.RouteUtils;
import com.zhen.baselibrary.datasource.preference.PreferencesManage;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class SplashDelegate extends Delegate implements View.OnClickListener {

    private AppCompatImageView img_splash;

    private AppCompatButton btn_splash;

    private CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected Object setLayout() {
        return R.layout.delegate_splash;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CountDown();
    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {
        img_splash = rootView.findViewById(R.id.img_splash);
        btn_splash = rootView.findViewById(R.id.btn_splash);
    }

    @Override
    protected void onEvent() {
        img_splash.setImageResource(R.mipmap.splash);
        btn_splash.setOnClickListener(this);
    }

    @SuppressLint("CheckResult")
    private void CountDown() {
        final long time = 5;
        Observable.intervalRange(0, 6, 1000, 1000, TimeUnit.MILLISECONDS)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return time - aLong;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        btn_splash.setText(aLong + "秒");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        CheckLoginStatus();
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_splash) {
            CheckLoginStatus();
        }
    }

    private void CheckLoginStatus() {
        if (PreferencesManage.getLogin()) {
            getSupportDelegate().startWithPop(RouteUtils.getMainDelegate());
        } else {
            getSupportDelegate().startWithPop(RouteUtils.getLoginDelegate());
        }
    }
}
