package org.evolution.pixelparts.utils;

import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;

import org.evolution.pixelparts.services.AutoHBMService;
import org.evolution.pixelparts.PixelParts;

public class AutoHBMUtils {

    private static boolean mAutoHBMEnabled = false;

    private static void startAutoHBM(Context context) {
        context.startServiceAsUser(new Intent(context, AutoHBMService.class),
                UserHandle.CURRENT);
        mAutoHBMEnabled = true;
    }

    private static void stopAutoHBM(Context context) {
        mAutoHBMEnabled = false;
        context.stopServiceAsUser(new Intent(context, AutoHBMService.class),
                UserHandle.CURRENT);
    }

    public static void enableAutoHBM(Context context) {
        if (PixelParts.isAutoHBMEnabled(context) && !mAutoHBMEnabled) {
            startAutoHBM(context);
        } else if (!PixelParts.isAutoHBMEnabled(context) && mAutoHBMEnabled) {
            stopAutoHBM(context);
        }
    }
}
