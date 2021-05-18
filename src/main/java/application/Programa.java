package application;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import controllers.ControladorTrabajadores;
import entities.Trabajadores;

public class Programa {

	public static void main(String[] args) {

		//Son fechas que me sirven para crear al trabajador
		Date fecha2 = new Date(116, 5, 3);
		Date fecha = new Date();
		
		//TODO Auto-generated method stub
		ControladorTrabajadores cv = new ControladorTrabajadores();

		// Se obtienen todas las instancias
		List<Trabajadores> listaTrabajadores = cv.findAll();

		// Se imprime la lista
		System.out.println("Todas las entidades ------------ ");
		for (Trabajadores v : listaTrabajadores) {
			System.out.println(v);
		}

		// Se obtiene una entidad
		System.out.println("Buscar el trabajador con codtrabajador = 2 ------------ ");
		Trabajadores aux = cv.findByPK(2);
		System.out.println(aux);

		
		// Creamos el trabajador nuevo
		Trabajadores v = new Trabajadores();
		v.setApe1("Ordoñez");
		v.setApe2("Colea");
		v.setCodtrabajador(8);
		v.setDni("08915997T");
		v.setFechaini(fecha2);
		v.setFechfincontrato(fecha);
		v.setNombre("José");
		v.setNomcontrato("Prácticas");
		v.setNumss("505-20-1670");
		v.setSueldo(1040);
		v.setTelf("722133940");
		v.setTipocontrato("P");
		
		cv.createTrabajador(v);

		// Se obtienen todas las instancias
		listaTrabajadores = cv.findAll();
		System.out.println("Todas las entidades después de crear una ------------ ");
		listaTrabajadores.forEach(System.out::println);

		// Se modifica el precio del vehículo id = 1
		Trabajadores trabModificar = cv.findByPK(1);
		if (trabModificar != null) {
			trabModificar.setNombre("Oliver");;
			cv.modifyTrabajador(trabModificar);
		}

		// Se obtienen todas las instancias
		listaTrabajadores = cv.findAll();
		System.out.println("Todas las entidades después de modificar una ------------ ");
		listaTrabajadores.forEach(System.out::println);

		Trabajadores trabBorrar = cv.findByPK(14);
		cv.borrarTrabajador(trabBorrar);

		// Se obtienen todas las instancias
		listaTrabajadores = cv.findAll();
		System.out.println("Todas las entidades después de borrar una ------------ ");
		listaTrabajadores.forEach(System.out::println);

		// Se obtienen todas las instancias de la marca Seat
		listaTrabajadores = cv.findByDni("722133940");
		System.out.println("Todas los trabajadores con DNI  722133940------------ ");
		listaTrabajadores.forEach(System.out::println);

	}
	
}
