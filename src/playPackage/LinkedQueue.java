package playPackage;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class LinkedQueue<E> implements Iterable<E> {
	private int N;               // number of elements on queue
	private Node<E> first;    // beginning of queue
	private Node<E> last;     // end of queue

	// helper linked list class
	private static class Node<E> {
		private E E;
		private Node<E> next;
	}

	/**
	 * Initializes an empty queue.
	 */
	public LinkedQueue() {
		first = null;
		last  = null;
		N = 0;
	}

	/**
	 * Is this queue empty?
	 * @return true if this queue is empty; false otherwise
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the number of Es in this queue.
	 * @return the number of Es in this queue
	 */
	public int size() {
		return N;     
	}

	/**
	 * Returns the E least recently added to this queue.
	 * @return the E least recently added to this queue
	 * @throws java.util.NoSuchElementException if this queue is empty
	 */
	public E peek() {
		if (isEmpty())
			return null;
		return first.E;
	}

	/**
	 * Adds the E to this queue.
	 * @param E the E to add
	 */
	public void enqueue(E E) {
		Node<E> oldlast = last;
		last = new Node<E>();
		last.E = E;
		last.next = null;
		if (isEmpty()) first = last;
		else           oldlast.next = last;
		N++;
	}

	/**
	 * Removes and returns the E on this queue that was least recently added.
	 * @return the E on this queue that was least recently added
	 * @throws java.util.NoSuchElementException if this queue is empty
	 */
	public E dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		E E = first.E;
		first = first.next;
		N--;
		if (isEmpty()) last = null;   // to avoid loitering
		return E;
	}

	/**
	 * Returns a string representation of this queue.
	 * @return the sequence of Es in FIFO order, separated by spaces
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (E E : this)
			s.append(E + " ");
		return s.toString();
	} 

	/**
	 * Returns an iterator that iterates over the Es in this queue in FIFO order.
	 * @return an iterator that iterates over the Es in this queue in FIFO order
	 */
	public Iterator<E> iterator()  {
		return new ListIterator<E>(first);  
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<E> implements Iterator<E> {
		private Node<E> current;

		public ListIterator(Node<E> first) {
			current = first;
		}

		public boolean hasNext()  { return current != null;                     }
		public void remove()      { throw new UnsupportedOperationException();  }

		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E E = current.E;
			current = current.next; 
			return E;
		}
	}

	}
