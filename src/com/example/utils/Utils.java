package com.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.example.carcreator.Car;
import com.example.constance.GlobalConstants;

import android.util.Log;

/**
 * Class represents Utility methods
 * 
 * @author eleonorakoshelva
 * 
 */
public class Utils {

	/**
	 * Displays message in Logcat
	 * 
	 * @param msg
	 *            string representation of the message
	 */
	public static void log(String msg) {
		Log.i(GlobalConstants.TAG, msg);
	}

	/**
	 * Converts Car List into the byte stream and writes it to a new file
	 * 
	 * @param path
	 *            path to the created file
	 * @param list
	 *            list of Cars to convert
	 */
	public static void serealization(String path, ArrayList<Car> list) {
		try {
			File f = new File(path);
			f.createNewFile();
			FileOutputStream fileOut = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(list);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	/**
	 * converts the byte stream into the Car list from the file
	 * 
	 * @param path
	 *            path of file used for deserealization
	 * @return returns deserealized car list
	 */
	public static ArrayList<Car> deserealization(String path) {
		ArrayList<Car> desCar = new ArrayList<Car>();
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			desCar = (ArrayList<Car>) in.readObject();
			in.close();
			fileIn.close();
			return desCar;
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return desCar;
	}
}
