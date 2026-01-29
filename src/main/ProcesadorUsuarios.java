import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase procesa listas de usuarios. Contiene 'code smells' intencionados.
 */
public class ProcesadorUsuarios {

    // Método con 'code smells': largo, números mágicos, malos nombres.
    public String procesarLista(List<String> dataList) {
        String admins = "";
        String invitados = "";

        for (String u : dataList) {
            String[] parts = u.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String n = parts[0];
                int r = Integer.parseInt(parts[1]);

                // Número Mágico: 1 es Admin
                if (r == 1) {
                    admins += n + ",";
                }
                // Número Mágico: 2 es Invitado
                else if (r == 2) {
                    invitados += n + ",";
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }
}