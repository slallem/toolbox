package fr.systapps.toolbox.domain;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class NetworkService {

    Environment environment;

    public NetworkService(Environment environment) {
        this.environment = environment;
    }

    public String getServerPort() {
        return environment.getProperty("local.server.port");
    }

    public String getHostAddress() {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return inetAddress == null ? "" : inetAddress.getHostAddress();
    }

    public String getHostName() {
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return inetAddress == null ? null : inetAddress.getHostName();
    }

    public boolean isDockerized() {
        File f = new File("/.dockerenv");
        return f.exists();
    }

}
