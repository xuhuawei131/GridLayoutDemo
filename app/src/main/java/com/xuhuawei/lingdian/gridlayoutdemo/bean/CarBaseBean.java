package com.xuhuawei.lingdian.gridlayoutdemo.bean;

import java.io.Serializable;

/**
 * Created by lingdian on 17/8/6.
 */

public class CarBaseBean implements Serializable {
    public int type;
    public String itemName;
    public static final int TYPE_EMPTY__CAR_VIEW=0;
    public static final int TYPE_ADD_CAR_VIEW=1;
    public static final int TYPE_ADD_CAR_TITLE=2;
    public static final int TYPE_RECOMEND_CAR_VIEW=3;
    public static final int TYPE_RECOMEND_CAR_TITLE=4;
    public CarBaseBean(int type){
        this.type=type;

    }
}
