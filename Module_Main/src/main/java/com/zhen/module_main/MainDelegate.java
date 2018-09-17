package com.zhen.module_main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhen.basecomponent.bean.BottomTabBean;
import com.zhen.basecomponent.bottom.BottomItemDelegate;
import com.zhen.basecomponent.bottom.BottomMainDelegate;
import com.zhen.basecomponent.utils.RouteUtils;
import com.zhen.module_find.FindDelegate;
import com.zhen.module_home.HomeDelegate;
import com.zhen.module_user.UserDelegate;

import java.util.LinkedHashMap;

@Route(path = RouteUtils.MAIN)
public class MainDelegate extends BottomMainDelegate {

    @Override
    protected LinkedHashMap<BottomTabBean, BottomItemDelegate> setItem() {
        LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();
        ITEMS.put(new BottomTabBean("首页"), new HomeDelegate());
        ITEMS.put(new BottomTabBean("发现"), new FindDelegate());
        ITEMS.put(new BottomTabBean("我"), new UserDelegate());
        return ITEMS;
    }

    @Override
    protected int setClickedTitleColor() {
        return 0;
    }

    @Override
    protected int setClickedItemColor() {
        return 0;
    }

    @Override
    protected int setCurrentDelegate() {
        return 0;
    }
}
