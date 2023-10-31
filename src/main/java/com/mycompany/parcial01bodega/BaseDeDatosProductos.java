package com.mycompany.parcial01bodega;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class BaseDeDatosProductos {
    private static Map<String, Object> productos = new HashMap<>();

    static {
        productos.put("producto1", new Producto("Moto g22", 700000, 40));
        productos.put("producto2", new Producto("Moto g32", 800000, 25));
        productos.put("producto3", new Producto("Moto g72", 1000000, 50));
        productos.put("producto4", new Producto("Iphone 13", 3700000, 45));
        productos.put("producto5", new Producto("Iphone 14", 4000000, 30));
        productos.put("producto6", new Producto("Iphone 14 pro", 5500000, 15));
        productos.put("producto7", new Producto("Samsung Galaxy A13", 750000, 45));
        productos.put("producto8", new Producto("Samsung Galaxy A54", 2000000, 45));
        productos.put("producto9", new Producto("Samsung Galaxy S23", 4000000, 35));
    }

    public static List<Producto> obtenerProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        for (Map.Entry<String, Object> entry : productos.entrySet()) {
            listaProductos.add((Producto) entry.getValue());
        }
        return listaProductos;
    }
}
