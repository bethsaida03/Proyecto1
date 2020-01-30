package pyclinica;

import DONANTE.*;
import OPERACIONES.Acciones;
import java.util.*;

public class Pruebas {

    public static void main(String[] args) {
/*
        Scanner sc = new Scanner(System.in); 
        String rep;
        Acciones acc1 = new Acciones();
        do{
                            Donante do1 = new Donante();
                            do1.IngresarD();
                            acc1.Valexist(do1);
                            acc1.Agg_P(do1);
                            System.out.print("\n¿Desea ingresar otro registro? (S/N)");
                            rep = sc.nextLine();
                            }while (rep.equals("S") || rep.equals("s"));
                
                
        acc1.mostrarLPD();
        acc1.SelecPD();*/
        
        ArrayList<String> Lprue= new ArrayList();
  
        Lprue.add("a");
        Lprue.add("b");
        Lprue.add("c");
        Lprue.clear();
        
        System.out.println(Lprue);
    }
}
