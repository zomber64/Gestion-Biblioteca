/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class libros {
    private int idLibro;
    private String titulo;
    private String isbn;
    private int anio;
    private String editorial;
    private int idCategoria;
    private int idAutor;
    private String estado;

    public libros() {}

    public libros(int idLibro, String titulo, String isbn, int anio, String editorial, int idCategoria, int idAutor, String estado) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anio = anio;
        this.editorial = editorial;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
        this.estado = estado;
    }

    public int getIdLibro() { return idLibro; }
    public void setIdLibro(int idLibro) { this.idLibro = idLibro; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }

    public int getIdAutor() { return idAutor; }
    public void setIdAutor(int idAutor) { this.idAutor = idAutor; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}