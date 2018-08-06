package com.dainik.bhaskar.fitness.utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.widget.DatePicker;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lenovo on 5/24/2018.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private final String DATE_FORMAT_DEFAULT = "dd-MM-yyyy";

    public static final String KEY_DATE_FROMAT = "key_date_format";
    public static final String KEY_SELECTED_DATE = "select_date";

    public interface OnDatePicked {
        void onDateProvided(String day, String month, String year);
    }

    private OnDatePicked onDatePicked;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {

            String dateFormat = bundle.getString(KEY_DATE_FROMAT);
            DateFormat format = null;
            if (TextUtils.isEmpty(dateFormat)) {
                format = new SimpleDateFormat(DATE_FORMAT_DEFAULT);
            } else {
                format = new SimpleDateFormat(dateFormat);
            }

            String selectedDate = bundle.getString(KEY_SELECTED_DATE);
            Date date = new Date();

            if (!TextUtils.isEmpty(selectedDate)) {
                try {
                    date = format.parse(selectedDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            final Calendar c = Calendar.getInstance();
            c.setTime(date);
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
            dialog.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
            return dialog;
        } else {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
            dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
            return dialog;
        }


    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        if (null != onDatePicked) {
            String _day = "" + day;
            if (day < 10) {
                _day = "0" + day;
            }
            String _month = "" + (month + 1);
            if ((month + 1) < 10) {
                _month = "0" + (month + 1);
            }
            onDatePicked.onDateProvided(_day, _month, year + "");
        }
    }

    /**
     * @param onDatePicked
     */
    public void setOnDatePicked(OnDatePicked onDatePicked) {
        this.onDatePicked = onDatePicked;
    }
}
