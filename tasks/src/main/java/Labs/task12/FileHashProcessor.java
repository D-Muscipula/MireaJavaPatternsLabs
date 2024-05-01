package Labs.task12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class FileHashProcessor implements CommandLineRunner {
    private File file;
    @Override
    public void run(String... args) throws Exception {
        processFiles(args);
    }

    private void processFiles(String... args) throws IOException, NoSuchAlgorithmException {
        String inputFile = args[0];
        String outputFile = args[1];
        file = new File(inputFile);
        if (!file.exists()) {
            Files.write(Path.of(outputFile), "null".getBytes());
            return;
        }
        String hash = hashFile(file);
        writeToFile(outputFile, hash);
    }

    @PostConstruct
    public void init() {
        System.out.println("Старт");
    }

    @PreDestroy
    public void destroy() {
        file.delete();
        System.out.println("Удаление файла");
    }

    private String hashFile(File file) throws IOException, NoSuchAlgorithmException {
        byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(bytes);
        return bytesToHex(hashedBytes);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }

    private void writeToFile(String filename, String content) throws IOException {
        Files.write(Paths.get(filename), content.getBytes());
    }


}

