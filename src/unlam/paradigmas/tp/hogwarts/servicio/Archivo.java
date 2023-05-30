package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.producto.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

				Atraccion atraccion = new Atraccion(nombre, tipo, cupo, precio, duracion);
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
				int lineasLeidas = 0;
				int descuento = Integer.parseInt(datos[2]);
				List<Atraccion> listaDeAtracciones = new ArrayList<>();

				while (lineasLeidas < Integer.parseInt(datos[3]) && (line = bufferedReader.readLine()) != null) {
					listaDeAtracciones.add(atracciones.get(line));
					lineasLeidas++;
				}

				if (datos[1].equals("Porcentual")) {
					var promo = new PromocionPorcentual(listaDeAtracciones, descuento);
					listaDePromociones.add(promo);
				} else if (datos[1].equals("Absoluta")) {
					var promo = new PromocionAbsoluta(listaDeAtracciones, descuento);
					listaDePromociones.add(promo);
				} else if (datos[1].equals("AxB")) {
					var promo = new PromocionAxB(listaDeAtracciones, descuento);
					listaDePromociones.add(promo);
				}
			}

			return listaDePromociones;
		}
	}
}
