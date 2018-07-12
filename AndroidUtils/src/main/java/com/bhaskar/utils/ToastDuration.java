package com.bhaskar.utils;

import android.support.annotation.IntDef;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by saurabh_jain on 16/1/17.
 */

/**
 * @hide
 */
@IntDef({Toast.LENGTH_SHORT, Toast.LENGTH_LONG})
@Retention(RetentionPolicy.SOURCE)
public @interface ToastDuration {
}
