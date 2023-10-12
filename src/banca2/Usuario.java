package banca2;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Usuario {
    private static int contadorId = 0;
 
    private final int id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String correo;
    private String telefono;
    private String fecha;
    private String status;

    public Usuario(String nombres, String apellidos, String direccion, String correo, String telefono) {
        this.id = contadorId++;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha = obtenerFechaActual();
        this.status = "Escribiendo";
    }
    
    private String obtenerFechaActual() {
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter fechaFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String fecha = fechaActual.format(fechaFormatter);
        String hora = fechaActual.format(horaFormatter);
        return fecha + " " + hora;
    
        //return "2023-05-14";
    }
    
    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }    
    
    public static int getContadorId() {
        return contadorId;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha() {
        return fecha;
    }

    //Se cambia el formto original para cambiar la instancia 
    @Override
    public String toString() {
        return "ID: " + id + "\nnombres: " + nombres + "\napellidos: " + apellidos + "\ndireccion: " + direccion + "\ncorreo: " + correo + "\ntelefono: " + telefono + "\nfecha: " + fecha + "\nstatus: " + status;
    }
    
}

