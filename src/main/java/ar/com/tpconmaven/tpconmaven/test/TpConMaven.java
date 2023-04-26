/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ar.com.tpconmaven.tpconmaven.test;

import ar.com.tpconmaven.tpconmaven.datos.Equipo;
/**
 *
 * @author EXO
 */
public class TpConMaven {

    public static void main(String[] args) {
        Equipo equipo = new Equipo("Boca Juniors", 11, 7, "Riquelme", 10, 4);
        equipo.mostrarEquipo(equipo.getNombre());
    }  
}
