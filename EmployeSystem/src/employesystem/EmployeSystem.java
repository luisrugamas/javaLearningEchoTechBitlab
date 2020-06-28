/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employesystem;


import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;
import sv.echo.bitlab.dao.EmployeesDAO;
import sv.echo.bitlab.entidades.Employe;

/**
 *
 * @author rgluis
 */
public class EmployeSystem {
    
    //Se deberá parametrizar y encriptar
   
    private static Logger log = Logger.getLogger(EmployeSystem.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            EmployeesDAO employeesDAO = new EmployeesDAO();
           List<Employe> employees = employeesDAO.getAllData(10);
           for(Employe e : employees){
               log.info(e.toString());
           }
           //Obtenindo el primer registro
           
           Employe e = employees.get(0);
           log.info("Actualizando el Empleado " + e + " con los datos Carlos Perez");
           e.setFirstName("Carlos");
           e.setLastName("Perez");
           //Actualizando al empleado
           employeesDAO.updateData(e);
           log.info("Empleado actualizado");
           
           //Creando un empleado
           GregorianCalendar gc = new GregorianCalendar();
           gc.set(GregorianCalendar.DATE, 01);
           gc.set(GregorianCalendar.MONTH, 11);
           gc.set(GregorianCalendar.YEAR, 1988);
           
           Employe eLuis = new Employe(1000000, new Date(gc.getTimeInMillis()), "Luis", "Rugamas", "M", new Date(new GregorianCalendar().getTimeInMillis()));
           log.info("Creando el empleado " + eLuis);
           employeesDAO.insertData(eLuis);
           log.info("Empleado creado exitosamente");
           
           
           //Recuperando a Luis de la BD
           log.info("Recuperando al empleado 1000000 de la BD");
           eLuis = employeesDAO.getByIDData(1000000);
           log.info("Información del empleado: " + eLuis);
            
           //Eliminando a Luis
           log.info("Eliminando al empleado Luis Rugamas");
           employeesDAO.deleteData(eLuis.getIdEmploye());
           log.info("Eliminado Existoso");
           
           
           //Codigo malicioso
//           TestLoad test = new TestLoad();
//           
//           for(int i = 0; i <=20; i++){
//               Thread t1 = new Thread(test);
//               t1.start();
//           }
//           
//           
//           Thread.sleep(5000000);

           
        }catch(Exception e){
            e.printStackTrace();;
        }
        
        
    }
    
}
