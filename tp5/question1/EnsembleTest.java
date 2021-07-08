package question1;

public class EnsembleTest extends junit.framework.TestCase {

    public void testUnion() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.union(e2);
        assertEquals(3, union.size());
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }
    

    public void testAddTest()
    {
        question1.Ensemble ensemble1 = new question1.Ensemble();
        question1.Ensemble ensemble2 = new question1.Ensemble();
        assertEquals(true, ensemble1.add(2));
        assertEquals(true, ensemble1.add(3));
        assertEquals(true, ensemble1.add(4));
        assertEquals(true, ensemble2.add(3));
        assertEquals(true, ensemble2.add(4));
        assertEquals(true, ensemble2.add(5));
        assertEquals(false, ensemble1.add(2));
        assertEquals(true, ensemble1.contains(2));
        assertEquals(false, ensemble2.contains(1));
    }

    public void testInter()
    {
        question1.Ensemble ensemble1 = new question1.Ensemble();
        question1.Ensemble ensemble2 = new question1.Ensemble();
        assertEquals(true, ensemble1.add(2));
        assertEquals(true, ensemble1.add(3));
        assertEquals(true, ensemble2.add(3));
        assertEquals(true, ensemble2.add(4));
        assertEquals(true, ensemble2.add(5));
        question1.Ensemble<Integer> inter = ensemble1.inter(ensemble2);
        assertEquals(1, inter.size());
        assertFalse(inter.contains(2));
        assertTrue(inter.contains(3));
        assertFalse(inter.contains(4));
    }
    
    public void testDiff() 
    {
        question1.Ensemble ensemble1 = new question1.Ensemble();
        question1.Ensemble ensemble2 = new question1.Ensemble();
        ensemble1 = new question1.Ensemble();
        assertEquals(true, ensemble1.add(2));
        assertEquals(true, ensemble1.add(3));
        assertEquals(true, ensemble1.add(5));
        assertEquals(true, ensemble2.add(3));
        assertEquals(true, ensemble2.add(4));
        question1.Ensemble<Integer> diff = ensemble1.diff(ensemble2);
        assertEquals(2, diff.size());
        assertTrue(diff.contains(2));
        assertFalse(diff.contains(3));
        assertFalse(diff.contains(4));
        assertTrue(diff.contains(5));
    }
    
    public void testDiffSym() 
    {
        question1.Ensemble ensemble1 = new question1.Ensemble();
        question1.Ensemble ensemble2 = new question1.Ensemble();
        assertEquals(true, ensemble1.add(2));
        assertEquals(true, ensemble1.add(3));
        assertEquals(true, ensemble2.add(3));
        assertEquals(true, ensemble2.add(4));
        question1.Ensemble<Integer> diffSym = ensemble1.diffSym(ensemble2);
        assertEquals(2, diffSym.size());
        assertTrue(diffSym.contains(2));
        assertFalse(diffSym.contains(3));
        assertTrue(diffSym.contains(4));
    }
}


