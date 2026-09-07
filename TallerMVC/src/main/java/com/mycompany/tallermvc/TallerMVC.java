package com.mycompany.tallermvc;

import com.mycompany.tallermvc.controller.ProductoController;
import com.mycompany.tallermvc.view.ProductoView;
import java.util.Scanner;

public class TallerMVC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductoView view = new ProductoView();
        ProductoController controller = new ProductoController(view);

        // Datos iniciales de prueba
        controller.registrarProducto(1, "Laptop", 850.00, 10);
        controller.registrarProducto(2, "Mouse", 15.50, 50);

        int opcion = 0;
        do {
            view.mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(scanner.nextLine());
                        System.out.print("Stock: ");
                        int stock = Integer.parseInt(scanner.nextLine());
                        controller.registrarProducto(id, nombre, precio, stock);
                        break;
                    case 2:
                        controller.listarProductos();
                        break;
                    case 3:
                        System.out.print("Ingrese ID a buscar: ");
                        int idBuscar = Integer.parseInt(scanner.nextLine());
                        controller.buscarProducto(idBuscar);
                        break;
                    case 4:
                        System.out.print("ID a modificar: ");
                        int idMod = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nuevo Nombre: ");
                        String nomMod = scanner.nextLine();
                        System.out.print("Nuevo Precio: ");
                        double precMod = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nuevo Stock: ");
                        int stockMod = Integer.parseInt(scanner.nextLine());
                        controller.modificarProducto(idMod, nomMod, precMod, stockMod);
                        break;
                    case 5:
                        System.out.print("ID a eliminar: ");
                        int idElim = Integer.parseInt(scanner.nextLine());
                        controller.eliminarProducto(idElim);
                        break;
                    case 6:
                        System.out.print("Precio mínimo: ");
                        double pMin = Double.parseDouble(scanner.nextLine());
                        controller.filtrarPorPrecioMayor(pMin);
                        break;
                    case 7:
                        System.out.print("Stock máximo: ");
                        int stMax = Integer.parseInt(scanner.nextLine());
                        controller.filtrarPorStockMaximo(stMax);
                        break;
                    case 8:
                        view.mostrarMensaje("Saliendo del sistema...");
                        break;
                    default:
                        view.mostrarMensaje("Opción no válida.");
                }
            } catch (Exception e) {
                view.mostrarMensaje("Error en la entrada de datos.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}