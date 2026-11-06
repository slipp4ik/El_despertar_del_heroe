public class Villano extends Personajes
{
    public Villano(String Nombre, int HP, int Nivel, int Damage)
    {
        super(Nombre, HP, Nivel, Damage);
    }
    public void MostrarStats()
    {
        System.out.println("\nCantidad de vida: "+getHP()+"\nDaño por ataque es de 5 a 15");
    }
}