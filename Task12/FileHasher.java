package Task12;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class FileHasher {
    private String inputFile;
    private String outputFile;

    public FileHasher() {
        System.err.println("CREATED"); 
    }

    public void setUP(String[] args) {
        inputFile = args[0];
        outputFile = args[1];
    }

    @PostConstruct
    public void init() {
        System.err.println("PostConstruct");
    }

    @PreDestroy
    public void deconstruct() {
        System.err.println("PreDestroy");
    }

    public void info() {
        System.out.println(inputFile + " " + outputFile);
    }

    public String hash() {
        String hash = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            File file = new File(inputFile);
            FileInputStream fis = new FileInputStream(file);

            byte[] dataBytes = new byte[1024];

            int nread = 0;
            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }
            byte[] mdbytes = md.digest();

            hash = convertHashToString(mdbytes);

            file.delete();

            fis.close();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return hash;
    }

    private String convertHashToString(byte[] hash) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
