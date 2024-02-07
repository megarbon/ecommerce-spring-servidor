package es.ecommerce.sneakerFreaks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
    /** Unique id for the client. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    /** The name of the client. */
    @Column(name = "nombre", nullable = false)
    private String nombre;

    /** The email of the client. */
    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correoElectronico;

    /** The password of the client. */
    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    /** The last name of the client. */
    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    /** The address of the client. */
    @Column(name = "direccion", nullable = false)
    private String direccion;

    /** The postal code of the client. */
    @Column(name = "codigo_postal", nullable = false)
    private String codigoPostal;

    /** The credit card number of the client. */
    @Column(name = "numero_tarjeta", nullable = false)
    private String numeroTarjeta;

    /** The profile picture url of the client. */
    @Column(name = "foto_perfil_url", nullable = true)
    private String fotoPerfilUrl;

    public Client() {
    }

    public Client(Long idCliente, String nombre, String correoElectronico, String contrasena, String apellidos,
            String direccion, String codigoPostal, String numeroTarjeta, String fotoPerfilUrl) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.numeroTarjeta = numeroTarjeta;
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    // Constructor, getters y setters

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
    }

    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
    }

    public void setId(Long id) {
        this.idCliente = id;
    }

}
