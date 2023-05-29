package unlam.paradigmas.tp.hogwarts.servicio;

import unlam.paradigmas.tp.hogwarts.dto.Usuario;
import unlam.paradigmas.tp.hogwarts.producto.Atraccion;
import unlam.paradigmas.tp.hogwarts.producto.Promocion;

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

				String nombre = datos[0];
				String gusto = datos[1];
				float presupuesto = Float.parseFloat(datos[2]);
				int horas = Integer.parseInt(datos[3]);

				Usuario usuario = new Usuario(nombre, gusto, presupuesto, horas);
				listaDeUsuarios.add(usuario);
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

				String nombre = datos[0];
				int precio = Integer.parseInt(datos[1]);
				int duracion = Integer.parseInt(datos[2]);
				int cupo = Integer.parseInt(datos[3]);
				String tipo = datos[4];

				Atraccion atraccion = new Atraccion(nombre, tipo, cupo, precio, duracion);
				listaDeAtracciones.add(atraccion);
			}

		}

		return listaDeAtracciones;
	}

	public static List<Promocion> lecturaDePromociones(String path) throws IOException {
		List<Promocion> listaDePromociones = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] datos = line.split(",");
			}

		}

		return listaDePromociones;
	}
}
