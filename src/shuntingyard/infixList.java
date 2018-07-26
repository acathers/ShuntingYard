package shuntingyard;

import java.util.ArrayList;

public class infixList extends ArrayList<Object> {

    public infixList() {
        super();
    }

    public infixList(int initialSize) {
        super(initialSize);
    }

    @Override
    public boolean add(Object obj) {
        if ((obj instanceof String) || (obj instanceof Operator)) {
            return add(obj);
            
        } else {
            throw new IllegalArgumentException("not of type String or Operator");
        }
    }

    public void add(String s) {
        super.add(s);
    }

    public void add(Operator o) {
        super.add(o);
    }
}