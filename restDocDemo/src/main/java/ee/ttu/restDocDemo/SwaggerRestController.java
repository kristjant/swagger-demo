package ee.ttu.restDocDemo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/swagger")
public class SwaggerRestController {

  //How to document:
  //https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X

  private final AtomicLong counter = new AtomicLong();

  @RequestMapping(value = "get", method = RequestMethod.GET)
  @ApiOperation(value = "Gets a car object", notes = "Returns a car object in json format")
  public Car get(@RequestParam(value = "make", defaultValue = "Lada") String make,
                 @RequestParam(value = "model", defaultValue = "Samara") String model) {
    return new Car(counter.incrementAndGet(), make, model, 2L, 4L);
  }

  @RequestMapping(value = "save", method = RequestMethod.POST)
  public Car save(@RequestBody Car car) {
    car.setId(counter.getAndIncrement());
    return car;
  }

  @RequestMapping(value = "find", method = RequestMethod.GET)
  //@ApiOperation(value = "Finds a list of all the car objects", responseContainer = "List")
  public List<Car> find() {
    List<Car> cars = new ArrayList<>();
    cars.add(new Car(counter.incrementAndGet(), "Ford", "Focus", 1L, 2L));
    cars.add(new Car(counter.incrementAndGet(), "Opel", "Omega", 3L, 4L));
    cars.add(new Car(counter.incrementAndGet(), "Renault", "Megane", 2L, 5L));
    return cars;
  }
}
