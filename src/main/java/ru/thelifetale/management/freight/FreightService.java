package ru.thelifetale.management.freight;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.thelifetale.management.error.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class FreightService {

    private final FreightRepository freightRepo;

    public FreightDto saveFreight(FreightDto freightDto) {
        freightDto.setId(0);
        Freight freight = freightRepo.save(Freight.mapToFreight(freightDto));
        log.info("Freight has been successfully saved with id({})!", freight.getId());
        return FreightDto.mapToFreightDto(freight);
    }

    public FreightDto updateFreight(FreightDto freightDto, Long id) {
        if (freightRepo.existsById(id)) {
            freightDto.setId(id);
            Freight freight = freightRepo.save(Freight.mapToFreight(freightDto));
            log.info("Freight with id({}) has been successfully updated!", freight.getId());
            return FreightDto.mapToFreightDto(freight);
        } else {
            throw new NotFoundException("Freight with id(%d) doesn't exists!".formatted(id));
        }
    }

    public FreightDto getFreight(Long id) {
        Freight freight = freightRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Freight with id(%d) doesn't exists!".formatted(id)));
        return FreightDto.mapToFreightDto(freight);
    }

    public List<FreightDto> getFreights() {
        return freightRepo.findAll().stream()
                .map(FreightDto::mapToFreightDto)
                .collect(Collectors.toList());
    }

    public String deleteFreight(Long id) {
        if (freightRepo.existsById(id)) {
            freightRepo.deleteById(id);
            String message = "Freight with id(%d) has been successfully deleted!".formatted(id);
            log.info(message);
            return message;
        } else {
            throw new NotFoundException("Freight with id(%d) doesn't exists!".formatted(id));
        }
    }
}
