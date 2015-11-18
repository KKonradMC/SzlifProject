package com.polidea.konradkrakowiak.common.ui;

import android.app.Activity;
import android.widget.Toast;
import com.polidea.konradkrakowiak.R;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import javax.inject.Inject;

public class ToastFactory {

    @Inject
    ToastFactory(){

    }
    public void cancelAllNotifications() {
        Crouton.cancelAllCroutons();
    }

    public void showError(Activity activity, Throwable exception) {
        Crouton.makeText(activity, exception.getMessage(), Style.ALERT).show();
    }

    public void showInfo(Activity activity, String message) {
        Crouton.makeText(activity, message, Style.INFO).show();
    }

    public void showError(Activity activity, int msgResId) {
        showError(activity, activity.getString(msgResId));
    }

    public void showError(Activity activity, String message) {
        Crouton.makeText(activity, message, Style.ALERT).show();
    }
}
