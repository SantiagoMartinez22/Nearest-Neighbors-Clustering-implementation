import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utilidades {
    public static Punto2D[] leerPuntos(String filename) {
        List<Punto2D> puntos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] coordinates = line.split(",");
                double x = Double.parseDouble(coordinates[0].trim());
                double y = Double.parseDouble(coordinates[1].trim());
                puntos.add(new Punto2D(x, y));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return puntos.toArray(new Punto2D[0]);
    }
}

