package com.parkingApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParkingLotApp {

	public void startApp(String filePath) {
		File file = new File(filePath);

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			String command;
			ParkingLotService prk = new ParkingLotService();

			while ((command = br.readLine()) != null) {
				processCommands(command, prk);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found at path " + filePath);
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		}
	}

	private void processCommands(String command, ParkingLotService prk) {
		String[] array = command.split(" ");
		switch (array[0]) {

		case "create_parking_lot":
			int i = Integer.parseInt(array[1]);
			prk.create_parking_lot(i);
			break;

		case "park":
			prk.park(array[1]);
			break;

		case "leave":
			int a = Integer.parseInt(array[2]);
			prk.leave(array[1], a);
			break;

		case "status":
			prk.status();
			break;
		}
	}
}
