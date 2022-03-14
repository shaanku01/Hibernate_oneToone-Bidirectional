package shanker.assignment.data;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String args[]) {
        //create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();


        try {

            Session session = factory.getCurrentSession();

            //Start the transaction
            session.beginTransaction();

            //get instructor by primary key

            int id  = 1;
            Instructor tempInstructor = session.get(Instructor.class,id);


            //delete the instructor
            if(tempInstructor!=null){
                System.out.println("deleting the object");
                session.delete(tempInstructor);
            }



            //commit the transaction
            session.getTransaction().commit();



        } finally {
            factory.close();
        }
    }

}
