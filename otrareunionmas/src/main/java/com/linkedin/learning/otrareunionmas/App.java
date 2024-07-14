package com.linkedin.learning.otrareunionmas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.linkedin.learning.otrareunionmas.dao.ReunionDao;
import com.linkedin.learning.otrareunionmas.dominio.Reunion;

import jakarta.persistence.NoResultException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ReunionDao dao = new ReunionDao();
        List<Reunion> reuniones2 = dao.getAll();
        System.out.println("->Mostrar todas las reuniones");
        reuniones2.forEach(reunion->System.out.println(reunion.toString()));
    
        
        System.out.println("->Guardamos una reunión");
        Reunion r = new Reunion(LocalDateTime.now().plusDays(1),"Otra reunión");
        System.out.println(r);
        
        dao.save(r);
        reuniones2 = dao.getAll();
        
        System.out.println("->Mostrar todas las reuniones");
        reuniones2.forEach(n->System.out.println(n.toString()));

        System.out.println("->Obtener próxima reunión");
        System.out.println("Hoy es día:"+LocalDate.now());
        System.out.println("Tu próxima reunión es:");
        try {
        	System.out.println(dao.proximaReunion());
        }catch(NoResultException ex) {
        	System.out.println("No tienes ninuna reunión");
        }
        System.out.println("Reuniones Mañana");
        reuniones2 = dao.reunionesManyana();
        reuniones2.forEach(re->System.out.println(re.toString()));
    }
}
