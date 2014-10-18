package com.example.carcreator;

import com.orm.SugarRecord;

public class Car extends SugarRecord<Car>  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Represents the name of the car created
	 */
	public String carName;

	/**
	 * Represents the engine volume of the car
	 */
	public float engineVolume;

	/**
	 * Represents the door numbers of the car
	 */
	public int doorNumber;
	/**
	 * Represents the production year of the car
	 */
	public int prodYear;
}
