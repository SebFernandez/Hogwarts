package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Archivo {

    public static List<Usuario> lecturaDeUsuarios(String path) throws IOException {
        List<Usuario> listaDeUsuarios = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] datos = line.split(",");

                String nombre = datos[0].trim();
                String gusto = datos[1].trim();
                float presupuesto = Float.parseFloat(datos[2].trim());
                int horas = Integer.parseInt(datos[3].trim());

                Usuario usuario = new Usuario(nombre, gusto, presupuesto, horas);
                listaDeUsuarios.add(usuario);

                System.out.println(usuario);
            }

            return listaDeUsuarios;
        }
    }

    public static List<Atraccion> lecturaDeAtracciones(String path) throws IOException {
        List<Atraccion> listaDeAtracciones = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] datos = line.split(",");

                String ubicacion = datos[0].trim();
                int hsDuracion = Integer.parseInt(datos[1].trim());

                Atraccion atraccion = new Atraccion(ubicacion, hsDuracion);
                listaDeAtracciones.add(atraccion);

                System.out.println(atraccion);
            }

        }

        return listaDeAtracciones;
    }

    public static List<Promocion> lecturaDePaquetes(String path) throws IOException {
        List<Promocion> listaDePromociones = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] datos = line.split(",");

//                String ubicacion = datos[0].trim();
//                int hsDuracion = Integer.parseInt(datos[1].trim());

                Promocion promo = new Promocion();
                listaDePromociones.add(promo);

                System.out.println(promo);
            }

        }

        return listaDePromociones;
    }
}
