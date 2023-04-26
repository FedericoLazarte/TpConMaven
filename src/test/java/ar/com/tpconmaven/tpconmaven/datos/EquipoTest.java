package ar.com.tpconmaven.tpconmaven.datos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EquipoTest {

    @Test
    public void testEquipo() {
        Equipo equipo = new Equipo("Boca", 11, 7, "Riquelme", 10, 4);
        assertEquals("Boca", equipo.getNombre());
        assertEquals(11, equipo.getTitulares());
        assertEquals(7, equipo.getSuplentes());
        assertEquals("Riquelme", equipo.getDirectorTecnico());
        assertEquals(10, equipo.getPuntos());
        assertEquals(4, equipo.getPartidosJugados());
    }

    @Test
    public void testEquals() {
        Equipo equipo1 = new Equipo("Boca", 11, 7, "Riquelme", 10, 4);
        Equipo equipo2 = new Equipo("Boca", 11, 7, "Riquelme", 10, 4);
        Equipo equipo3 = new Equipo("River", 11, 7, "Gallardo", 8, 4);
        assertEquals(equipo1, equipo2);
        assertEquals(equipo2, equipo1);
        assertEquals(equipo1.hashCode(), equipo2.hashCode());
        assertEquals(false, equipo1.equals(equipo3));
    }

    @Test
    public void testToString() {
        Equipo equipo = new Equipo("Boca", 11, 7, "Riquelme", 10, 4);
        assertEquals("Equipo{nombre=Boca, titulares=11, suplentes=7, directorTecnico=Riquelme, puntos=10, partidosJugados=4}", equipo.toString());
    }
}
