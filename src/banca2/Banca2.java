package banca2;

//Importando los arrays
import java.util.ArrayList;
//Importando las listas
import java.util.List;
//Importando el scanner
import java.util.Scanner;

public class Banca2 {
    //Declarando la lista de datos Clientes
    private static List<Usuario> usuarios = new ArrayList<>();
    //Declarando la lista de datos borradores
    private static List<Usuario> borradores = new ArrayList<>();
    //Declarando el contador de id
    private static int contadorId = 0;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\u001B[37m" + "         SISTEMAS BCA");
            System.out.println("\u001B[37m" + "Sistema de generacion de cuentas banca\n");
            System.out.println("--------Menu de opciones--------");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Consultar datos del usuario");
            System.out.println("3. Borrar usuario");
            System.out.println("4. Borradores usuarios");
            System.out.println("0. Salir");
            System.out.println("Ingrese su opcion: ");
            opcion = input.nextInt();
            input.nextLine();
            
            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                   
                case 2:
                    consultarUsuario();
                    break;
                    
                case 3:
                    borrarUsuario();
                    break;
                    
                case 4:
                    mostrarborradores();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...\n");
                    System.out.println("\u001B[37m" + "Gracias por utilizar Sistemas BCA\n");
                    System.out.println("Todos los derechos reservados");
                    System.out.println("\033[0;1m" + "@BCA 2023");
                    break;
                default:
                    System.out.println("\u001B[31m" + "Opcion invalida. Intente nuevamente\n");
                    break;
            }
        }while (opcion != 0);
    }
    
    private static void registrarUsuario() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Registrar usuario");
        System.out.println("Status: Escribiendo...");
        System.out.println("Nombres: ");
        String nombres = input.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = input.nextLine();
        System.out.println("Direccion: ");
        String direccion = input.nextLine();
        System.out.println("Correo: ");
        String correo = input.nextLine();
        System.out.println("Telefono: ");
        String telefono = input.nextLine();
        System.out.println("Procesando datos...");
        String salto = input.nextLine();
        System.out.println("--------Opciones--------");
        System.out.println("1. Registrar");
        System.out.println("2. Guardar como borrador");
        System.out.println("3. Salir sin guardar cambios");
        System.out.println("Ingrese su opcion: ");
        int opcion = input.nextInt();
        input.nextLine();
        
        switch (opcion) {
            case 1:
                //Registrar usuario
                Usuario usuario = new Usuario(nombres, apellidos, direccion, correo, telefono);
                usuario.setStatus("Registrado");
                usuarios.add(usuario);
                System.out.println("ID: " + usuario.getId());
                System.out.println("Status: Registrado\n");
                break;
                
            case 2:
                //Guardar borrador
                Usuario borrador = new Usuario(nombres, apellidos, direccion, correo, telefono);
                borrador.setStatus("Borrador\n");
                borradores.add(borrador);
                System.out.println("ID: " + borrador.getId());
                System.out.println("Status: Guardado como borradoor\n");
                break;
                
            case 3:
                //Salir sin cambios
                System.out.println("Redirigiendo al menu...\n");
                break;
                
            default:
                System.out.println("\u001B[31m" + "Opcion invalida. Redirigiendo al menu...\n");
                break;
        }
    }
    
    private static void consultarUsuario() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingresa el ID del usuario a registrar: ");
        int id = input.nextInt();
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            usuario.setStatus("Registrado\n");
            System.out.println(usuario);
        } else {
            System.out.println("\u001B[31m" + "ID de usuario no encontrado\n");
        }
    }
    
    private static void borrarUsuario() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingresa el ID del usuario a eliminar");
        int id = input.nextInt();
        Usuario usuario = buscarUsuario(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Status: Eliminado\n");
            System.out.println("Correo eliminado:\n" + usuario);
        } else {
            System.out.println("\u001B[31m" + "ID no encontrado\n");
        }
    }
    
    private static void mostrarborradores() {
        Scanner input = new Scanner(System.in);
        System.out.println("Borradores:");
        //empty valida si existe algun borrador
        if (borradores.isEmpty()) {
            System.out.println("\u001B[31m" + "No hay borradores\n");
        } else {
            for (Usuario borrador : borradores) {
                System.out.println(borrador);
            }
            System.out.println("--------Opciones--------");
            System.out.println("1. Registrar");
            System.out.println("2. Guardar");
            System.out.println("3. Eliminar");
            System.out.println("4. Editar");
            System.out.println("5. Salir sin guardar cambios");
            System.out.println("Ingrese su opcion: ");
            int opcion = input.nextInt();
            input.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el ID del usuario a registrar:");
                    int idRegistrar = input.nextInt();
                    Usuario usuarioRegistrar = buscarUsuarioBorrador(idRegistrar);
                    if (usuarioRegistrar != null) {
                        usuarioRegistrar.setStatus("Registrado");
                        usuarios.add(usuarioRegistrar);
                        System.out.println("Usuario registrado: \n" + usuarioRegistrar);
                    } else {
                        System.out.println("\u001B[31m" + "ID del usuario no encontrado\n");
                    }
                    break;
                
                case 2:
                    System.out.println("Ingresa el ID del usuario a guardar: ");
                    int idGuardar = input.nextInt();
                    Usuario usuarioGuardar = buscarUsuarioBorrador(idGuardar);
                    if (usuarioGuardar != null) {
                        System.out.println("Usuario guardado como borrador: \n" + usuarioGuardar);
                    } else {
                        System.out.println("\u001B[31m" + "ID de usuario no encontrado\n");
                    }
                    break;
                  
                case 3:
                    System.out.println("Ingresa el ID del usuario a eliminar: ");
                    int idEliminar = input.nextInt();
                    Usuario usuarioEliminar = buscarUsuarioBorrador(idEliminar);
                    if (usuarioEliminar != null) {
                        usuarioEliminar.setStatus("Eliminado");
                        borradores.remove(usuarioEliminar);
                        System.out.println("Usuario eliminado: \n" + usuarioEliminar);
                    } else {
                        System.out.println("\u001B[31m" + "ID de usuario no encontrado\n");
                    }
                    break;
                    
                case 4:
                    System.out.println("Ingrese el ID del borrador a editar: ");
                    int id = input.nextInt();
                    input.nextLine();
                    Usuario borrador = buscarUsuarioBorrador(id);
                    if (borrador != null) {
                        System.out.println("Borrador encontrado: \n" + borrador);
                        editarBorrador(borrador);
                    } else {
                        System.out.println("\u001B[31m" + "ID de borrador no encontrado\n");
                    }
                    break;
                    
                case 5:
                    System.out.println("Redirigiendo al menu");
                    break;
                
                default:
                    System.out.println("\u001B[31m" + "Opción inválida. Redirigiendo al menu\n");
                    break;
            }
        }
    }
    
    private static void editarBorrador(Usuario borrador) {
        Scanner input = new Scanner(System.in);
        System.out.println("Editar borrador");
        System.out.println("Status: Editando...");
        System.out.println("Nombres: ");
        String nombres = input.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = input.nextLine();
        System.out.println("Direccion: ");
        String direccion = input.nextLine();
        System.out.println("Correo: ");
        String correo = input.nextLine();
        System.out.println("Telefono: ");
        String telefono = input.nextLine();
        System.out.println("Procesando datos...");
        String salto = input.nextLine();
        
        borrador.setNombres(nombres);
        borrador.setApellidos(apellidos);
        borrador.setDireccion(direccion);
        borrador.setCorreo(correo);
        borrador.setTelefono(telefono);
        
        System.out.println("--------Opciones--------");
        System.out.println("1. Registrar");
        System.out.println("2. Guardar");
        System.out.println("3. Eliminar");
        System.out.println("4. Salir sin guardar cambios");
        System.out.println("Ingrese su opcion: ");
        int opcion = input.nextInt();
        input.nextLine();
        
        switch (opcion) {
            case 1:
                // Registrar el usuario
                borrador.setStatus("Registrado");
                usuarios.add(borrador);
                borradores.remove(borrador);
                System.out.println("ID: " + borrador.getId());
                System.out.println("Status: Registrado\n");
                break;
            case 2:
                // Conservar como borrador
                borrador.setStatus("Borrador");
                System.out.println("ID: " + borrador.getId());
                System.out.println("Status: Guardado como borrador\n");
                break;
            case 3:
                // Eliminar el borrador
                borrador.setStatus("Eliminado");
                borradores.remove(borrador);
                System.out.println("Status: Eliminado\n");
                break;
            case 4:
                // Regresar al menú sin guardar cambios
                System.out.println("Redirigiendo al menu...\n");
                break;
            default:
                System.out.println("\u001B[31m" + "Opcion invalida. Redirigiendo al menu...\n");
                break;
        }
    }
    
    private static Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    
    private static Usuario buscarUsuarioBorrador(int id) {
        for (Usuario borrador : borradores) {
            if (borrador.getId() == id) {
                return borrador;
            }
        }
        return null;
    }
}
