class Solution {
    public String intToRoman(int num) {
        int n=(int)Math.log10(num);
        StringBuilder sb= new StringBuilder();
        HashMap<Integer,String> roman= new HashMap<>();
        roman.put(1,"I");
        roman.put(4,"IV");
        roman.put(5,"V");
        roman.put(9,"IX");
        roman.put(10,"X");
        roman.put(40,"XL");
        roman.put(50,"L");
        roman.put(90,"XC");
        roman.put(100,"C");
        roman.put(400,"CD");
        roman.put(500,"D");
        roman.put(900,"CM");
        roman.put(1000,"M");
        for(int i=n;i>=0;i--){
            int base=(int)Math.pow(10,i);
            int msb=num/base;
            num=num%base;
            if(msb!=4&&msb!=9){
                if(msb>=5){
                    sb.append(roman.get(5*base));
                    msb-=5;
                }
                while(msb!=0){
                    sb.append(roman.get(base));
                    msb--;
                }
            }
            else{
                sb.append(roman.get(msb*base));
            }

        }
        return sb.toString();
    }
}