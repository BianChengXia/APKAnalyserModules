package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ActivateFriendGridItem
  extends RelativeLayout
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public boolean a;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public ActivateFriendGridItem(Context paramContext)
  {
    this(paramContext, true, true);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public ActivateFriendGridItem(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    jdField_a_of_type_Boolean = true;
    a(paramContext, paramBoolean1, paramBoolean2);
  }
  
  private void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    LayoutInflater.from(paramContext).inflate(2130903989, this, true);
    jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131296683));
    jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300831));
    jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296718));
    jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300832));
    if (!paramBoolean2)
    {
      jdField_a_of_type_AndroidWidgetTextView.setHorizontallyScrolling(false);
      jdField_b_of_type_AndroidWidgetTextView.setHorizontallyScrolling(false);
    }
    if (!paramBoolean1)
    {
      paramContext = findViewById(2131300830).getBackground();
      if ((paramContext != null) && ((paramContext instanceof GradientDrawable))) {
        ((GradientDrawable)paramContext).setColor(-1);
      }
      jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
  }
  
  public void a()
  {
    if (!jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  public void setBirthday(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setBirthdayDesc(String paramString)
  {
    jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    if (jdField_a_of_type_Boolean)
    {
      jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840206);
      str2 = getResources().getString(2131371058) + jdField_a_of_type_AndroidWidgetTextView.getText();
      str1 = str2;
      if (jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        str1 = str2 + jdField_b_of_type_AndroidWidgetTextView.getText();
      }
      setContentDescription(str1);
      return;
    }
    jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840207);
    String str2 = "" + jdField_a_of_type_AndroidWidgetTextView.getText();
    String str1 = str2;
    if (jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      str1 = str2 + jdField_b_of_type_AndroidWidgetTextView.getText();
    }
    setContentDescription(str1);
  }
  
  public void setHead(Bitmap paramBitmap)
  {
    jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
  
  public void setNickName(String paramString)
  {
    jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}
