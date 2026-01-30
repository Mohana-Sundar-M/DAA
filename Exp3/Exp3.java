package Exp3;
public class Exp3 {

    public static void main(String[] args) {
        int pro[][] = {{10,20,30},{60,100,120}};
        int cap = 50;
        double[] ratio = new double[3] ;
        for(int i=0;i<=pro.length;i++ ){
           ratio[i] = pro[1][i]/pro[0][i];
        }
     

        //Descending order
        double temp;
        for(int i =0;i<ratio.length;i++){
            for(int j=0;j<ratio.length;j++){
                if(ratio[i]>ratio[j]
                ){
                    temp = ratio[j];
                    ratio[j] = ratio[i];
                    ratio[i]=temp;
                    // swap weight
                    int tempW = pro[0][i];
                    pro[0][i] = pro[0][j];
                    pro[0][j] = tempW;

                    // swap profit
                    int tempP = pro[1][i];
                    pro[1][i] = pro[1][j];
                    pro[1][j] = tempP;
                }
            }
        }
         double totalProfit = 0;

         int n = pro[0].length;
        for (int i = 0; i < n; i++) {

            if (cap >= pro[0][i]) {
                cap -= pro[0][i];
                totalProfit += pro[1][i];
            } else {
                totalProfit += ratio[i] * cap;
                break;  
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);
    }
}