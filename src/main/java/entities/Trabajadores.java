package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trabajadores database table.
 * 
 */
//@Entity, Indica que la clase es una entidad que se va a mapear con una tabla 
//Los campos de la clase se mapearán con columnas de la tabla
@Entity

//@Table, sirve para indicar características del esquema de la tabla
//En este caso, su nombre
@Table(name="trabajadores")

//@NamedQuery, sirve para indicar consultas identificables por un nombre
@NamedQueries({
	@NamedQuery(name="Trabajadores.findAll", query="SELECT t FROM Trabajadores t"),
	@NamedQuery(name = "Trabajadores.findNombre", query = "SELECT v FROM Trabajadores v WHERE v.codtrabajador = :codtrabajador"),
})





public class Trabajadores implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codtrabajador;

	private String ape1;

	private String ape2;

	private String dni;

	@Temporal(TemporalType.DATE)
	private Date fechaini;

	@Temporal(TemporalType.DATE)
	private Date fechfincontrato;

	private String nombre;

	private String nomcontrato;

	private String numss;

	private double sueldo;

	private String telf;

	private String tipocontrato;

	public Trabajadores() {
	}

	public int getCodtrabajador() {
		return this.codtrabajador;
	}

	public void setCodtrabajador(int codtrabajador) {
		this.codtrabajador = codtrabajador;
	}

	public String getApe1() {
		return this.ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return this.ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaini() {
		return this.fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public Date getFechfincontrato() {
		return this.fechfincontrato;
	}

	public void setFechfincontrato(Date fechfincontrato) {
		this.fechfincontrato = fechfincontrato;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNomcontrato() {
		return this.nomcontrato;
	}

	public void setNomcontrato(String nomcontrato) {
		this.nomcontrato = nomcontrato;
	}

	public String getNumss() {
		return this.numss;
	}

	public void setNumss(String numss) {
		this.numss = numss;
	}

	public double getSueldo() {
		return this.sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getTelf() {
		return this.telf;
	}

	public void setTelf(String telf) {
		this.telf = telf;
	}

	public String getTipocontrato() {
		return this.tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Trabajador [codtrabajador=");
		builder.append(codtrabajador);
		builder.append(", dni=");
		builder.append(dni);
		builder.append(", telf=");
		builder.append(telf);
		builder.append(", numss=");
		builder.append(numss);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", ape1=");
		builder.append(ape1);
		builder.append(", ape2=");
		builder.append(ape2);
		builder.append(", sueldo=");
		builder.append(sueldo);
		builder.append(", fechaini=");
		builder.append(fechaini);
		builder.append(", fechfincon=");
		builder.append(fechfincontrato);
		builder.append(", tipoContrato=");
		builder.append(tipocontrato);
		builder.append(", nomContrato=");
		builder.append(nomcontrato);
		builder.append("]");
		return builder.toString();
	}
	
}