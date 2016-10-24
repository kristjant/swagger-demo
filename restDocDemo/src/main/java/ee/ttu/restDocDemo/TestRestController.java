package ee.ttu.restDocDemo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/restDocs")
public class TestRestController {

  private final AtomicLong counter = new AtomicLong();

  @RequestMapping(value = "get", method = RequestMethod.GET)
  public Car get(@RequestParam(value = "make", defaultValue = "2") String make,
                 @RequestParam(value = "model", defaultValue = "2") String model) {
    return new Car(counter.incrementAndGet(), make, model, 2L, 4L);
  }

  @RequestMapping(value = "save", method = RequestMethod.POST)
  public Car save(@RequestBody Car car) {
    car.setId(counter.getAndIncrement());
    return car;
  }

  @RequestMapping(value = "find", method = RequestMethod.GET)
  public List<Car> find() {
    List<Car> cars = new ArrayList<>();
    cars.add(new Car(counter.incrementAndGet(), "Ford", "2", 1L, 2L));
    cars.add(new Car(counter.incrementAndGet(), "Opel", "2", 3L, 4L));
    cars.add(new Car(counter.incrementAndGet(), "Renault", "2", 2L, 5L));
    return cars;
  }
}
