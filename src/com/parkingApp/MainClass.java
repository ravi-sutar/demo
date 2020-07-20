package com.parkingApp;

public class MainClass {

	public static void main(String args[]) {
		String filePath = args[0];

		ParkingLotApp parkingLotApp = new ParkingLotApp();
		parkingLotApp.startApp(filePath);
	}
}