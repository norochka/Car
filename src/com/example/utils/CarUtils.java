package com.example.utils;

import java.util.ArrayList;
import java.util.Iterator;

import com.example.carcreator.Car;

public class CarUtils {

	/**
	 * method iterates through car list and returns the car with the biggest
	 * engine volume
	 * 
	 * @param carList
	 *            -list of cars
	 * @return car object with biggest engine
	 */
	public static Car getCarBiggestEngine(ArrayList<Car> carList) {
		Car maxCar = null;
		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);
			if (maxCar == null) {
				maxCar = car;
				continue;
			}
			if (maxCar.engineVolume < car.engineVolume) {
				maxCar = car;
			}
		}
		return maxCar;

	}

	/**
	 * returns the oldest car in the list
	 * @param carList- list of cars
	 * @return oldest car from list
	 */
	public static Car getOldestCar(ArrayList<Car> carList) {
		Car oldCar = null;
		for (int i = 0; i < carList.size(); i++) {
			Car car = carList.get(i);
			if (oldCar == null) {
				oldCar = car;
				continue;
			}
			if (oldCar.prodYear > car.prodYear) {
				oldCar = car;
			}

		}
		return oldCar;
	}
	
	public static ArrayList<Car> getListOfOldestCars(ArrayList<Car> carList){
		ArrayList<Car> retList= new ArrayList<Car>();
		for( Car car: carList){
			if(retList.isEmpty()){
				retList.add(car);
				continue;
			}
			
			
			for(Iterator<Car> it = retList.iterator(); it.hasNext();) {
			    Car oldCar = it.next();
			    if (oldCar.prodYear> car.prodYear){
					retList.clear();
					retList.add(car);
				}
				if(oldCar.prodYear==car.prodYear){
					retList.add(car);
				}
			    
			}
			/*
		for( Car oldCar: retList){
			
			if (oldCar.prodYear> car.prodYear){
				retList.clear();
				retList.add(car);
			}
			if(oldCar.prodYear==car.prodYear){
				retList.add(car);
			}
		}*/
		}
		return retList;
	}
	
}
