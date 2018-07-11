package com.bhaskar.utils;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by saurabh_jain on 16/3/16.
 */
public class DBToast {

    /**
     * @param context
     * @param title
     * @param message
     */
    public static void showSuccessToast(Context context, String title, String message) {
        showToast(context, title, message, R.drawable.ic_success, R.color.tc_toast_success);
    }

    /***
     * @param context
     * @param message
     */
    public static void showFailToast(Context context, String message) {
        showToast(context, context.getString(R.string.alert_title_failed), message, R.drawable.ic_fail, R.color.tc_toast_fail);
    }

    /***
     * @param context
     * @param title
     * @param message
     */
    public static void showFailToast(Context context, String title, String message) {
        showToast(context, title, message, R.drawable.ic_fail, R.color.tc_toast_fail);
    }

    /**
     * @param context
     * @param message
     */
    public static void showAlertToast(Context context, String message) {
        showToast(context, null, message, R.drawable.ic_alert, R.color.tc_toast_alert);
    }

    /***
     * @param context
     * @param title
     * @param message
     */
    public static void showAlertToast(Context context, String title, String message) {
        showToast(context, title, message, R.drawable.ic_alert, R.color.tc_toast_alert);
    }

    /**
     * @param context
     * @param message
     */
    public static void showSuccessToast(Context context, String message) {
        showToast(context, null, message, R.drawable.ic_success, R.color.tc_toast_success);
    }

    /***
     * @param context
     * @param title
     * @param message
     * @param indicatorResId
     * @param titleTextColor
     */
    private static void showToast(Context context, String title, String message, int indicatorResId,
                                  int titleTextColor) {

        Toast toast = new Toast(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.toast_info_message, null);
        TextView titleTv = (TextView) view.findViewById(R.id.tv_info_title);
        TextView msgTv = (TextView) view.findViewById(R.id.tv_info_message);
        ImageView indicatorIv = (ImageView) view.findViewById(R.id.iv_info_indicator);

        indicatorIv.setImageResource(indicatorResId);
        titleTv.setTextColor(context.getResources().getColor(titleTextColor));

        if (TextUtils.isEmpty(title)) {
            titleTv.setVisibility(View.GONE);
        } else {
            titleTv.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            msgTv.setText(Html.fromHtml(message));
        }
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
        toast.setView(view);
        toast.show();
    }
}
