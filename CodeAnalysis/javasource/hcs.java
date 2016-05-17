import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hcs
  implements Runnable
{
  public hcs(BaseApplicationImpl paramBaseApplicationImpl, Context paramContext, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = jdField_a_of_type_AndroidContentContext.getSharedPreferences("sp_dex_patch", 4);
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
        if ((jdField_a_of_type_Int == 501) || (jdField_a_of_type_Int == 502)) {
          localEditor.putInt("installFailCount", b + 1).commit();
        }
        i = ((SharedPreferences)localObject1).getInt("dexPatchConfigCount", 0);
        int j = ((SharedPreferences)localObject1).getInt("curDexPatchIndex", -1);
        Object localObject2 = ((SharedPreferences)localObject1).getString("dexPatchConfigList", "");
        QLog.d("BaseApplicationImpl", 1, "updatePatchConfig curPatchCount=" + i + ", curPatchIndex=" + j + ", dexPatchCfgArray=" + (String)localObject2 + ", installFailCnt=" + b);
        if ((i > 0) && (j >= 0) && (j < i) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          localObject2 = new JSONArray((String)localObject2);
          JSONArray localJSONArray = new JSONArray();
          Object localObject3 = ((JSONArray)localObject2).getJSONObject(j);
          if (localObject3 != null) {
            localJSONArray.put(localObject3);
          }
          localObject3 = ((SharedPreferences)localObject1).getString("name", "");
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            if (i == j) {
              break label508;
            }
            localObject1 = ((JSONArray)localObject2).getJSONObject(i);
            if (!((JSONObject)localObject1).has("name")) {
              break label515;
            }
            localObject1 = ((JSONObject)localObject1).getString("name");
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals(localObject3))) {
              break label508;
            }
            File localFile = new File("/data/data/com.tencent.mobileqq/files/hotpatch/" + (String)localObject1);
            if ((localFile != null) && (localFile.exists())) {
              localFile.delete();
            }
            localEditor.remove("actNvwaCheck" + (String)localObject1);
            localEditor.remove("actNvwaInstall" + (String)localObject1);
            localEditor.commit();
            break label508;
          }
          if (localJSONArray.length() > 0)
          {
            localEditor.putString("dexPatchConfigList", localJSONArray.toString());
            localEditor.putInt("dexPatchConfigCount", 1);
            localEditor.putInt("curDexPatchIndex", 0);
            localEditor.commit();
          }
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("BaseApplicationImpl", 1, "updatePatchConfig JSONException=" + localJSONException.toString());
        localJSONException.printStackTrace();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("BaseApplicationImpl", 1, "updatePatchConfig throwable=" + localThrowable.toString());
        localThrowable.printStackTrace();
        return;
      }
      label508:
      i += 1;
      continue;
      label515:
      String str = "";
    }
  }
}
