package com.xuhuawei.lingdian.gridlayoutdemo.bean;

/**
 * Created by lingdian on 17/8/6.
 */

public class RecomendCarBean extends CarBaseBean {
    public RecomendCarBean(String itemName) {
        super(TYPE_RECOMEND_CAR_VIEW);
        this.itemName=itemName;
    }
}
