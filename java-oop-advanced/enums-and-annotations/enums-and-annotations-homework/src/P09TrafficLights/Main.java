package P09TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		List<TrafficLight> trafficLights = new ArrayList<>();
		String[] tokens = reader.readLine().split("\\s+");
		for (String token : tokens) {
			TrafficLight trafficLight = TrafficLight.valueOf(token.trim());
			trafficLights.add(trafficLight);
		}
		
		
		int n = Integer.valueOf(reader.readLine());
		
		while (n-- > 0) {
			trafficLights = updateTrafficLights(trafficLights);
			printTrafficLights(trafficLights);
		}
		
		
	}
	
	private static List<TrafficLight> updateTrafficLights(List<TrafficLight> trafficLights) {
		return trafficLights.stream()
				.map(Main::updateTrafficLight)
				.collect(Collectors.toList());
	}
	
	private static TrafficLight updateTrafficLight(TrafficLight trafficLight) {
		TrafficLight result = null;
		switch (trafficLight){
			case RED:
				result = TrafficLight.GREEN;
				break;
			case GREEN:
				result = TrafficLight.YELLOW;
				break;
			case YELLOW:
				result =  TrafficLight.RED;
				break;
		}
		return result;
	}
	
	private static void printTrafficLights(List<TrafficLight> trafficLights) {
		String result = trafficLights.stream().map(Enum::name).collect(Collectors.joining(" "));
		System.out.println(result);
	}
}
