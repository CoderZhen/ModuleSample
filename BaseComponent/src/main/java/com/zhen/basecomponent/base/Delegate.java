package com.zhen.basecomponent.base;

public abstract class Delegate extends PermissionDelegate{

    protected <T extends Delegate> T getParentDelegate(){
        return (T) getParentFragment();
    }

}
