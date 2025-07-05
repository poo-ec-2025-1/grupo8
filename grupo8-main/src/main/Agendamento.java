//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Classes;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(
    tableName = "Agendamentos"
)
public class Agendamento {
    @DatabaseField(
        id = true
    )
    public String chaveComposta;
    @DatabaseField
    public String procedimento;
    @DatabaseField
    public String pessoa;

    public Agendamento(String chaveComposta, String procedimento, String pessoa) {
        this.chaveComposta = chaveComposta;
        this.procedimento = procedimento;
        this.pessoa = pessoa;
    }

    public Agendamento() {
    }

    public String getProcedimento() {
        return this.procedimento;
    }

    public void setProcedimento(String nome) {
        this.procedimento = nome;
    }
}
