package com.example.carcreator;

import com.orm.SugarRecord;

public class Car extends SugarRecord<Car> implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Represents the name of the car created
	 */
	private String carName;

	/**
	 * Represents the engine volume of the car
	 */
	private float engineVolume;

	/**
	 * Represents the door numbers of the car
	 */
	private int doorNumber;
	/**
	 * Represents the production year of the car
	 */
	private int prodYear;

	public void setCarName(String name) {
		this.carName = name;
	}
	public String getCarName(){
		return this.carName;
	}
	public void setEngineVolume(float volume){
		this.engineVolume= volume;
	}
	public float getEngineVolume(){
		return this.engineVolume;
	}
	public void setDoorNumber(int doors){
		this.doorNumber= doors;
	}
	public int getDoorNumber(){
		return this.doorNumber;
	}
	public int getProdYear() {
		return prodYear;
	}
	public void setProdYear(int prodYear) {
		this.prodYear = prodYear;
	}
}
