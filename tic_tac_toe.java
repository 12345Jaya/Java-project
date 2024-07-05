import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException; //java.lang is a default package
public class tic_tac_toe {
	public static boolean check_if(Object[][] mat, char user) {
		for(int i=0;i<mat.length;i++) {
			if(mat[i][0]==(Object)user && mat[i][1]==(Object)user && mat[i][2]==(Object)user)
				return true;
			else if(mat[0][i]==(Object)user && mat[1][i]==(Object)user && mat[2][i]==(Object)user)
				return true;
		}
		if(mat[0][0]==(Object)user && mat[1][1]==(Object)user && mat[2][2]==(Object)user)
			return true;
		else if(mat[0][2]==(Object)user && mat[1][1]==(Object)user && mat[2][0]==(Object)user)
			return true;
		return false;
	}
	public static void print_mat(Object[][] mat) {
		for(int i=0;i<3;i++) {
        	for(int j=0;j<3;j++) {
        		System.out.print(mat[i][j]);
        		if(j!=2)System.out.print("|");
        	}
        	if(i!=2)System.out.println("\n- - - ");
        }
	}
	public static int enter_input(Object[][] mat,char user) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.print("\n\nEnter the row : ");
			int i=sc.nextInt();
			System.out.print("Enter the column : ");
			int j=sc.nextInt();
			System.out.println();
			if(mat[i-1][j-1]==" ") {
				mat[i-1][j-1]=user;
				return 1;
			}
			else{
				System.out.println("Already it's filled\n");
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Enter an integer\n\n");
		}
		catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("Row and Column must be in the range 1 to 3\n\n");
		}
		return 0;
	}
	public static void main(String[] args) {
        Object[][] mat=new Object[3][3];
        for(int i=0;i<3;i++) {
        	Arrays.fill(mat[i], " ");
        }
        print_mat(mat);
        char user='X';
        int chance=0;
        boolean b;
        while(chance!=9) {
			int m=enter_input(mat,user);
			if(m==0){
			   print_mat(mat);
			   user=(user=='X')?'O':'X';
			}
			else{
				chance+=m;
				b=check_if(mat,user);
				print_mat(mat);
				if(b==true) {
					System.out.println("\n\n"+user+" wins !");
					System.exit(0);
				}
			}
			user=(user=='X')?'O':'X';
        }
        System.out.println("\n\nIt's a draw !");
        /*
        while(chance!=9) {
        	if(chance%2==0) {
		        chance+=enter_input(mat,'O');
		        b=check_if(mat,'O');
		        print_mat(mat);
        	}
        	else {
        		chance+=enter_input(mat,'X');
		        print_mat(mat);
        	}
        }  
        */
	}
}