public class StudentManager extends UserManager{

    void addStudent(User user){
        System.out.println(user.getName()+" "+user.getSurname()+" ogrenci olarak eklendi");
    }

}
