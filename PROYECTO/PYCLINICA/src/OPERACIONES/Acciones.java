package OPERACIONES;
import DONANTE.*;
import INTERFACES.OPERACIONES;
import java.util.*;
import javax.swing.JOptionPane;

public class Acciones implements OPERACIONES{
    Scanner sc = new Scanner(System.in);
    protected String nom;
    protected String ape;
    protected String ced;
    private Donante persona = new Donante();
    Set <Donante> ListDonante;
    ArrayList<Donante> LDonan;
    ArrayList<Donacion> LDonaciones;
    ArrayList<Donacion> LDComestibles;    
    
    public Acciones(){
        this.ListDonante = new HashSet();
        this.LDonaciones = new ArrayList();
        this.LDComestibles = new ArrayList();
    }

    public Donante getPersona() {
        return persona;
    }

    public void setPersona(Donante persona) {
        this.persona = persona;
    }
     
    @Override
    public void SelecPD() {
        int ini;
        LDonan = new ArrayList(ListDonante);
        //LDonan.clear();
        //System.out.print("\nIngrese el numero del Donante: ");
        ini=this.Val_num("\nIngrese el numero de lista del Donante: ");
        
        if (ini<=LDonan.size()){
            nom= LDonan.get(ini-1).getNombre();
            persona.setNombre(nom);
            ape=LDonan.get(ini-1).getApellido();
            persona.setApellido(ape);
            ced= LDonan.get(ini-1).getCedula();
            persona.setCedula(ced);
            System.out.print(" "+ nom + " | " + ape + " | " + ced);
        }
        else{
           System.out.print("Escoja un Donante Existente");
           this.SelecPD();   
        }     
    }

/*  public void Valexist(Donante pd){
        for(Donante per: this.ListDonante){
            if(per.equals(pd)){
             System.out.println("ESTA CEDULA YA EXISTE");
            }
        }
    }*/
    
    public int Val_num(String Enunciado){
        String s1= "";
        while(s1.equals("")){
            System.out.print(Enunciado);
            s1 = sc.nextLine();
            if (!s1.matches("[0-9]{1,9}")){
                s1="";
                System.out.println("SOLO PUEDE INGRESAR NUMEROS Y DEBEN TENER UNA LONGITUD MENOR DE 10 CARACTERES");
            }
        }
        return Integer.parseInt(s1);    
    }
    

    @Override
    public void Buscar_Donante(String ced){    
        if(!(ListDonante.size()==0)){
            for(Donante man : ListDonante) {  
                if(man.getCedula().equals(ced)){
                    System.out.println("\n************DONANTE ENCONCTRADO********");
                    System.out.println(man.toString());
                }
                else{
                    System.out.println("NO EXISTE UN DONANTE CON ESTE NUMERO DE CEDULA");
                }
            }
        }
        else{
            System.out.println("NO EXISTEN DONANTES EN EL REGISTRO");
        }
    }
    
    @Override
    public void Buscar_Donacion(String cod){
        if(!(LDonaciones.size()==0)){
            for(Donacion donacion : LDonaciones) {  
                    if(donacion.getCodigo().equals(cod)){
                        System.out.println("\n************DONACION ENCONCTRADA********");
                        System.out.println(donacion.toString());
                    }
                    else{
                        System.out.println("NO EXISTE UNA DONACION CON ESTE CODIGO");
                    }
            }
        }
        else{
            System.out.println("NO EXISTEN DONACIONES EN EL REGISTRO");
        }
    }
    
    public void Valexist(Donante d){
       if (ListDonante.contains(d)){
           System.out.println("ESTA CEDULA ESTA EXISTENTE EN EL REGISTRO");
       }
    }
    
    
       public boolean Valexistdona( String cod){
       boolean rep=false;
       if(!(LDonaciones.size()==0)){
            for(Donacion donacion : LDonaciones) {  
                    if(donacion.getCodigo().equals(cod)){
                        System.out.println("\n************DONACION EXISTENTE********");
                        rep=true; 
                    }
            }
        }
        else{
            System.out.println("NO EXISTEN DONACIONES EN EL REGISTRO");
        }
        
       return rep;
    }
    
    
    
    
    @Override
    public void mostrarLPD() {
        int i=0;
        System.out.println("\n**********LISTA DE DONANTES*******");
        for (Donante man : ListDonante) {      
            System.out.println("["+(i+1)+"]" + " "+ man.getNombre() + " | " + man.getApellido() + " | " + man.getCedula());
            i++;
        }
    }
    
    @Override
    public void Remover_Donante(String d1){
        String s="";
        if(!(ListDonante.size()==0)){
            Iterator<Donante> it = ListDonante.iterator();
            while(it.hasNext()){
                String cedula_donante= it.next().getCedula();
                    if(cedula_donante.equals(d1)){
                        it.remove();
                        s="DONANTE ELIMINADO CON EXITO";
                    }
                    else{
                        s="EL DONANTE QUE INTENTA ELIMINAR NO EXISTE";
                    }
            }
            System.out.println(s);
        }
        else{
            //JOptionPane.showMessageDialog(null,"NO EXISTEN DONANTES EN EL INGRESO","SOTFWARE", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("NO EXISTEN DONANTES EN EL REGISTRO");
        }
    }
    
    @Override
    public double monto_recibido(){
        double total = 0;
        for(Donacion donacion : LDonaciones) {
            if (donacion instanceof DEconomica) {
                DEconomica dec = (DEconomica)donacion;
                total += dec.getMonto(); 
            }
        }
        return total;
    }
    
    @Override
    public void Agg_P(Donante d1){
        this.ListDonante.add(d1);              
    }
    @Override
    public void Agg_D(Donacion d1) {
        this.LDonaciones.add(d1);
    }
   
    public void Agg_DComes(Donacion d1) {
        this.LDComestibles.add(d1);
    }
/*  public void Mostrar_PD(){
        for(int i=0; i<this.LDonante.size();i++){
            String objeto = this.LDonante.get(i).toString();
            System.out.println(objeto);
        }   
    }*/
}
