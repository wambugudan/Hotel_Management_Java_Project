
public class Room {
	
	//declaring the class attributes
	private int roomId;
	public int roomNumber;
	public String roomType;
	private boolean roomIsAvailable;
	public int roomPrice;
	private int numOfRooms;
	
	//creating the class constructor
	public Room(String roomType, int roomPrice) {
		numOfRooms ++;
		roomId = numOfRooms;
		roomNumber = numOfRooms;
		this.roomType = roomType;
		roomIsAvailable = true;
		this.roomPrice = roomPrice;
	}



    /**
     * @return int return the roomId
     */
    public int getRoomId() {
        return roomId;
    }


    /**
     * @return boolean return the roomIsAvailable
     */
    public boolean isRoomIsAvailable() {
        return roomIsAvailable;
    }


    /**
     * @param roomIsAvailable the roomIsAvailable to set
     */
    public void setRoomIsAvailable(boolean roomIsAvailable) {
        this.roomIsAvailable = roomIsAvailable;
    }


}
