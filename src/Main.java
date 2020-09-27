import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Operations operation=new Operations();
        operation.connectWithDB();
         //   operation.select();
           insertCredentials(operation);
        operation.select();
        //     deleteUser(operation);
        //  updatePassword(operation);
    }

    public static void updatePassword(Operations operation){
        System.out.print ("Enter username you want to update : ");
        Scanner input=new Scanner(System.in);
        String user=input.nextLine();
        System.out.print ("ENTER new password: ");
        String newPass=input.nextLine();

        operation.update(newPass,user);
    }

    public static void deleteUser(Operations operation){
        System.out.print ("Enter user you want to delete : ");
        Scanner input=new Scanner(System.in);
        String user=input.nextLine();
        operation.delete(user);
    }

    public static void insertCredentials(Operations operation){
        Scanner input=new Scanner(System.in);
        System.out.print("enter username:    ");
        String user=input.nextLine();
        System.out.println("enter password:    ");
        String pass=input.nextLine();

        operation.insert(user,pass);
    }
}
