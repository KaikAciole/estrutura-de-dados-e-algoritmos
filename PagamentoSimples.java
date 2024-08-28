// Implementação da cor
interface Cor {
    void aplicarCor();
}

class Vermelho implements Cor {
    public void aplicarCor() {
        System.out.println("Aplicando cor vermelha");
    }
}

class Azul implements Cor {
    public void aplicarCor() {
        System.out.println("Aplicando cor azul");
    }
}

// Abstração da forma
abstract class Forma {
    protected Cor cor;

    public Forma(Cor cor) {
        this.cor = cor;
    }

    abstract void desenhar();
}

class Circulo extends Forma {
    public Circulo(Cor cor) {
        super(cor);
    }

    public void desenhar() {
        System.out.print("Desenhando círculo com ");
        cor.aplicarCor();
    }
}

class Quadrado extends Forma {
    public Quadrado(Cor cor) {
        super(cor);
    }

    public void desenhar() {
        System.out.print("Desenhando quadrado com ");
        cor.aplicarCor();
    }
}
