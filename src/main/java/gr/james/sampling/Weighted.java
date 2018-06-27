package gr.james.sampling;

/**
 * Represents an item with a weight.
 * <p>
 * This class is immutable and is meant for use in weighted random sampling algorithms.
 *
 * @param <T> the object type
 * @author Giorgos Stamatelatos
 */
class Weighted<T> implements Comparable<Weighted<T>> {
    /**
     * The object associated with this instance.
     */
    public final T object;

    /**
     * The weight associated with the {@link #object}.
     */
    public final double weight;

    /**
     * Construct a new {@link Weighted} from a given object and weight.
     * <p>
     * For performance reasons, no checks are performed on the inputs.
     *
     * @param object the object
     * @param weight the weight of the object
     */
    public Weighted(T object, double weight) {
        this.object = object;
        this.weight = weight;
    }

    /**
     * Compares this object with the specified object for order. Returns a negative integer, zero, or a positive integer
     * as this object is less than, equal to, or greater than the specified object.
     * <p>
     * The comparison is based on the {@link #weight} values of the two {@link Weighted} objects. If the weights are of
     * the same value, the comparison is based on {@link System#identityHashCode(Object)}. This means that
     * {@code a.equals(b)} will evaluate to {@code 0} if and only if {@code a == b}.
     *
     * @param o the object to be compared
     * @return a negative integer, zero, or a positive integer as the object is less than, equal to, or greater than the
     * specified object
     * @throws NullPointerException if {@code o} is {@code null}
     */
    @Override
    public int compareTo(Weighted<T> o) {
        final int c = Double.compare(weight, o.weight);
        if (c == 0) {
            assert (Integer.compare(System.identityHashCode(this), System.identityHashCode(o)) == 0) == (this.equals(o));
            return Integer.compare(System.identityHashCode(this), System.identityHashCode(o));
        } else {
            assert !this.equals(o);
            return c;
        }
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The implementation delegates to an invocation of {@link Object#equals(Object)}.
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this object is the same as the {@code obj} argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        assert !super.equals(obj) || super.hashCode() == obj.hashCode();
        return super.equals(obj);
    }

    /**
     * Returns a hash code value for the object.
     * <p>
     * The implementation delegates to an invocation of {@link Object#hashCode()}.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Returns a string representation of this object.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        return String.format("{%s, %f}", object, weight);
    }
}
