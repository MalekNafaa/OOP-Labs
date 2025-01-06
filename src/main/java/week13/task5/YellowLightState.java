package week13.task5;

public class YellowLightState implements TrafficLightState {
    @Override
    public void transitionToRed() {
        System.out.println("Soon Switching to RED state");
    }

    @Override
    public void transitionToGreen() {
        System.out.println("Soon Switching to GREEN state");
    }

    @Override
    public void transitionToYellow() {
        System.out.println("Already in YELLOW state");
    }
}
