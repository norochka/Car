package com.example.custom.views;

import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import com.example.carcreator.ACarsList;
import com.example.carcreator.Car;
import com.example.carcreator.R;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

@EViewGroup(R.layout.dialog_view_list_item)
public class CarDescriptionDialog extends RelativeLayout {
	private Car car;
	private Activity activity;

	@ViewById
	public EditText etYearsNum, etVolumeNum, etDoorsNum, etCarName;
	@ViewById
	public Button btnSaveCh;

	// конструкрор класса- никогда ничего не возвращает и имя всегда совпадает с
	// именем классаб это т метож вызфывается первым при создании объекта
	// context=activity
	public CarDescriptionDialog(Context context, Car mashina) {
		super(context);
		activity = (Activity) context;
		car = mashina;
	}

	@AfterViews
	void afterViews() {
		etYearsNum.setText(String.valueOf(car.prodYear));
		etVolumeNum.setText(String.valueOf(car.engineVolume));
		etDoorsNum.setText(String.valueOf(car.doorNumber));
		etCarName.setText(car.carName);
	}

	@Click
	
	void btnSaveCh() {
		car.doorNumber = Integer.valueOf(etDoorsNum.getText().toString());
		car.engineVolume = Float.valueOf(etVolumeNum.getText().toString());
		car.prodYear = Integer.valueOf(etYearsNum.getText().toString());
		car.carName = String.valueOf(etCarName.getText().toString());
		car.save();
		List<Car> list = Car.listAll(Car.class);
		// вызывается адаптор для обновления данных на экране
		ACarsList.listAdapter.setCars(list);
		ACarsList.listAdapter.notifyDataSetChanged();
		// происходит иметация нажатия кнопки назад
		this.activity.onBackPressed();

	}

}
