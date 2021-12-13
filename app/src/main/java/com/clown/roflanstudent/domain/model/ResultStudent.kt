package com.clown.roflanstudent.domain.model

import android.os.Parcel
import android.os.Parcelable

data class ResultStudent(
    val lesson: String,
    val result: List<DateResultStudent>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.createTypedArrayList(DateResultStudent)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(lesson)
        parcel.writeTypedList(result)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultStudent> {
        override fun createFromParcel(parcel: Parcel): ResultStudent {
            return ResultStudent(parcel)
        }

        override fun newArray(size: Int): Array<ResultStudent?> {
            return arrayOfNulls(size)
        }
    }
}