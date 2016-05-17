package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;

public class RecentCallHuangyeItemBuilder
  extends RecentItemBaseBuilder
{
  public RecentCallHuangyeItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = LayoutInflater.from(paramContext).inflate(2130904052, null);
    }
    paramRecentFaceDecoder = paramObject.findViewById(2131301087);
    paramRecentFaceDecoder.setContentDescription("电话黄页 按钮");
    paramRecentFaceDecoder.setOnClickListener(paramOnClickListener);
    paramRecentFaceDecoder.setOnLongClickListener(paramOnLongClickListener);
    paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
    boolean bool = BaseApplicationImpl.getContext().getSharedPreferences("qqhuangye", 0).getBoolean("show_reddot", true);
    paramRecentFaceDecoder = paramObject.findViewById(2131297338);
    if (bool)
    {
      paramRecentFaceDecoder.setVisibility(0);
      return paramObject;
    }
    paramRecentFaceDecoder.setVisibility(8);
    return paramObject;
  }
}
