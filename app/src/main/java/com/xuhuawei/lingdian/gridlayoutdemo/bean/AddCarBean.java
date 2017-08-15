package com.xuhuawei.lingdian.gridlayoutdemo.bean;

import com.xuhuawei.lingdian.gridlayoutdemo.bean.CarBaseBean;

/**
 * Created by lingdian on 17/8/6.
 */

public class AddCarBean extends CarBaseBean {
    public AddCarBean(String itemName) {
        super(TYPE_ADD_CAR_VIEW);
        this.itemName=itemName;
    }
}
