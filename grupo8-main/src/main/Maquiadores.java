//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Classes;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(
    tableName = "Maquiadores"
)
public class Maquiadores extends Profissionais {
    @DatabaseField
    protected double avaliacao;

    public Maquiadores(String nome, String dataNasc, String cpf, String senha, double avaliacao, double valor) {
        super(nome, dataNasc, cpf, "Maquiador", senha, avaliacao, valor);
    }

    public Maquiadores() {
    }

    public double getAvaliacao() {
        return this.avaliacao;
    }
}
