package com.example.custom.adaptors;

import java.util.ArrayList;
import java.util.List;

import com.example.carcreator.Car;
import com.example.custom.views.ListItem;
import com.example.custom.views.ListItem_;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class CustomAdapter extends BaseAdapter {

	/*********** Declare Used Variables *********/
	private Activity activity;
	private List<Car> data;

	/************* CustomAdapter Constructor *****************/
	public CustomAdapter(Activity a, ArrayList<Car> list) {
		this.data = list;
		this.activity = a;
	}

	public void setCars(List<Car> serCars){
		this.data = serCars;
	}
	
	
	/******** What is the size of Passed Arraylist Size ************/
	public int getCount() {
		return data.size();
	}

	/****** Depends upon data size called for each row , Create each ListView row *****/
	public View getView(int position, View convertView, ViewGroup parent) {
		// create new object class ListItem using word _.build
		ListItem itemList = ListItem_.build(activity);
		
		// getting car from ArrayList by position index
		Car car = data.get(position);
		
		itemList.setCar(car);
		
		// asking our viewshku for text view and set a text for it which is the name of the car from ArrayList 
		itemList.tvCarName.setText(car.carName);
		//
		return itemList;
	}

	@Override
	public Object getItem(int position) {
		return data.get(position).carName;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
