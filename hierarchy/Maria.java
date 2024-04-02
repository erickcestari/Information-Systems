package exercise;

public class Maria extends Pessoa implements IAcoesPessoa {
  Maria(){
    super("Maria", "Rua Cunha", 28, "Feminino");
  }

  public void andar() {
    System.out.println("Estou andando");
    
  }

  public void parar() {
    System.out.println("Parei de andar");
  }
}
