
public class Main {
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        carWash.washCar(new TrackWrap(new MyTrack()));

    }
}

class TrackWrap implements Car{
    Track track;

    public TrackWrap(Track track) {
        this.track = track;
    }

    @Override
    public void wash() {
        track.clean();
    }
}

interface Car {
    void wash();
}

interface Track {
    void clean();
}

class MyTrack implements Track {

    @Override
    public void clean() {
        System.out.println("Track is clean");
    }
}

class Audi implements Car {

    @Override
    public void wash() {
        System.out.println("Car wash");
    }
}

class CarWash {
    public void washCar(Car car){
        car.wash();
    }
}
