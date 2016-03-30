package org.absolutedimension.swachcityabhiyan.common;

import android.app.Service;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;


import org.absolutedimension.swachcityabhiyan.R;
import org.absolutedimension.swachcityabhiyan.viewmodels.ExampleSourceModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleFragmentBase extends Fragment {

    private ExampleLoadedListener listener;

    public boolean onBackPressed() {
        return false;
    }

    public ExampleFragmentBase() {
        // Required empty public constructor
    }

    public void unloadExample() {
    }

    public void onHidden() {

    }

    public void onVisualized() {

    }

    public void onExampleSuspended() {

    }

    public void onExampleResumed() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            if (this.usesInternet()) {
                ConnectivityManager connectivityManager =
                        (ConnectivityManager) this.getActivity().getSystemService(Service.CONNECTIVITY_SERVICE);
                NetworkInfo ni = connectivityManager.getActiveNetworkInfo();

                if (ni == null || !ni.isConnectedOrConnecting()) {
                    Toast toast = Toast.makeText(this.getActivity(), R.string.internet_connectivity_prompt, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }
    }

    public ExampleSourceModel getSourceCodeModel() {
        return new ExampleSourceModel(this.getClassHierarchyNames());
    }

    public String getEQATECCategory() {
        return "";
    }

    @Override
    public void onResume() {
        super.onResume();
        if (this.listener != null) {
            this.listener.onExampleLoaded(this.getView());
        }
    }

    public void setOnExampleLoadedListener(ExampleLoadedListener listener) {
        if (listener != null && this.listener != null) {
            throw new IllegalArgumentException("Listener already set!");
        }
        this.listener = listener;
    }

    protected boolean usesInternet() {
        return false;
    }

    private ArrayList<String> getClassHierarchyNames() {
        ArrayList<String> classes = new ArrayList<String>();

        for (Class c = this.getClass(); c != null; c = c.getSuperclass()) {
            if (c.getSimpleName().equals(ExampleFragmentBase.class.getSimpleName())) {
                break;
            }

            classes.add(c.getSimpleName());
        }

        return classes;
    }


    public interface ExampleLoadedListener {
        void onExampleLoaded(View root);
    }
}
