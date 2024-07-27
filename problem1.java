class problem1{
    public static void main(String[] args){
        String str1="xyz";
        String str2="abcexyfg";
        System.out.println("The longest common subsequence is "+subseq(str1,str2));
    }
    public static int subseq(String str1,String str2){
        int x=str1.length();
        int y=str2.length();
        //storing the result
        int[][] a= new int[x+1][y+1];
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    a[i][j]=a[i-1][j-1]+1;
                }
                else{
                    a[i][j]=Math.max(a[i-1][j],a[i][j-1]);
                }
            }
        }
        return a[x][y];
    }
}