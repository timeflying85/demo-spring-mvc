package be.technifutur.java.mvc;

import be.technifutur.java.mvc.models.Hotel;
import be.technifutur.java.mvc.services.HotelService;
import be.technifutur.java.mvc.services.RoomService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class HotelServiceTest {

    private final HotelService service = new HotelService(new RoomService());

    @Test
    void getById_validId() {
        Hotel h = service.getById(1);

        assertNotNull(h);
    }
}
