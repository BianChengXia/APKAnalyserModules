package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class SettingDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public SettingDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = 9;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (Setting)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      headImgTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("headImgTimestamp"));
      systemHeadID = paramCursor.getShort(paramCursor.getColumnIndex("systemHeadID"));
      bFaceFlags = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bFaceFlags")));
      bUsrType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bUsrType")));
      bHeadType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bHeadType")));
      url = paramCursor.getString(paramCursor.getColumnIndex("url"));
      bSourceType = ((byte)paramCursor.getShort(paramCursor.getColumnIndex("bSourceType")));
      updateTimestamp = paramCursor.getLong(paramCursor.getColumnIndex("updateTimestamp"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("headImgTimestamp");
      if (i != -1) {
        break label508;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("headImgTimestamp", Long.TYPE));
      label247:
      i = paramCursor.getColumnIndex("systemHeadID");
      if (i != -1) {
        break label523;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("systemHeadID", Short.TYPE));
      label282:
      i = paramCursor.getColumnIndex("bFaceFlags");
      if (i != -1) {
        break label538;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bFaceFlags", Byte.TYPE));
      label317:
      i = paramCursor.getColumnIndex("bUsrType");
      if (i != -1) {
        break label554;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bUsrType", Byte.TYPE));
      label352:
      i = paramCursor.getColumnIndex("bHeadType");
      if (i != -1) {
        break label570;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bHeadType", Byte.TYPE));
      label387:
      i = paramCursor.getColumnIndex("url");
      if (i != -1) {
        break label586;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("url", String.class));
      label421:
      i = paramCursor.getColumnIndex("bSourceType");
      if (i != -1) {
        break label601;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("bSourceType", Byte.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("updateTimestamp");
      if (i != -1) {
        break label617;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("updateTimestamp", Long.TYPE));
      return paramEntity;
      uin = paramCursor.getString(i);
      break;
      label508:
      headImgTimestamp = paramCursor.getLong(i);
      break label247;
      label523:
      systemHeadID = paramCursor.getShort(i);
      break label282;
      label538:
      bFaceFlags = ((byte)paramCursor.getShort(i));
      break label317;
      label554:
      bUsrType = ((byte)paramCursor.getShort(i));
      break label352;
      label570:
      bHeadType = ((byte)paramCursor.getShort(i));
      break label387;
      label586:
      url = paramCursor.getString(i);
      break label421;
      label601:
      bSourceType = ((byte)paramCursor.getShort(i));
    }
    label617:
    updateTimestamp = paramCursor.getLong(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,headImgTimestamp INTEGER ,systemHeadID INTEGER ,bFaceFlags INTEGER ,bUsrType INTEGER ,bHeadType INTEGER ,url TEXT ,bSourceType INTEGER ,updateTimestamp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Setting)paramEntity;
    paramContentValues.put("uin", uin);
    paramContentValues.put("headImgTimestamp", Long.valueOf(headImgTimestamp));
    paramContentValues.put("systemHeadID", Short.valueOf(systemHeadID));
    paramContentValues.put("bFaceFlags", Byte.valueOf(bFaceFlags));
    paramContentValues.put("bUsrType", Byte.valueOf(bUsrType));
    paramContentValues.put("bHeadType", Byte.valueOf(bHeadType));
    paramContentValues.put("url", url);
    paramContentValues.put("bSourceType", Byte.valueOf(bSourceType));
    paramContentValues.put("updateTimestamp", Long.valueOf(updateTimestamp));
  }
}
