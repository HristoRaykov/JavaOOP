package P08PetClinics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class PetClinic implements Iterable<Room> {
	
	private String name;
	
	private final Room[] rooms;
	
	private final int MIDDLE_ROOM_INDEX;
	
	
	public PetClinic(String name, Integer numberOfRooms) throws IllegalArgumentException {
		this.name = name;
		if (((numberOfRooms % 2) == 0) || numberOfRooms==0) {
			throw new IllegalArgumentException("Invalid Operation!");
		}
		this.rooms = new Room[numberOfRooms];
		for (int i = 0; i < this.getRooms().length; i++) {
			rooms[i] = new Room();
		}
		if (this.getRooms().length<3){
			MIDDLE_ROOM_INDEX = 1;
		}else {
			MIDDLE_ROOM_INDEX = this.getRooms().length/2;
		}
	}
	
	
	public String getName() {
		return name;
	}
	
	public Room[] getRooms() {
		return rooms;
	}
	
	
	public boolean hasEmptyRooms() {
		return Arrays.stream(this.getRooms()).anyMatch(Room::isEmpty);
	}
	
	@Override
	public Iterator<Room> iterator() {
		return new Iterator<Room>() {
			private int cursor = 0;
			
			@Override
			public boolean hasNext() {
				return this.cursor < getRooms().length;
			}
			
			@Override
			public Room next() {
				return rooms[cursor++];
			}
		};
	}
	
	private final class AccommodationIterator implements Iterator<Room> {
		
		private int cursor;
		
		private String side;
		
		private int cycleCounter;
		
		public AccommodationIterator() {
			if (MIDDLE_ROOM_INDEX==1){
				this.cursor=0;
			}else {
				this.cursor = MIDDLE_ROOM_INDEX;
			}
			this.side = "left";
			this.cycleCounter = 1;
		}
		
		@Override
		public boolean hasNext() {
			if (this.cursor >= getRooms().length-1){
				if (getRooms().length-1==0 && this.cursor==0){
					return true;
				}
				return false;
			}
			return true;
		}
		
		@Override
		public Room next() {
			Room room = rooms[cursor];
			if ("left".equals(side)){
				this.cursor=MIDDLE_ROOM_INDEX-this.cycleCounter;
				this.side="right";
				return room;
			}else {
				this.cursor = MIDDLE_ROOM_INDEX+this.cycleCounter;
				this.side="left";
				this.cycleCounter++;
				return room;
			}
		}
	}
	
	private final class ReleaseIterator implements Iterator<Room> {
		
		private int cursor;
		
		public ReleaseIterator() {
			if (MIDDLE_ROOM_INDEX==1){
				this.cursor=0;
			}else {
				this.cursor = MIDDLE_ROOM_INDEX;
			}
		}
		
		@Override
		public boolean hasNext() {
			if (getRooms().length-1==0){
				if (this.cursor==0){
					return true;
				}else {
					return false;
				}
			}
			if (this.cursor==getRooms().length-1) {
				this.cursor=0;
				return true;
			}
			if (this.cursor==MIDDLE_ROOM_INDEX-1){
				return false;
			}
			
			return true;
		}
		
		@Override
		public Room next() {
			return rooms[this.cursor++];
		}
	}
	
	public Iterator<Room> getAccommodationIterator(){
		return new AccommodationIterator();
	}
	
	public Iterator<Room> getReleaseIterator(){
		return new ReleaseIterator();
	}
	
}
