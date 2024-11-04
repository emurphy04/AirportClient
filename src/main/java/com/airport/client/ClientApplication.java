package com.airport.client;

import com.airport.client.Model.Flight;
import com.airport.client.Service.AirportService;
import com.airport.client.Service.CityService;
import com.airport.client.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Autowired
	private AirportService airportService;

	@Autowired
	private CityService cityService;

	@Autowired
	private FlightService flightService;

	@Override
	public void run(String... args) throws Exception {
		Scanner input = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.println();
			System.out.println("Welcome to the airport management system!");
			System.out.println();
			System.out.println("1. Fetch Data");
			System.out.println("2. Upload Data");
			System.out.println("3. Edit Existing Data");
			System.out.println("4. Delete Data");
			System.out.println("5. Exit");
			String choice = input.nextLine();

			switch (choice) {
				case "1":
					// Fetch data
					System.out.println();
					System.out.println("What data would you like to fetch?");
					System.out.println();
					System.out.println("1. Airports");
					System.out.println("2. Cities");
					System.out.println("3. Flight Info");
					System.out.println("4. Passenger Info");
					choice = input.nextLine();

					switch (choice) {
						case "1":
							System.out.println();
							System.out.println("How would you like to search?");
							System.out.println();
							System.out.println("1. Search All");
							System.out.println("2. Search by ID");
							choice = input.nextLine();
							switch (choice) {
								case "1":
									airportService.getAirports();
									break;
								case "2":
									System.out.println();
									System.out.println("What is the ID?");
									int id = input.nextInt();
									input.nextLine();
									airportService.getAirportById(id);
									break;
								default:
									System.out.println("Invalid Input, please try again.");
									break;
							}
							break;

						case "2":
							System.out.println();
							System.out.println("How would you like to search?");
							System.out.println();
							System.out.println("1. Search All");
							System.out.println("2. Search by ID");
							choice = input.nextLine();
							switch (choice) {
								case "1":
									// get all cities
									cityService.getCities();
									break;
								case "2":
									// get city by id
									System.out.println();
									System.out.println("What is the ID?");
									int id = input.nextInt();
									input.nextLine();
									cityService.getCityById(id);
									break;
								default:
									System.out.println("Invalid Input, please try again.");
									break;
							}
							break;

						case "3":
							System.out.println();
							System.out.println("How would you like to search?");
							System.out.println();
							System.out.println("1. Search All");
							System.out.println("2. Search by ID");
							System.out.println("3. Search by Passenger");
							choice = input.nextLine();
							switch (choice) {
								case "1":
									// get all flights
									flightService.getFlights();
									break;
								case "2":
									// get flight by id
									System.out.println();
									System.out.println("What is the ID?");
									int id = input.nextInt();
									input.nextLine();
									flightService.getFlightById(id);
									break;
								case "3":
									// get flight by passenger
									System.out.println();
									System.out.println("What is the Passenger ID?");
									id = input.nextInt();
									input.nextLine();
									flightService.getFlightByPassenger(id);
									break;
								default:
									System.out.println("Invalid Input, please try again.");
									break;
							}
							break;

						case "4":
							System.out.println();
							System.out.println("How would you like to search?");
							System.out.println();
							System.out.println("1. Search All");
							System.out.println("2. Search by ID");
							choice = input.nextLine();
							switch (choice) {
								case "1":
									// get all passengers
									break;
								case "2":
									// get passenger by id
									break;
								default:
									System.out.println("Invalid Input, please try again.");
									break;
							}
							break;

						default:
							System.out.println("Invalid Input, please try again.");
							break;
					}
					break;

				case "2":
					// upload data
					System.out.println();
					System.out.println("What data would you like to upload?");
					System.out.println();
					System.out.println("1. Airport");
					System.out.println("2. City");
					System.out.println("3. Flight Info");
					System.out.println("4. Passenger Info");
					choice = input.nextLine();

					switch (choice) {
						case "1":
							System.out.println("Enter Airport ID to upload:");
							// get airport ID and upload data
							break;
						case "2":
							System.out.println("Enter City ID to upload:");
							// get city ID and upload data
							break;
						case "3":
							System.out.println("Enter Flight ID to upload:");
							// get flight ID and upload data
							break;
						case "4":
							System.out.println("Enter Passenger ID to upload:");
							// get passenger ID and upload data
							break;
						default:
							System.out.println("Invalid Input, please try again.");
							break;
					}
					break;

				case "3":
					// edit data
					System.out.println();
					System.out.println("What data would you like to edit?");
					System.out.println();
					System.out.println("1. Airport");
					System.out.println("2. City");
					System.out.println("3. Flight Info");
					System.out.println("4. Passenger Info");
					choice = input.nextLine();

					switch (choice) {
						case "1":
							System.out.println("Enter Airport ID to edit:");
							// get airport ID and edit data
							break;
						case "2":
							System.out.println("Enter City ID to edit:");
							// get city ID and edit data
							break;
						case "3":
							System.out.println("Enter Flight ID to edit:");
							// get flight ID and edit data
							break;
						case "4":
							System.out.println("Enter Passenger ID to edit:");
							// get passenger ID and edit data
							break;
						default:
							System.out.println("Invalid Input, please try again.");
							break;
					}
					break;

				case "4":
					// delete data
					System.out.println();
					System.out.println("What data would you like to delete?");
					System.out.println();
					System.out.println("1. Airport");
					System.out.println("2. City");
					System.out.println("3. Flight Info");
					System.out.println("4. Passenger Info");
					choice = input.nextLine();

					switch (choice) {
						case "1":
							System.out.println("Enter Airport ID to delete:");
							// get airport ID and delete data
							break;
						case "2":
							System.out.println("Enter City ID to delete:");
							// get city ID and delete data
							break;
						case "3":
							System.out.println("Enter Flight ID to delete:");
							// get flight ID and delete data
							break;
						case "4":
							System.out.println("Enter Passenger ID to delete:");
							// get passenger ID and delete data
							break;
						default:
							System.out.println("Invalid Input, please try again.");
							break;
					}
					break;

				case "5":
					System.out.println("Have a nice day!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Input, please try again.");
					break;
			}
		}
	}
}
