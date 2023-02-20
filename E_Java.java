
public class E_Java {
    
    public static void parity(int number){
        if ((number % 2) == 1){
            System.out.println( number + " is odd");
            for (int i = number-2; i>0; i=i-2){
                System.out.println("next odd number is " + i);
            }
        }
    else System.out.println(number + " is even");
        
    }
    
    public static void leer_persona(persona[] personas){
        for (int i = 0; i< 50; i++){
            personas[i] = new persona((int)(Math.random()*70), (int)(Math.random()*2));
        System.out.println( i+1 +" - Edad: " + personas[i].Edad + " - Genero: " + personas[i].Sexo);
        }
    }
    
    public static void estadisticas(persona[] personas){
        int m_18 = 0; //hombres >18
        int f_18 = 0; //mujeres >18
        int n_m_18 = 0; //hombres <18
        int n_f_18 = 0; //mujeres <18
    
        for (int i = 0; i< 50; i++){
            if(personas[i].Edad < 18 && personas[i].Sexo == 0) n_m_18++;
            else if(personas[i].Edad < 18 && personas[i].Sexo == 1) n_f_18++;
            else if(personas[i].Edad >= 18 && personas[i].Sexo == 0) m_18++;
            else f_18++;
        }
        
        float p_18 = 100* (m_18+f_18)/50;
        float p_f = 100* (n_f_18+f_18)/50;
        
        System.out.println("Hombres >18: " + m_18);
        System.out.println("Hombres <18: " + n_m_18);
        System.out.println("Mujeres >18: " + f_18);
        System.out.println("Mujeres <18: " + n_f_18);
    
        System.out.println("Mayores de Edad: " +  (m_18+f_18));
        System.out.println("Menores de Edad: " + (n_m_18+n_f_18));
        System.out.println("Porcentaje Mayores de Edad: " +p_18 + " %");
        System.out.println("Porcentaje Mujeres: " + p_f + "%");
        
    }
    
    public static float leer_tarifa(){
        return (float)(Math.random()*20);
    }
    public static int leer_horas(){
        return (int)(Math.random()*200);
    }
    
    public static void calcular_salario(int horas, float tarifa){
        float salario = 0;
        if (horas > 40) salario = tarifa * (1.5f*horas - 20f); // Reduccion de tarifa * (40 + 1.5*(horas-40))
        else salario = tarifa*horas;
        
        System.out.println("Salario Calculado para " + horas + " horas con una tarifa de " + tarifa + " € = " + salario);
    }
    
    public static void main(String args[]) {
        
        System.out.println("Prueba Numero Impar");
        int numero=31;
        parity(numero);
        System.out.println();
        System.out.println("Prueba Numero Par");
        numero=490;
        parity(numero);
        
        System.out.println();
        System.out.println("Prueba Clasificacion");
        persona[] personas = new persona[50];
        leer_persona(personas);
        System.out.println();
        estadisticas(personas);
        System.out.println();
        
        System.out.println("Prueba Salario");
        float tarifa = leer_tarifa();
        int horas = leer_horas();
        
        calcular_salario(horas, tarifa);
      
    }
    
    static class persona
        {
    public int    Edad;
    public int    Sexo;
    persona(int e, int s){
     Edad = e;
     Sexo = s;
  }
 }
}
