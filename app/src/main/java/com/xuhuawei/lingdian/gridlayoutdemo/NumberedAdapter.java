package com.xuhuawei.lingdian.gridlayoutdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xuhuawei.lingdian.gridlayoutdemo.bean.CarBaseBean;

import java.util.ArrayList;
import java.util.List;

public class NumberedAdapter extends RecyclerView.Adapter<TextViewHolder> {
  private List<CarBaseBean> arrayList;
  public NumberedAdapter(List<CarBaseBean> arrayList) {
    this.arrayList=arrayList;
  }

  @Override
  public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
    return new TextViewHolder(view);
  }

  @Override
  public int getItemViewType(int position) {
    return arrayList.get(position).type;
  }

  @Override
  public void onBindViewHolder(final TextViewHolder holder, final int position) {
    final String label = arrayList.get(position).itemName;
    holder.textView.setText(label);
    holder.textView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(
            holder.textView.getContext(), label, Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public int getItemCount() {
    return arrayList.size();
  }
}