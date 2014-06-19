

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author alejandro.del.amo.gonzalez
 */

import java.util.Comparator;



public class NodeComparador implements Comparator<Node>
{
    @Override
    public int compare(Node x, Node y)
    {
        // Compara los costes de los nodos y devuelve un valor 
        // indicando si es mayor,menor o igual
        if (x.cost < y.cost)
        {
            return -1;
        }
        if (x.cost > y.cost)
        {
            return 1;
        }
        return 0;
    }
}
