package ru.thelifetale.management.freight;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FreightDto {

    long id;
    @NotBlank(message = "Freight's name can't be null or empty!")
    String name;
    float priceToMoscow;
    float totalDeliveryPrice;
    float expenses;
    float expectedIncome;
    LocalDate sentDate;
    LocalDate deliveryDate;

    public static FreightDto mapToFreightDto(Freight freight) {
        return FreightDto.builder()
                .id(freight.getId())
                .name(freight.getName())
                .priceToMoscow(freight.getPriceToMoscow())
                .totalDeliveryPrice(freight.getTotalDeliveryPrice())
                .expenses(freight.getExpenses())
                .expectedIncome(freight.getExpectedIncome())
                .sentDate(freight.getSentDate())
                .deliveryDate(freight.getDeliveryDate())
                .build();
    }

}
