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

        static AnswerCityRegister checkCityRegister(StudentOrder so) {
            return CityRegisterValidator.checkCityRegister(so);
        }

        static AnswerWedding checkWedding(StudentOrder so) {
            return WeddingValidator.checkWedding(so);
        }

        static AnswerChildren checkChildren(StudentOrder so) {
            return ChildrenValidator.checkChildren(so);
        }

        static AnswerStudent checkStudent(StudentOrder so) {
            return StudentValidator.checkStudent(so);
        }

        static void sendMail(StudentOrder so) {
            System.out.println("Mail was sended.");
        }
    }
}
