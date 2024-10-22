import Objects.Config;
import Objects.CourseSystem;

public class App {
    public static void main(String[] args) throws Exception {

        Config con = new Config(5, false, 2);
        con = new Config(5, false, 2);
        CourseSystem studenSystem = new CourseSystem(con);
        Objects.Store studentStore = studenSystem.getContainer();

        CourseSystem CouseSystem = new CourseSystem(con);
        Objects.Store courseStore = CouseSystem.getContainer();

        CourseSystem registrationSystem = new CourseSystem(con);
        Objects.Store registrationStore = registrationSystem.getContainer();

        studentStore.Add();
        courseStore.Edit();
        registrationStore.Delete();
    }
}
