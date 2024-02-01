package es.ecommerce.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nombre")
    private Long idCliente;

    private String nombre;
    private String correoElectronico;
    private String contrasena;
    private String apellidos;
    private String direccion;
    private String codigoPostal;
    private String numeroTarjeta;
    private String fotoPerfilURL;

    public Cliente(Long idCliente, String nombre, String correoElectronico, String contrasena, String apellidos,
            String direccion, String codigoPostal, String numeroTarjeta, String fotoPerfilURL) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.numeroTarjeta = numeroTarjeta;
        this.fotoPerfilURL = fotoPerfilURL;
    }

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

    public String getFotoPerfilURL() {
        return fotoPerfilURL;
    }

    public void setFotoPerfilURL(String fotoPerfilURL) {
        this.fotoPerfilURL = fotoPerfilURL;
    }

}
