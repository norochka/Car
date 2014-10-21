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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.constance.GlobalConstants;
import com.example.custom.adaptors.CustomAdapter;
import com.example.custom.views.CarDescriptionDialog;
import com.example.custom.views.CarDescriptionDialog_;
import com.example.utils.CarUtils;

import static com.example.utils.Utils.log;

@EActivity(R.layout.activity_acars_list)
public class ACarsList extends Activity {

	// ==================================================================VRIABLES
	public static CustomAdapter listAdapter;

	// ==================================================================VIEWS
	@ViewById
	ListView lvCars;
	@ViewById
	Button btnGetCarBiggestEngine, btnGetOldestCar, btnGetListOfOldestCars;
	@ViewById
	EditText etSearch;

	// ===================================================================VIEWS
	@AfterViews
	void afterViews() {

		listAdapter = new CustomAdapter(ACarsList.this, GlobalConstants.LIST);
		lvCars.setAdapter(listAdapter);
		;
	}

	@ItemClick
	public void lvCars(String item) {
		/**
		 * Have a cycle to look through the list of all cars
		 */
		for (int i = 0; i < GlobalConstants.LIST.size(); i++) {
			/**
			 * taking one of the cars from the array list of the cars
			 */
			Car car = GlobalConstants.LIST.get(i);
			if (car.getCarName().equals(item)) {
				/**
				 * 
				 */
				CarDescriptionDialog carDialog = CarDescriptionDialog_.build(
						ACarsList.this, car);
				Dialog newDialog = new Dialog(ACarsList.this);
				newDialog.setContentView(carDialog);
				newDialog.setTitle(car.getCarName());
				newDialog.show();
				return;
			}
		}
	}

	/**
	 * the button that shows the car with biggest engine
	 */
	@Click
	void btnGetCarBiggestEngine() {
		/**
		 * takes the car for the
		 */
		Car biggestEng = CarUtils.getCarBiggestEngine(GlobalConstants.LIST);
		Toast.makeText(this,
				biggestEng.getCarName() + " " + biggestEng.getEngineVolume(),
				Toast.LENGTH_LONG).show();
	}

	@Click
	void btnGetOldestCar() {
		Car oldCar = CarUtils.getOldestCar(GlobalConstants.LIST);
		Toast.makeText(this,
				oldCar.getCarName() + " - " + oldCar.getProdYear(),
				Toast.LENGTH_LONG).show();
	}

	@AfterTextChange
	void etSearch() {
		ArrayList<Car> serCars = new ArrayList<Car>();

		for (int i = 0; i < GlobalConstants.LIST.size(); i++) {
			Car car = GlobalConstants.LIST.get(i);
			if (car.getCarName().contains(etSearch.getText().toString())) {
				serCars.add(car);
			}
		}
		/**
		 * if we dont have car in the new list the we have the shake animation
		 */
		if (serCars.isEmpty()) {
			/**
			 * loading an animation from the xml file
			 * 
			 */
			final Animation a = AnimationUtils.loadAnimation(this,
					R.anim.shakeanim);
			/**
			 * setting an animation on edit text
			 */
			etSearch.startAnimation(a);
		}
		listAdapter.setCars(serCars);
		// call to bank
		listAdapter.notifyDataSetChanged();
		log(etSearch.getText().toString());

	}
}
