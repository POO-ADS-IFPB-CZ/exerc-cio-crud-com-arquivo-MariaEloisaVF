import java.io.*;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

public class Gerencia {
    private Set<Pessoa> pessoas;
    private final String fileName = "pessoas.dat";

    public Gerencia(){
        pessoas = new HashSet<>();
        carregarPessoas();
    }

    public void salvarPessoa(Pessoa pessoa){
        if (pessoas.add(pessoa)){
            salvarPessoas();
            System.out.println("Pessoa salva!");
        } else {
            System.out.println("Pessoa já cadastrada!");
        }
    }

    public void listarPessoas(){
        if (pessoas.isEmpty()){
            System.out.println("Nenhuma pessoa na lista!");
        } else {
            pessoas.forEach(System.out::println);
        }
    }

    public void deletarPessoa(String email){
        Pessoa pessoaDeletar = null;
        for (Pessoa p : pessoas){
            if (p.getEmail().equalsIgnoreCase(email)){
                pessoaDeletar = p;
                break;
            }
        }
        if (pessoaDeletar != null){
            pessoas.remove(pessoaDeletar);
            salvarPessoas();
            System.out.println("Pessoa deletada!");
        } else {
            System.out.println("Pessoa não encontrada");
        }
    }

    private void carregarPessoas(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            pessoas = (Set<Pessoa>) ois.readObject();
        } catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado!");
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Erro ao carregar" + e.getMessage());
        }
    }

    private void salvarPessoas(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(pessoas);
        }catch (IOException e){
            System.out.println("Erro ao salvar" + e.getMessage());
        }
    }


}
