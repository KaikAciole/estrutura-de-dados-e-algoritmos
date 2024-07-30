public class InsertionSort {
    
    public static void OrdCres(int[] lista){
        int aux;
        for (int i = 1; i < lista.length; i++) {
            aux = lista[i];
            int j = i-1;

            while (j >= 0 && lista[j] > aux) {
                lista[j+1] = lista[j];
                j--;
            }
            lista[j+1] = aux;
        }
        Mostrar(lista);
    }

    public static void Mostrar(int[] lista){
        for(int numero : lista){
            System.out.println(numero);
        }
    }

    public static void main(String[] args) {
        int[] lista = new int[]{2,1,7,8,5,6,4,3};
                           
        OrdCres(lista);
    }

}
