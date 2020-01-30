package INTERFACES;

import DONANTE.*;

/**
 *
 * @author mac
 */

public interface OPERACIONES {
    public void Buscar_Donacion(String cod);
    public void Buscar_Donante(String ced);
    public void SelecPD();
    public void Agg_P(Donante d1);
    public void Remover_Donante(String d1);
    public void Agg_D(Donacion d1);
    public void mostrarLPD();
    public double monto_recibido();
    //public void Mostrar_PD();
}
