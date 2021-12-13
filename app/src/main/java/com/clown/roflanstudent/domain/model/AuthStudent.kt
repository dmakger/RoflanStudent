package com.clown.roflanstudent.domain.model

import android.os.Parcel
import android.os.Parcelable

data class AuthStudent(
    val email: String,
    val login: String,
    val password: String
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(login)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AuthStudent> {
        override fun createFromParcel(parcel: Parcel): AuthStudent {
            return AuthStudent(parcel)
        }

        override fun newArray(size: Int): Array<AuthStudent?> {
            return arrayOfNulls(size)
        }
    }
}
