package com.loschidos.cotizaciones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cotizacion")
public class Cotizacion {

	public Cotizacion() {
	}
	
	public Cotizacion(int id, String nombre, String apellido, String email, String empresa, String telefono,
			String direccion, String tipoDePublico, String serviciosDestacados, String descripcionServicios, String duracion, String pretencion, String detalles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.empresa = empresa;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tipoDePublico = tipoDePublico;
		this.detalles = detalles;
		this.duracion = duracion;
		this.pretencion = pretencion;
	}
	
	public Cotizacion(int id, String nombre, String apellido, String email, String empresa, String telefono,
			String direccion, String tipoDePublico, String detalles, String duracion, String pretencion,
			int costoObjetivo, int costoDuracion, int costoTipoProducto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.empresa = empresa;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tipoDePublico = tipoDePublico;
		this.detalles = detalles;
		this.duracion = duracion;
		this.pretencion = pretencion;
		this.costoObjetivo = costoObjetivo;
		this.costoDuracion = costoDuracion;
		this.costoTipoProducto = costoTipoProducto;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre", unique = true, nullable = false, length = 45)
	private String nombre;

	@Column(name = "apellido", nullable = false, length = 60)
	private String apellido;

	@Column(name = "email", nullable = false, length = 60)
	private String email;

	@Column(name = "empresa", nullable = false, length = 60)
	private String empresa;

	@Column(name = "telefono", nullable = false, length = 60)
	private String telefono;

	@Column(name = "direccion", nullable = false, length = 60)
	private String direccion;

	@Column(name = "tipoDePublico", nullable = false, length = 60)
	private String tipoDePublico;

	@Column(name = "detalles", nullable = true, length = 160)
	private String detalles;
	
	@Column(name = "duracion", nullable = true, length = 160)
	private String duracion;
	
	@Column(name = "pretencion", nullable = true, length = 160)
	private String pretencion;
	
	@Column(name = "costoObjetivo")
	private int costoObjetivo;
	
	@Column(name = "costoDuracion")
	private int costoDuracion;
	
	@Column(name = "costoTipoProducto")
	private int costoTipoProducto;
	
	
	public int getCostoObjetivo() {
		return costoObjetivo;
	}

	public void setCostoObjetivo(int costoObjetivo) {
		this.costoObjetivo = costoObjetivo;
	}

	public int getCostoDuracion() {
		return costoDuracion;
	}

	public void setCostoDuracion(int costoDuracion) {
		this.costoDuracion = costoDuracion;
	}

	public int getCostoTipoProducto() {
		return costoTipoProducto;
	}

	public void setCostoTipoProducto(int costoTipoProducto) {
		this.costoTipoProducto = costoTipoProducto;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getPretencion() {
		return pretencion;
	}

	public void setPretencion(String pretencion) {
		this.pretencion = pretencion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipoDePublico() {
		return tipoDePublico;
	}

	public void setTipoDePublico(String tipoDePublico) {
		this.tipoDePublico = tipoDePublico;
	}

}
