
package persistencia;

public class Articulo {
    private String clave;
    private String descripcion;
    private Categoria tipoC;
    private int existencia;
    private float precio;

    public Articulo(String clave, String descripcion, Categoria tipoC, int existencia, float precio) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.tipoC = tipoC;
        this.existencia = existencia;
        this.precio = precio;
    }

    public String getClave() {
        return clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Categoria getTipoC() {
        return tipoC;
    }

    public int getExistencia() {
        return existencia;
    }

    public float getPrecio() {
        return precio;
    }
}
