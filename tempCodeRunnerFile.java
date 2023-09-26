public static String balancedSums(List<Integer> arr) {
    int sum1 = 0;
    for(int i=0;i<arr.size();i++)
    {
        sum1 = sum1 + arr.get(i);
    }
    int sum2 = 0;
    for(int i=0;i<arr.size();i++)
    {
        sum1 = sum1 - arr.get(i);
        if(sum1 == sum2)
        {
            return "YES";
        }
        else
            sum2 = sum2 + arr.get(i);      
        
    }
    return "NO";
}