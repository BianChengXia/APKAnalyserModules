package org.apache.http.impl.auth;

import java.nio.charset.Charset;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthSchemeFactory;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class BasicSchemeFactory
  implements AuthSchemeFactory, AuthSchemeProvider
{
  private final Charset charset;
  
  public BasicSchemeFactory()
  {
    this(null);
  }
  
  public BasicSchemeFactory(Charset paramCharset)
  {
    charset = paramCharset;
  }
  
  public AuthScheme create(HttpContext paramHttpContext)
  {
    return new BasicScheme(charset);
  }
  
  public AuthScheme newInstance(HttpParams paramHttpParams)
  {
    return new BasicScheme();
  }
}