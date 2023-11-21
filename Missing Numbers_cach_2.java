public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    Collections.sort(arr);
    Collections.sort(brr);
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < brr.size(); i++) {
        if(arr.contains(brr.get(i)) ){
            arr.remove(brr.get(i));
        }else{
            if(!result.contains(brr.get(i)))
                result.add(brr.get(i));
        }
    }
    
    Collections.sort(result);
    return result;

}