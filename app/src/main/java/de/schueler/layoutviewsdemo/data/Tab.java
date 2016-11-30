package de.schueler.layoutviewsdemo.data;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

public class Tab {
    @LayoutRes
    private final int layoutId;
    @StringRes
    private final int stringId;

    public Tab(@LayoutRes int layoutId, @StringRes int stringId) {
        this.layoutId = layoutId;
        this.stringId = stringId;
    }

    @LayoutRes
    public int getLayoutId() {
        return layoutId;
    }

    @StringRes
    public int getStringId() {
        return stringId;
    }
}
