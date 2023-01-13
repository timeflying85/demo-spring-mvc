package be.technifutur.java.mvc.services;


import be.technifutur.java.mvc.models.Hotel;
import be.technifutur.java.mvc.models.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class HotelService {

    private static final List<Hotel> list = new ArrayList<>();

    public HotelService(RoomService roomService) {

        List<Room> rooms = new ArrayList<>();
        rooms.add(roomService.getOne(1));
        rooms.add(roomService.getOne(3));
        rooms.add(roomService.getOne(4));
        rooms.add(roomService.getOne(7));
        rooms.add(roomService.getOne(15));

        list.add(
                Hotel.builder()
                        .ID(1)
                        .nomReceptionist("Jack")
                        .nbrEtoiles(3)
                        .nom("Overlook")
                        .adresse("Timberline Lodge, Mt. Hood, Oregon")
                        .rooms(rooms)
                        .build()
        );
        rooms.forEach(r -> r.setHotel(list.get(0)));


        rooms = new ArrayList<>();
        rooms.add(roomService.getOne(2));
        rooms.add(roomService.getOne(8));
        rooms.add(roomService.getOne(12));

        list.add(
                Hotel.builder()
                        .ID(2)
                        .nomReceptionist("Miss Chloe")
                        .nbrEtoiles(1)
                        .nom("IciBas")
                        .adresse("Madrid, Espagne")
                        .rooms(rooms)
                        .build()
        );
        rooms.forEach(r -> r.setHotel(list.get(1)));


        rooms = new ArrayList<>();
        rooms.add(roomService.getOne(3));
        rooms.add(roomService.getOne(6));
        rooms.add(roomService.getOne(15));

        list.add(
                Hotel.builder()
                        .ID(3)
                        .nomReceptionist("Mr. Gustave")
                        .nbrEtoiles(5)
                        .nom("The Grand Budapest")
                        .adresse("Gorlitz, Germany")
                        .rooms(rooms)
                        .build()
        );
        rooms.forEach(r -> r.setHotel(list.get(2)));


        rooms = new ArrayList<>();
        rooms.add(roomService.getOne(7));
        rooms.add(roomService.getOne(9));
        rooms.add(roomService.getOne(13));
        rooms.add(roomService.getOne(14));

        list.add(
                Hotel.builder()
                        .ID(4)
                        .nomReceptionist("Miss Rose")
                        .nbrEtoiles(2)
                        .nom("Le Monarque")
                        .adresse("Seaside, Miami")
                        .rooms(rooms)
                        .build()
        );
        rooms.forEach(r -> r.setHotel(list.get(3)));


        rooms = new ArrayList<>();
        rooms.add(roomService.getOne(2));
        rooms.add(roomService.getOne(5));
        rooms.add(roomService.getOne(10));

        list.add(
                Hotel.builder()
                        .ID(5)
                        .nomReceptionist("Norma Jennings")
                        .nbrEtoiles(4)
                        .nom("The Great Northern")
                        .adresse("Twin Peaks")
                        .rooms(rooms)
                        .build()
        );
        rooms.forEach(r -> r.setHotel(list.get(4)));

        rooms = new ArrayList<>();
        rooms.add(roomService.getOne(4));
        rooms.add(roomService.getOne(9));
        rooms.add(roomService.getOne(11));
        rooms.add(roomService.getOne(14));

        list.add(
                Hotel.builder()
                        .ID(6)
                        .nomReceptionist("Mr Albert")
                        .nbrEtoiles(3)
                        .nom("Au Doux Sommeil")
                        .adresse("Vevey, Suisse")
                        .rooms(rooms)
                        .build()
        );
        rooms.forEach(r -> r.setHotel(list.get(5)));


        rooms = new ArrayList<>();
        rooms.add(roomService.getOne(5));
        rooms.add(roomService.getOne(7));
        rooms.add(roomService.getOne(13));
        rooms.add(roomService.getOne(15));

        list.add(
                Hotel.builder()
                        .ID(7)
                        .nomReceptionist("Miss Hope")
                        .nbrEtoiles(3)
                        .nom("La Colombe")
                        .adresse("Paradis, Belgique")
                        .rooms(rooms)
                        .build()
        );
        rooms.forEach(r -> r.setHotel(list.get(6)));


    }

   /* public HotelService(){
        hotels.add(new Hotel(1, 5,"Le Monarque","Albert","Avenue Royale 45, Vevey, Suisse"));
        hotels.add(new Hotel(2, 1,"Le Havre","Louise","Rue de l'impasse 12, Outsiplou, Belgique"));
        hotels.add(new Hotel(3, 4,"IciBas","Chloe","Boulevard du paradis 69, Seaside, USA"));
        hotels.add(new Hotel(4, 2,"La Colombe","Hope","Place du marché 22, Madrid, Espagne"));
        hotels.add(new Hotel(5, 5,"La Villa des Roses","Melodie","Impasse du bonheur 1, Paradis, Belgique"));
    }*/

    public List<Hotel> getAll() {

        return new ArrayList<>(list);
    }

    public Hotel getById(long ID){
        return list.stream()
                .filter(h -> h.getID() == ID)
                .findAny()
                .orElseThrow( () -> new RuntimeException(("Il n'y a pas d'hotel de cet ID dans la liste !") ) );
    }
}
