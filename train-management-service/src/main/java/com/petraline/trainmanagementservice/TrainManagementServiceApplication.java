package com.petraline.trainmanagementservice;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;

import com.petraline.trainmanagementservice.repository.CityRepository;
import com.petraline.trainmanagementservice.repository.StationRepository;
import com.petraline.trainmanagementservice.repository.TrainClassRepository;
import com.petraline.trainmanagementservice.repository.TrainRepository;
import com.petraline.trainmanagementservice.repository.TrainRouteRepository;
import com.petraline.trainmanagementservice.repository.TrainSeatRepository;
import com.petraline.trainmanagementservice.repository.TrainStopRepository;
import com.petraline.trainmanagementservice.repository.TrainlineRepository;
import com.petraline.trainmanagementservice.model.City;
import com.petraline.trainmanagementservice.model.Station;
import com.petraline.trainmanagementservice.model.Train;
import com.petraline.trainmanagementservice.model.TrainClass;
import com.petraline.trainmanagementservice.model.TrainRoute;
import com.petraline.trainmanagementservice.model.TrainSeat;
import com.petraline.trainmanagementservice.model.TrainStop;
import com.petraline.trainmanagementservice.model.Trainline;

@SpringBootApplication
public class TrainManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainManagementServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(
			TrainlineRepository Trainlinerepo, 
			TrainRepository Trainrepo,
			TrainClassRepository TrainClassrepo, 
			StationRepository Stationrepo, 
			CityRepository cityRepo,
			TrainRouteRepository trainRouteRepo, 
			TrainSeatRepository trainSeatRepository, 
			TrainStopRepository trainStopRepository
		) {

		return args -> {
			/* Start Of Stub Data Generation */
			ArrayList<City> cityStubs = new ArrayList<City>();
			cityStubs.add(new City("Surabaya"));
			cityStubs.add(new City("Lamongan"));
			cityStubs.add(new City("Bojonegoro"));
			cityStubs.add(new City("Cepu"));
			cityStubs.add(new City("Weleri"));
			cityStubs.add(new City("Pekalongan"));
			cityStubs.add(new City("Tegal"));
			cityStubs.add(new City("Cirebon"));
			cityStubs.add(new City("Jatibarang"));
			cityStubs.add(new City("Haurgeulis"));
			cityStubs.add(new City("Bekasi"));
			cityStubs.add(new City("Jakarta"));
			cityRepo.saveAll(cityStubs);

			ArrayList<Station> stationStubs = new ArrayList<Station>();
			stationStubs.add(new Station("Pasar Turi", cityStubs.get(0)));
			stationStubs.add(new Station("Lamongan", cityStubs.get(1)));
			stationStubs.add(new Station("Bojonegoro", cityStubs.get(2)));
			stationStubs.add(new Station("Cepu", cityStubs.get(3)));
			stationStubs.add(new Station("Semarang Tawang", cityStubs.get(4)));
			stationStubs.add(new Station("Pekalongan", cityStubs.get(5)));
			stationStubs.add(new Station("Tegal", cityStubs.get(6)));
			stationStubs.add(new Station("Cirebon Prujakan", cityStubs.get(7)));
			stationStubs.add(new Station("Jatibarang", cityStubs.get(8)));
			stationStubs.add(new Station("Haurgeulis", cityStubs.get(9)));
			stationStubs.add(new Station("Bekasi", cityStubs.get(10)));
			stationStubs.add(new Station("Pasar Senen", cityStubs.get(11)));
			stationStubs.add(new Station("Gambir", cityStubs.get(11)));
			Stationrepo.saveAll(stationStubs);

			ArrayList<Trainline> trainlinestubs = new ArrayList<Trainline>();
			trainlinestubs.add(new Trainline("Jayabaya"));
			trainlinestubs.add(new Trainline("Bima"));
			trainlinestubs.add(new Trainline("Jayakarta"));
			trainlinestubs.add(new Trainline("Argo Bromo"));
			trainlinestubs.add(new Trainline("Petra Megah"));
			Trainlinerepo.saveAll(trainlinestubs);

			ArrayList<Train> trainstubs = new ArrayList<Train>();
			trainstubs.add(new Train("001", trainlinestubs.get(0)));
			trainstubs.add(new Train("002", trainlinestubs.get(0)));
			trainstubs.add(new Train("003", trainlinestubs.get(0)));

			trainstubs.add(new Train("011", trainlinestubs.get(1)));
			trainstubs.add(new Train("012", trainlinestubs.get(1)));
			trainstubs.add(new Train("013", trainlinestubs.get(1)));

			trainstubs.add(new Train("021", trainlinestubs.get(2)));
			trainstubs.add(new Train("022", trainlinestubs.get(2)));
			trainstubs.add(new Train("023", trainlinestubs.get(2)));

			trainstubs.add(new Train("031", trainlinestubs.get(3)));
			trainstubs.add(new Train("032", trainlinestubs.get(3)));
			trainstubs.add(new Train("033", trainlinestubs.get(3)));

			trainstubs.add(new Train("041", trainlinestubs.get(4)));
			trainstubs.add(new Train("042", trainlinestubs.get(4)));
			trainstubs.add(new Train("043", trainlinestubs.get(4)));
			Trainrepo.saveAll(trainstubs);

			ArrayList<TrainClass> trainClassStubs = new ArrayList<TrainClass>();			
			for (int i = 0; i < trainstubs.size(); i++) {
				int carriageNum = 1;
				for (int j = 0; j < 3; j++) {
					TrainClass newTC = new TrainClass(carriageNum++, "Executive " + String.valueOf(j + 1), trainstubs.get(i));
					trainClassStubs.add(newTC);
				}

				for (int j = 0; j < 4; j++) {
					TrainClass newTC = new TrainClass(carriageNum++, "Bussiness " + String.valueOf(j + 1), trainstubs.get(i));
					trainClassStubs.add(newTC);
				}

				for (int j = 0; j < 5; j++) {
					TrainClass newTC = new TrainClass(carriageNum++, "Economy " + String.valueOf(j + 1), trainstubs.get(i));
					trainClassStubs.add(newTC);
				}

			}
			TrainClassrepo.saveAll(trainClassStubs);

			ArrayList<TrainSeat> trainSeatStubs = new ArrayList<TrainSeat>();
			for (int i = 0; i < trainClassStubs.size(); i++) {
				TrainClass trainClass = trainClassStubs.get(i);
				if(trainClass.getName() == "Executive"){
					for (int row = 1; row <= 10; row++) {
						for (int col = 0; col < 4; col++) {
							TrainSeat newSeat = new TrainSeat(row, (char)('A'+ col), trainClass);
							trainSeatStubs.add(newSeat);
						}
					}
				}
				else if(trainClass.getName() == "Bussiness"){
					for (int row = 1; row <= 12; row++) {
						for (int col = 0; col < 6; col++) {
							TrainSeat newSeat = new TrainSeat(row, (char)('A'+ col), trainClass);
							trainSeatStubs.add(newSeat);
						}
					}
				}
				else if(trainClass.getName() == "Economy"){
					for (int row = 1; row <= 14; row++) {
						for (int col = 0; col < 6; col++) {
							TrainSeat newSeat = new TrainSeat(row, (char)('A'+ col), trainClass);
							trainSeatStubs.add(newSeat);
						}
					}
				}
			}
			trainSeatRepository.saveAll(trainSeatStubs);

			ArrayList<TrainRoute> trainRouteStubs = new ArrayList<TrainRoute>();
			for (int i = 0; i < trainstubs.size(); i++) {
				trainRouteStubs.add(new TrainRoute(trainstubs.get(i), stationStubs.get(0), stationStubs.get(12)));
			}
			trainRouteRepo.saveAll(trainRouteStubs);
			
			ArrayList<TrainStop> trainStopStubs = new ArrayList<TrainStop>();
			int manualId = 1;
			for (int i = 0; i < trainRouteStubs.size(); i++) {
				for (int j = 0; j < stationStubs.size(); j++) {					
					if (j == 0){
						TrainStop newTrainStop = 
						new TrainStop(
							j+1, 
							stationStubs.get(j), 
							null, 
							null, 
							LocalDateTime.now(), 
							LocalDateTime.now().plus(10, ChronoUnit.MINUTES));
						newTrainStop.setId(manualId++);
						// newTrainStop.setPrevStop(newTrainStop);
						trainStopStubs.add(newTrainStop);
					}
					else{
						LocalDateTime arrival = trainStopStubs.get(j-1).getDeparture().plus(3, ChronoUnit.HOURS);
						TrainStop newTrainStop = 
						new TrainStop(
							j+1, 
							stationStubs.get(j), 
							null,
							null, 
							arrival, 
							arrival.plus(10, ChronoUnit.MINUTES)
						);	
						newTrainStop.setId(manualId++);	
					
						trainStopStubs.add(newTrainStop);
					}
				}
			}	
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			trainStopRepository.saveAll(trainStopStubs);
			for (int i = 0; i < trainStopStubs.size(); i++) {
				if (i == 0){
					trainStopStubs.get(i).setPrevStop(null);
					trainStopStubs.get(i).setNextStop(trainStopStubs.get(i+1));
				}
				else if(i == trainStopStubs.size() - 1){
					trainStopStubs.get(i).setPrevStop(trainStopStubs.get(i-1));
				}
				else{
					trainStopStubs.get(i).setNextStop(trainStopStubs.get(i+1));
					trainStopStubs.get(i).setPrevStop(trainStopStubs.get(i-1));
				}
			}
			trainStopRepository.saveAll(trainStopStubs);	
			
			/* End Of Stub Data Generation */
		};
		
	}
}
