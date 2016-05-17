package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.Ability;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class AbilityDao
  extends OGAbstractDao
{
  private OGEntityInfo a;
  
  public AbilityDao()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    a = 2;
  }
  
  public Entity a(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    paramEntity = (Ability)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      flags = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      return paramEntity;
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1) {
      paramNoColumnErrorHandler.a(new NoColumnError("uin", String.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("flags");
      if (i != -1) {
        break;
      }
      paramNoColumnErrorHandler.a(new NoColumnError("flags", Integer.TYPE));
      return paramEntity;
      uin = paramCursor.getString(i);
    }
    flags = paramCursor.getInt(i);
    return paramEntity;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,flags INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (Ability)paramEntity;
    paramContentValues.put("uin", uin);
    paramContentValues.put("flags", Integer.valueOf(flags));
  }
}
