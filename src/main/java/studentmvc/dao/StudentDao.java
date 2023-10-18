package studentmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import studentmvc.dto.Student;

@Repository
public class StudentDao {
    @Autowired
	private EntityManager entityManager;
    
    public Student saveStudent(Student student) {
    	EntityTransaction entityTransaction=entityManager.getTransaction();
    	entityTransaction.begin();
    	entityManager.persist(student);
    	entityTransaction.commit();
    	return student;
    }

	public List<Student> getAllStudents() {
		Query query=entityManager.createQuery("Select s from Student s");
		return query.getResultList();
	}

	public void deleteStudent(int id) {
		Student student=entityManager.find(Student.class, id);
		EntityTransaction entityTransaction=entityManager.getTransaction();
    	entityTransaction.begin();
    	entityManager.remove(student);
    	entityTransaction.commit();
		
	}

	public Student findStudent(int id) {
		Student student=entityManager.find(Student.class, id);
		return student;
	}

	public void updateStudent(Student student) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();	
	}
	
	
	
	
	
	
	
	
	
	
	
}
