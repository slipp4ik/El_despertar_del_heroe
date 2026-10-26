public class Heroe extends Characters
{
    private int Pts; //puntos
    private int Pocion; 
    
    public Heroe(String Nombre, int HP, int Nivel, int Damage, int Pts, int Pocion)
    {
        super(Nombre, HP, Nivel, Damage);
        this.Pts = Pts;
        this.Pocion = Pocion;
    }

    public int getPts() {
        return Pts;
    }

    public void setPts(int pts) {
        Pts = pts;
    }

    public int getPocion() {
        return Pocion;
    }

    public void setPocion(int pocion) {
        Pocion = pocion;
    }
    
    public void MostrarStats()
    {
        System.out.println("\nEl nombe de tu heroe es: "+getNombre()+
                "\nNivel actual: "+getNivel() +" con "+getPts()+" de 100 puntos maximos"+"\nCantidad de vida: "+getHP()+"\nDaño por ataque es de 10 a 20"+
                "\nCantidad de pociones disponibles: "+getPocion());
    }
    
}