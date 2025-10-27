class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        l=[]
        i=1
        while(i<=numRows):
            r=[]
            c=1
            for j in range(i):
                r.append(c)
                c=c*(i-j-1)//(j+1)
            l.append(r)
            i+=1
        return l   


        