package org.absolutedimension.swachcityabhiyan.userhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.absolutedimension.swachcityabhiyan.R;
import org.absolutedimension.swachcityabhiyan.camera.OperateCameraActivity;
import org.absolutedimension.swachcityabhiyan.camera.login.LoginActivity;
import org.absolutedimension.swachcityabhiyan.userhome.UserHomeSideDrawer;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by praka on 19-03-2016.
 */
public class HomeScreenActiivity extends AppCompatActivity {


    @Bind(R.id.photobutton) Button _photoButton;
    @Bind(R.id.taskbutton) Button _taskButton;
    @Bind(R.id.volunterbutton) Button _volunterButton;
    @Bind(R.id.notificationbutton) Button _notficationButton;
    @Bind(R.id.contributebutton) Button _contributeButton;



    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        ButterKnife.bind(this);
        _volunterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start a Login Activity
                //Pass the proper intent to it.
                Log.v("HomeScreenActivity", "Inside On Click Volunteer");
                Intent intentToLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intentToLogin);
            }
        });

        _photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start a Login Activity
                //Pass the proper intent to it.
                Log.v("HomeScreenActivity","Inside On Photo Click");
                Intent intentToTakePic = new Intent(getApplicationContext(),OperateCameraActivity.class);
                startActivity(intentToTakePic);
            }
        });
        _taskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start a Login Activity
                //Pass the proper intent to it.
                Log.v("HomeScreenActivity","Inside On Map/Task List");
                Intent intentToSideDrawer = new Intent(getApplicationContext(),UserHomeSideDrawer.class);
                startActivity(intentToSideDrawer);
            }
        });

    }
    }
