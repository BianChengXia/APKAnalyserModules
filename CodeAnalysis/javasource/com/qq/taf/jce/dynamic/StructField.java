package com.qq.taf.jce.dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class StructField
  extends JceField
{
  private static final Comparator<JceField> tagComp = new Comparator()
  {
    public int compare(JceField paramAnonymousJceField1, JceField paramAnonymousJceField2)
    {
      return paramAnonymousJceField1.getTag() - paramAnonymousJceField2.getTag();
    }
  };
  private JceField[] data;
  
  StructField(JceField[] paramArrayOfJceField, int paramInt)
  {
    super(paramInt);
    data = paramArrayOfJceField;
  }
  
  public JceField[] get()
  {
    return data;
  }
  
  public JceField getFieldByTag(int paramInt)
  {
    paramInt = Arrays.binarySearch(data, JceField.createZero(paramInt), tagComp);
    if (paramInt >= 0) {
      return data[paramInt];
    }
    return null;
  }
  
  public boolean setByTag(int paramInt, JceField paramJceField)
  {
    paramInt = Arrays.binarySearch(data, JceField.createZero(paramInt), tagComp);
    if (paramInt >= 0)
    {
      data[paramInt] = paramJceField;
      return true;
    }
    int i = -paramInt - 1;
    JceField[] arrayOfJceField = new JceField[data.length + 1];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfJceField[paramInt] = data[paramInt];
      paramInt += 1;
    }
    arrayOfJceField[i] = paramJceField;
    paramInt = i;
    while (paramInt < data.length)
    {
      arrayOfJceField[(paramInt + 1)] = data[paramInt];
      paramInt += 1;
    }
    return false;
  }
}
