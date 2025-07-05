//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Classes;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(
    tableName = "Cabeleleiros"
)
public class Cabeleleiros extends Profissionais {
    @DatabaseField
    protected double avaliacao;

    public Cabeleleiros(String nome, String dataNasc, String cpf, String senha, double avaliacao, double valor) {
        super(nome, dataNasc, cpf, "Cabeleleiro", senha, avaliacao, valor);
    }

    public Cabeleleiros() {
    }

    public double getAvaliacao() {
        return this.avaliacao;
    }
}
