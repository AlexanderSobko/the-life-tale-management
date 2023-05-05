package ru.thelifetale.management.freight;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/freights")
public class FreightController {

    private final FreightService service;

    @PostMapping
    public ResponseEntity<FreightDto> saveFreight(@RequestBody @Valid FreightDto freightDto) {
        return ResponseEntity.status(201).body(service.saveFreight(freightDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FreightDto> updateFreight(@RequestBody @Valid FreightDto freightDto,
                                                    @PathVariable(name = "id") Long id) {
        return ResponseEntity.status(201).body(service.updateFreight(freightDto, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FreightDto> getFreight(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(201).body(service.getFreight(id));
    }

    @GetMapping
    public ResponseEntity<List<FreightDto>> getFreights() {
        return ResponseEntity.status(201).body(service.getFreights());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFreight(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(201).body(service.deleteFreight(id));
    }
}
