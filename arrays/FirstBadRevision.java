public class FirstBadRevision {
    public boolean isBadVersion(int version){
        //method implemented in some Api
        return true;
    }
    public int firstBadVersion(int n) {
        int l =1;
        int h = n;
        while(h >= l){
            int m = l + (h-l)/2 ; 
            boolean midVer = isBadVersion(m);
            boolean predMidVer = (m>1)?isBadVersion(m-1):false;
            if(midVer && !predMidVer){
                h = m;
                break;
            }
            else if(midVer && predMidVer){
                h = m-1;
            }
            else{
                l = m +1;
            }
        }
        return h;
    }
    public static void main(String[] args) {
        /**
         * You are a product manager and currently leading a team to develop a new
         * product. Unfortunately, the latest version of your product fails the quality
         * check. Since each version is developed based on the previous version, all the
         * versions after a bad version are also bad.
         * 
         * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
         * bad one, which causes all the following ones to be bad.
         * 
         * You are given an API bool isBadVersion(version) which returns whether version
         * is bad. Implement a function to find the first bad version. You should
         * minimize the number of calls to the API.
         */
    }
}
