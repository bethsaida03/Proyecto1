package DONANTE;
import java.util.*;
/**
 *
 * @author mac
 */
public class DEconomica extends Donacion{
    private double monto;
    private String metpago;
    private String direccion;
    protected int op;

    public DEconomica(double monto, String metpago, String direccion, String codigo, String motivo, String tipdon, Donante persona, String fecha) {
        super(codigo, motivo, tipdon, persona);
        this.monto = monto;
        this.metpago = metpago;
        this.direccion = direccion;
    }

    public DEconomica() {
        this.monto = 0;
        this.metpago = "";
        this.direccion="";
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetpago() {
        return metpago;
    }

    public void setMetpago(String metpago) {
        this.metpago = metpago;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public void menu(){
        System.out.println("*************PAGO*************");
        System.out.println("[1] EFECTIVO");
        System.out.println("[2] CHEQUE");
        System.out.println("[3] TARJETA DE CREDITO");
        System.out.println("[4] OTRO");   
        this.tippag();
    }
    
    public void tippag(){

        this.Val_excepcion();
            switch(op){
                case 1:{
                    System.out.println("ESCOGIO EFECTIVO" );
                    this.setMetpago("EFECTIVO");    
                    break;
                } 
                case 2:{
                    System.out.println("ESCOGIO CHEQUE" );
                    this.setMetpago("CHEQUE");   
                    break;
                }
                case 3:{
                    System.out.println("ESCOGIO TARJETA DE CREDITO" );
                    this.setMetpago("TARJETA DE CREDITO");   
                    break;
                }
                case 4:{
                    System.out.println("ESCOGIO OTRO" );
                    this.setMetpago("OTRO");   
                    break;
                }
                default:
                    System.out.println("ESCOJA UNA OPCION VALIDA");
                    this.tippag();
                break;
               }
    }
    
    
    @Override
    public void IngresarD(){
        this.tipo_de_Donacion();
        super.IngresarD();
        //System.out.print("INGRESE EL MONTO A DONAR      : " );
        //this.setMonto(this.monto=sc.nextDouble());
        this.setMonto(this.Val_num("INGRESE EL MONTO A DONAR      : " ));
        this.menu();
        System.out.print("INGRESE LA DIRECCION          : " );
        this.setDireccion(this.direccion=sc.nextLine());
    }
        
    @Override
    public String toString(){
        String s;
        s=     "\nDONACION DE TIPO              : " +this.getTIPDON();
        s = s+ super.toString();
        s = s+ "\nMONTO A DONAR                 : "+this.getMonto();
        s = s+ "\nTIPO DE PAGO                  : "+this.getMetpago();
        s = s+ "\nDIRECCION                     : " + this.getDireccion();     
        return  s;
    }
    
    @Override
    public void tipo_de_Donacion() {
     this.setTIPDON("ECONOMICA");
    }
    
    @Override
    public void Elegir_opcion() throws InputMismatchException{
       op= this.Val_num2("\nELIJA EL TIPO DE PAGO: ");
    }
    
}
