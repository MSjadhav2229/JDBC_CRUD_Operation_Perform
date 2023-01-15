import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("  Welcome to student management App");
		System.out.println("=====================================");
//		System.out.println("Thank you  for using my application" + "\n" + "See you soon ....bye...bye..." + "");
		System.out.println();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Press 1 for ADD STUDENT");
			System.out.println("Press 2 for DELETE STUDENT");
			System.out.println("Press 3 for DISPLAY STUDENT");
			System.out.println("Press 4 for Exit App");
			System.out.println();
			int c = Integer.parseInt(br.readLine());

			if (c == 1) {
//			TO ADD STUDENT
				System.out.println("Enter user Name    :-");
				String name = br.readLine();

				System.out.println("Enter user Phone  :-");
				String phone = br.readLine();

				System.out.println("Enter user City :-");
				String city = br.readLine();

				// create Student object to store object
				Student st = new Student(name, phone, city);

				boolean answer = StudentDao.insertStudentToDB(st);
				if (answer) {
					System.out.println("Student is added successfully..!!"+"\n");
				} else {
					System.out.println("somthing went wrong"+"\n");
				}
//				System.out.println(st);

			}

			else if (c == 2) {
//			 TO DELETE STUDENT
				System.out.println("Enter student to delete id:-");
				int userID = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userID);
				if (f) {
					System.out.println("Deleted.........!"+"\n");
				} else {
					System.out.println("something wnet wrong......"+"\n");
				}
			} else if (c == 3) {
//			TO DISPLAY STUDENT
				StudentDao.showAllStudent();
			}

			else if (c == 4) {
//			EXIT FROM APP

				break;
			} else {

			}
			System.out.println("\n"+"Thank you  for using my application" + "\n" + "See you soon ....bye...bye..." +"\n" +"\n" +"\n");
		}

	}
}
