package avion;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class writeAvion {
    public static void main(String[] args) {
        Avion avion = new Avion();
        avion.uvediPutnika(21, "Jovan Jovanovic", 53);
        avion.uvediPutnika(31, "Milos Milosevic", 23);
        avion.uvediPutnika(41, "Ana Jovanovic", 22);
       
        
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("./putnici.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(avion.svakoMesto());
            printWriter.printf(avion.jovanovici());
            printWriter.printf("Prosecna starost putnika je: " + avion.prosecnaStarostPutnika());
            printWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(writeAvion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               

       
    }
}
