package question3;

import java.util.Set;

public class Tests extends junit.framework.TestCase {

    public void test1(question3.Factory<Set>  f) throws Exception {
        Set<Integer> set = f.create();
        for (int i = 20; i > 0; i--)
            set.add(i);
    }

    public void test_Creation() {
        try {
            test1(new TreeSetFactory<Integer>());
            test1(new HashSetFactory<Integer>());
        } catch (NoSuchMethodError e) {
            fail("NoSuchMethodError : " + e.getMessage());
        } catch (Exception e) {
            fail(" exception inattendue : " + e.getMessage());
        }
    }

    public void test_compare(){
        question3.Factory<Set> factTree1 = new TreeSetFactory<String>();
        question3.Factory<Set> factHash2 = new HashSetFactory<String>();
        question3.Factory<Set> factHash3 = new HashSetFactory<String>();
        Set<String> set = factTree1.create();
        factHash2.create();
        factHash3.create();
    }

}