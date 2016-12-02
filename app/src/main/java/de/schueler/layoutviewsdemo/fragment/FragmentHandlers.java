package de.schueler.layoutviewsdemo.fragment;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public final class FragmentHandlers {
    public static final class HandlerId implements Parcelable {
        private final int id;

        private HandlerId(int id) {
            this.id = id;
        }

        protected HandlerId(Parcel in) {
            id = in.readInt();
        }

        public static final Creator<HandlerId> CREATOR = new Creator<HandlerId>() {
            @Override
            public HandlerId createFromParcel(Parcel in) {
                return new HandlerId(in);
            }

            @Override
            public HandlerId[] newArray(int size) {
                return new HandlerId[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
        }
    }

    private static final List<FragmentHandler> handlers = new ArrayList<>();

    public static FragmentHandler get(HandlerId id) {
        return handlers.get(id.id);
    }

    public static HandlerId put(FragmentHandler handler) {
        HandlerId handlerId = new HandlerId(handlers.size());
        handlers.add(handler);
        return handlerId;
    }

    private FragmentHandlers() {
    }
}
