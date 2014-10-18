package com.example.carcreator;

import java.util.ArrayList;

import org.androidannotations.annotations.AfterTextChange;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.constance.GlobalConstance;
import com.example.custom.adaptors.CustomAdapter;
import com.example.custom.views.CarDescriptionDialog;
import com.example.custom.views.CarDescriptionDialog_;
import com.example.utils.CarUtils;

import static com.example.utils.Utils.log;

@EActivity(R.layout.activity_acars_list)
public class ACarsList extends Activity {

	public static CustomAdapter listAdapter;

	@ViewById
	ListView lvCars;

	@ViewById
	Button btnGetCarBiggestEngine, btnGetOldestCar, btnGetListOfOldestCars;

	@ViewById
	EditText etSearch;

	@AfterViews
	void afterViews() {

		listAdapter = new CustomAdapter(ACarsList.this, GlobalConstance.list);
		lvCars.setAdapter(listAdapter);
		;
	}

	@ItemClick
	public void lvCars(String item) {
		for (int i = 0; i < GlobalConstance.list.size(); i++) {
			Car car = GlobalConstance.list.get(i);
			if (car.carName.equals(item)) {
				CarDescriptionDialog carDialog = CarDescriptionDialog_.build(
						ACarsList.this, car);
				Dialog newDialog = new Dialog(ACarsList.this);
				newDialog.setContentView(carDialog);
				newDialog.setTitle(car.carName);
				newDialog.show();
				return;
			}
		}
	}

	@Click
	void btnGetCarBiggestEngine() {
		Car biggestEng = CarUtils.getCarBiggestEngine(GlobalConstance.list);
		Toast.makeText(this,
				biggestEng.carName + " " + biggestEng.engineVolume,
				Toast.LENGTH_LONG).show();
	}

	@Click
	void btnGetOldestCar() {
		Car oldCar = CarUtils.getOldestCar(GlobalConstance.list);
		Toast.makeText(this, oldCar.carName + " - " + oldCar.prodYear,
				Toast.LENGTH_LONG).show();
	}

	@AfterTextChange
	void etSearch() {
		ArrayList<Car> serCars = new ArrayList<Car>();

		for (int i = 0; i < GlobalConstance.list.size(); i++) {
			Car car = GlobalConstance.list.get(i);
			if (car.carName.contains(etSearch.getText().toString())) {
				serCars.add(car);
			}
		}
		
		// call to bank
		listAdapter.notifyDataSetChanged();
		listAdapter.setCars(serCars);
		log(etSearch.getText().toString());

	}
}
