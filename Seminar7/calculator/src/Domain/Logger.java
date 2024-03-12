package Domain;

import java.io.FileWriter;
import java.util.Date;

import Services.iComplex;

public class Logger {

    private String file;

    public Logger(String path) {
        this.file = path;
    }

    public Logger() {
        this("log.txt");
    }

    public void add(String operation, iComplex number1, iComplex number2) {
        Date date = new Date();

        try (FileWriter writer = new FileWriter(file, true)) {
            
            String line = String.format("%s | %s\t | %s\t : %s\n",date, operation, number1, number2);
            writer.write(line);
            writer.flush();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
