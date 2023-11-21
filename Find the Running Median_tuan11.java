public static List<Double> runningMedian(List<Integer> a) {
    ArrayList<Double> list=new ArrayList<Double>();
    ArrayList<Double> result=new ArrayList<Double>();
    for(int i=0;i<a.size();i++)
    {
        double x=a.get(i)*1.0;
        if(i==0)
        {
           list.add(x);
           result.add(x);
        }
        else{
            int low=0,high=list.size()-1,index=0;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(list.get(mid)>x)
                {
                    index=mid;
                    high=mid-1;
                }
                else{
                    index=mid+1;
                    low=mid+1;
                }
            }
            list.add(index,x);
            if(list.size()%2==0)
            {
                int m=list.size()/2;
                result.add((list.get(m)+list.get(m-1))/2);
            }
            else
            {
                int m=list.size()/2;
                result.add(list.get(m));
            }
        }
    }
    
    return result;
    }