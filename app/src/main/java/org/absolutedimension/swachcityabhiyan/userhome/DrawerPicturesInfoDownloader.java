package org.absolutedimension.swachcityabhiyan.userhome;

import com.googlecode.flickrjandroid.photos.PhotoList;


import org.absolutedimension.swachcityabhiyan.helper.FlickrHelper;
import org.absolutedimension.swachcityabhiyan.notification.AsyncTaskNotificationListener;
import org.absolutedimension.swachcityabhiyan.notification.AsyncTaskWithNotifications;

public class DrawerPicturesInfoDownloader extends AsyncTaskWithNotifications<String, Integer, PhotoList> {
    public DrawerPicturesInfoDownloader(AsyncTaskNotificationListener<PhotoList> listener) {
        super(listener);
    }

    @Override
    protected PhotoList doInBackground(String... params) {
        return FlickrHelper.downloadPicturesForTag(params[0], 10, 0);
    }
}
