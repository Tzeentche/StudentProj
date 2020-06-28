public class StudentOrderValidator {

    public static void main(String[] args) {
        static void checkAll() {
            while(true) {
                StudentOrder so = readStudentOrder();
                System.out.println("Start");
                if (so == null) {
                    break;
                }

                System.out.println("Finish");

                AnswerCityRegister cityAnswer = checkCityRegister(so);
                if (!cityAnswer.success) {
                    //
                    continue;
                }

                AnswerWedding wedAnswer = checkWedding(so);
                AnswerChildren childrenAnswer = checkChildren(so);
                AnswerStudent studentAnswer = checkStudent(so);

                sendMail(so);
            }
            System.out.println("Finish 2");
        }

        static StudentOrder readStudentOrder() {
            StudentOrder so = new StudentOrder();
            return null;
        }

        static AnswerWedding checkWedding(StudentOrder so) {
            System.out.println("Wedding check is running");
            return new AnswerWedding();
        }

        static AnswerChildren checkChildren(StudentOrder so) {
            System.out.println("Children check is running");
            return new AnswerChildren();
        }

        static AnswerStudent checkStudent(StudentOrder so) {
            System.out.println("Student check is running");
            return new AnswerStudent();
        }

        static void sendMail(StudentOrder so) {
            System.out.println("Mail was sended.");
        }
    }
}
