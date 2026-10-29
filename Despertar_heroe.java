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
    public static String CrearHeroe() // nombrar el heroe como el jugador quiere
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIntroduce el nombre de tu heroe\n");
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
    public static int DamageHeroe() // crear el daño para el heroe, usando random
    {
        Random random = new Random();
        int damageHeroe = random.nextInt(10,20);
        return damageHeroe;
    }

    public static int DamageVillano() // crear el daño para el villano, usando random
    {
        Random random = new Random();
        int damageVillano = random.nextInt(5,15);
        return damageVillano;
    }

    //Abajo viene la historia/contexto del juego
    public static void HistoriaIntro(Heroe heroe) // la prehistoria 
    {
        System.out.println(
        "Mientras caminaba por un bosque envuelto en niebla, el joven "+heroe.getNombre()+ " descubrió una pequeña cabaña\n"
        +"iluminada por una luz extraña, donde un anciano mago lo esperaba como si hubiera estado aguardando su llegada \ndurante siglos." 
        +"El Señor de las Sombras ha despertado, susurró el mago, entregándole una espada antigua. Solo tú puedes detenerlo.\n");
        System.out.println(heroe.getNombre()+ " aceptó la espada y salió de la cabaña rumbo a las montañas del norte, donde se alzaba la fortaleza del villano.\n"+ 
        "Pero el camino no sería fácil: antes tendría que cruzar tierras malditas y enfrentarse a los siervos que guardaban \ncada paso hacia su destino.");
    }
    public static void villanoIntro(Heroe heroe) // intro del primer villano
    {
       System.out.println("Al cruzar un puente de piedra derruido, " + heroe.getNombre() + " oye un arrastrar de cadenas \nque resuena entre la niebla. "
        + " Grimdal el Encadenado emerge de las sombras, bloqueándole el paso con los ojos ardiendo de rabia: \nNadie cruza estas tierras sin pasar sobre mi cadáver.");
    }
    public static void finalPrimeraBatalla() // al ganar la primera batalla
    {
        System.out.println("Grimdal cae de rodillas y sus cadenas se deshacen en polvo. El héroe recoge de su \narmadura un colgante con un símbolo oscuro y sigue su camino."
            +"El sendero se adentra en un pantano cubierto de niebla, donde los árboles retorcidos parecen observarlo en silencio. \nEntre las ramas, el héroe cruza ruinas olvidadas y escucha los primeros susurros que llaman a su nombre."
            +"Al llegar a un claro iluminado por una luna pálida, Vessa la Susurrante aparece flotando entre las sombras:\n Has llegado muy lejos, pero mis voces te harán dudar de todo.");
        
    }
    //-------------------------------------------------
    
    public static void heroeAtacar(Heroe heroe, Villano villano) // metodo que realiza el ataque del heroe
    {    
        if(heroe.serVivo() && villano.serVivo());
        {
            heroe.setDamage(DamageHeroe());
            System.out.println("Atacando...");
            villano.serAtacado(heroe.getDamage());
            System.out.println("Ataque realizada, el villano tiene "+villano.getHP()+" de vida.\n");
        }
    }

    public static void VillanoAtacar(Heroe heroe, Villano villano) // metodo que realiza el ataque del villano
    {
        if(heroe.serVivo() && villano.serVivo());
        {
            villano.setDamage(DamageVillano());
            
            System.out.println("Villano atacando...");
            heroe.serAtacado(villano.getDamage());
            System.out.println("Ataque realizada, tienes "+heroe.getHP()+" de vida.");
        }
    }

    public static int intLimit2(Scanner sc) //comprobar si el numero es 1-2
    {
        int opcion;
        do
        {
            opcion = MenuCheck(sc);
            if(!(opcion >=1 && opcion<=2))
            {
                System.out.println(RED+"\nError: Tienes que introducir un numero 1-2\n"+RESET);
            }
        }while(!(opcion >=1 && opcion<=2));
        return opcion;  
    }

   
    public static void menuDuranteBatalla() // un menu que esta utilizado dentro de la batalla
    {
        System.out.println("1. Atacar \n"+"2. Defender \n"+"3. Usar un poción\n"+"4. Inventario\n"+"5. Abandonar\n");
    }

    public static boolean defender(Villano villano) 
    {
        Random random = new Random();
        int nivelVillano = villano.getNivel();
        switch(nivelVillano)
        {
        case 1: 
            int defend1 = random.nextInt(0,2);  // posibilidad 50% de defender el ataque del villano
            if(defend1 == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        case 2:
            int defend2 = random.nextInt(0,3);  // posibilidad 33.3% de defender el ataque del villano
            if(defend2 == 0 || defend2 == 1)
            {
                return false;
            }
            else
            {
                return true;
            }
        case 3:
            int defend3 = random.nextInt(0,4);  // posibilidad 25% de defender el ataque del villano
            if(defend3 == 0 || defend3 == 1 || defend3 == 2)
            {
                return false;
            }
            else
            {
                return true;
            }
        default:
            return false;
        }
        
    }

    public static void UsarPocion(Heroe heroe)
    {
        int HPactual = heroe.getHP();
        int MaxHp = 100;
        HPactual += 25;
        if(HPactual > MaxHp)
        {
            HPactual = 100;
        }
        heroe.setHP(HPactual);
        
    }

    public static void Batalla(Heroe heroe, Villano villano) // el metodo de batalla principal
    {
        Scanner sc = new Scanner(System.in);
        boolean turnoAt;
        boolean turnoDef;
        int limitPocion = 3;
        turnoAt = true;
        turnoDef = false;
        
        Filler();
        System.out.println("La batalla contra "+villano.getNombre()+" comienza");
        do
        {   
            Filler();
            menuDuranteBatalla();
            int opcion = sc.nextInt();
            switch(opcion)
            {
            case 1: 
                if(turnoAt == true)
                {
                    heroeAtacar(heroe, villano);
                    turnoAt = false;
                    turnoDef = true;    
                }
                else
                {
                    System.out.println("No puedes atacar dos veces seguidas");  
                }
                break;
            case 2: 
                if(turnoDef == true)
                {
                    turnoDef = false;
                    turnoAt = true;
                    if(defender(villano) == true)
                    {
                    System.out.println("Ataque de "+villano.getNombre()+" fue defendida");
                    }
                    else
                    {
                    VillanoAtacar(heroe, villano);
                    }
                }
                else
                {
                    System.out.println("No puedes defender aun");  
                }
                break;
            case 3:
                if(limitPocion==3 || limitPocion==2 || limitPocion ==1)
                {
                    UsarPocion(heroe); 
                    limitPocion--;
                    System.out.println("Has regenerado 25 unidades de vida, ahora tienes "+heroe.getHP()+" y te quedan "+limitPocion+" pociones");
                }
                else
                {
                    System.out.println("No te quedan pociones de regenerar");
                }
                
            
            break;
            case 4: System.out.println("en proceso"); break;
            case 5: System.out.println("en proceso"); break;
            default: 
            System.out.println("Opción no válida");
            break;
            }
            
        }while(heroe.serVivo() && villano.serVivo());    
    }

    // Creacion de tres villanos
    public static void primerVillano(Villano villano)
    {
        villano.setNombre("Grimdal el Encadenado");
        villano.setHP(40);
        villano.setNivel(1);  
    }

    public static void segundoVillano(Villano villano)
    {
        villano.setNombre("Vessa la Susurrante");
        villano.setHP(60);
        villano.setNivel(2);  
    }

    public static void tercerVillano(Villano villano)
    {
        villano.setNombre("El Señor de las Sombras");
        villano.setHP(80);
        villano.setNivel(3);  
    }
 //-----------------------------------



    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String user = Intro();
        
        Menu();
        int opcion = intLimitCheck(sc);
        OpcionMenu(opcion);
        
        String HeroeNom = CrearHeroe();
        Heroe heroe = new Heroe(HeroeNom, 100,1,0,0,3);
        Villano villano = new Villano("", 0, 0,0 );

        primerVillano(villano);
        HistoriaIntro(heroe);
        villanoIntro(heroe);
        Batalla(heroe, villano);
        finalPrimeraBatalla();
        segundoVillano(villano);
        Batalla(heroe, villano);

        

    }
}