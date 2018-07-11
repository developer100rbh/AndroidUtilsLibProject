package com.bhaskar.utils;

import android.os.Parcel;
import android.os.Parcelable;

public interface ParcelableInterface extends Parcelable {

    void readFromParcel(Parcel source);
}
