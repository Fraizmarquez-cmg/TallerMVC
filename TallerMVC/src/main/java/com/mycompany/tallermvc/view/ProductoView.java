package com.mycompany.tallermvc.view;

import com.mycompany.tallermvc.model.Producto;
import java.util.List;

public class ProductoView {

    public void mostrarMensaje(String mensaje) {
        System.out.println(">> " + mensaje);
    }

    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println(producto);
        } else {
            System.out.println(">> Producto no encontrado.");
        }
    }

    public void mostrarListaProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println(">> No hay productos registrados.");
        } else {
            System.out.println("\n--- LISTA DE PRODUCTOS ---");
          productos.forEach(System.out::println);
        }
    }

    public void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE INVENTARIO (MVC) ===");
        System.out.println("1. Registrar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto por ID");
        System.out.println("4. Modificar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Filtrar por precio mayor a...");
        System.out.println("7. Filtrar por stock bajo");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }
}