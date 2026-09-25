class Solution {
    TreeSet<String> a=new TreeSet<>();
    void dfs(String s){
        int r=s.indexOf('}');
        if(r==-1){
            a.add(s);
            return;
        }
        int x=s.lastIndexOf('{',r);
        String l=s.substring(0,x);
        String z=s.substring(r+1);
        String i=s.substring(x+1,r);
        for(String j:i.split(",")) dfs(l+j+z);
    }
    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(a);
    }
}