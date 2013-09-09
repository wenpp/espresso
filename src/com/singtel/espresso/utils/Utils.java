package com.singtel.espresso.utils;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.actionbarsherlock.app.SherlockActivity;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-9-3
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    public static String getVersion(SherlockActivity context){
        return getPackageInfo(context).versionName;
    }

    private static PackageInfo getPackageInfo(SherlockActivity context){
        PackageInfo pi = null;
        try{
            pi = context.getPackageManager().getPackageInfo(context.getPackageName(),PackageManager.GET_ACTIVITIES);
        }catch(PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return pi;
    }
}
