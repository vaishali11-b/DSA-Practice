class 12 {
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String ans="";
        for(int i=0;i<values.length;i++){
            //System.out.println(values[i]);
            while(num>=values[i]){
                 System.out.println(symbols[i]);
                ans+=symbols[i];
                num=num-values[i];
            }
            
           // System.out.println(num);
        }
        return ans;
    }
}
