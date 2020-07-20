package com.parkingApp;

public class ParkingLotService {

	String[] parkingLot;

	public void create_parking_lot(int i) {
		parkingLot = new String[i];
		System.out.println("Created parking lot with " + i + " slots\n");

	}

	public void park(String registrationNumber) {

		int parkingOccupied = 0;
		for (int i = 0; i <= parkingLot.length - 1; i++) {

			if (parkingLot[i] == null) {
				parkingLot[i] = registrationNumber;
				System.out.println("Allocated slot number: " + (i + 1));
				break;
			}
			parkingOccupied++;
		}
		if (parkingOccupied == parkingLot.length) {
			System.out.println("Sorry!!!  ParkingLot is Full");
		}

	}

	public void leave(String registrationNumber, int rentingHours) {

		int parakingSlot = 0;

		int totalRent = calculateRent(rentingHours);
		unPark(registrationNumber, parakingSlot, totalRent);
	}

	private void unPark(String registrationNumber, int parakingSlot, int totalRent) {
		for (int i = 0; i <= parkingLot.length - 1; i++) {
			if (parkingLot[i] != null && parkingLot[i].equals(registrationNumber)) {
				parkingLot[i] = null;
				parakingSlot = i + 1;

				break;
			}
		}
		if (parakingSlot == 0) {
			System.out.println("Car is not found....!!!");
		} else
			System.out.println("Registration number " + registrationNumber + "with slot number " + parakingSlot
					+ " is free with charge " + totalRent);
	}

	private int calculateRent(int rentingHours) {
		/*
		 * if (rentingHours == 0) { return 0; } return (rentingHours - 1) * 10;
		 */
		int totalRent;
		int baseHours = 2;
		int baseRent = 10;

		if (rentingHours > 0 && rentingHours <= 2) {
			return 10;
		}

		int additionalHours = rentingHours - baseHours;
		int additonalRent = additionalHours * 10;
		totalRent = baseRent + additonalRent;
		return totalRent;

	}

	public void status() {

		System.out.println("Slot No. Registration No");
		for (int i = 0; i <= parkingLot.length - 1; i++) {

			if (parkingLot[i] != null) {
				System.out.println((i + 1) + "\t" + parkingLot[i]);
			}
		}

	}
}