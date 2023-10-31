
package com.mycompany.parcial01bodega;


import java.util.List;

public class Autenticador {
    public static boolean autenticar(String nombreUsuario, String contrasena) {
        List<Usuario> usuarios = BaseDeDatosUsuarios.obtenerUsuarios();
        
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        
        return false;
    }
}