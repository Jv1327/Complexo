public class NumeroComplexo {
    private double parteReal;
    private double parteImaginaria;

    // Construtor
    public NumeroComplexo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    // Getters e Setters
    public double getParteReal() {
        return parteReal;
    }

    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    public double getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    // Método somar
    public void somar(NumeroComplexo outro) {
        this.parteReal += outro.parteReal;
        this.parteImaginaria += outro.parteImaginaria;
    }

    // Método subtrair
    public void subtrair(NumeroComplexo outro) {
        this.parteReal -= outro.parteReal;
        this.parteImaginaria -= outro.parteImaginaria;
    }

    // Método multiplicar
    public void multiplicar(NumeroComplexo outro) {
        double real = this.parteReal * outro.parteReal - this.parteImaginaria * outro.parteImaginaria;
        double imaginaria = this.parteReal * outro.parteImaginaria + this.parteImaginaria * outro.parteReal;
        this.parteReal = real;
        this.parteImaginaria = imaginaria;
    }

    // Método dividir
    public void dividir(NumeroComplexo outro) {
        double divisor = outro.parteReal * outro.parteReal + outro.parteImaginaria * outro.parteImaginaria;
        double real = (this.parteReal * outro.parteReal + this.parteImaginaria * outro.parteImaginaria) / divisor;
        double imaginaria = (this.parteImaginaria * outro.parteReal - this.parteReal * outro.parteImaginaria) / divisor;
        this.parteReal = real;
        this.parteImaginaria = imaginaria;
    }

    // Método de comparação semântica (equals)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NumeroComplexo outro = (NumeroComplexo) obj;
        return Double.compare(outro.parteReal, parteReal) == 0 &&
               Double.compare(outro.parteImaginaria, parteImaginaria) == 0;
    }

    // Método que gera e retorna a representação string do número complexo
    @Override
    public String toString() {
        return parteReal + (parteImaginaria >= 0 ? " + " : " - ") + Math.abs(parteImaginaria) + "i";
    }

    // Método que retorna o módulo do número complexo
    public double modulo() {
        return Math.sqrt(parteReal * parteReal + parteImaginaria * parteImaginaria);
    }

    // Método principal para teste
    public static void main(String[] args) {
        NumeroComplexo num1 = new NumeroComplexo(3, 4);
        NumeroComplexo num2 = new NumeroComplexo(1, 2);

        System.out.println("Número 1: " + num1);
        System.out.println("Número 2: " + num2);

        num1.somar(num2);
        System.out.println("Após somar: " + num1);

        num1 = new NumeroComplexo(3, 4); // Resetando num1 para o valor original
        num1.subtrair(num2);
        System.out.println("Após subtrair: " + num1);

        num1 = new NumeroComplexo(3, 4); // Resetando num1 para o valor original
        num1.multiplicar(num2);
        System.out.println("Após multiplicar: " + num1);

        num1 = new NumeroComplexo(3, 4); // Resetando num1 para o valor original
        num1.dividir(num2);
        System.out.println("Após dividir: " + num1);

        System.out.println("Número 1 é igual ao número 2? " + num1.equals(num2));

        System.out.println("Módulo do número 1: " + num1.modulo());
    }
}