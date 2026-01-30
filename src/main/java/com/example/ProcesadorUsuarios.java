package com.example;
import java.util.List;

/**
 * Clase encargada de procesar y clasificar listas de usuarios según su rol.
 * Proporciona funcionalidad para separar administradores de invitados.
 */
public class ProcesadorUsuarios {

    private static final int ROL_INVITADO = 2;
    private static final int ROL_ADMIN = 1;

    /**
     * Procesa una lista de strings con formato "nombre:rol" y devuelve un resumen clasificado. 
     * * @param usuarios Lista de strings que contienen el nombre y el ID del rol del usuario.
     * @return Una cadena de texto con los nombres de administradores e invitados separados.
     */
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String u : usuarios) {
            String[] parts = u.split(":"); 
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                if (rol == ROL_ADMIN) {
                    admins = procesarAdmin(admins, nombre);
                }
                else if (rol == ROL_INVITADO) {
                    invitados = procesarInvitado(invitados, nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    private String procesarInvitado(String invitados, String nombre) {
        invitados += nombre + ",";
        return invitados;
    }

    private String procesarAdmin(String admins, String nombre) {
        admins = procesarInvitado(admins, nombre);
        return admins;
    }
}
//cambio