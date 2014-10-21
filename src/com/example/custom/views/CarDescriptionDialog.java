package com.example.custom.views;

import java.text.DateFormat;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.carcreator.ACarsList;
import com.example.carcreator.Car;
import com.example.carcreator.R;

/**
 * Dialog to display car details
 * 
 * @author eleonorakoshelva
 * 
 */
@EViewGroup(R.layout.dialog_view_list_item)
public class CarDescriptionDialog extends RelativeLayout {

	// ========================================================= Variables
	private Car car;
	private Activity activity;
	String currentDateTimeString;

	// ========================================================= VIEWS
	@ViewById
	public EditText etYearsNum, etVolumeNum, etDoorsNum, etCarName, etDate;
	@ViewById
	public Button btnSaveCh;
	@ViewById
	public ImageView ivPhoto;

	// ========================================================= VIEWS

	// конструкрор класса- никогда ничего не возвращает и имя всегда совпадает с
	// именем классаб это т метож вызфывается первым при создании объекта
	// context=activity

	public CarDescriptionDialog(Context context, Car mashina) {
		super(context);
		activity = (Activity) context;
		this.car = mashina;
	}

	/**
	 * describes all the views that are recieved after the launch of the dialog
	 */
	@AfterViews
	void afterViews() {
		/**
		 * Car name, production year of the car, engine volume, doors amount and
		 * the picture of the car and time and date of car creation
		 */
		etYearsNum.setText(String.valueOf(car.getProdYear()));
		etVolumeNum.setText(String.valueOf(car.getEngineVolume()));
		etDoorsNum.setText(String.valueOf(car.getDoorNumber()));
		etCarName.setText(car.getCarName());
		etDate.setText(car.getCurrentDate());
		Bitmap myBitmap = BitmapFactory.decodeFile(car.getPathToPhoto());
		ivPhoto.setImageBitmap(myBitmap);
	}

	/**
	 * Changes that are made to the car details are saved after the click on the
	 * Save changes button
	 */
	@Click
	void btnSaveCh() {
		car.setDoorNumber(Integer.valueOf(etDoorsNum.getText().toString()));
		car.setEngineVolume(Float.valueOf(etVolumeNum.getText().toString()));
		car.setProdYear(Integer.valueOf(etYearsNum.getText().toString()));
		car.setCarName(String.valueOf(etCarName.getText().toString()));
		car.save();
		List<Car> list = Car.listAll(Car.class);
		// вызывается адаптор для обновления данных на экране
		ACarsList.listAdapter.setCars(list);
		ACarsList.listAdapter.notifyDataSetChanged();
		// происходит иметация нажатия кнопки назад
		this.activity.onBackPressed();

	}

}
