package Model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class Hotel{
    private Integer id;
    private String name;
    private Integer capacity;
    private LocalDate bookingDate;
}
