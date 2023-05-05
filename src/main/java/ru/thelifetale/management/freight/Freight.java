package ru.thelifetale.management.freight;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@ToString
@Entity(name = "freights")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Freight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    float priceToMoscow;
    float totalDeliveryPrice;
    float expenses;
    float expectedIncome;
    LocalDate sentDate;
    LocalDate deliveryDate;

    public static Freight mapToFreight(FreightDto freightDto) {
        return Freight.builder()
                .id(freightDto.getId())
                .name(freightDto.getName())
                .priceToMoscow(freightDto.getPriceToMoscow())
                .totalDeliveryPrice(freightDto.getTotalDeliveryPrice())
                .expenses(freightDto.getExpenses())
                .expectedIncome(freightDto.getExpectedIncome())
                .sentDate(freightDto.getSentDate())
                .deliveryDate(freightDto.getDeliveryDate())
                .build();
    }

}
