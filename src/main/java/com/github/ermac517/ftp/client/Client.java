package com.github.ermac517.ftp.client;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * Sample FTP Client
 * 
 * @author ermac517
 *
 */
public class Client {

    private FTPClient ftpClient;
    
    private static final String DEFAULT_SERVER = "ftp.mozilla.org";
    
    public Client() {
        ftpClient = new FTPClient();
    }
    
    /**
     * Main method
     * 
     * @param args the server name
     */
    public static void main(String args[]) {
        String server = DEFAULT_SERVER;
        
        Client client = new Client();
        
        if (args.length > 0) {
            server = args[0];
        }
        
        try {
            if (client.connectToServer(server)) {
                System.out.println("Connected to server: " + server);
            } else {
                System.out.println("Could not connect to server " + server);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.exit(0);
    }

    /**
     * Connects to FTP server
     * @param server the server url
     * @return true if successful, false otherwise
     * @throws IOException
     */
    public boolean connectToServer(final String server) throws IOException {
        
        if (StringUtils.isEmpty(server)) {
            return false;
        }
        
        ftpClient.connect(server);
        
        if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            return false;
        }
        
        ftpClient.disconnect();
        
        return true;
    }
    
}
