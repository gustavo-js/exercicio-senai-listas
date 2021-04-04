package sample;

public abstract class ListValidation {
    public void indexBiggerOrMinorTheList(int counter, int index) throws Exception {
        if (index >= counter) {
            throw new Exception("O index é maior do que o número de itens adicionados no array.");
        } else if (index < 0) {
            throw new Exception("O index é menor do que o número de itens adicionados no array.");
        }
    }
}
