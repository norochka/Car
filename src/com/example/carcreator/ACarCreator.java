package com.example.carcreator;

import static com.example.utils.Utils.log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.example.constance.GlobalConstants;
import com.example.utils.ISettings_;
import com.example.utils.Utils;

import android.graphics.BitmapFactory;

/**
 * The main Activity , the start screen of the application
 * 
 * @author eleonorakoshelva
 * 
 */
@EActivity(R.layout.activity_acar_creator)
public class ACarCreator extends Activity {
	// =========================================================================Variables
	private Bitmap bitmap;
	public String path;
	public String currentDateTimeString;

	// ==========================================================================Settings
	@Pref
	ISettings_ myPrefs;

	// =====================================================================VIEWS
	@ViewById
	ImageButton ibAdd, ibList;
	@ViewById
	EditText etCarName, etEngineVolume, etDoorsAmmount, etProductionYear;
	@ViewById
	SeekBar sbProductionYear;
	@ViewById
	ImageView ivPhoto;

	// ======================================================================VIEWS

	@AfterViews
	void afterViews() {
		File extStorDir = Environment.getExternalStorageDirectory();

		GlobalConstants.LIST = (ArrayList<Car>) Car.listAll(Car.class);
		// GlobalConstance.list = Utils.deserealization(extStorDir
		// .getAbsolutePath() + "/car.ser");

		myPrefs.name().put("Igor");
		myPrefs.age().put(24);
		myPrefs.haveBoyFriend().put(false);

		String name = myPrefs.name().get();
		int age = myPrefs.age().get();
		boolean haveBoyFriend = myPrefs.haveBoyFriend().get();
		Utils.log(name + " " + age + " " + haveBoyFriend);
		/**
		 * Seek bar used to seek the production year of the car
		 */
		sbProductionYear
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {

						etProductionYear.setText(String
								.valueOf(sbProductionYear.getProgress() + 1970));
						// TODO Auto-generated method stub
					}
				});

		// Intent k = new Intent(ACarCreator.this, ASettings_.class);
		// startActivity(k);
		Intent k = new Intent(ACarCreator.this, ACarDrawer_.class);
		startActivity(k);
	}

	/**
	 * After clicking on the button the car is saved to the car list
	 */
	@Click
	void ibAdd() {
		String currentDateTimeString = DateFormat.getDateTimeInstance().format(
				new java.util.Date());
		Toast.makeText(this, currentDateTimeString, Toast.LENGTH_LONG).show();
		try {
			String carName = etCarName.getText().toString();

			/**
			 * идет преобразования eddit text в int потмому что они совсем
			 * разных типов то мы берем с eddit texta text
			 */

			float engineVolume = Float.valueOf(etEngineVolume.getText()
					.toString());
			int doorsAmmoiunt = Integer.valueOf(etDoorsAmmount.getText()
					.toString());
			int productionYear = sbProductionYear.getProgress() + 1970;

			Car car = new Car();
			car.setCarName(carName);
			car.setDoorNumber(doorsAmmoiunt);
			car.setEngineVolume(engineVolume);
			car.setProdYear(productionYear);
			car.setPathToPhoto(path);
			car.setCurrentDate(currentDateTimeString);

			GlobalConstants.LIST.add(car);
			car.save();

		} catch (Exception e) {
			Toast.makeText(this, "Please fill all the fields",
					Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}

	}

	/**
	 * After clicking the button we receive the list of the cars and see the car
	 * name
	 */
	@Click
	void ibList() {

		List<Car> carsList = Car.listAll(Car.class);
		for (int i = 0; i < carsList.size(); i++) {
			log(carsList.get(i).getCarName());

		}
		Intent k = new Intent(ACarCreator.this, ACarsList_.class);
		startActivity(k);

	}

	/**
	 * Going back to the first screen
	 */
	@Override
	public void onBackPressed() {
		/*
		 * File extStorDir = Environment.getExternalStorageDirectory();
		 * Utils.log(extStorDir.getAbsolutePath());
		 * Utils.serealization(extStorDir.getAbsolutePath() + "/car.ser",
		 * GlobalConstance.list);
		 */

	}

	/**
	 * After clicking on image ,screen goes to camera
	 */
	@Click
	void ivPhoto() {
		/**
		 * creating new object camraIntent that is used later as a parameter to
		 * capture the picture from the camera and going back to the screen
		 */
		Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(cameraIntent, 200);
	}

	/**
	 * 
	 * @param data
	 */
	@OnActivityResult(200)
	void onResult(Intent data) {
		log("ya tut");
		Bitmap photo = (Bitmap) data.getExtras().get("data");
		ivPhoto.setImageBitmap(photo);

		// CALL THIS METHOD TO GET THE URI FROM THE BITMAP
		Uri tempUri = getImageUri(getApplicationContext(), photo);

		// CALL THIS METHOD TO GET THE ACTUAL PATH
		File finalFile = new File(getRealPathFromURI(tempUri));

		log(finalFile.getAbsolutePath());
		path = finalFile.getAbsolutePath();

	}

	public Uri getImageUri(Context inContext, Bitmap inImage) {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
		String path = Images.Media.insertImage(inContext.getContentResolver(),
				inImage, "Title", null);
		return Uri.parse(path);
	}

	public String getRealPathFromURI(Uri uri) {
		Cursor cursor = getContentResolver().query(uri, null, null, null, null);
		cursor.moveToFirst();
		int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
		return cursor.getString(idx);
	}
}
