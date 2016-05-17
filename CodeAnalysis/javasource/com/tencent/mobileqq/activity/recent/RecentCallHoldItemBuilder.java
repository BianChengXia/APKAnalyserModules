package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;

public class RecentCallHoldItemBuilder
  extends RecentItemBaseBuilder
{
  public RecentCallHoldItemBuilder()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public View a(int paramInt, Object paramObject, RecentFaceDecoder paramRecentFaceDecoder, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    int i = 0;
    paramObject = paramView;
    if (paramView == null) {
      paramObject = LayoutInflater.from(paramContext).inflate(2130904051, null);
    }
    ((ImageView)paramObject.findViewById(2131301079)).setImageResource(2130840321);
    paramRecentFaceDecoder = paramObject.findViewById(2131301086);
    paramRecentFaceDecoder.setContentDescription("找人聊聊按钮");
    paramRecentFaceDecoder.setOnClickListener(paramOnClickListener);
    paramRecentFaceDecoder.setOnLongClickListener(paramOnLongClickListener);
    paramRecentFaceDecoder.setTag(-1, Integer.valueOf(paramInt));
    if ((paramViewGroup instanceof ListView))
    {
      paramRecentFaceDecoder = (ListView)paramViewGroup;
      int j = paramRecentFaceDecoder.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        i += paramRecentFaceDecoder.getChildAt(paramInt).getHeight();
        paramInt += 1;
      }
      paramObject.setMinimumHeight(paramRecentFaceDecoder.getHeight() - i);
    }
    if (AppSetting.i)
    {
      paramObject.setFocusable(true);
      paramObject.setFocusableInTouchMode(true);
    }
    return paramObject;
  }
  
  View a(View paramView, List paramList, QQAppInterface paramQQAppInterface)
  {
    int i = 4;
    ImageView[] arrayOfImageView;
    int j;
    if ((paramView != null) && (paramQQAppInterface != null))
    {
      arrayOfImageView = new ImageView[4];
      arrayOfImageView[0] = ((ImageView)paramView.findViewById(2131301081));
      arrayOfImageView[1] = ((ImageView)paramView.findViewById(2131301082));
      arrayOfImageView[2] = ((ImageView)paramView.findViewById(2131301083));
      arrayOfImageView[3] = ((ImageView)paramView.findViewById(2131301084));
      if ((paramList != null) && (paramList.size() > 0))
      {
        j = paramList.size();
        if (j <= 4) {
          break label379;
        }
      }
    }
    for (;;)
    {
      j = 0;
      if (j < i)
      {
        String str = ((Long)paramList.get(j)).toString();
        localObject2 = paramQQAppInterface.a(str, (byte)3, true);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "recommendFriendList headBitmap[" + j + "]" + "= null !");
          }
          localObject1 = paramQQAppInterface.a(str, (byte)3, true);
        }
        if (localObject1 == null) {
          arrayOfImageView[j].setImageResource(2130840320);
        }
        for (;;)
        {
          j += 1;
          break;
          arrayOfImageView[j].setImageBitmap((Bitmap)localObject1);
        }
      }
      i = getContextgetResourcesgetDisplayMetricsheightPixels;
      paramList = (TextView)paramView.findViewById(2131301085);
      paramQQAppInterface = (RelativeLayout.LayoutParams)paramList.getLayoutParams();
      Object localObject1 = (TextView)paramView.findViewById(2131301086);
      Object localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      if (i <= 800)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "screenHeight = " + i);
        }
        paramView.setPadding(0, 0, 0, paramView.getPaddingBottom());
        topMargin = BaseApplication.getContext().getResources().getDimensionPixelSize(2131493914);
        topMargin = BaseApplication.getContext().getResources().getDimensionPixelSize(2131493914);
        paramList.setLayoutParams(paramQQAppInterface);
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      return paramView;
      label379:
      i = j;
    }
  }
}
