package config;

/**
 * Created by Admin on 26.03.2016.
 */
public class Config {
    private int portNumber;
    private String hostName;

    public Config(String hostName, int portNumber) {
        this.portNumber = portNumber;
        this.hostName = hostName;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public String getHostName() {
        return hostName;
    }
}
