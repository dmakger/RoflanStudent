package com.clown.roflanstudent.domain.model

import android.os.Parcel
import android.os.Parcelable

data class DateResultStudent(val date: String, val result: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeInt(result)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DateResultStudent> {
        override fun createFromParcel(parcel: Parcel): DateResultStudent {
            return DateResultStudent(parcel)
        }

        override fun newArray(size: Int): Array<DateResultStudent?> {
            return arrayOfNulls(size)
        }
    }
}