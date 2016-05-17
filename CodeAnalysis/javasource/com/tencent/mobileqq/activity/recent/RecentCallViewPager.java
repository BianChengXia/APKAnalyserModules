package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class RecentCallViewPager
  extends ViewPager
{
  public RecentCallViewPager(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RecentCallViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      FrameHelperActivity.d(false);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        FrameHelperActivity.d(true);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      FrameHelperActivity.d(false);
    }
    for (;;)
    {
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent) {}
      if ((i == 1) || (i == 3)) {
        FrameHelperActivity.d(true);
      }
    }
    return false;
  }
}
