
package libreria.servicios;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;


public class EditorialServicio {
    
  
    static Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public static void crearEditorial() {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        Editorial editorial = new Editorial();
        System.out.println("Ingrese el nombre de la editorial");
        editorial.setNombre(leer.next());
        System.out.println("EDITORIAL AGREGADA CORRECTAMENTE");
        
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }
    
    
    public static void modificarEditorial(){
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        System.out.println("Ingrese el ID de la editorial que desea modificar");
        Editorial editorial = em.find(Editorial.class, leer.nextInt());
        System.out.println("Ingrese el nuevo nombre de la editorial");
        editorial.setNombre(leer.next());
        if (editorial != null) {
             System.out.println("EDITORIAL MODIFICADA EXITOSAMENTE");
         }else{
             System.out.println("EDITORIAL NO ENCONTRADA");
         }
        
        em.getTransaction().begin();
        em.merge(editorial); //actualiza
        em.getTransaction().commit();
    }
    
     public static void borrarEditorial(){
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        System.out.println("Ingrese el ID de la editorial que desea borrar");
        Editorial editorial = em.find(Editorial.class, leer.nextInt());
         if (editorial != null) {
             System.out.println("EDITORIAL " +editorial.getNombre() +" BORRADA EXITOSAMENTE");
         }else{
             System.out.println("EDITORIAL NO ENCONTRADA");
         }
    
        em.getTransaction().begin();
        em.remove(editorial); //borra
        em.getTransaction().commit();
    }
}
