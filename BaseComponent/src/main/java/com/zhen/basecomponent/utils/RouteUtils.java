package com.zhen.basecomponent.utils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zhen.basecomponent.base.BaseDelegate;

public class RouteUtils {

    public static final String MAIN = "/main/main";

    public static final String LOGIN = "/login/login";

    public static BaseDelegate getMainDelegate(){
        return (BaseDelegate) ARouter.getInstance().build(MAIN).navigation();
    }

    public static BaseDelegate getLoginDelegate(){
        return (BaseDelegate) ARouter.getInstance().build(LOGIN).navigation();
    }

}
