package com.example.custom.views;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import com.example.carcreator.ACarsList;
import com.example.carcreator.Car;
import com.example.carcreator.R;
import com.example.constance.GlobalConstance;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

@EViewGroup(R.layout.car_list_item)
public class ListItem extends RelativeLayout {

	@ViewById
	public ImageView ivPicture, ivDelete;

	@ViewById
	public TextView tvCarName;

	private Car car;

	public ListItem(Context context) {
		super(context);
	}

	public void setCar(Car setCar) {
		this.car = setCar;
	}

	@Click
	void ivDelete() {
		car.delete();
		List<Car> listAllCars = Car.listAll(Car.class);
		GlobalConstance.list.remove(car);
		//GlobalConstance.list =(ArrayList<Car>) listAllCars;
		ACarsList.listAdapter.setCars(listAllCars);
		ACarsList.listAdapter.notifyDataSetChanged();
	}
}
