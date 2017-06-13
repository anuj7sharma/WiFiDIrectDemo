package anuj.wifidirect.utils;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import anuj.wifidirect.R;
import anuj.wifidirect.GlobalActivity;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by anuj.sharma on 1/12/2017.
 */

public class Utils {
    private static Utils ourInstance = new Utils();
    /*
    *  -----------  Font Style Code
    * */
    private Typeface font_light, font_regular, font_bold, font_medium; // Typeface for set Font Style
    //    ----------- Set Font Cal
//    Calligrapher calligrapher;

    private Utils() {
    }

    public static Utils getInstance() {
        return ourInstance;
    }

    public static void e(Exception msge) {
        Log.i("TAG", msge.getMessage());
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null && GlobalActivity.getGlobalContext() != null) {
            context = GlobalActivity.getGlobalContext();
        }
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    public final void showToast(String toast) {
        if (toast != null) {
            Toast toast1 = Toast.makeText(GlobalActivity.getGlobalContext(), toast, Toast.LENGTH_LONG);
//            toast1.setGravity(Gravity.CENTER, 0, 0);
            toast1.show();
        }
    }

    public String getMD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    //----------      Clipboard function        ----------
    public void copytoClipboard(String str) {
        try {
            if (str != null) {
                ClipboardManager clipboard = (ClipboardManager) GlobalActivity.getGlobalContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", str);
                clipboard.setPrimaryClip(clip);
            }
            showToast("Copy to clipboard.");
        } catch (Exception e) {

        }

    }

    // --------- convert dp to pixels  -----
    float converDPtoPx(int dp) {
        Resources r = GlobalActivity.getGlobalContext().getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
        r = null;
        return px;

    }

    public void showSnakBarwithOk(View view, String message) {
        if (view != null && message != null) {

            Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("Ok", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            snackbar.setActionTextColor(ContextCompat.getColor(GlobalActivity.getGlobalContext(), R.color.colorAccent));
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(Color.parseColor("#444444"));
            TextView tv = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
            tv.setTextColor(Color.WHITE);
//            tv.setTypeface(getfontStyle(Fontstyle.FONT_REGULAR));
//            getInstance().setTextviewTypeface(tv);
            snackbar.show();
        }

    }

    // ------  Boolean for SDK Level check --------------
    public boolean isEqualLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    //------- Close Keyboard --------------
    public void hideSoftKeyboard(Context context, View view) {
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    COnfirmation Dialog
     */
    public interface ConfirmDialogCallbackInterface {
        void onYesClick(String tag);

        void onNoClick(String tag);
    }

    public void confirmDialog(Context context, String alert_msg, final String tag,
                              final ConfirmDialogCallbackInterface listener) {
        try {
            android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(context);
            alertDialogBuilder.setMessage(alert_msg);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    listener.onYesClick(tag);
                }
            });

            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    listener.onNoClick(tag);
                    dialog.dismiss();
                }
            });

            android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDeviceId(Context context) {
        try {
            // GET DEVICE ID
            String DEVICEID = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            return DEVICEID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /*
     * Alert Box
     */
    public interface okDialogInterface {
        public void onOkayClicked();
    }

    public static final void showOkDialog(String dlgText, final Context context, final okDialogInterface listener) {
        if (context == null) {
            return;
        }

        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(context);
        alertDialogBuilder.setMessage(dlgText);

        alertDialogBuilder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                listener.onOkayClicked();
            }
        });
        alertDialogBuilder.show();
    }

    // A method to find height of the status bar
    public int getStatusBarHeight(Context ctx) {
        int result = 0;
        int resourceId = ctx.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = ctx.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public boolean isMyServiceRunning(Context ctx, String serviceName) {
        ActivityManager manager = (ActivityManager) ctx.getSystemService(ctx.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceName.equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public String getFormattedTime(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM, yyyy hh:mm a", Locale.ENGLISH);
            SimpleDateFormat simpleDateFormatServer = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
            simpleDateFormatServer.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.format(simpleDateFormatServer.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getYMDFormattedTime(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            SimpleDateFormat simpleDateFormatServer = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
            simpleDateFormatServer.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.format(simpleDateFormatServer.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public File saveToDirectory(Context ctx, String name, String fileExtension) {
        File dir = new File(Environment.getExternalStorageDirectory() + File.separator +
                ctx.getString(R.string.app_name));
        if (!dir.isDirectory()) {
            dir.mkdirs();
        }
        File file = new File(dir, name + "." + fileExtension);
        if (file.isFile()) file.delete();
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Animate COlor if using Pallet library
     */
    public final static int COLOR_ANIMATION_DURATION = 1000;
    public final static int DEFAULT_DELAY = 0;

    @SuppressLint("NewApi")
    public static void animateViewColor(View v, int startColor, int endColor) {

        ObjectAnimator animator = ObjectAnimator.ofObject(v, "backgroundColor",
                new ArgbEvaluator(), startColor, endColor);

        if (Build.VERSION.SDK_INT >= 21) {
            animator.setInterpolator(new PathInterpolator(0.4f, 0f, 1f, 1f));
        }
        animator.setDuration(COLOR_ANIMATION_DURATION);
        animator.start();
    }

    /*
  Play Notification Sound Vibrate
   */
    private Vibrator vibrator;

    public void generateNotificationSound(Context ctx) {
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        vibrator = (Vibrator) ctx.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        vibrator.vibrate(500);
        //play sound
        Ringtone r = RingtoneManager.getRingtone(ctx, alarmSound);
        r.play();
    }


}
