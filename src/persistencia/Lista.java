package persistencia;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class Lista {
    private ArrayList<Articulo> miLista;
    private DefaultListModel<String> modelo;
    private DefaultTableModel tablaModelo;

    public Lista() {
        miLista = new ArrayList<>();
        modelo = new DefaultListModel<>();
        tablaModelo = new DefaultTableModel();
    }

    public int buscarElemento(String clave) {
        for (int x = 0; x < miLista.size(); x++) {
            if (clave.equals(miLista.get(x).getClave())) {
                return x;
            }
        }
        return -1;
    }

    public boolean agregarElemento(Articulo objA) {
        if (buscarElemento(objA.getClave()) == -1) {
            miLista.add(objA);
            return true;
        }
        return false;
    }

    public boolean eliminarElemento(String clave) {
        int encontrado = buscarElemento(clave);
        if (encontrado > -1) {
            miLista.remove(encontrado);
            return true;
        }
        return false;
    }

    public void listar() {
        tablaModelo.setRowCount(0); // Limpia el modelo anterior
        modelo.clear();
        String[] titulos = { "CLAVE", "DESCRIPCION", "CATEGORIA", "EXISTENCIA", "PRECIO" };
        tablaModelo.setColumnIdentifiers(titulos);

        Object[] fila;
        for (Articulo articulo : miLista) {
            fila = new Object[tablaModelo.getColumnCount()];
            fila[0] = articulo.getClave();
            fila[1] = articulo.getDescripcion();
            fila[2] = articulo.getTipoC();
            fila[3] = articulo.getExistencia();
            fila[4] = articulo.getPrecio();
            tablaModelo.addRow(fila);
            
            modelo.addElement(articulo.getClave() + " | " + articulo.getDescripcion() + " | " 
                          + articulo.getTipoC() + " | " + articulo.getExistencia() + " | " 
                          + articulo.getPrecio());
        }
    }

    public DefaultListModel<String> getModelo() {
        return modelo;
    }

    public DefaultTableModel getTablaModelo() {
        listar(); // Actualiza la tabla con la lista actual
        return tablaModelo;
    }
}

