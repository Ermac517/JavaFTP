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
    
    public Client() {
        ftpClient = new FTPClient();
    }
    
    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String args[]) {
        Client client = new Client();
        final String server = "ftp.mozilla.org";
        
        try {
            if (client.connectToServer(server)) {
                System.out.println("Connected to server: " + server);
            } else {
                System.out.println("Could not connect to server " + server);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.exit(0);
    }

    public boolean connectToServer(final String server) throws IOException {
        
        if (StringUtils.isEmpty(server)) {
            return false;
        }
        
        ftpClient.connect(server);
        
        if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            return false;
        }
        
        return true;
    }
    
}
