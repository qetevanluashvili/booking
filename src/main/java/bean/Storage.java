package bean;




import Model.Hotel;

import Req.UpdateHotelRequest;
import Request.NewHotelRequest;
import lombok.Getter;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
public class Storage {

    private static Map<String, Hotel> hotels;
    private static int lastId;

    @Value("${storage.max-id}")
    private static int maxId;

    public Storage() {
        this.hotels = new HashMap<>();
        this.lastId = 0;
    }

    public static Hotel addHotel(NewHotelRequest request) {
        validateHotelId();

        Hotel hotel;
        hotel = new Hotel();
        hotel.setName(request.getName());

        String hotelId = generateHotelId();
        hotels.put(hotelId, hotel);

        return hotel;
    }

    public static Hotel updateHotel(String id, UpdateHotelRequest request) {
        if (!hotels.containsKey(id)) {
            throw new EntityNotFoundException("Hotel with id " + id + " not found");
        }
        val hotel = hotels.get(id);
        hotel.setName(request.getName());
        hotels.put(id, hotel);
        return hotel;
    }

    public static Hotel removeHotel(String id) {
        if (!hotels.containsKey(id)) {
            throw new EntityNotFoundException("Hotel with id " + id + " not found");
        }
        return hotels.remove(id);
    }

    public static Hotel getHotel(String id) {
        if (!hotels.containsKey(id)) {
            throw new EntityNotFoundException("Hotel with id " + id + " not found");
        }
        return hotels.get(id);
    }

    private static void validateHotelId() {
        if (lastId > maxId) {
            throw new EntityLimitReachedException("Hotel ID limit reached");
        }
    }

    private static String generateHotelId() {
        return String.valueOf(++lastId);
    }
}
