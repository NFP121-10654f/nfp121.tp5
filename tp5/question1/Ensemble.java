package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {
        if(this.table.contains(t))
        {
            return false;
	} 
	else 
	{
            this.table.add(t);
            return true;
	} 
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        this.diff(e);
        this.addAll(e);
        return this;
    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
        Ensemble inter = new Ensemble();
        inter.addAll(this);
        inter.retainAll(e);
        return inter;
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        Ensemble diff = new Ensemble();
        diff.addAll(this);
        diff.removeAll(this.inter(e));
        return diff;
    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) {
        Ensemble<T> temp = new Ensemble<>();
        temp.addAll(this);
        temp.union(e);
        temp.removeAll(this.inter(e));
        
        return temp;
    }
    
}
