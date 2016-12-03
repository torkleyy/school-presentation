package de.schueler.layoutviewsdemo.data;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import de.schueler.layoutviewsdemo.fragment.FragmentHandlers;

public class Tab {
    @LayoutRes
    private final int layoutId;
    @StringRes
    private final int stringId;
    private final FragmentHandlers.HandlerId handlerId;

    public Tab(@LayoutRes int layoutId, @StringRes int stringId, FragmentHandlers.HandlerId handlerId) {
        this.layoutId = layoutId;
        this.stringId = stringId;
        this.handlerId = handlerId;
    }

    @LayoutRes
    public int getLayoutId() {
        return layoutId;
    }

    @StringRes
    public int getStringId() {
        return stringId;
    }

    public FragmentHandlers.HandlerId getHandlerId() {
        return handlerId;
    }
}
