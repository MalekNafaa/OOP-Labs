package week13.task5;

public class GreenLightState implements TrafficLightState {
    @Override
    public void transitionToRed() {
        System.out.println("Soon Switching in RED state");
    }

    @Override
    public void transitionToGreen() {
        System.out.println("Already in GREEN state");
    }

    @Override
    public void transitionToYellow() {
        System.out.println("Soon Switching to YELLOW state");
    }
}