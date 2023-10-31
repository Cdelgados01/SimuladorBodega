
package com.mycompany.parcial01bodega;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatosUsuarios {
    private static List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new Usuario("user", "1234"));
        usuarios.add(new Usuario("usuario1", "123456"));
    }

    public static List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}
