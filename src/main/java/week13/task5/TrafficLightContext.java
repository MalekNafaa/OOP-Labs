package week13.task5;

public class TrafficLightContext {
    private TrafficLightState trafficLightState;

    public TrafficLightContext(){
        this.trafficLightState=new RedLightState();
    }
    void setState(TrafficLightState trafficLightState)
    {
        this.trafficLightState = trafficLightState;
    }

    public void transitionToRed(){
        trafficLightState.transitionToRed();
    }
    public void transitionToGreen() {
        trafficLightState.transitionToGreen();
    }

    public void transitionToYellow() {
        trafficLightState.transitionToYellow();
    }


}
