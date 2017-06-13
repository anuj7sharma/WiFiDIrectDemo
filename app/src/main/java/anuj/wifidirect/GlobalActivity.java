/*
 * Copyright (c) 2016.  Nimble91solution Inc. and/or its affiliates. All rights reserved.
 *
 *                              Redistribution and use in source and binary forms, with or without
 *                            modification, are permitted provided that the following conditions are met:
 *
 *                            - Redistributions of source code must retain the above copyright
 *                                notice, this list of conditions and the following disclaimer.
 *
 *                            - Redistributions in binary form must reproduce the above copyright
 *                         notice, this list of conditions and the following disclaimer in the
 *                            documentation and/or other materials provided with the distribution.
 */

package anuj.wifidirect;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;


/**
 * Created by Mobilyte on 2/18/2016.
 */
public class GlobalActivity extends Application {
    private static Context context;

    public static synchronized Context getGlobalContext() {
        return context;
    }

    @Override
    public void onCreate() {

        super.onCreate();
        if (GlobalActivity.context == null) {
            GlobalActivity.context = getApplicationContext();
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
