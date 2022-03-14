package shanker.assignment.data;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

    public static void main(String args[]) {
        //create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();


        try {


            //Start the transaction
            session.beginTransaction();


            //get instructor details object:
            int theId = 3;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theId);

            //print the instructor details :
            System.out.println(tempInstructorDetail.toString());


            //print the associated instructor.
            System.out.println(tempInstructorDetail.getInstructor().toString());

            //delete Instructor Detail:
            tempInstructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(tempInstructorDetail);


            //commit the transaction
            session.getTransaction().commit();



        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }

}
