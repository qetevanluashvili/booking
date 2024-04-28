package service;

import Dto.HotelDTO;
import Dto.HotelDTOCollection;
import Req.UpdateHotelRequest;
import Request.NewHotelRequest;
import Util.ModelConverter;
import bean.Storage;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;



@Service
@RequiredArgsConstructor
public class HotelService {



    @Qualifier("fModelConverter")
    private final ModelConverter converter;

    public HotelDTO addHotel(NewHotelRequest request) {
        val hotel = Storage.addHotel(request);
        return converter.convert(hotel);
    }

    public HotelDTO updateHotel(String id, UpdateHotelRequest request) {
        val hotel = Storage.updateHotel(id, request);
        return converter.convert(hotel);
    }

    public HotelDTO deleteHotel(String id) {
        val hotel = Storage.removeHotel(id);

        return converter.convert(hotel);
    }

    public HotelDTO getHotel(String id) {
        val hotel = Storage.getHotel(id);
        return converter.convert(hotel);
    }



}
