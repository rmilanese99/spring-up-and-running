package it.unimol.spring.up;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final List<Car> cars = new ArrayList<>();

    @GetMapping("/{index}")
    public ResponseEntity<Car> get(@PathVariable int index) {
        try {
            Car car = this.cars.get(index);

            return ResponseEntity.ok(car);
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAll(@RequestParam(required = false) String make) {
        if (make == null)
            return ResponseEntity.ok(this.cars);
        else
            return ResponseEntity.ok(this.cars.stream()
                    .filter(c -> c.getMake().equals(make))
                    .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Car> add(@RequestBody Car car) {
        this.cars.add(car);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(car);
    }

    @PutMapping("/{index}")
    public ResponseEntity<Car> replace(@PathVariable int index, @RequestBody Car car) {
        try {
            this.cars.set(index, car);
        } catch (IndexOutOfBoundsException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(car);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> delete(@PathVariable int index) {
        try {
            this.cars.remove(index);
        } catch (IndexOutOfBoundsException ignored) {
        }

        return ResponseEntity.noContent().build();
    }
}
