package projeto;

public class Cliente {
  private Integer id;
  private String nome;
  private String dataNascimento;
  private String senha;

  public Cliente(String nome, String dataNascimento, String senha) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.senha = senha;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getSenha () {
    return senha;
  }

  @Override
  public String toString() {
    return "Cliente [dataNascimento=" + dataNascimento + ", id=" + id + ", nome=" + nome + "]";
  }
}
