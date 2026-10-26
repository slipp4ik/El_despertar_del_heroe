public class Villano extends Characters
{
    public Villano(String Nombre, int HP, int Nivel, int Damage)
    {
        super(Nombre, HP, Nivel, Damage);
    }
    public void MostrarStats()
    {
        System.out.println("\nEl nombe de tu enemigo es: "+getNombre()+
                "\nNivel actual: "+getNivel() +"\nCantidad de vida: "+getHP()+"\nDaño por ataque es de 5 a 15");
    }
}