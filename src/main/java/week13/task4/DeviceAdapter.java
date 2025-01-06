package week13.task4;

public class DeviceAdapter implements NewDevice{
    private OldDevice oldDevice;

    public DeviceAdapter(OldDevice oldDevice)
    {
        this.oldDevice=oldDevice;
    }

    @Override
    public void operateNewFunction()
    {
        oldDevice.operateOldFunction();
    }
    public static void main(String[] args) {
        NewDevice newDevice = new NewDeviceImpl();
        OldDevice oldDevice = new OldDeviceImpl();
        NewDevice adaptedDevice = new DeviceAdapter(oldDevice);

        System.out.println("Using NewDevice:");
        newDevice.operateNewFunction();

        System.out.println("Using OldDevice through DeviceAdapter:");
        adaptedDevice.operateNewFunction();
    }
}
