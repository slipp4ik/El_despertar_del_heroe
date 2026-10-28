//El despertar del heroe 

import java.util.Random;
import java.util.Scanner;


public class Despertar_heroe 
{
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String ORANGE = "\u001B[38;5;166m";

    //alternativa para utilizar timeout sin throws InterruptedException
    //hecho con ayuda de IA
    public static void TimeOut(int milliseconds)  
    {
    try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void Filler()//un separador para estetica visual
    {
        System.out.println("_____________________________________");
    }

    public static String Intro()//introduccion + hay que guardar el usuario 
    {
        Scanner sc = new Scanner(System.in);
        Filler();
        System.out.println("Bienvenido a El despertar del heroe");
        TimeOut(500);
        System.out.println("\nIntroduce tu usuario para guardar las partidas:\n");
        String usuario = sc.next();
        Filler();
        System.out.println(GREEN+"\nEl usuario "+usuario+" guardado correctamente\n"+RESET);
        return usuario;
    }

    public static void Menu() //un menu-> nueva partida, consultar ranking, ayuda, salir
    {   
        
        TimeOut(500);
        System.out.println("Elige:\n"+"1. Nueva partida\n"+"2. Consultar ranking\n"+"3. Ayuda\n"+"4. Salir");
        Filler(); 
    }

    public static boolean intCheck(Scanner sc)  //comprobador basico de si he introducido un int
    {
        if(!sc.hasNextInt())
        {
            System.out.println(RED+"\nError: Tienes que introducir un numero\n"+RESET);
            sc.next();
            return false;
        }
        return true;
    }
    
    public static int MenuCheck(Scanner sc) //utilizando mi comprobador repeat until int intoducido 
    {
        int opcion = 0;
        boolean repeat = true;
        while(repeat)
        {
            if(intCheck(sc))
                {
                opcion = sc.nextInt();
                repeat = false;
                }
            else
                {
                Menu();
                }
        }
        return opcion;

    }

    public static int intLimitCheck(Scanner sc) //comprobar si el numero es 1-4 
    {
        int opcion;
        do
        {
            opcion = MenuCheck(sc);
            if(!(opcion >=1 && opcion<=4))
            {
                System.out.println(RED+"\nError: Tienes que introducir un numero 1-4\n"+RESET);
                Menu();
            }
        }while(!(opcion >=1 && opcion<=4));
        return opcion;  
    }

    public static void NuevaPartida()//opcion nueva partida del menu
    {
        System.out.println("\nCreando nueva partida\n");
        for (int i = 0; i < 14; i++) 
        {
            TimeOut(80);
            System.out.print(RED + "|" + RESET);
        }
        for (int i = 0; i < 15; i++) 
        {
            TimeOut(90);
            System.out.print(ORANGE + "|" + RESET);
        }  
    }

    public static void ConsultarRanking()//opcion consultar ranking del menu
    {
        System.out.println("Aun no hecho");
    }

    public static void Ayuda()//opcion ayuda del menu
    {
        System.out.println("Aun no hecho");
    }

    public static void Salir()//opcion salir del menu
    {
        System.out.println("Hasta luego...");
        System.exit(0);
    }
    public static void OpcionMenu(int opcion)//1.nueva partida, 2.consultar ranking, 3.ayuda, 4.salir
    {
        switch(opcion)
        {
            case 1:
                {
                    NuevaPartida();
                    break;
                }
            case 2:
                {
                    ConsultarRanking();
                    break;
                }
            case 3:
                {
                    Ayuda();
                    break;
                }
            case 4:
                {
                    Salir();
                    break;
                }
        }
    }
    public static String CrearHeroe()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIntroduce el nombre de tu heroe");
        String HeroeNom = sc.next();
        for (int i = 0; i < 10; i++) 
        {
            TimeOut(90);
            System.out.print(ORANGE + "|" + RESET);
        }
        for (int i = 0; i < 20; i++) 
        {
            TimeOut(100);
            System.out.print(GREEN + "|" + RESET);
        }
        System.out.println(GREEN+"\nHeroe creado"+RESET);
        return HeroeNom;
    }
    public static int DamageHeroe()
    {
        Random random = new Random();
        int damageHeroe = random.nextInt(10,21);
        return damageHeroe;
    }

    public static int DamageVillano()
    {
        Random random = new Random();
        int damageVillano = random.nextInt(5,15);
        return damageVillano;
    }
    
    public static void battaleIntro(Heroe heroe1)
    {
        System.out.println("Mientras caminaba por un bosque envuelto en niebla, el joven "+heroe1.getNombre()+ " descubrió una pequeña cabaña "
        +"iluminada por una luz extraña, donde un anciano mago lo esperaba como si hubiera estado aguardando su llegada durante siglos." 
        +"El Señor de las Sombras ha despertado, susurró el mago, entregándole una espada antigua. Solo tú puedes detenerlo.");
        System.out.println(heroe1.getNombre()+ "aceptó la espada y salió de la cabaña rumbo a las montañas del norte, donde se alzaba la fortaleza del villano."+ 
        "Pero el camino no sería fácil: antes tendría que cruzar tierras malditas y enfrentarse a los siervos que guardaban cada paso hacia su destino.");
    }
    public static void primerVillanoIntro(Heroe heroe1)
    {
        System.out.println("Al cruzar un puente de piedra derruido, "+heroe1.getNombre()+" oyó un arrastrar de cadenas que resonaba entre la niebla." 
        +"Grimdal el Encadenado emergió de las sombras, bloqueándole el paso con los ojos ardiendo de rabia: Nadie cruza estas tierras sin pasar sobre mi cadáver.");
    }
    public static void primerBattala()
    {

    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String user = Intro();
        Menu();
        int opcion = intLimitCheck(sc);
        OpcionMenu(opcion);
        
        String HeroeNom = CrearHeroe();
        Heroe heroe1 = new Heroe("", 100,1,0,0,3);
        heroe1.setNombre(HeroeNom);
        
        Villano primerVillano = new Villano("Grimdal el Encadenado", 40, 1,0 );
        Villano segundoVillano = new Villano("Vessa la Susurrante", 60, 2, 0);
        Villano finalBoss = new Villano("Señor de las Sombras ",80 , 3, 0);
        
        
        
    }
}