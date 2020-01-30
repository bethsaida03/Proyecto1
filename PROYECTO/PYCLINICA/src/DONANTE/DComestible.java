package DONANTE;
import java.util.*;
/**
 *
 * @author mac
 */
public class DComestible extends Donacion {
        
    private String nombre;
    private String fechex;
    private String paisorigen;
    private String destinatario;
    private int cant;
    protected int op;

    public DComestible(String nombre, String fechex, String paisorigen, String destinatario, int cant, String codigo, String motivo, String tipdon, Donante persona, String fecha) {
        super(codigo, motivo, tipdon, persona);
        this.nombre = nombre;
        this.fechex = fechex;
        this.paisorigen = paisorigen;
        this.destinatario = destinatario;
        this.cant = cant;
    }

    public DComestible() {
        this.nombre="";
        this.fechex="";
        this.paisorigen="";
        this.destinatario="";
        this.cant=0;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechex() {
        return fechex;
    }

    public void setFechex(String fechex) {
        this.fechex = fechex;
    }

    public String getPaisorigen() {
        return paisorigen;
    }

    public void setPaisorigen(String paisorigen) {
        this.paisorigen = paisorigen;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    @Override
    public void IngresarD(){
        this.tipo_de_Donacion();
        this.menu();
        //sc.nextLine();
        super.IngresarD();
        
        this.setCant(this.Val_num2("INGRESE LA CANTIDAD           : " ));
        System.out.print("INGRESE LA FECHA DE EXPEDICION: " );
        this.setFechex(this.fechex=sc.nextLine());
        System.out.print("INGRESE EL PAIS DE ORIGEN     : " );
        this.setPaisorigen(this.paisorigen=sc.nextLine());
        System.out.print("INGRESE EL DESTINATARIO       : " );
        this.setDestinatario(this.destinatario=sc.nextLine());
    }
    
    @Override
    public String toString(){
        String s;
        s =    "\nDONACION DE TIPO              : " +this.getTIPDON();
        s = s+ super.toString();
        s = s+ "\nNOMBRE DEL COMESTIBLE         : "+this.getNombre();
        s = s+ "\nCANTIDAD                      : "+this.getCant();
        s = s+ "\nFECHA DE EXPEDICION           : "+this.getFechex();
        s = s+ "\nPAIS DE ORIGEN                : " + this.getPaisorigen(); 
        s = s+ "\nDESTINATARIO                  : " + this.getDestinatario(); 
        return  s;
    }
    
    @Override
    public void menu(){
        System.out.println("\n*************MENU*************");
        System.out.println("[1] ENLATADOS");
        System.out.println("[2] AGUA EMBOTELLADA");
        System.out.println("[3] BOLSA DE ARROZ/LENTEJA");
        System.out.println("[4] BOLSA DE AZUCAR/SAL");
        System.out.println("[5] GALLETAS");
        this.tipocomes();
    }
    
    public void tipocomes(){
        this.Val_excepcion();        
                    switch(op){
                    case 1:{
                        System.out.println("ESCOGIO ENLATADOS");
                        this.setNombre("ENLATADOS");
                    break;
                    } 
                    case 2:{
                        System.out.println("ESCOGIO AGUA EMBOTELLADA");
                        this.setNombre("AGUA EMBOTELLADA");
                    break;
                    }
                    case 3:{
                        System.out.println("ESCOGIO ARROZ/LENTEJA");
                        this.setNombre("BOLSA DE ARROZ/LENTEJA");
                    break;
                    }
                    case 4:{
                        System.out.println("ESCOGIO BOLSA DE AZUCAR / SAL");
                        this.setNombre("BOLSA DE AZUCAR SAL");
                    break;
                    }
                    case 5:{
                        System.out.println("ESCOGIO GALLETAS");
                        this.setNombre("GALLETAS");
                    break;
                    }
                    default:
                    System.out.println("ESCOJA UNA OPCION VALIDA");
                    this.tipocomes();
                    break;
                    }
    }
    
    
    
    @Override
    public void tipo_de_Donacion() {
     this.setTIPDON("COMESTIBLE");
    }
    
    @Override
    public void Elegir_opcion() throws InputMismatchException{
       op= this.Val_num2("\nELIJA EL TIPO DE CONSUMIBLE: ");
    }
    
}
