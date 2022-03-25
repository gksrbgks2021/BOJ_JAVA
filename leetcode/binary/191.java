public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count =0;
        int com = 1;
        for(int i = 0;i<32;i++)
        {
            if((n & com) !=0)//왼쪽으로 하나하나 가면서 1을 찾는다 
                count++;
                com <<= 1;
}
        return count;
    }
}