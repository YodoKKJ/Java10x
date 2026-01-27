package RefMemoria;

public abstract class Ninja {

    String nome;
    String aldeia;
    int idade;

    public Ninja(String nome, String aldeia, int idade) {
        this.nome = nome;
        this.aldeia = aldeia;
        this.idade = idade;
    }

    public Ninja(){

    }

    @Override
    public String toString() {
        return "Metodo to string pra ref na men";
    }
}
