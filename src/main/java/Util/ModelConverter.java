package Util;

import Dto.HotelDTO;
import Model.Hotel;
import org.springframework.stereotype.Component;

@Component
public class ModelConverter {

    public HotelDTO convert(Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setName(hotel.getName());
        return hotelDTO;
    }
}
