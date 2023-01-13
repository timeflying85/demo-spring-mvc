package be.technifutur.java.mvc.controllers;


import be.technifutur.java.mvc.models.Hotel;
import be.technifutur.java.mvc.services.HotelService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/all")
    public String allHotel(Model model){
        List<Hotel> hotel = hotelService.getAll();

        model.addAttribute("hotels", hotel);

        return "hotel/hotelAll";
    }

    @GetMapping("/{ID}")
    public String oneHotel(Model model, @PathVariable long ID){
        model.addAttribute("hotel",hotelService.getById(ID));
        return "hotel/hotelOne";

    }
}
