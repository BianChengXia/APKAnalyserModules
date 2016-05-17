package com.tencent.mobileqq.activity.richmedia.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext;
import com.tencent.qphone.base.util.QLog;

public class CameraTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static final String a = "CameraTextureView";
  public TexturePreviewContext a;
  
  public CameraTextureView(Context paramContext)
  {
    this(paramContext, null);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a();
  }
  
  public CameraTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    a();
  }
  
  public CameraTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setSurfaceTextureListener(this);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (QLog.isColorLevel()) {
      QLog.i("PEAK_CAMERA", 2, "onAttachedToWindow");
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (QLog.isColorLevel()) {
      QLog.i("PEAK_CAMERA", 2, "onDetachedFromWindow");
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraTextureView", 2, "onSurfaceTextureAvailable width " + paramInt1 + ", height " + paramInt2);
    }
    a.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraTextureView", 2, "onSurfaceTextureDestroyed");
    }
    a.onSurfaceTextureDestroyed(paramSurfaceTexture);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraTextureView", 2, "onSurfaceTextureSizeChanged width " + paramInt1 + ", height " + paramInt2);
    }
    a.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    a.onSurfaceTextureUpdated(paramSurfaceTexture);
  }
}
