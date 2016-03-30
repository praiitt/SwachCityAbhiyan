package org.absolutedimension.swachcityabhiyan.notification;

public interface AsyncTaskNotificationListener<T> {
    void onTaskFinished(AsyncTaskWithNotifications asyncTask, T result);
    void onTaskCancelled(AsyncTaskWithNotifications asyncTask);
}