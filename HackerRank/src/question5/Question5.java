

package question5;

class Main{
public static void main() {
	int n=4;
	double edges= n*(n-1)*0.5;
    double sum=1;
    for (int i=n;i>=0; i--){
        sum+=funct(i,edges);
    }
    sum=(sum)%(Math.pow(10,9)+7);
    System.out.print(sum);
}


static double funct(int n,double edges){
     if (n==0)
         return 1;
     else
         return(funct(n-1,edges)*(edges-n)/(n+1));
 }
}
