package com.example.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.example.carcreator.Car;

import android.util.Log;
import android.widget.Toast;

public class Utils {
	public static void log(String msg) {
		Log.i("kuku", msg);
	}

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

	public static ArrayList<Car> deserealization(String path) {
		ArrayList<Car> desCar = new ArrayList<Car> ();
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
