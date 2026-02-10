public class Main {
    public static void main(String[] args) throws Exception {
        int [] arr;//Declaracion
        arr= new int[10]; //Inicializacion de arr de tamaño 10
        int [] arr1 = new int[5];//Declaracion e inicializacion
        int[] arr2 = {1,2,3,4,5}; //Declaracion e inicializacion con valores



        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);

//Asignacion
        arr[0]=5;
        System.out.println(arr[0]);
        System.out.println(arr[1]);

//Recorrido
        System.out.println("Valores de Arr: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("______________");
        Persona[] personas=new Persona[3];
        Persona persona1= new Persona();
        persona1.setId(1);
        persona1.setName("Lizeth");
        persona1.setSctive(true);
        System.out.println(persona1.getId());
        Persona persona2 = new Persona(2,"Escamilla");
        System.out.println(persona2.isSctive());
        Persona persona3= new Persona(3,"Silvana");

        personas[0]=persona1;
        personas[1]=persona2;
        personas[2]=persona3;
        personas[0]=null;

        for (Persona persona : personas) {
            if(persona==null){
                System.out.println("null");
            }else{
                System.out.println(persona.getName());
            }



        }





    }
}
