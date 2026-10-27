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
        System.out.println("Creando nueva partida");
        for (int i = 0; i < 10; i++) 
        {
            TimeOut(80);
            System.out.print(RED + "." + RESET);
        }
        for (int i = 0; i < 15; i++) 
        {
            TimeOut(90);
            System.out.print(ORANGE + "." + RESET);
        }
        for (int i = 0; i < 20; i++) 
        {
            TimeOut(100);
            System.out.print(GREEN + "." + RESET);
        }
        System.out.println(GREEN+"\nPartida creada"+RESET);
        
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

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String user = Intro();
        Menu();
        int opcion = intLimitCheck(sc);
        OpcionMenu(opcion);
        
        
        Heroe heroe1 = new Heroe("Alli", 100,1,0,0,3);
        Villano villano1 = new Villano("Mago ",40 , 1, 40);
        heroe1.MostrarStats();
        villano1.MostrarStats();
        
    }
}