package be.technifutur.java.mvc.services;

import be.technifutur.java.mvc.models.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoomService {

    private final List<Room> rooms = new ArrayList<>();

    public RoomService(){
        rooms.add(new Room(1,1,1,22,null));
        rooms.add(new Room(2,2,2,75,null));
        rooms.add(new Room(3,3,1,62,null));
        rooms.add( new Room(4, 2, 0, 25, null) );
        rooms.add( new Room(5, 2, 0, 25, null) );
        rooms.add( new Room(6, 0, 1, 30, null) );
        rooms.add( new Room(7, 0, 2, 30, null) );
        rooms.add( new Room(8, 4, 1, 80, null));
        rooms.add( new Room(9, 1, 1, 30, null));
        rooms.add( new Room(10, 2, 2, 50, null));
        rooms.add( new Room(11, 3, 1, 70, null));
        rooms.add( new Room(12, 0, 2, 35, null));
        rooms.add( new Room(13, 0, 3, 60, null));
        rooms.add( new Room(14, 1, 1, 45, null));
        rooms.add(new Room(15,1,3,80,null));
    }

    public List<Room> getAll(){

        return new ArrayList<>(rooms);
    }

    public Room getOne (int numRoom){
        return rooms.stream()
                .filter(room -> room.getNumRoom() == numRoom)
                .findAny()
                .orElseThrow( () -> new RuntimeException(("Pas de chambre avec ce numéro") ) );
    }
}
