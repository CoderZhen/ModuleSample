package com.zhen.basecomponent.delegate.base;

public abstract class Delegate extends PermissionDelegate{

    protected <T extends Delegate> T getParentDelegate(){
        return (T) getParentFragment();
    }

}
