public class Characters 
{
    private String Nombre;
    private int HP; // cantidad de vida
    private int Nivel;
    private int Damage; //el daño 

    public Characters(String Nombre, int HP, int Nivel, int Damage)
    {
        this.Nombre = Nombre;
        this.HP = HP;
        this.Nivel = Nivel;
        this.Damage = Damage;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int hP) {
        HP = hP;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int nivel) {
        Nivel = nivel;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public void serAtacado(int Damage)
    {
        HP -= Damage;
        if(HP < 0)
        {
            HP = 0;
        }
    }

    public boolean serVivo()
    {
        return HP > 0;
    }

}
