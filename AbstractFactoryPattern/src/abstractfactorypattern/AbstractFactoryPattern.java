/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactorypattern;

/**
 *
 * @author thunv
 */
public class AbstractFactoryPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println(CarFactory.buildCar(CarType.MICRO));
        System.out.println(CarFactory.buildCar(CarType.MINI));
        System.out.println(CarFactory.buildCar(CarType.LUXURY));
    }
    
}

enum CarType{
    MICRO, MINI, LUXURY
}

enum Location
{
  DEFAULT, USA, INDIA
}

abstract class Car{
    CarType model = null;
    Location location = null;
    Car(CarType model, Location location){
        this.model = model;
        this.location = location;
    }
    abstract void contruct();

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    @Override
    public String toString(){
        return "CarModel - "+model + " located in "+location;
    }
}

class Luxury extends Car{
    Luxury(Location location){
        super(CarType.LUXURY, location);
        contruct();
    }

    @Override
    void contruct() {
        System.out.println("Connecting to luxury car");
    }
}
class MicroCar extends Car
{
    MicroCar(Location location)
    {
        super(CarType.MICRO, location);
        contruct();
    }
    @Override
    protected void contruct()
    {
        System.out.println("Connecting to Micro Car ");
    }
}
 
class MiniCar extends Car
{
    MiniCar(Location location)
    {
        super(CarType.MINI,location );
        contruct();
    }
     
    @Override
    void contruct()
    {
        System.out.println("Connecting to Mini car");
    }
}
class INDIACarFactory
{
    static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case MICRO:
                car = new MicroCar(Location.INDIA);
                break;
             
            case MINI:
                car = new MiniCar(Location.INDIA);
                break;
                 
            case LUXURY:
                car = new Luxury(Location.INDIA);
                break;
                 
                default:
                break;
             
        }
        return car;
    }
}
 
class DefaultCarFactory
{
    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case MICRO:
                car = new MicroCar(Location.DEFAULT);
                break;
             
            case MINI:
                car = new MiniCar(Location.DEFAULT);
                break;
                 
            case LUXURY:
                car = new Luxury(Location.DEFAULT);
                break;
                 
                default:
                break;
             
        }
        return car;
    }
}
 
 
class USACarFactory
{
    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case MICRO:
                car = new MicroCar(Location.USA);
                break;
             
            case MINI:
                car = new MiniCar(Location.USA);
                break;
                 
            case LUXURY:
                car = new Luxury(Location.USA);
                break;
                 
                default:
                break;
             
        }
        return car;
    }
}

class CarFactory
{
    private CarFactory()
    {
         
    }
    public static Car buildCar(CarType type)
    {
        Car car = null;
        // We can add any GPS Function here which
        // read location property somewhere from configuration
        // and use location specific car factory
        // Currently I'm just using INDIA as Location
        Location location = Location.INDIA;
         
        switch(location)
        {
            case USA:
                car = USACarFactory.buildCar(type);
                break;
                 
            case INDIA:
                car = INDIACarFactory.buildCar(type);
                break;
                     
            default:
                car = DefaultCarFactory.buildCar(type);
 
        }
         
        return car;
 
    }
}
