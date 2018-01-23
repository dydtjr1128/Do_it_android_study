package org.androidtown.myapplication;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.SimpleAdapter;

/**
 * Created by CYSN on 2017-02-21.
 */

public class SimpleData implements Parcelable{//직렬화
    int number;
    String message;
    public SimpleData(int number, String message){
        this.number = number;
        this.message = message;
    }
    public SimpleData(Parcel src){
        number = src.readInt();
        message = src.readString();
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){
        @Override
        public SimpleData createFromParcel(Parcel in){
            return new SimpleData(in);
        }
        public SimpleData[] newArray(int size){
            return new SimpleData[size];
        }
    };
    public int describeContents(){
        return 0;
    }
    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(number);
        dest.writeString(message);
    }


}
