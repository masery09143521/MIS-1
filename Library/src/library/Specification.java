package library;

public interface Specification<T> {
	
	public boolean IsSatisfiedBy(T entity);
}
