package com.reactnativecommunity.webview;

import android.app.DownloadManager;
import android.net.Uri;

import androidx.annotation.NonNull;
import android.webkit.ValueCallback;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = RNCWebViewModuleImpl.NAME)
public class RNCWebViewModule extends ReactContextBaseJavaModule {
    final private RNCWebViewModuleImpl mRNCWebViewModuleImpl;

    public RNCWebViewModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mRNCWebViewModuleImpl = new RNCWebViewModuleImpl(reactContext);
    }

    @ReactMethod
    public void isFileUploadSupported(final Promise promise) {
        promise.resolve(mRNCWebViewModuleImpl.isFileUploadSupported());
    }

    @ReactMethod
    public void shouldStartLoadWithLockIdentifier(boolean shouldStart, double lockIdentifier) {
        mRNCWebViewModuleImpl.shouldStartLoadWithLockIdentifier(shouldStart, lockIdentifier);
    }

    public void startPhotoPickerIntent(ValueCallback<Uri> filePathCallback, String acceptType) {
        mRNCWebViewModuleImpl.startPhotoPickerIntent(acceptType, filePathCallback);
    }

    public boolean startPhotoPickerIntent(final ValueCallback<Uri[]> callback, final String[] acceptTypes, final boolean allowMultiple) {
        return mRNCWebViewModuleImpl.startPhotoPickerIntent(acceptTypes, allowMultiple, callback);
    }

    public void setDownloadRequest(DownloadManager.Request request) {
        mRNCWebViewModuleImpl.setDownloadRequest(request);
    }

    public void downloadFile(String downloadingMessage) {
        mRNCWebViewModuleImpl.downloadFile(downloadingMessage);
    }

    public boolean grantFileDownloaderPermissions(String downloadingMessage, String lackPermissionToDownloadMessage) {
        return mRNCWebViewModuleImpl.grantFileDownloaderPermissions(downloadingMessage, lackPermissionToDownloadMessage);
    }

    @NonNull
    @Override
    public String getName() {
        return RNCWebViewModuleImpl.NAME;
    }
}