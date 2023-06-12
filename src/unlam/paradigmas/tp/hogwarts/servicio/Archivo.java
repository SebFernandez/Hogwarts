package unlam.paradigmas.tp.hogwarts.servicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import unlam.paradigmas.tp.hogwarts.dto.Atraccion;
import unlam.paradigmas.tp.hogwarts.dto.Producto;
import unlam.paradigmas.tp.hogwarts.dto.Promocion;
import unlam.paradigmas.tp.hogwarts.dto.PromocionAbsoluta;
import unlam.paradigmas.tp.hogwarts.dto.PromocionAxB;
import unlam.paradigmas.tp.hogwarts.dto.PromocionPorcentual;
import unlam.paradigmas.tp.hogwarts.dto.Usuario;

public class Archivo {

    public static Queue<Usuario> lecturaDeUsuarios(String path) throws IOException {
        Queue<Usuario> colaDeUsuarios = new LinkedList<>();
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

    public static Map<String, Atraccion> lecturaDeAtracciones(String path) throws IOException {
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

    public static List<Promocion> lecturaDePromociones(String path, Map<String, Atraccion> atracciones) throws IOException {
        List<Promocion> listaDePromociones = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] datos = line.split(",");
                String tipoPaquete = datos[0].replace("Pack", "");
                int lineasLeidas = 0;
                int descuento = Integer.parseInt(datos[2]);
                List<Atraccion> listaDeAtracciones = new ArrayList<>();

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
    
    public static void generarArchivoSalida(String path, Map<String, Set<Producto>> resumenCompraUsuario) throws IOException {
    	try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
    		Iterator<String> iteradorCompras = resumenCompraUsuario.keySet().iterator();      
    		while(iteradorCompras.hasNext()) {
    			String nombreUsuario = iteradorCompras.next();
    			double precioTotal = 0;
            	double tiempoTotal = 0;
    			bufferedWriter.write("Usuario: " + nombreUsuario + "\n");
    			bufferedWriter.write("Compras: \n");
    			Iterator<Producto> iteradorProductos = resumenCompraUsuario.get(nombreUsuario).iterator();
    			while(iteradorProductos.hasNext()) {
    				Producto prod = iteradorProductos.next();
    				precioTotal += prod.getPrecio();
    				tiempoTotal += prod.getDuracion();
    				bufferedWriter.write(prod + "\n");
    			}
    			bufferedWriter.write("Precio Final: " + String.format("%.2f", precioTotal) + "\n");
    			bufferedWriter.write("Tiempo Necesario: " + String.format("%.2f", tiempoTotal) + "\n\n");
    		}
    	}
    }
}
