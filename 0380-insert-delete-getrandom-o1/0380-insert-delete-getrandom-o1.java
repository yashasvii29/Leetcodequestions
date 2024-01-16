class RandomizedSet {
    private List<Integer> ls;
    public RandomizedSet() {
        ls=new ArrayList<>();
    }
    public boolean insert(int val) {
        if(ls.contains(val)) 
            return false;
        ls.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(ls.contains(val)){
            ls.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }
    
    public int getRandom() {
      double rand=Math.floor(Math.random()*ls.size());
      return ls.get((int)rand);
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */