package anuj.wifidirect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

@SuppressLint("NewApi")
public class CommonMethods {
	
	public static String Tag = "AnujWiFiDemo";

	public static String getPath(Uri uri, Context context) {
		if (uri == null) {
			CommonMethods.e("", "uri is null");
			return null;
		}
		// this will only work for images selected from gallery
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
		CommonMethods.e("", "get path method->> after cursor init");
		if (cursor != null) {
			int column_index = cursor
					.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
			cursor.moveToFirst();
			return cursor.getString(column_index);
		}
		CommonMethods.e("", "get path method->> after cursor");
		CommonMethods.e("", "get path method->> " + uri.getPath());
		return uri.getPath();
	}
	


	public static void DisplayToast(Context context, String msg){
    	Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
    public static void e(String tag, String msg){
    	Log.e(tag, msg);
    }
   
    
    public static String getMeNthParamInString(String p_text,
			String p_seperator, int nThParam) { // / "TOTRPIDS=101=104" returns
												// "101" If nThParam ==
												// 2.
		String retStrThirdParam = new String("");
		int index = -1;
		int prevIdx = 0;
		int loopNM = 1;
		boolean loopBool = true;
		while (loopBool) {
			try {
				index = p_text.indexOf(p_seperator, prevIdx);
				if (loopNM >= nThParam) {
					if (index >= 0) {
						retStrThirdParam = p_text.substring(prevIdx, index);
					} else // /-1
					{
						retStrThirdParam = p_text.substring(prevIdx);
					}
					loopBool = false;
					break;
				} else {
					if (index < 0) // /-1
					{
						loopBool = false;
						retStrThirdParam = "";
						break;
					}
				}
				loopNM++;
				prevIdx = index + 1;
			} catch (Exception ex) {
				loopBool = false;
				retStrThirdParam = "";
				break;
			}
		} // /while
		if (retStrThirdParam.trim().length() <= 0) {
			retStrThirdParam = "";
		}
		return retStrThirdParam;
	}
    
    

    
    
    public static long AvailableMemory(Context context){
    	StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
    	long bytesAvailable = (long)stat.getBlockSize() * (long)stat.getAvailableBlocks();
    	long megAvailable = bytesAvailable / (1024 );
		return megAvailable;
    }
    
    
	
}
