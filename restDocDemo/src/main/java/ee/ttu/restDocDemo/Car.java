package ee.ttu.restDocDemo;

public class Car {

  private Long id;
  private String make;
  private String model;
  private Long engineSize;
  private Long numberOfDoors;

  public Car() {}

  public Car(Long id, String make, String model, Long engineSize, Long numberOfDoors) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.engineSize = engineSize;
    this.numberOfDoors = numberOfDoors;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Long getEngineSize() {
    return engineSize;
  }

  public void setEngineSize(Long engineSize) {
    this.engineSize = engineSize;
  }

  public Long getNumberOfDoors() {
    return numberOfDoors;
  }

  public void setNumberOfDoors(Long numberOfDoors) {
    this.numberOfDoors = numberOfDoors;
  }
}
