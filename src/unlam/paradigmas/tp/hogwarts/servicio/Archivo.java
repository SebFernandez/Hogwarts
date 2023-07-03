package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.*;

import java.io.*;
import java.util.*;

public class Archivo {

    public static List<Usuario> lecturaDeUsuarios(String path) throws IOException {
        List<Usuario> colaDeUsuarios = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] datos = line.split(",");

                String nombre = datos[0];
                String gusto = datos[1];
                float presupuesto = Float.parseFloat(datos[2]);
                int horas = Integer.parseInt(datos[3]);

                Usuario usuario = new Usuario(nombre, gusto, presupuesto, horas);
                colaDeUsuarios.add(usuario);
            }

            return colaDeUsuarios;
        }
    }

    public static LinkedList<Producto> armarProductos(String pathAtracciones, String pathPromociones) throws IOException {

        Map<String, Atraccion> atracciones = lecturaDeAtracciones(pathAtracciones);
        List<Promocion> listaDePromociones = lecturaDePromociones(pathPromociones, atracciones);

        return Producto.prepararOfertas(listaDePromociones, atracciones);
    }

    private static Map<String, Atraccion> lecturaDeAtracciones(String path) throws IOException {
        Map<String, Atraccion> atracciones = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] datos = line.split(",");

                String nombre = datos[0];
                int precio = Integer.parseInt(datos[1]);
                int duracion = Integer.parseInt(datos[2]);
                int cupo = Integer.parseInt(datos[3]);
                String tipo = datos[4];

                Atraccion atraccion = new Atraccion(nombre, tipo, precio, cupo, duracion);
                atracciones.put(atraccion.getNombre(), atraccion);
            }

            return atracciones;
        }
    }

    private static List<Promocion> lecturaDePromociones(String path, Map<String, Atraccion> atracciones) throws IOException {
        List<Promocion> listaDePromociones = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] datos = line.split(",");
                String tipoPaquete = datos[0].replace("Pack", "");

                int descuento = Integer.parseInt(datos[2]);
                List<Atraccion> listaDeAtracciones = new ArrayList<>();

                int lineasLeidas = 0;
                while (lineasLeidas < Integer.parseInt(datos[3]) && (line = bufferedReader.readLine()) != null) {
                    listaDeAtracciones.add(atracciones.get(line));
                    lineasLeidas++;
                }

                if (datos[1].equals("Porcentual")) {
                    var promo = new PromocionPorcentual(listaDeAtracciones, tipoPaquete, descuento);
                    listaDePromociones.add(promo);
                } else if (datos[1].equals("Absoluta")) {
                    var promo = new PromocionAbsoluta(listaDeAtracciones, tipoPaquete, descuento);
                    listaDePromociones.add(promo);
                } else if (datos[1].equals("AxB")) {
                    var promo = new PromocionAxB(listaDeAtracciones, tipoPaquete, descuento);
                    listaDePromociones.add(promo);
                }
            }

            return listaDePromociones;
        }
    }

    public static void generarArchivoSalida(String path, List<Usuario> resumenCompraUsuario) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            for (Usuario usuario : resumenCompraUsuario) {
                double precioTotal = 0;
                double tiempoTotal = 0;

                bufferedWriter.write("Usuario: " + usuario.getNombre() + "\n");
                bufferedWriter.write("Compras: \n");

                for (Producto producto : usuario.getCompras()) {
                    precioTotal += producto.getPrecio();
                    tiempoTotal += producto.getDuracion();
                    bufferedWriter.write(producto + "\n");
                }

                bufferedWriter.write("Precio Final: " + String.format("%.2f", precioTotal) + "\n");
                bufferedWriter.write("Tiempo Necesario: " + String.format("%.2f", tiempoTotal) + "\n\n");
            }
        }
    }
}
