package ar.com.tpconmaven.tpconmaven.datos;

import java.sql.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lazarte Federico
 */
public class Equipo {
    private static final String SQL_MOSTRAR_EQUIPO = "SELECT * FROM equipo WHERE nombre_equipo = ?";
    private String nombre;
    private int titulares;
    private int suplentes;
    private String directorTecnico;
    private int puntos;
    private int partidosJugados;

    public Equipo() {
    }

    public Equipo(String nombre, int titulares, int suplentes, String directorTecnico, int puntos, int partidosJugados) {
        this.nombre = nombre;
        this.titulares = titulares;
        this.suplentes = suplentes;
        this.directorTecnico = directorTecnico;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTitulares() {
        return this.titulares;
    }

    public void setTitulares(int titulares) {
        this.titulares = titulares;
    }

    public int getSuplentes() {
        return this.suplentes;
    }

    public void setSuplentes(int suplentes) {
        this.suplentes = suplentes;
    }

    public String getDirectorTecnico() {
        return this.directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return this.partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Equipo{");
        sb.append("nombre=").append(nombre);
        sb.append(", titulares=").append(titulares);
        sb.append(", suplentes=").append(suplentes);
        sb.append(", directorTecnico=").append(directorTecnico);
        sb.append(", puntos=").append(puntos);
        sb.append(", partidosJugados=").append(partidosJugados);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + this.titulares;
        hash = 23 * hash + this.suplentes;
        hash = 23 * hash + Objects.hashCode(this.directorTecnico);
        hash = 23 * hash + this.puntos;
        hash = 23 * hash + this.partidosJugados;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipo other = (Equipo) obj;
        if (this.titulares != other.titulares) {
            return false;
        }
        if (this.suplentes != other.suplentes) {
            return false;
        }
        if (this.puntos != other.puntos) {
            return false;
        }
        if (this.partidosJugados != other.partidosJugados) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.directorTecnico, other.directorTecnico);
    }
    
    public void mostrarEquipo(String nombre) {
        Equipo equipo = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_MOSTRAR_EQUIPO);
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                equipo = new Equipo(rs.getString("nombre_equipo"),
                        rs.getInt("titulares"),
                        rs.getInt("suplentes"),
                        rs.getString("director_tecnico"),
                        rs.getInt("puntos"),
                        rs.getInt("partidos_jugados")
                );
                System.out.print("Nombre: " + rs.getString("nombre_equipo"));
                System.out.print(" Titulares: " + rs.getInt("titulares"));
                System.out.print(" Suplentes: " + rs.getInt("suplentes"));
                System.out.print(" Director Técnico: " + rs.getString("director_tecnico"));
                System.out.print(" Puntos: " + rs.getInt("puntos"));
                System.out.print(" Partidos Jugados: " + rs.getInt("partidos_jugados") + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
    }
    
}
