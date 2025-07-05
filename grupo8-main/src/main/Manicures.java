//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Classes;

import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(
    tableName = "Manicures"
)
public class Manicures extends Profissionais {
    public Manicures() {
    }

    public Manicures(String nome, String dataNasc, String cpf, String categoria, String senha, float avaliacao, double valor) {
        super(nome, dataNasc, cpf, "manicure", senha, (double)avaliacao, valor);
    }
}
