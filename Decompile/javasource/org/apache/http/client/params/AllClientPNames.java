package org.apache.http.client.params;

import org.apache.http.auth.params.AuthPNames;
import org.apache.http.conn.params.ConnConnectionPNames;
import org.apache.http.conn.params.ConnManagerPNames;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;

@Deprecated
public abstract interface AllClientPNames
  extends AuthPNames, ClientPNames, ConnConnectionPNames, ConnManagerPNames, ConnRoutePNames, CookieSpecPNames, CoreConnectionPNames, CoreProtocolPNames
{}
