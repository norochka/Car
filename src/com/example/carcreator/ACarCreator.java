package com.example.carcreator;

import static com.example.utils.Utils.log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

import com.example.constance.GlobalConstance;
import com.example.utils.ISettings_;
import com.example.utils.Utils;

@EActivity(R.layout.activity_acar_creator)
public class ACarCreator extends Activity {
	@Pref
	ISettings_ myPrefs;

	@ViewById
	ImageButton ibAdd, ibList;

	@ViewById
	EditText etCarName, etEngineVolume, etDoorsAmmount, etProductionYear;

	@ViewById
	SeekBar sbProductionYear;

	@AfterViews
	void afterViews() {
		File extStorDir = Environment.getExternalStorageDirectory();

		GlobalConstance.list = (ArrayList<Car>) Car.listAll(Car.class);
		// GlobalConstance.list = Utils.deserealization(extStorDir
		// .getAbsolutePath() + "/car.ser");

		myPrefs.name().put("Igor");
		myPrefs.age().put(24);
		myPrefs.haveBoyFriend().put(false);

		String name = myPrefs.name().get();
		int age = myPrefs.age().get();
		boolean haveBoyFriend = myPrefs.haveBoyFriend().get();
		Utils.log(name + " " + age + " " + haveBoyFriend);

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

	}

	@Click
	void ibAdd() {
		try {
			String carName = etCarName.getText().toString();
			
			// идет преобразования eddit text в int потмому что они совсем разных типов
			// \то мы берем с eddit texta text

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

			GlobalConstance.list.add(car);
			car.save();
		} catch (Exception e) {
			Toast.makeText(this, "Please fill all the fields",
					Toast.LENGTH_LONG).show();

		}

	}

	@Click
	void ibList() {
		List<Car> carsList = Car.listAll(Car.class);
		for (int i = 0; i < carsList.size(); i++) {
			log(carsList.get(i).getCarName());
		}
		Intent k = new Intent(ACarCreator.this, ACarsList_.class);
		startActivity(k);

	}

	@Override
	public void onBackPressed() {
		/*
		 * File extStorDir = Environment.getExternalStorageDirectory();
		 * Utils.log(extStorDir.getAbsolutePath());
		 * Utils.serealization(extStorDir.getAbsolutePath() + "/car.ser",
		 * GlobalConstance.list);
		 */

	}

}
