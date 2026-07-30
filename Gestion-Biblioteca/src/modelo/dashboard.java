package modelo;

public class dashboard {

    private int usuarios;
    private int categorias;
    private int autores;
    private int libros;
    private int prestamos;

    public dashboard() {
    }

    public int getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(int usuarios) {
        this.usuarios = usuarios;
    }

    public int getCategorias() {
        return categorias;
    }

    public void setCategorias(int categorias) {
        this.categorias = categorias;
    }

    public int getAutores() {
        return autores;
    }

    public void setAutores(int autores) {
        this.autores = autores;
    }

    public int getLibros() {
        return libros;
    }

    public void setLibros(int libros) {
        this.libros = libros;
    }

    public int getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(int prestamos) {
        this.prestamos = prestamos;
    }

}