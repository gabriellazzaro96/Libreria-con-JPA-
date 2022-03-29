package Main;

import java.util.Scanner;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

/*
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación:
• Validar campos obligatorios.
• No ingresar datos duplicados. */
public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("INGRESEE OPCION\n");
            System.out.println("1 - REGISTRAR AUTOR");
            System.out.println("2 - REGISTRAR EDITORIAL");
            System.out.println("3 - REGISTRAR LIBRO");
            System.out.println("4 - MODIFICAR AUTOR POR ID");
            System.out.println("5 - MODIFICAR EDITORIAL POR ID");
            System.out.println("6 - MODIFICAR LIBRO POR ISBN");
            System.out.println("7 - BORRAR AUTOR POR ID");
            System.out.println("8 - BORRAR EDITORIAL POR ID");
            System.out.println("9 - BORRAR LIBRO POR ISBN");
            System.out.println("10 - Búsqueda de un Autor por nombre");
            System.out.println("11 - Búsqueda de un libro por ISBN");
            System.out.println("12 - Búsqueda de un libro por Título");
            System.out.println("13 - Búsqueda de un libro/s por nombre de Autor");
            System.out.println("14 - Búsqueda de un libro/s por nombre de Editorial");
            System.out.println("15 - SALIR");
            opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    AutorServicio.crearAutor();
                    break;
                case 2:
                    EditorialServicio.crearEditorial();
                    break;
                case 3:
                    LibroServicio.crearLibro();
                    break;
                case 4:
                    AutorServicio.modificarAutor();
                    break;
                case 5:
                    EditorialServicio.modificarEditorial();
                    break;
                case 6:
                    LibroServicio.modificarLibroPorId();
                    break;
                case 7:
                    AutorServicio.borrarAutor();
                    break;
                case 8:
                    EditorialServicio.borrarEditorial();
                    break;
                case 9:
                    LibroServicio.borrarLibroPorId();
                    break;
                case 10:
                    AutorServicio.busquedaAutorPorNombre();
                    break;
                case 11:
                    LibroServicio.busquedaPorISBN();
                    break;
                case 12:
                    LibroServicio.busquedaPorTitulo();
                    break;
                case 13:
                    LibroServicio.busquedaPorNombreAutor();
                    break;
                case 14:
                    LibroServicio.busquedaPorNombreEditorial();
                    break;
                default:
                    System.out.println("GRACIAS POR USAR EL SISTEMA");
                    return;
            }
        } while (opcion <= 14);
    }

}
