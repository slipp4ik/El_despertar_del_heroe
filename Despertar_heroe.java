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
        System.out.println("____________________________________________");
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
        Filler();

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
    
    public static int MenuCheck(Scanner sc) //utilizando mi comprobador repetir hasta int intoducido 
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

    public static int intLimitCheck(Scanner sc, int x) // el int x es el limite que quieres tener
    {
        int opcion;
        do
        {
            opcion = MenuCheck(sc);
            if(!(opcion >=1 && opcion<=x))
            {
                System.out.println(RED+"\nError: Tienes que introducir un numero 1-4\n"+RESET);
                Menu();
            }
        }while(!(opcion >=1 && opcion<=x));
        return opcion;  
    }

    public static void NuevaPartida()//opcion nueva partida del menu
    {
        System.out.println("\nCreando nueva partida");
        for (int i = 0; i < 10; i++) 
        {
            TimeOut(80);
            System.out.print(RED + "|" + RESET);
        }
        
        for (int i = 0; i < 12; i++) 
        {
            TimeOut(80);
            System.out.print(ORANGE + "|" + RESET);
        } 
    }

    public static void ConsultarRanking()//opcion consultar ranking del menu
    {
        System.out.println("Aun no hecho");
    }

    public static void Ayuda()//opcion ayuda del menu
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nLas reglas del juego son: \n"
        +"Tienes que ganar a tres diferentes villanos durante tu camino.\n"
        +"Cada villano ganado te añade 100 puntos, los cuales puedes consultar en Ranking.\n"+
        "En caso de victoria completa, a los puntos ganados sumara el numero de vida final.\n"
        +"Durante el camino tienes 3 pociones que te regeneran 25 unidades de vida. \n");
        System.out.println("Introduce 1 para volver al menu principal");
        int volver = 0;
        do
        {
        if(intCheck(sc))
        {
            volver = sc.nextInt();
        }
        if(volver ==1)
        {
            Filler();
            return;
        }
        else
        {
            System.out.println("Hay que intorducir 1");
        }
        }while(volver !=1); 
    }

    public static void Salir()//opcion salir del menu
    {
        System.out.println("Hasta luego...");
        System.exit(0);
    }
    public static void OpcionMenu()//1.nueva partida, 2.consultar ranking, 3.ayuda, 4.salir
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            Menu();
            int opcion = intLimitCheck(sc, 4);
        
            switch(opcion)
            {
                case 1: 
                        NuevaPartida();
                        return;
                case 2:
                        ConsultarRanking();                        
                        break;
                case 3:
                        Ayuda();
                        break;
                case 4:
                        Salir();                        
                        break;
            }
        }        
    }

    public static String CrearHeroe() // nombrar el heroe como el jugador quiere
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIntroduce el nombre de tu heroe");
        String HeroeNom = sc.next();
        for (int i = 0; i < 23; i++) 
        {
            TimeOut(100);
            System.out.print(GREEN + "|" + RESET);
        }
        System.out.println(GREEN+"\nHeroe creado\n"+RESET);
        System.out.println("La historia empieza...");
        TimeOut(200);
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
        TimeOut(200);
        System.out.println(
        "\nMientras caminaba por un bosque envuelto en niebla, el joven "+heroe.getNombre()+ " descubrió una pequeña cabaña\n"
        +"iluminada por una luz extraña, donde un anciano mago lo esperaba como si hubiera estado aguardando su llegada \ndurante siglos." 
        +" El Señor de las Sombras ha despertado, susurró el mago, entregándole una espada antigua. Solo tú puedes detenerlo.\n");
        System.out.println(heroe.getNombre()+ " aceptó la espada y salió de la cabaña rumbo a las montañas del norte, donde se alzaba la fortaleza del villano.\n"+ 
        "Pero el camino no sería fácil: antes tendría que cruzar tierras malditas y enfrentarse a los siervos que guardaban \ncada paso hacia su destino.\n");
    }
    public static void villanoIntro(Heroe heroe, Villano villano) // intro del primer villano
    {
        primerVillano(villano);
        TimeOut(1000);
       System.out.println("Al cruzar un puente de piedra derruido, " + heroe.getNombre() + " oye un arrastrar de cadenas \nque resuena entre la niebla. "
        + " Grimdal el Encadenado emerge de las sombras, bloqueándole el paso con los ojos ardiendo de rabia: \nNadie cruza estas tierras sin pasar sobre mi cadáver.");
        TimeOut(1000);
    }
    public static void finalPrimeraBatalla(Heroe heroe, Villano villano) // al ganar la primera batalla
    {
        segundoVillano(villano);
        Filler();
        Filler();
        AñadirPuntos(heroe);
        System.out.println("Grimdal cae de rodillas y sus cadenas se deshacen en polvo. "+heroe.getNombre()+" recoge de su armadura un colgante\ncon un símbolo oscuro y sigue su camino."
            +"El sendero se adentra en un pantano cubierto de niebla,\ndonde los árboles retorcidos parecen observarlo en silencio. Entre las ramas,"+heroe.getNombre()+" cruza nruinas olvidadas y\nescucha los primeros susurros que llaman a su nombre."
            +"Al llegar a un claro iluminado por una luna pálida,\nVessa la Susurrante aparece flotando entre las sombras:Has llegado muy lejos, \npero mis voces te harán dudar de todo.");
        
    }

    public static void finalSegundaBatalla(Heroe heroe, Villano villano)
    {
        tercerVillano(villano);
        Filler();
        Filler();
        AñadirPuntos(heroe);
        System.out.println("Vessa la Susurrante lanza un último lamento y su figura se disuelve en el aire, llevándose consigo las voces que atormentaban a "+heroe.getNombre()+"\n" 
       +"El silencio vuelve al pantano y, entre la niebla que se disipa, aparece un camino de piedra negra que sube hacia las montañas del norte.\n"
        +"Tras una larga ascensión, el héroe llega a las puertas de la fortaleza, donde el viento aúlla entre torres rotas y el colgante de Grimdal\n"
        +"empieza a brillar con una luz oscura. Las puertas se abren solas, y en el centro del gran salón, sentado en un trono de sombras,\n"
        +"lo espera el Señor de las Sombras. Has derrotado a mis siervos, pequeño héroe, dice con una voz que hace temblar los muros.\n"
        +"Pero aquí termina tu viaje. Ven, y comprueba cuánto pesa la oscuridad.");
    }

    public static void finalTercerBatalla(Heroe heroe)
    {
        Filler();
        Filler();
        AñadirPuntos(heroe);
        System.out.println("El Señor de las Sombras se derrumba con un rugido que sacude toda la fortaleza. Su trono se resquebraja y\n"  
        +"la oscuridad que lo rodeaba se desvanece como humo arrastrado por el viento. El colgante de Grimdal se parte en dos y\n" 
        +"su luz oscura se apaga para siempre.\n"
        +"Los primeros rayos del sol atraviesan las ventanas rotas e iluminan el salón por primera vez en siglos.\n"
        +"Desde lo alto de las montañas, el héroe contempla las tierras que vuelven a la vida: la niebla se retira,\n"
        +"el pantano se aclara y el bosque despierta. En la lejanía, junto a una pequeña cabaña, el anciano mago alza\n"
        +"la mano en señal de despedida. La leyenda del héroe acaba de comenzar, y su nombre será recordado por todos.");
    }
    //-------------------------------------------------
    
    public static void heroeAtacar(Heroe heroe, Villano villano) // metodo que realiza el ataque del heroe
    {    
        if(heroe.serVivo() && villano.serVivo())
        {
            heroe.setDamage(DamageHeroe());
            System.out.println("Atacando...");
            villano.serAtacado(heroe.getDamage());
            System.out.println("Ataque realizada con "+heroe.getDamage()+" de daño, el villano tiene "+villano.getHP()+" de vida.");
        }
    }

    public static void VillanoAtacar(Heroe heroe, Villano villano) // metodo que realiza el ataque del villano
    {
        if(heroe.serVivo() && villano.serVivo())
        {
            villano.setDamage(DamageVillano());
            
            System.out.println("Villano atacando...");
            heroe.serAtacado(villano.getDamage());
            System.out.println("Ataque realizada con "+villano.getDamage()+" de daño, tienes "+heroe.getHP()+" de vida.");
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

    //opcion del menu de defender el ataque del villano---------
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

    //regenerar HP con una pocion, opcion del menu---------
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

    //menus durante la batalla----------------------
    public static void menuSinPosibilidadAtacar()
    {
        System.out.println("\n1. Defender \n"+"2. Usar un poción\n"+"3. Inventario\n"+"4. Abandonar");
    }
    public static void menuSinPosibilidadDefender()
    {
        System.out.println("\n1. Atacar \n"+"2. Usar un poción\n"+"3. Inventario\n"+"4. Abandonar");
    }
   
    //puntos para el ranking --------------------
    public static void AñadirPuntos(Heroe heroe)
    {
       int PtsActual = heroe.getPts();
       PtsActual += 100;
       heroe.setPts(PtsActual);
    
    }
    
    public static void Batalla(Heroe heroe, Villano villano, String[]inventario) // el metodo de batalla principal
    {
        Scanner sc = new Scanner(System.in);
        boolean turnoAt;
        boolean turnoDef;
        int limitPocion = 3;
        turnoAt = true;
        turnoDef = false;
        Filler();
        Filler();
        System.out.println("\nLa batalla contra "+villano.getNombre()+" comienza."+"\nLa estadistica de tu oponente es:");
        villano.MostrarStats();
        Filler();
        do
        {  
            int opcion = 0;
            if(turnoAt == true)
            {
                Filler();
                menuSinPosibilidadDefender();
                opcion = sc.nextInt();
                if(opcion != 1)
                {
                    opcion+=1;
                }
            }
            else
            {
                Filler();
                menuSinPosibilidadAtacar();
                opcion = sc.nextInt();
                opcion += 1;
            }
            
            Filler();
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
                    System.out.println(RED+"\nNo puedes atacar dos veces seguidas"+RESET);  
                }
                break;
            case 2: 
                if(turnoDef == true)
                {
                    turnoDef = false;
                    turnoAt = true;
                    if(defender(villano) == true)
                    {
                    System.out.println(GREEN+"\nAtaque de "+villano.getNombre()+" fue defendida"+RESET);
                    }
                    else
                    {
                    VillanoAtacar(heroe, villano);
                    }
                }
                else
                {
                    System.out.println(RED+"\nNo puedes defender aun"+RESET);  
                }
                break;
            case 3:
                if(limitPocion > 0 && heroe.getHP()<100) 
                {
                    UsarPocion(heroe); 
                    limitPocion--;
                    System.out.println("\nHas regenerado 25 unidades de vida, ahora tienes "+heroe.getHP()+" y te quedan "+limitPocion+" pociones");
                    for(int i =0; i<inventario.length; i++)
                    {
                        if(inventario[i] != null)
                        {
                            inventario[i]= null;
                            break;
                        }
                    } 
                }
                else if(limitPocion == 0)
                {
                    System.out.println(RED+"\nNo te quedan pociones de regenerar"+RESET);
                }
                else
                {
                    System.out.println(GREEN+"\nYa tienes 100 de vida"+RESET);
                }
            break;
            case 4:  
            printInventario(inventario); 
            break;
            case 5: Salir(); break;
            default: 
            System.out.println(RED+"\nOpción no válida"+RESET);
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

    public static String[] inventario()
    {
     return new String[] {"Pocion","Pocion","Pocion"};
    }
    
    public static void printInventario(String[] inventario)
    {
        for(int i = 0; i < inventario.length; i++)
        {
            if(inventario[i] != null)
            {
                System.out.println("Slot " + (i+1) + ": " + inventario[i]);
            }
            else
            {
            System.out.println("Slot " + (i+1) + ": Vacío");
            }
        }
    }



    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String user = Intro();

        OpcionMenu();
        String HeroeNom = CrearHeroe();
        Heroe heroe = new Heroe(HeroeNom, 100,1,0,0,3);
        Villano villano = new Villano("", 0, 0,0 );
        String[] inventario = inventario();
        
        HistoriaIntro(heroe); //Y
    
        villanoIntro(heroe, villano); //Y

        Batalla(heroe, villano, inventario); //Y

        finalPrimeraBatalla(heroe, villano);
        
        Batalla(heroe, villano, inventario);

        finalSegundaBatalla(heroe, villano);

        Batalla(heroe, villano, inventario);

        finalTercerBatalla(heroe);

    }
}