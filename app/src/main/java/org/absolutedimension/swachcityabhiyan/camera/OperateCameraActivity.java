package org.absolutedimension.swachcityabhiyan.camera;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import org.absolutedimension.swachcityabhiyan.R;
import org.absolutedimension.swachcityabhiyan.SwachtaImageSaver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import butterknife.Bind;

public class OperateCameraActivity extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;

    @Bind(R.id.input_name) ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //openCamera();
        dispatchTakePictureIntent();
      //
    }


    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 2;

/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(this, "Image saved to:\n" +
                data.getData()+resultCode + "", Toast.LENGTH_LONG).show();
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
                Toast.makeText(this, "Image saved to:\n" +
                        data.getData(), Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user
            }
        }
        Toast.makeText(this, "Escaped Result " +
                data.getData(), Toast.LENGTH_LONG).show();
        if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Video captured and saved to fileUri specified in the Intent
                Toast.makeText(this, "Video saved to:\n" +
                        data.getData(), Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the video capture
            } else {
                // Video capture failed, advise user
            }
        }
    }     */
    @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(getApplicationContext(), "Before camera start activity"+requestCode+"Data :"+data.toString(), Toast.LENGTH_LONG).show();

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        setContentView(R.layout.open_camera_activity);
        mImageView.setImageBitmap(bp);
    }
    SwachtaImageSaver imageSaver = null;
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
     //   if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                imageSaver = new SwachtaImageSaver(getApplicationContext());
               // photoFile = createImageFile();
                imageSaver.setDirectoryName("taskFolder");
                imageSaver.setFileName("task_photo_"+new Date().getTime());
                photoFile = imageSaver.createFile();

            } catch (Exception ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                Toast.makeText(getApplicationContext(), "Before camera start activity", Toast.LENGTH_LONG).show();
                startActivityForResult(takePictureIntent, 0);
               // startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                Toast.makeText(getApplicationContext(), "After camera start activity",Toast.LENGTH_LONG).show();
            }
      //  }
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {

        // Create an image file name
       // String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "MyFile";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        Toast.makeText(getApplicationContext(), isExternalStorageWritable(),Toast.LENGTH_LONG).show();


        String SaveFolder = "/Ready";
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        File image = new File(storageDir.toURI());
        Toast.makeText(getApplicationContext(), "File created "+image.isFile(),Toast.LENGTH_LONG).show();

       // myFolder.mkdir();

       // File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        Toast.makeText(getApplicationContext(), image.getAbsolutePath(),Toast.LENGTH_LONG).show();

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        Toast.makeText(getApplicationContext(), mCurrentPhotoPath,Toast.LENGTH_LONG).show();
        return image;
    }

    private void setPic() {
        // Get the dimensions of the View
        int targetW = mImageView.getWidth();
        int targetH = mImageView.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        mImageView.setImageBitmap(bitmap);
    }

    public void openCamera(){
        //This method opens camera feature of the mobile phone.
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }
    public String isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return "true";
        }
        return "false";
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }


    public void getLatLngLocation() {
        //this methods gets the current location of the user.
    }

    public Map returnImageWithLocation(){
        //this method will return the Images with LatLng locations of the place.
        return null;
    }
    public void saveImagesWithLocation(){
        //this method saves the photo/image clicked by the camera.
    }
}
