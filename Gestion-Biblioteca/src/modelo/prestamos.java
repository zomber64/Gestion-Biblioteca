package modelo;

import java.sql.Date;

public class prestamos {

    private int idPre;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estadoPre; // prestado o devuelto
    private int fkIdUsu;
    private int fkIdLib;


    private String nombreUsuario;
    private String tituloLibro;

    public prestamos() {}

    public prestamos(int idPre, Date fechaPrestamo, Date fechaDevolucion, String estadoPre, int fkIdUsu, int fkIdLib) {
        this.idPre = idPre;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estadoPre = estadoPre;
        this.fkIdUsu = fkIdUsu;
        this.fkIdLib = fkIdLib;
    }

    public int getIdPre() { return idPre; }
    public void setIdPre(int idPre) { this.idPre = idPre; }

    public Date getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public Date getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public String getEstadoPre() { return estadoPre; }
    public void setEstadoPre(String estadoPre) { this.estadoPre = estadoPre; }

    public int getFkIdUsu() { return fkIdUsu; }
    public void setFkIdUsu(int fkIdUsu) { this.fkIdUsu = fkIdUsu; }

    public int getFkIdLib() { return fkIdLib; }
    public void setFkIdLib(int fkIdLib) { this.fkIdLib = fkIdLib; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getTituloLibro() { return tituloLibro; }
    public void setTituloLibro(String tituloLibro) { this.tituloLibro = tituloLibro; }
}