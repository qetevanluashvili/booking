package controller;

import Dto.HotelDTO;
import Dto.HotelDTOCollection;
import Req.UpdateHotelRequest;
import Request.NewHotelRequest;
import bean.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }



    @GetMapping("/{id}")
    public HotelDTO getHotel(@PathVariable("id") String id) {
        try {
            return hotelService.getHotel(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @PostMapping
    public HotelDTO addHotel(@RequestBody NewHotelRequest request) {
        return hotelService.addHotel(request);
    }

    @PutMapping("/{id}")
    public HotelDTO updateHotel(@PathVariable("id") String id, @RequestBody UpdateHotelRequest request) {
        try {
            return hotelService.updateHotel(id, request);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public HotelDTO deleteHotel(@PathVariable("id") String id) {
        try {
            return hotelService.deleteHotel(id);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }
}
