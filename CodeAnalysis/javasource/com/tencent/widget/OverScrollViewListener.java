package com.tencent.widget;

import android.view.View;

public abstract interface OverScrollViewListener
{
  public static final int ap = 1;
  public static final int e_ = 0;
  
  public abstract void a(int paramInt, View paramView, ListView paramListView);
  
  public abstract boolean a(int paramInt, View paramView, ListView paramListView);
  
  public abstract void b(int paramInt, View paramView, ListView paramListView);
  
  public abstract void c(int paramInt, View paramView, ListView paramListView);
}
