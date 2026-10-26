//El despertar del heroe 

import java.util.Scanner;

public class Despertar_heroe 
{
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String ORANGE = "\u001B[38;5;166m";

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
    public static void Filler()
    {
        System.out.println("_____________________________________");
    }
    public static void Menu() //nueva partida, consultar ranking, ayuda, salir
    {   
        Filler();
        TimeOut(500);
        System.out.println("Bienvenido a El despertar del heroe\n");
        TimeOut(500);
        System.out.println("Elige:\n"+"1. Nueva partida\n"+"2. Consultar ranking\n"+"3. Ayuda\n"+"4. Salir");
        Filler(); 
    }
    public static boolean intCheck(Scanner sc)
    {
        if(!sc.hasNextInt())
        {
            System.out.println("Error: Tienes que introducir un numero entero\n");
            sc.next();
            return false;
        }
        return true;
    }
    public static int afterCheck(Scanner sc)
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
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Menu();

        System.out.println("opcion:"+afterCheck(sc));
        
    }
}