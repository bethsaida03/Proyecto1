package DONANTE;
import java.util.*;
/**
 *
 * @author mac
 */
public class DBien extends Donacion {
    private String nombre;
    private String estado;
    private String descripcion;
    protected int op;

    public DBien(String nombre, String estado, String descripcion, String codigo, String motivo, String tipdon, Donante persona, String fecha) {
        super(codigo, motivo, tipdon, persona);
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public DBien() {
        this.nombre="";
        this.estado="";
        this.descripcion="";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    @Override
    public void IngresarD(){
        this.tipo_de_Donacion();
        this.menu();
        super.IngresarD();
        this.setEstado(this.Val_texto("INGRESE EL ESTADO             : " ));
        System.out.print("DESCRIPCION                   : " );
        this.setDescripcion(this.descripcion=sc.nextLine());

    }
    
    @Override
    public String toString(){
        String s;
        s =    "\nDONACION DE TIPO              : " +this.getTIPDON();
        s = s+ super.toString();
        s = s+ "\nNOMBRE DEL BIEN               : "+this.getNombre();
        s = s+ "\nESTADO                        : "+this.getEstado();
        s = s+ "\nDESCRIPCION                   : "+this.getDescripcion();
        return  s;
    }
    
    @Override
    public void menu(){
        System.out.println("\n*************MENU*************");
        System.out.println("[1] VESTIMENTA");
        System.out.println("[2] CALZADO");
        System.out.println("[3] ARTICULOS DE ASEO");
        System.out.println("[4] ARTICULOS DE PRIMEROS AUXILIOS");
        System.out.println("[5] OTROS");
        this.tipoBien();
    }
    
     public void tipoBien(){
        this.Val_excepcion();
                    switch(op){
                    case 1:{
                        System.out.println("ESCOGIO VESTIMENTA");
                        this.setNombre("VESTIMENTA");
                    break;
                    } 
                    case 2:{
                        System.out.println("ESCOGIO CALZADO");
                        this.setNombre("CALZADO");
                    break;
                    }
                    case 3:{
                        System.out.println("ESCOGIO ASEO");
                        this.setNombre("ARTICULOS DE ASEO");
                    break;
                    }
                    case 4:{
                        System.out.println("ESCOGIO PRIMEROS AUXILIOS");
                        this.setNombre("ARTICULOS DE PRIMEROS AUXILIOS");
                    break;
                    }
                    case 5:{
                        System.out.println("ESCOGIO OTROS");
                        this.setNombre("OTROS");
                    break;
                    }
                    default:
                    System.out.println("ESCOJA UNA OPCION VALIDA");
                    this.tipoBien();
                    break;
                    }
    }
    
    
    @Override
    public void tipo_de_Donacion() {
     this.setTIPDON("BIENES");
    }

    @Override
    public void Elegir_opcion() throws InputMismatchException{
        op= this.Val_num2("\nELIJA EL TIPO DE BIEN: ");
    }    
}
