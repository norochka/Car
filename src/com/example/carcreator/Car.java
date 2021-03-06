package com.example.carcreator;

import java.text.DateFormat;

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
	/**
	 * Represents the photo of the car taken by the camera
	 */
	private String pathToPhoto;
	/**
	 * Represents the date and time of car creation
	 */
	private String currentDate;

	/**
	 * Setter for car name
	 * 
	 * @param name
	 *            name of the car
	 */
	public void setCarName(String name) {
		this.carName = name;
	}

	/**
	 * Getter of the car name
	 * 
	 * @return returns the name of the car
	 */
	public String getCarName() {
		return this.carName;
	}

	/**
	 * Setter for the engine volume of the car
	 * 
	 * @param volume
	 *            The volume number
	 */
	public void setEngineVolume(float volume) {
		this.engineVolume = volume;
	}

	/**
	 * Getter of the volume figure
	 * 
	 * @return Returns the volume figure
	 */
	public float getEngineVolume() {
		return this.engineVolume;
	}

	/**
	 * Setter of doors amount in the car
	 * 
	 * @param doors
	 *            Number of doors
	 */
	public void setDoorNumber(int doors) {
		this.doorNumber = doors;
	}

	/**
	 * Getter of the doors amount
	 * 
	 * @return Returns the number of doors
	 */
	public int getDoorNumber() {
		return this.doorNumber;
	}

	/**
	 * Getter of the car production year
	 * 
	 * @return Returns the year of production
	 */
	public int getProdYear() {
		return prodYear;
	}

	/**
	 * Setter of the production year of the car
	 * 
	 * @param prodYear
	 *            the year of the production
	 */
	public void setProdYear(int prodYear) {
		this.prodYear = prodYear;
	}

	/**
	 * Getter for the photo path
	 * 
	 * @return returns the path to the photo that was taken
	 */
	public String getPathToPhoto() {
		return pathToPhoto;
	}

	/**
	 * Setter for the photo path
	 * 
	 * @param pathToPhoto
	 *            the path to the photo that was taken
	 */
	public void setPathToPhoto(String pathToPhoto) {
		this.pathToPhoto = pathToPhoto;
	}

	/**
	 * Getter for the Date and time
	 * 
	 * @return returns date and time of car creation
	 */
	public String getCurrentDate() {
		return currentDate;
	}

	/**
	 * Setting the date ad time of car creation
	 * 
	 * @param currentDate
	 *            current date and time of creation
	 */
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

}
