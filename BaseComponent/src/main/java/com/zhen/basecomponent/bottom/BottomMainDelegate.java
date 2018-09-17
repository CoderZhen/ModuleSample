package com.zhen.basecomponent.bottom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;

import com.zhen.basecomponent.R;
import com.zhen.basecomponent.base.Delegate;
import com.zhen.basecomponent.bean.BottomTabBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import me.yokeyword.fragmentation.ISupportFragment;

public abstract class BottomMainDelegate extends Delegate implements View.OnClickListener {

    private LinearLayoutCompat mBottomTab;

    protected abstract LinkedHashMap<BottomTabBean, BottomItemDelegate> setItem();

    protected abstract int setClickedTitleColor();

    protected abstract int setClickedItemColor();

    protected abstract int setCurrentDelegate();

    private int mCurrentDelegate = 0;
    private int mClickedColor = Color.BLACK;
    private int mClickedItemColor = Color.LTGRAY;
    private int mNoClickedColor = Color.GRAY;
    private int mNoClickedItemColor = Color.WHITE;
    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> LINKED_HASH_MAP = new LinkedHashMap<>();
    private final List<BottomTabBean> TABBEANS = new ArrayList<>();
    private final List<BottomItemDelegate> ITEMDELEGATES = new ArrayList<>();

    @Override
    protected Object setLayout() {
        return R.layout.delegate_main;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (setClickedTitleColor() != 0) {
            mClickedColor = setClickedTitleColor();
        }
        if (setClickedItemColor() != 0) {
            mClickedItemColor = setClickedItemColor();
        }
        if (setItem() != null) {
            LINKED_HASH_MAP.putAll(setItem());
        } else {
            throw new NullPointerException("setItem() is null");
        }

        for (Map.Entry<BottomTabBean, BottomItemDelegate> entry : LINKED_HASH_MAP.entrySet()) {
            final BottomTabBean key = entry.getKey();
            final BottomItemDelegate value = entry.getValue();
            TABBEANS.add(key);
            ITEMDELEGATES.add(value);
        }

    }

    @Override
    protected void BindView(@Nullable Bundle savedInstanceState, View rootView) {
        mBottomTab = rootView.findViewById(R.id.bottom_tab);
        int size = TABBEANS.size();
        for (int i = 0; i < size; i++) {
            LayoutInflater.from(getContext()).inflate(R.layout.item_tab, mBottomTab);
            LinearLayoutCompat item = (LinearLayoutCompat) mBottomTab.getChildAt(i);
            item.setTag(i);
            item.setOnClickListener(this);
            AppCompatTextView title = (AppCompatTextView) item.getChildAt(0);
            BottomTabBean bean = TABBEANS.get(i);
            title.setText(bean.getTitle());

            if (i == mCurrentDelegate) {
                title.setTextColor(mClickedColor);
                item.setBackgroundColor(mClickedItemColor);
            } else {
                title.setTextColor(mNoClickedColor);
                item.setBackgroundColor(mNoClickedItemColor);
            }
        }

        ISupportFragment[] fragments = ITEMDELEGATES.toArray(new ISupportFragment[size]);
        getSupportDelegate().loadMultipleRootFragment(R.id.bottom_container, setCurrentDelegate(), fragments);
    }

    @Override
    protected void onEvent() {

    }

    private void reset() {
        int count = mBottomTab.getChildCount();
        for (int i = 0; i < count; i++) {
            LinearLayoutCompat item = (LinearLayoutCompat) mBottomTab.getChildAt(i);
            AppCompatTextView title = (AppCompatTextView) item.getChildAt(0);
            item.setBackgroundColor(mNoClickedItemColor);
            title.setTextColor(mNoClickedColor);
        }
    }

    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();
        LinearLayoutCompat item = (LinearLayoutCompat) v;
        reset();
        item.setBackgroundColor(mClickedItemColor);
        AppCompatTextView title = (AppCompatTextView) item.getChildAt(0);
        title.setTextColor(mClickedColor);
        getSupportDelegate().showHideFragment(ITEMDELEGATES.get(tag), ITEMDELEGATES.get(mCurrentDelegate));
        mCurrentDelegate = tag;
    }

}
