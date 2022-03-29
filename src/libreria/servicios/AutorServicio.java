package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import libreria.entidades.Autor;



public class AutorServicio {

    

    static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void crearAutor() {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        Autor autor = new Autor();
        System.out.println("Ingrese el nombre del autor");
        autor.setNombre(leer.next());
        
        System.out.println("AUTOR AGREGADO EXITOSAMENTE");
         
        em.getTransaction().begin();
        em.persist(autor); //graba
        em.getTransaction().commit();
    }
    
    public static void modificarAutor(){
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        System.out.println("Ingrese el ID del autor que desea modificar");
        Autor autor = em.find(Autor.class, leer.nextInt());
        System.out.println("Ingrese el nuevo nombre");
        autor.setNombre(leer.next());
        
        if (autor != null) {
             System.out.println("AUTOR MODIFICADO EXITOSAMENTE");
         }else{
             System.out.println("AUTOR NO ENCONTRADO");
         }
        
        em.getTransaction().begin();
        em.merge(autor); //actualiza
        em.getTransaction().commit();
    }
    
     public static void borrarAutor(){
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        System.out.println("Ingrese el ID del autor que desea borrar");
        Autor autor = em.find(Autor.class, leer.nextInt());
        
        if (autor != null) {
             System.out.println("AUTOR" +autor.getNombre() +" BORRADO EXITOSAMENTE");
         }else{
             System.out.println("AUTOR NO ENCONTRADO");
         }
    
        em.getTransaction().begin();
        em.remove(autor); //borra
        em.getTransaction().commit();
    }

     //8) Búsqueda de un Autor por nombre.
     public static void busquedaAutorPorNombre(){
         EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
         System.out.println("INGRESE EL NOMBRE DEL AUTOR A BUSCAR");
         String nombre = leer.next();
         List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :"+nombre).getResultList(); //setParameter("nombre",nombre);
         if (autores.isEmpty()){
             System.out.println("LISTA DE AUTORES VACIA");
         }
         for (Autor i : autores) {
             System.out.println(i);
         }
     }
    
    
}
