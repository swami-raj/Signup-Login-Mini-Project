import java.util.Scanner;
import java.io.*;
public class loginsign {
    public static void main(String[] args) {
        boolean flag=true;
        Scanner sc=new Scanner(System.in);
        File f=new File("data.txt");
        try{
            if(f.createNewFile()){
                System.out.println("File is created: ");
            }
            else{
                System.out.println("File not created: ");
            }
        }
        catch(Exception e){
            System.out.println("Error"+e);
        }
        System.out.println("Press 1 for SignUp: ");
        System.out.println("Press 2 for SignIn: ");
        System.out.println("Press 3 for Exit: ");
        int key=sc.nextInt();
        switch (key){
            case 1:{
                System.out.println("Enter your Name: ");
                sc.nextLine();
                String s= sc.nextLine();
                System.out.println("Enter your Email: ");
                String s1= sc.next();
                System.out.println("Enter your password: ");
                String s2= sc.next();
                System.out.println("Re-enter your password: ");
                String s3=sc.next();
                if(s2.equals(s3)){
                    System.out.println("Account created Successfully ");
                }
                else{
                    System.out.println("Password not match");
                }
                try{
                    FileWriter fw=new FileWriter("data.txt",true);
                    fw.write(s +","+ s1+","+s2+","+s3+"\n");
                    fw.close();
                    System.out.println("Successfully data stored");

                }
                catch(Exception e){
                    System.out.println("Something error"+ e);
                }
                break;
            }
            case 2:{
                System.out.println("Enter your username: ");
                sc.nextLine();
                String p=sc.nextLine();
                System.out.println("Enter your Password: ");
                String p1=sc.next();
                try{
                    File fr=new File("data.txt");
                    Scanner src=new Scanner(fr);
                    while (src.hasNextLine()){
                        String line = src.nextLine();
                        String[] data = line.split(",");
                        if (  p.equals(data[0]) && p1.equals(data[2])) {
                            System.out.println("Loggin Successfully");
                            flag = true;
                            break;

                        }
                    }
                    if(flag==false){
                        System.out.println("Invalid User and Password");
                    }
                }
                catch(Exception e){
                    System.out.println("Something Error"+e);
                }
                break;
            }
            case 3:{
                System.out.println("Fuck you");
                break;
            }
            default:{
                System.out.println("Bhai kya kar raha hi");
                break;
            }
        }
    }
}
