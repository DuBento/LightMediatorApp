package ami.proj.lightmediator

import android.os.Parcel
import android.os.Parcelable

data class User(val name: String?, val id: Int, val color: Int) : Parcelable {
    private var spokenTime = 0

    constructor(source: Parcel) : this(
        source.readString(),
        source.readInt(),
        source.readInt()
    )

    fun getSpokenTime(): Int { return spokenTime }

    fun addSpokenTime(time: Int) { spokenTime += time }


    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeInt(id)
        writeInt(color)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }
}