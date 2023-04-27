
package ar.com.tpconmaven.tpconmaven.test;

import ar.com.tpconmaven.tpconmaven.datos.Equipo;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
/**
 *
 * @author Lazarte Federico
 */
public class ConsultaEquipos {

    public static void main(String[] args) {
        int opcion = -1;
        Equipo equipo;
        Scanner sc = new Scanner(System.in);
        while ( opcion != 3) {
            System.out.println("Escoja una de las opciones, por favor\n"
                + "1. Si desea buscara un equipo en particular para ver su información\n"
                + "2. Si desea ver toda la información de todo los equipos\n"
                + "3. Si desea salir");
            opcion = parseInt(sc.nextLine()); // utilizo nextLine para que haga el salto al ingresar el número y que no de errores
            switch(opcion) {
                case 1:
                    String nombreEquipo;
                    System.out.println("Ingrese el nombre del equipo que busca, por ejemplo Boca Juniors, Independiente, etc");
                    nombreEquipo = sc.nextLine();
                    equipo = new Equipo(nombreEquipo);
                    equipo.mostrarEquipo(nombreEquipo);
                    break;
                case 2:
                    equipo = new Equipo();
                    equipo.mostrarEquipos();
                    break;
                case 3:
                    System.out.println("Gracias por usar nuestro servicio, adiós!!");
                    break;
                default:
                    System.out.println("Opción incorrecta, vuelva a intentarlo");
            }
        }
    }  
}
