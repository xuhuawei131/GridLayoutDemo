package com.xuhuawei.lingdian.gridlayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.xuhuawei.lingdian.gridlayoutdemo.bean.AddCarBean;
import com.xuhuawei.lingdian.gridlayoutdemo.bean.AddCarTitleBean;
import com.xuhuawei.lingdian.gridlayoutdemo.bean.CarBaseBean;
import com.xuhuawei.lingdian.gridlayoutdemo.bean.EmptyCarBean;
import com.xuhuawei.lingdian.gridlayoutdemo.bean.RecomendCarBean;
import com.xuhuawei.lingdian.gridlayoutdemo.bean.RecomendTitleBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<CarBaseBean> arrayList = new ArrayList<>();
    private List<AddCarBean> addCarList = new ArrayList<>();
    private List<RecomendCarBean> recomendCarList=new ArrayList<>();
    private EmptyCarBean bean;
    private NumberedAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View btn_empty=findViewById(R.id.btn_empty);
        View btn_add=findViewById(R.id.btn_add);

        btn_empty.setOnClickListener(this);
        btn_add.setOnClickListener(this);




        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new MarginDecoration(this));
        recyclerView.setHasFixedSize(true);

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type=arrayList.get(position).type;

                if(type==CarBaseBean.TYPE_EMPTY__CAR_VIEW){
                    return 2;
                }else if(type==CarBaseBean.TYPE_ADD_CAR_VIEW){
                    return 2;
                }else if(type==CarBaseBean.TYPE_ADD_CAR_TITLE){
                    return 2;
                }else if(type==CarBaseBean.TYPE_RECOMEND_CAR_TITLE){
                    return 2;
                }
                else{
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(manager);



        adapter=new NumberedAdapter(arrayList);

        recyclerView.setAdapter(adapter);

        setAddCarData();
    }


    private void setAddCarData(){

        arrayList.clear();
        addCarList.clear();
        recomendCarList.clear();


        bean =new EmptyCarBean("购物车是空的");


        int addCarLength=4;
        if(addCarLength>0){
            for(int i=0;i<addCarLength;i++){
                addCarList.add(new AddCarBean("购物商品"+i));
            }
        }

        int recomendCarLength=20;
        for(int i=0;i<recomendCarLength;i++){
            recomendCarList.add(new RecomendCarBean("推荐商品"+i));
        }

        if(addCarLength==0){
            arrayList.add(bean);
        }else{
            arrayList.add(new AddCarTitleBean("美丽优选"));
            arrayList.addAll(addCarList);
        }

        arrayList.add(new RecomendTitleBean("猜你喜欢"));
        arrayList.addAll(recomendCarList);

        adapter.notifyDataSetChanged();
    }


    private void setEmptyCar(){
        arrayList.clear();
        addCarList.clear();
        recomendCarList.clear();


        bean =new EmptyCarBean("购物车是空的");
        arrayList.add(bean);

        int recomendCarLength=20;
        for(int i=0;i<recomendCarLength;i++){
            recomendCarList.add(new RecomendCarBean("推荐商品"+i));
        }
        arrayList.add(new RecomendTitleBean("猜你喜欢"));
        arrayList.addAll(recomendCarList);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        int btnId=view.getId();
        switch (btnId){
            case R.id.btn_add:
                setAddCarData();
                break;
            case R.id.btn_empty:
                setEmptyCar();
                break;
        }
    }
}
