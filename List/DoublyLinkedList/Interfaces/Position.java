package Interfaces;

/*
 * Interface that enables values to be extracted from
 * specified indexes.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

public interface Position<E> {
    //Returns the element stored at this position.
    E getElement();
}
