package com.singtel.espresso.core;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-9-3
 * Time: 下午2:07
 * To change this template use File | Settings | File Templates.
 */
public class CustomCredential {
    private String ApplicationVersion;
    private String DeviceID;
    private String OSName;
    private String OSType;
    private String OSVersion;
    private String AppID;
    private String OsID;

    public String getApplicationVersion() {
        return ApplicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        ApplicationVersion = applicationVersion;
    }

    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String deviceID) {
        DeviceID = deviceID;
    }

    public String getOSName() {
        return OSName;
    }

    public void setOSName(String OSName) {
        this.OSName = OSName;
    }

    public String getOSType() {
        return OSType;
    }

    public void setOSType(String OSType) {
        this.OSType = OSType;
    }

    public String getOSVersion() {
        return OSVersion;
    }

    public void setOSVersion(String OSVersion) {
        this.OSVersion = OSVersion;
    }

    public String getAppID() {
        return AppID;
    }

    public void setAppID(String appID) {
        AppID = appID;
    }

    public String getOsID() {
        return OsID;
    }

    public void setOsID(String osID) {
        OsID = osID;
    }
}
