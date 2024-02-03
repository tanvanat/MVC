package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private Map<String, List<Room>> gameToRoomsMap;
    int chosenRooms = 0;
    public Model() {
        gameToRoomsMap = new HashMap<>();
        // Initialize with 5 games and 5 rooms
        for (int i = 1; i <= 5; i++) {
            String gameKey = "Game" + i;
            gameToRoomsMap.put(gameKey, new ArrayList<>());

            for (int j = 1; j <= 5; j++) {
                String roomKey = "Room" + j;
                gameToRoomsMap.get(gameKey).add(new Room(roomKey));
            }
        }
    }

    public void print() {
        System.out.println(gameToRoomsMap);
    }

    public String calculategame(String gamekey) {
        // Check if the game exists
        if (gameToRoomsMap.containsKey(gamekey)) {
            List<Room> rooms = gameToRoomsMap.get(gamekey);
            for (Room room : rooms) {
                if (!room.isChosen() && chosenRooms<=2) {
                    room.setChosen(true);
                    chosenRooms++;
                    return "Choose " + gamekey + " " + room.getName();
                }

            }
            return "No available rooms for " + gamekey + ". Choose another game.";
        }
        return "Game not found.";
    }

   
    public String calculateroom(String roomName) {
        // Iterate through all games
        for (Map.Entry<String, List<Room>> entry : gameToRoomsMap.entrySet()) {
            String gamekey = entry.getKey();
            List<Room> rooms = entry.getValue();
    
            // Find the chosen room in the list
            for (Room room : rooms) {
                if (room.getName().equals(roomName) && room.isChosen()) {
                    // Remove the chosen room
                    room.setChosen(false);
                    chosenRooms--;
                    System.out.println("Room removed: " + roomName + " for " + gamekey);
                    return "Room " + roomName + " removed for " + gamekey;
                }
            }
        }
    
        return "Room " + roomName + " not chosen or not found in any game.";
    }
    

    private static class Room {
        private String name;
        private boolean chosen;

        public Room(String name) {
            this.name = name;
            this.chosen = false;
        }

        public String getName() {
            return name;
        }

        public boolean isChosen() {
            return chosen;
        }

        public void setChosen(boolean chosen) {
            this.chosen = chosen;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "name='" + name + '\'' +
                    ", chosen=" + chosen +
                    '}';
        }
    }
}
