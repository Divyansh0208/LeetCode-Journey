class ProductOfNumbers {
    List<Integer> n = null; 
    public ProductOfNumbers() {
        n=new ArrayList<Integer>();
        n.add(1);
    }
    
    public void add(int num) {
        if(num==0) {n.clear();
        n.add(1);}
        else n.add(num * n.get(n.size()-1));
    }
    
    public int getProduct(int k) {
        if(k>=n.size()) return 0;
        else
        return n.getLast()/n.get(n.size()-1-k);
    }
}