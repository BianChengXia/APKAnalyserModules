package com.tencent.qphone.base.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class g
  extends Writer
{
  static boolean c = true;
  static Class d;
  static Field e;
  static Field f;
  CharBuffer a;
  boolean b = false;
  private final OutputStream g;
  private CharsetEncoder h;
  private ByteBuffer i = ByteBuffer.allocate(8192);
  
  public g(File paramFile, boolean paramBoolean)
    throws IOException
  {
    this(new FileOutputStream(paramFile, paramBoolean));
  }
  
  public g(OutputStream paramOutputStream)
  {
    this(paramOutputStream, Charset.defaultCharset());
  }
  
  public g(OutputStream paramOutputStream, String paramString)
    throws UnsupportedEncodingException
  {
    super(paramOutputStream);
    if (paramString == null) {
      throw new NullPointerException();
    }
    g = paramOutputStream;
    try
    {
      h = Charset.forName(paramString).newEncoder();
      h.onMalformedInput(CodingErrorAction.REPLACE);
      h.onUnmappableCharacter(CodingErrorAction.REPLACE);
      return;
    }
    catch (Exception paramOutputStream)
    {
      throw new UnsupportedEncodingException(paramString);
    }
  }
  
  public g(OutputStream paramOutputStream, Charset paramCharset)
  {
    super(paramOutputStream);
    g = paramOutputStream;
    h = paramCharset.newEncoder();
    h.onMalformedInput(CodingErrorAction.REPLACE);
    h.onUnmappableCharacter(CodingErrorAction.REPLACE);
  }
  
  public g(OutputStream paramOutputStream, CharsetEncoder paramCharsetEncoder)
  {
    super(paramOutputStream);
    paramCharsetEncoder.charset();
    g = paramOutputStream;
    h = paramCharsetEncoder;
  }
  
  /* Error */
  private CharBuffer a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/qphone/base/util/g:b	Z
    //   4: ifne +23 -> 27
    //   7: aload_0
    //   8: aload_1
    //   9: iload_2
    //   10: iload_3
    //   11: invokestatic 118	java/nio/CharBuffer:wrap	([CII)Ljava/nio/CharBuffer;
    //   14: putfield 120	com/tencent/qphone/base/util/g:a	Ljava/nio/CharBuffer;
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 64	com/tencent/qphone/base/util/g:b	Z
    //   22: aload_0
    //   23: getfield 120	com/tencent/qphone/base/util/g:a	Ljava/nio/CharBuffer;
    //   26: areturn
    //   27: getstatic 24	com/tencent/qphone/base/util/g:c	Z
    //   30: ifeq +258 -> 288
    //   33: aload_0
    //   34: getfield 120	com/tencent/qphone/base/util/g:a	Ljava/nio/CharBuffer;
    //   37: invokevirtual 124	java/nio/CharBuffer:clear	()Ljava/nio/Buffer;
    //   40: pop
    //   41: getstatic 126	com/tencent/qphone/base/util/g:d	Ljava/lang/Class;
    //   44: ifnull +15 -> 59
    //   47: getstatic 128	com/tencent/qphone/base/util/g:e	Ljava/lang/reflect/Field;
    //   50: ifnull +9 -> 59
    //   53: getstatic 130	com/tencent/qphone/base/util/g:f	Ljava/lang/reflect/Field;
    //   56: ifnonnull +87 -> 143
    //   59: getstatic 136	android/os/Build$VERSION:SDK_INT	I
    //   62: bipush 8
    //   64: if_icmplt +161 -> 225
    //   67: getstatic 136	android/os/Build$VERSION:SDK_INT	I
    //   70: bipush 17
    //   72: if_icmpgt +153 -> 225
    //   75: ldc -118
    //   77: invokestatic 143	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   80: putstatic 126	com/tencent/qphone/base/util/g:d	Ljava/lang/Class;
    //   83: getstatic 126	com/tencent/qphone/base/util/g:d	Ljava/lang/Class;
    //   86: invokevirtual 147	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   89: ldc -107
    //   91: invokevirtual 153	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   94: putstatic 128	com/tencent/qphone/base/util/g:e	Ljava/lang/reflect/Field;
    //   97: getstatic 126	com/tencent/qphone/base/util/g:d	Ljava/lang/Class;
    //   100: invokevirtual 147	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   103: invokevirtual 147	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   106: invokevirtual 147	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   109: ldc -101
    //   111: invokevirtual 153	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   114: putstatic 130	com/tencent/qphone/base/util/g:f	Ljava/lang/reflect/Field;
    //   117: getstatic 128	com/tencent/qphone/base/util/g:e	Ljava/lang/reflect/Field;
    //   120: ifnull +10 -> 130
    //   123: getstatic 128	com/tencent/qphone/base/util/g:e	Ljava/lang/reflect/Field;
    //   126: iconst_1
    //   127: invokevirtual 161	java/lang/reflect/Field:setAccessible	(Z)V
    //   130: getstatic 130	com/tencent/qphone/base/util/g:f	Ljava/lang/reflect/Field;
    //   133: ifnull +10 -> 143
    //   136: getstatic 130	com/tencent/qphone/base/util/g:f	Ljava/lang/reflect/Field;
    //   139: iconst_1
    //   140: invokevirtual 161	java/lang/reflect/Field:setAccessible	(Z)V
    //   143: getstatic 130	com/tencent/qphone/base/util/g:f	Ljava/lang/reflect/Field;
    //   146: ifnull +133 -> 279
    //   149: getstatic 128	com/tencent/qphone/base/util/g:e	Ljava/lang/reflect/Field;
    //   152: ifnull +127 -> 279
    //   155: getstatic 126	com/tencent/qphone/base/util/g:d	Ljava/lang/Class;
    //   158: ifnull +121 -> 279
    //   161: getstatic 126	com/tencent/qphone/base/util/g:d	Ljava/lang/Class;
    //   164: aload_0
    //   165: getfield 120	com/tencent/qphone/base/util/g:a	Ljava/nio/CharBuffer;
    //   168: invokevirtual 165	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   171: ifeq +108 -> 279
    //   174: getstatic 128	com/tencent/qphone/base/util/g:e	Ljava/lang/reflect/Field;
    //   177: aload_0
    //   178: getfield 120	com/tencent/qphone/base/util/g:a	Ljava/nio/CharBuffer;
    //   181: aload_1
    //   182: invokevirtual 169	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   185: getstatic 130	com/tencent/qphone/base/util/g:f	Ljava/lang/reflect/Field;
    //   188: aload_0
    //   189: getfield 120	com/tencent/qphone/base/util/g:a	Ljava/nio/CharBuffer;
    //   192: aload_1
    //   193: arraylength
    //   194: invokestatic 175	com/tencent/commonsdk/util/LargerInteger:valueOf	(I)Ljava/lang/Integer;
    //   197: invokevirtual 169	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   200: aload_0
    //   201: getfield 120	com/tencent/qphone/base/util/g:a	Ljava/nio/CharBuffer;
    //   204: iload_2
    //   205: invokevirtual 179	java/nio/CharBuffer:position	(I)Ljava/nio/Buffer;
    //   208: pop
    //   209: aload_0
    //   210: getfield 120	com/tencent/qphone/base/util/g:a	Ljava/nio/CharBuffer;
    //   213: iload_2
    //   214: iload_3
    //   215: iadd
    //   216: invokevirtual 182	java/nio/CharBuffer:limit	(I)Ljava/nio/Buffer;
    //   219: pop
    //   220: aload_0
    //   221: getfield 120	com/tencent/qphone/base/util/g:a	Ljava/nio/CharBuffer;
    //   224: areturn
    //   225: getstatic 136	android/os/Build$VERSION:SDK_INT	I
    //   228: bipush 18
    //   230: if_icmplt -113 -> 117
    //   233: ldc -72
    //   235: invokestatic 143	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   238: putstatic 126	com/tencent/qphone/base/util/g:d	Ljava/lang/Class;
    //   241: getstatic 126	com/tencent/qphone/base/util/g:d	Ljava/lang/Class;
    //   244: ldc -107
    //   246: invokevirtual 153	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   249: putstatic 128	com/tencent/qphone/base/util/g:e	Ljava/lang/reflect/Field;
    //   252: getstatic 126	com/tencent/qphone/base/util/g:d	Ljava/lang/Class;
    //   255: invokevirtual 147	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   258: invokevirtual 147	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   261: ldc -101
    //   263: invokevirtual 153	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   266: putstatic 130	com/tencent/qphone/base/util/g:f	Ljava/lang/reflect/Field;
    //   269: goto -152 -> 117
    //   272: astore 4
    //   274: aload 4
    //   276: invokevirtual 187	java/lang/ClassNotFoundException:printStackTrace	()V
    //   279: iconst_0
    //   280: putstatic 24	com/tencent/qphone/base/util/g:c	Z
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 120	com/tencent/qphone/base/util/g:a	Ljava/nio/CharBuffer;
    //   288: aload_1
    //   289: iload_2
    //   290: iload_3
    //   291: invokestatic 118	java/nio/CharBuffer:wrap	([CII)Ljava/nio/CharBuffer;
    //   294: areturn
    //   295: astore 4
    //   297: aload 4
    //   299: invokevirtual 188	java/lang/NoSuchFieldException:printStackTrace	()V
    //   302: goto -23 -> 279
    //   305: astore 4
    //   307: aload 4
    //   309: invokevirtual 189	java/lang/IllegalArgumentException:printStackTrace	()V
    //   312: goto -33 -> 279
    //   315: astore 4
    //   317: aload 4
    //   319: invokevirtual 190	java/lang/IllegalAccessException:printStackTrace	()V
    //   322: goto -43 -> 279
    //   325: astore 4
    //   327: aload 4
    //   329: invokevirtual 191	java/lang/Throwable:printStackTrace	()V
    //   332: goto -53 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	g
    //   0	335	1	paramArrayOfChar	char[]
    //   0	335	2	paramInt1	int
    //   0	335	3	paramInt2	int
    //   272	3	4	localClassNotFoundException	ClassNotFoundException
    //   295	3	4	localNoSuchFieldException	NoSuchFieldException
    //   305	3	4	localIllegalArgumentException	IllegalArgumentException
    //   315	3	4	localIllegalAccessException	IllegalAccessException
    //   325	3	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   41	59	272	java/lang/ClassNotFoundException
    //   59	117	272	java/lang/ClassNotFoundException
    //   117	130	272	java/lang/ClassNotFoundException
    //   130	143	272	java/lang/ClassNotFoundException
    //   143	225	272	java/lang/ClassNotFoundException
    //   225	269	272	java/lang/ClassNotFoundException
    //   41	59	295	java/lang/NoSuchFieldException
    //   59	117	295	java/lang/NoSuchFieldException
    //   117	130	295	java/lang/NoSuchFieldException
    //   130	143	295	java/lang/NoSuchFieldException
    //   143	225	295	java/lang/NoSuchFieldException
    //   225	269	295	java/lang/NoSuchFieldException
    //   41	59	305	java/lang/IllegalArgumentException
    //   59	117	305	java/lang/IllegalArgumentException
    //   117	130	305	java/lang/IllegalArgumentException
    //   130	143	305	java/lang/IllegalArgumentException
    //   143	225	305	java/lang/IllegalArgumentException
    //   225	269	305	java/lang/IllegalArgumentException
    //   41	59	315	java/lang/IllegalAccessException
    //   59	117	315	java/lang/IllegalAccessException
    //   117	130	315	java/lang/IllegalAccessException
    //   130	143	315	java/lang/IllegalAccessException
    //   143	225	315	java/lang/IllegalAccessException
    //   225	269	315	java/lang/IllegalAccessException
    //   41	59	325	java/lang/Throwable
    //   59	117	325	java/lang/Throwable
    //   117	130	325	java/lang/Throwable
    //   130	143	325	java/lang/Throwable
    //   143	225	325	java/lang/Throwable
    //   225	269	325	java/lang/Throwable
  }
  
  private void a()
    throws IOException
  {
    Object localObject = CharBuffer.allocate(0);
    CoderResult localCoderResult = h.encode((CharBuffer)localObject, i, true);
    if (localCoderResult.isError())
    {
      localCoderResult.throwException();
      label30:
      localObject = h.flush(i);
    }
    for (;;)
    {
      if (((CoderResult)localObject).isUnderflow()) {
        return;
      }
      if (((CoderResult)localObject).isOverflow())
      {
        a(false);
        localObject = h.flush(i);
        continue;
        if (!localCoderResult.isOverflow()) {
          break label30;
        }
        a(false);
        break;
      }
      ((CoderResult)localObject).throwException();
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) < 0) || (paramInt2 > paramInt1) || (paramInt1 - paramInt2 < paramInt3))
    {
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("length=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("; regionStart=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("; regionLength=");
      localStringBuilder.append(paramInt3);
      throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
    }
  }
  
  private void a(CharBuffer paramCharBuffer)
    throws IOException
  {
    CoderResult localCoderResult;
    for (;;)
    {
      localCoderResult = h.encode(paramCharBuffer, i, false);
      if (!localCoderResult.isOverflow()) {
        break;
      }
      a(false);
    }
    if (localCoderResult.isError()) {
      localCoderResult.throwException();
    }
  }
  
  private void a(boolean paramBoolean)
    throws IOException
  {
    synchronized (lock)
    {
      b();
      int j = i.position();
      if (j > 0)
      {
        i.flip();
        g.write(i.array(), i.arrayOffset(), j);
        i.clear();
      }
      if (paramBoolean) {
        g.flush();
      }
      return;
    }
  }
  
  private void b()
    throws IOException
  {
    if (h == null) {
      throw new IOException("OutputStreamWriter is closed");
    }
  }
  
  public void close()
    throws IOException
  {
    synchronized (lock)
    {
      if (h != null)
      {
        a();
        a(false);
        g.close();
        h = null;
        i = null;
      }
      return;
    }
  }
  
  public void flush()
    throws IOException
  {
    a(true);
  }
  
  public void write(int paramInt)
    throws IOException
  {
    synchronized (lock)
    {
      b();
      a(CharBuffer.wrap(new char[] { (char)paramInt }));
      return;
    }
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    Object localObject = lock;
    StringBuilder localStringBuilder;
    if (paramInt2 < 0) {
      try
      {
        localStringBuilder = new StringBuilder(50);
        localStringBuilder.append("length=");
        localStringBuilder.append(paramString.length());
        localStringBuilder.append("; regionStart=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("; regionLength=");
        localStringBuilder.append(paramInt2);
        throw new StringIndexOutOfBoundsException(localStringBuilder.toString());
      }
      finally {}
    }
    if (paramString == null) {
      throw new NullPointerException("str == null");
    }
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > paramString.length() - paramInt2))
    {
      localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("length=");
      localStringBuilder.append(paramString.length());
      localStringBuilder.append("; regionStart=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("; regionLength=");
      localStringBuilder.append(paramInt2);
      throw new StringIndexOutOfBoundsException(localStringBuilder.toString());
    }
    b();
    a(CharBuffer.wrap(paramString, paramInt1, paramInt2 + paramInt1));
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    synchronized (lock)
    {
      b();
      a(paramArrayOfChar.length, paramInt1, paramInt2);
      a(a(paramArrayOfChar, paramInt1, paramInt2));
      return;
    }
  }
}
