package Classes;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Manicures")
public class Manicures extends Profissionais {

    public Manicures(){
        super();
    }


    public Manicures(String nome, String dataNasc, String cpf, String categoria, String senha, float avaliacao, double valor) {

        super(nome, dataNasc, cpf, "manicure", senha, avaliacao, valor);
    }

}
