package com.mycompany.parcial01bodega;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


    
public class Parcial01Bodega {
    
            
        public static void main(String[] args) {
        Conexion.conectarFirebase();
        FirebaseDataManager dataManager = new FirebaseDataManager(Conexion.db);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        if (Autenticador.autenticar(nombreUsuario, contrasena)) {
            System.out.println("Inicio de sesión exitoso.");

            // Después de iniciar sesión, muestra la lista de productos
            System.out.println("\nBodega01\n");

            // Map para representar los productos
            Map<String, Object> productos = new HashMap<>();
            
            productos.put("producto1", new Producto("Moto g22", 700000, 40));
            productos.put("producto2", new Producto("Moto g32", 800000, 25));
            productos.put("producto3", new Producto("Moto g72", 1000000, 50));
            productos.put("producto4", new Producto("Iphone 13", 3700000, 45));
            productos.put("producto5", new Producto("Iphone 14", 4000000, 30));
            productos.put("producto6", new Producto("Iphone 14 pro", 5500000, 15));
            productos.put("producto7", new Producto("Samsung Galaxy A13", 750000, 45));
            productos.put("producto8", new Producto("Samsung Galaxy A54", 2000000, 45));
            productos.put("producto9", new Producto("Samsung Galaxy S23", 4000000, 35));

            
            // Almacena los datos en Firebase
            dataManager.agregarDatos("Productos", "Bodega01", productos);
            

            // Ahora, para obtener los datos de productos desde Firebase
            Map<String, Object> datos = dataManager.obtenerDatos("Productos", "Bodega01");

            if (datos != null) {
                System.out.println("\nLista de productos en bodega:\n");
                System.out.println("---------------");
                for (Map.Entry<String, Object> entry : datos.entrySet()) {
                    String nombreProducto = entry.getKey();
                    Map<String, Object> atributosProducto = (Map<String, Object>) entry.getValue();

                    System.out.println("Nombre: " + atributosProducto.get("nombre"));
                    System.out.println("Precio: " + atributosProducto.get("precio"));
                    System.out.println("Cantidad: " + atributosProducto.get("cantidad"));
                    System.out.println("---------------");
                }
            } else {
                System.out.println("No se pudieron recuperar los datos de productos.");
            }
            boolean continuar = true;
            while (continuar) {

            System.out.print("\n¿Desea agregar un nuevo producto? (s/n): ");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                // Detalles del nuevo producto y agregarlo
                System.out.print("Ingrese el nombre del nuevo producto: ");
                String nuevoNombre = scanner.nextLine();
                System.out.print("Ingrese el precio del nuevo producto: ");
                double nuevoPrecio = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingrese la cantidad del nuevo producto: ");
                int nuevaCantidad = Integer.parseInt(scanner.nextLine());

                // Crear el nuevo producto y agregarlo al mapa de productos
                Producto nuevoProducto = new Producto(nuevoNombre, nuevoPrecio, nuevaCantidad);
                productos.put("producto" + (productos.size() + 1), nuevoProducto);
                // Agregar el nuevo producto a la base de datos
                dataManager.agregarDatos("Productos", "Bodega01", productos);

                System.out.println("Producto agregado a la base de datos de la bodega.");
            } else if (respuesta.equalsIgnoreCase("n")) {
                System.out.println("Saliendo...");
                continuar = false;
            } else {
                System.out.println("Respuesta no válida.");
            }
        }
    } else {
        System.out.println("Nombre de usuario o contraseña incorrectos.");
    }
}
}