package OPERACIONES;
import DONANTE.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Menu {

    private Acciones acc1 = new Acciones();
    private String rep;
    protected int op;
    Scanner sc = new Scanner(System.in); 

    public void Cuerpo_Menu(){
        
           Donante d = new Donante("Alex", "Castro", "0953581972"); 
           acc1.Agg_P(d);
         do{

            System.out.println("\n*************MENU*************");
            System.out.println("[1] DONANTE");
            System.out.println("[2] REGISTRAR DONACION");
            System.out.println("[3] ADMINISTRACION");
            System.out.println("[4] BUSQUEDAS RAPIDAS");
            do{
                this.Val_excepcion();
            }while(op<1 || op>4);            
            switch(op){
                case 1:{
                    this.Opciones_Donante();
                break;} 
                case 2:{
                    //acc1.mostrarLPD();
                    this.Menu_Donacion();
                break;}
                case 3:{
                    this.Administracion();
                break;}
                case 4:{
                    this.Busquedas_Rapidas();
                break;}
                default:
                    System.out.println("ESCOJA UNA OPCION VALIDA");
                break;
            }  
        System.out.print("¿Desea volver al menu? (S/OTRO)");
        rep = sc.nextLine();
       }while (rep.equals("S") || rep.equals("s"));
    }
    
    public void Val_excepcion(){
        try{
            this.Elegir_opcion();
        }catch(InputMismatchException e){
            //JOptionPane.showMessageDialog(null,"NO PUEDE INGRESAR NUMEROS","SOTFWARE", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("SOLO PUEDE INGRESAR NUMEROS");
            sc.nextLine();
        }
    }
    
    public void Elegir_opcion() throws InputMismatchException{
        System.out.print("ELIJA UNA OPCION: ");
        op=sc.nextInt();
        sc.nextLine();
    }
    
    public void Opciones_Donante(){
            System.out.println("\n*********DONANTE*********");
            System.out.println("[1] REGISTRAR DONANTE");
            System.out.println("[2] ELIMINAR  DONANTE");
            do{
                this.Val_excepcion();
            }while(op<1 || op>2);

            switch(op){
            case 1:{
                this.Registrar_Persona();
            break;} 
            case 2:{
                this.Eliminar_Donante();
            break;}
            default:
                System.out.println("ESCOJA UNA OPCION VALIDA");
            break;}    
    }
    
    public void Registrar_Persona(){
       do{
            Donante do1 = new Donante();
            do1.IngresarD();
            acc1.Agg_P(do1);
            //sc.nextLine();
            System.out.print("\n¿Desea ingresar otro registro? (S/OTRO)");
            rep = sc.nextLine();
        }while (rep.equals("S") || rep.equals("s")); 
    } 
    
    public void Eliminar_Donante(){
        String ced;
        System.out.print("INGRESE EL NUMERO DE CEDULA DEL DONANTE A ELIMINAR: ");
        ced= sc.nextLine();
        acc1.Remover_Donante(ced);
    }
    
    public void Menu_Donacion(){
        if(acc1.ListDonante.size()!=0){
            do{
            
            acc1.mostrarLPD();
            acc1.SelecPD();
            
            System.out.println("\n*************MENU*************");
            System.out.println("[1] DONACION ECONOMICA");
            System.out.println("[2] DONACION DE COMESTIBLES");
            System.out.println("[3] DONACION DE BIENES");
            do{
               this.Val_excepcion();
            //abajo tenia op1   
            }while(op<1 || op>3);

                switch(op){
                case 1:{
                    Donacion d1= new DEconomica();
                    d1.IngresarD();
                    d1.setPersona(acc1.getPersona());
                   
                    
                    
                    if(acc1.Valexistdona(d1.getCodigo())==true){
                        acc1.Agg_D(d1);
                    System.out.println(d1.toString());
                    }
                    else {
                        System.out.println("NO PUEDE SER REGISTRADA");
                    }
                    
                    
                break;} 
                case 2:{
                    Donacion d1= new DComestible();
                    d1.IngresarD();
                    d1.setPersona(acc1.getPersona());
                    
                    
                    
                    
                    acc1.Agg_D(d1);
                    acc1.Agg_DComes(d1);
                    System.out.println(d1.toString());
                break;}
                case 3:{
                    Donacion d1= new DBien();
                    d1.IngresarD();
                    d1.setPersona(acc1.getPersona());
                    acc1.Agg_D(d1);
                    System.out.println(d1.toString());
                break;}
                default:
                    System.out.println("ESCOJA UNA OPCION VALIDA");
                break;}                
                
            System.out.print("\n¿Desea registrar otra donacion? (S/OTRO)");
            rep = sc.nextLine();
            }while (rep.equals("S") || rep.equals("s"));
        }
        else{
            System.out.println("PRIMERO REGISTRE UN DONANTE");
            this.Cuerpo_Menu();
        }
       
    }
    
    public void Administracion(){
            System.out.println("\n*********ADMINISTRACION*********");
            System.out.println("[1] REPORTE DE LAS DONACIONES ECONOMICAS");
            //System.out.println("[2] BUSQUEDA DE DONACION");
            do{
               this.Val_excepcion();
            }while(op<1 || op>1);
            switch(op){
            case 1:{
                this.Reporte();
            break;} 
            default:
                System.out.println("ESCOJA UNA OPCION VALIDA");
            break;}              
    }
    
    public void Reporte(){
        System.out.println("EL MONTO RECIBIDO DE LAS DONACIONES ECONOMICAS ES DE: $ " + acc1.monto_recibido());
    }
    
    public void Busquedas_Rapidas(){
            System.out.println("\n*********BUSQUEDAS RAPIDAS*********");
            System.out.println("[1] BUSQUEDA DE DONANTE");
            System.out.println("[2] BUSQUEDA DE DONACION");
            do{
               this.Val_excepcion();
            }while(op<1 || op>2);

            switch(op){
            case 1:{
                this.B_PersD();
            break;} 
            case 2:{
                this.B_Donacion();
            break;}
            default:
                System.out.println("ESCOJA UNA OPCION VALIDA");
            break;}                
    }
    
    public void B_PersD(){
        String ced;
        System.out.print("INGRESE UN NUMERO DE CEDULA: ");
        ced= sc.nextLine();
        acc1.Buscar_Donante(ced);
    } 
    
    public void B_Donacion(){
        String cod;
        System.out.print("INGRESE EL CODIGO: ");
        cod= sc.nextLine();
        acc1.Buscar_Donacion(cod);
    } 
}
