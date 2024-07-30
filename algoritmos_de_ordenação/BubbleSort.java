public class BubbleSort {
    
    public static void OrdCres(int[] lista){
        boolean troca;
        for(int j=0; j<lista.length-1; j++){
            troca = false;
            for(int i=0; i<lista.length-1-j; i++){    
                if(lista[i]>lista[i+1]){
                    int aux = 0;
                    aux = lista[i+1];
                    lista[i+1] = lista[i]; 
                    lista[i] = aux;
                    troca = true;
                }
            }
            if (!troca) {
                break;
            }                
        }            
        Mostra(lista);
    }

    public static void OrdDecres(int[] lista){
        boolean troca;
        for(int j=0; j<lista.length-1; j++){
            troca = false;
            for(int i=0; i<lista.length-1-j; i++){    
                if(lista[i]<lista[i+1]){
                    int aux = 0;
                    aux = lista[i+1];
                    lista[i+1] = lista[i]; 
                    lista[i] = aux;
                    troca = true;
                }
            }
            if (!troca) {
                break;
            }                
        }            
        Mostra(lista);
    }

    public static void Mostra(int[] Lista){
        for (int i : Lista) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args){
        int[] lista = new int[] {1,5,7,3,4,2,6}; /*1,3,4,2,5,6,7 */
        OrdCres(lista);
        OrdDecres(lista);
    }
}
