package week13.task1;

public class Logger {
    private static Logger instance;

    public Logger(){
        //System.out.println("Logger instance");
    }

    public static synchronized Logger getInstance() {
        if(instance==null){
          instance = new Logger();
        }
        return instance;
    }
    public void log(String message){
        System.out.println("Log" + message);
    }
    public void logInfo(String message){
        System.out.println("LogInfo"+ message);
    }
    public void logWarning(String message){
        System.out.println("LogWaring"+message);
    }
    public void logError(String message){
        System.out.println("LogError"+message);
    }

    public static void main(String[] args){
        Logger log = Logger.getInstance();
        log.log("login...");
        log.logError("Error...");
        log.logInfo("bla");
        log.logWarning("bla");

    }
}
