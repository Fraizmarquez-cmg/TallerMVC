package com.mycompany.tallermvc.controller;

import com.mycompany.tallermvc.model.Producto;
import com.mycompany.tallermvc.view.ProductoView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductoController {
    private List<Producto> productos;
    private ProductoView view;

    public ProductoController(ProductoView view) {
        this.productos = new ArrayList<>();
        this.view = view;
    }

    public void registrarProducto(int id, String nombre, double precio, int stock) {
        if (buscarPorId(id).isPresent()) {
            view.mostrarMensaje("Error: Ya existe un producto con el ID " + id);
            return;
        }
        productos.add(new Producto(id, nombre, precio, stock));
        view.mostrarMensaje("Producto registrado con éxito.");
    }

    public void listarProductos() {
        view.mostrarListaProductos(productos);
    }

    private Optional<Producto> buscarPorId(int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public void buscarProducto(int id) {
        Optional<Producto> prod = buscarPorId(id);
        if (prod.isPresent()) {
            view.mostrarProducto(prod.get());
        } else {
            view.mostrarMensaje("No se encontró ningún producto con ID: " + id);
        }
    }

    public void modificarProducto(int id, String nuevoNombre, double nuevoPrecio, int nuevoStock) {
        Optional<Producto> prodOpt = buscarPorId(id);
        if (prodOpt.isPresent()) {
            Producto p = prodOpt.get();
            p.setNombre(nuevoNombre);
            p.setPrecio(nuevoPrecio);
            p.setStock(nuevoStock);
            view.mostrarMensaje("Producto modificado correctamente.");
        } else {
            view.mostrarMensaje("No se puede modificar: ID no encontrado.");
        }
    }

    public void eliminarProducto(int id) {
        boolean eliminado = productos.removeIf(p -> p.getId() == id);
        if (eliminado) {
            view.mostrarMensaje("Producto eliminado del inventario.");
        } else {
            view.mostrarMensaje("No se encontró el producto para eliminar.");
        }
    }

    public void filtrarPorPrecioMayor(double precioMinimo) {
        List<Producto> filtrados = productos.stream()
                .filter(p -> p.getPrecio() > precioMinimo)
                .collect(Collectors.toList());

        view.mostrarMensaje("Productos con precio mayor a $" + precioMinimo + ":");
        view.mostrarListaProductos(filtrados);
    }

    public void filtrarPorStockMaximo(int stockMaximo) {
        List<Producto> filtrados = productos.stream()
                .filter(p -> p.getStock() <= stockMaximo)
                .collect(Collectors.toList());

        view.mostrarMensaje("Productos con stock menor o igual a " + stockMaximo + ":");
        view.mostrarListaProductos(filtrados);
    }
}