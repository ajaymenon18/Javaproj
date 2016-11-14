import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;


class Faculty{
    public:               /*Faculty class which manipulates the question paper,answers and has special prev*/
    Scanner s=new Scanner(System.in);
    String name;
    String passid;
    static int oneword=0;
    static int multiplechoice=0;
    public:
     Faculty()
      {
      
      }
     Faculty(String name,String passid)
       {
           this.name=name;
           this.passid=passid;
       }

     
    void addrecord(){}  /* Adding the records to the file*/
                         
    void delrecord() {} /* deleting records to a file */
 
    void settime(){} /* changing the time limit.I think this is optional */

    void change(){
      System.out.println("Enter 0 to edit one word mark or 1 to edit multiple choice questions or 2 to edit both);
      int p=s.nextInt();

          if(p==0){
                 System.out.println("Editing the one mark valuation");
                 oneword=s.nextInt();}

          else if(p==1){
                 System.out.println("Editing the multiple choice valuation");
                 multiplechoice=s.nextInt();}

          else if(p==2){
                  System.out.println("Editing both the multiple choice valuation and one mark valuation");
                  multiplechoice=s.nextInt();}} 
   }  
 
                        

class Student extends Faculty{              /*Here we need the static variables oneword and multiplechoice to calculate marks */
  String name;
  String pass;                             /*Care should be used while trying to convert it to alphanumeric*/
  int marks;
  Scanner s=new Scanner(System.in);
  BufferedReader a=new BufferedReader(new InputStreamReader(System.in));
  public:
  Student(){
     marks=0;}

  Student(String name,String pass){
     this.name=name;
     this.pass=pass;}

  void takeonewordtest(){                     /* The student class conducts the test 1st one takeonewordtest */
     BufferedReader r=new BufferedReader(new FileReader("oneword.txt"));
     System.out.println("The test is going to begin now")
     System.out.println();                   /*The awarded points are the static objects in faculty class We need to fix the inheritence */
     System.out.println("The questions are single word answers if you get right then you will be awarded points If wrong then 0");
     System.out.println();
     String line1;
     String line2;
     int x=1;
      while(EOF!=true)     /*Looping condition not checked*/
       {
          line=r.readLine();  /*The variable line has the question from the key*/
          line2=r.readLine(); /*The variable line2 has the answer for the question.Note maintain the oneword.txt in that way */
          System.out.println("Question"+x);
          System.out.println(line);
          String ans=a.readLine(); /* User inputs the answer */
          if(ans.equals(line2)){
              System.out.println("Correct Answer");   /*Condition to check the answer*/
              marks=marks+oneword;}            /*The total mark of each student is incremented based on the test */
          else(){
               System.out.println("Wrong answer");
               marks=marks+0;}       /*If wrong no marks are deduced the marks remain the same */
               x++; }}
   
    void takemultiplechoice(){    /*The Multiple Choice test*/
         BufferedReader br=new BufferedReader(new FileReader("multchoice.txt"));
    
         System.out.println("The Test begins now");
         System.out.println("The Questions are multiple choice correct one will be awarded points and wrong ones will get zero");
         String line6;
         String line7;
         int x=1;
           while(EOF!=true){
            System.out.println("Question +x");
              for(int i=0;i<5;i++){
                 line7=br.readLine();
                 System.out.println(line7);}  
             String s1=br.readLine();
               line7=br.readLine();

              if(s1.equals(line7)){
                  System.out.println("The correct answer");
                   marks=marks+multiplechoice;}
              else{
                    System.out.println("The wrong answer");
                     marks=marks+0;}
            }

void Markfinal(){
          System.out.println("The mark of student"+name+"is"+marks); /*Displaying the Final Marks*/
     }
  }


class Project{ /*The class which has the main method */

  public static void main(String[]args)throws IOException
  {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     BufferedReader br2=new BufferedReader(new FileReader("Document.txt"));    /*Seperate Document for faculty and Students should be maintained*/
     BufferedReader br3=new BufferedReader(new FileReader("DocFaculty.txt"));  /*For confidentiality*/
     String line; 
     String ans;
     while(1)                       /*Check the while condition and the braces */
     {
       Scanner s =new Scanner(System.in);
     System.out.println("Enter whether you are a faculty or a staff");
     System.out.println("P.S Please dont lie if lie is caught you are SUSPENDED");
     String s=br.readLine(); /*Inputs whether the test taker is faculty or student */
     if(s.equals("Faculty")||s.equals("faculty")){
         System.out.println("Enter the username");
         String s2=br.readLine();                    /*Error condition unique userid and password should be maintained */
         System.out.println("Enter the password");
         String s3=br.readLine();
         String line4;
         int flag=0;
         
         while((line4=br3.readLine())!=null){     /*The username and password are compared with all the entries in the faculty file*/
               String[] element=line4.split(",");
               if((element[0].equals(s2))&&(element[1].equals(s3)))
                 {
                    flag=1;
                     break;
                } }
             
    if((flag==1)){                   /*If found then faculty can manipulate  data */ 
         Faculty f1=new Faculty(s2,s3);
         System.out.println("Does the Faculty want to");
         System.out.println("a.Add an entry in student record");  /*Functions need to be made and added*/
         System.out.println("b.Delete an entry in student record");
         System.out.println("c.Change the marking scheme");
         System.out.println("d.Change the timelimit");
         char ch=s.nextChar();
         switch(ch)
           {
             case 'a':f1.addrecord();
                      break;
             case 'b':f1.delrecord();
                      break;
             case 'c':f1.change();
                      break;
             case 'd':f1.settime();
                      break;
             default: break;
             }
      }
    else
      {                                                /*If the test condition fails code assumes that student as faculty tried to login*/
         System.out.println("Login failed");
         System.out.println("Meet the principal");
         break;
    }
   }
}
     else if(s.equals("Student")||s.equals("students")) /*The student login condition*/
       {    
 
         System.out.println("Enter the username");
         String s=br.readLine();
         System.out.println("Enter the password");
         String f=br.readLine(i);
         String line;

         int flag1=0;
     while((line=br2.readLine())!=null)
        {
            String[]element=line.split(",");
            if((element[0].equals(s))&&(element[1].equals(f)))
              {
                  flag1=1;
                  break;
             }
        
        }
    if(flag1==1)
     {
        System.out.println("Login sucess");
        Student s1=new Student(s,f);           /*whenever a student login is sucess the student object is created and it is added to the arraylist for manipulation */
        s1.takeonewordtest();
        s1.takemultest();
        System.out.println("The Test is over");
        System.out.println("The Student"+s1.name+"Got mark"+s1.mark;
      }
    else
      {
         System.out.println("Login failed");
         break;                                 
    }
   }
   }
   
/*  Iterator ar=als.iterator();
  while(ar.hasNext())
   {
      Student s1=ar.next();   /*From the arraylist each object/student is taken they undergo both the test and again is stored in an arrayList P.S Not necessary
      s1.takeonewordtest();
      s1.takemulttest();
      als1.add(s1);
   }
  System.out.println("The Test Results are"); /*The results of each student along with there login name is printed
   Iterator ar2=als1.iterator();
   while(ar2.hasNext())                  /*There should be paranthesis error
    {
      Student s2=ar2.hasNext();
      System.out.println("The Student"+s2.name+"Got the mark"+s2.mark);
  
}
*/
}
}/*I have not fully compiled it since its missing a lot of functions and dependencies.One package concept is not implemented as i think it is not needed 2.On entering the password it should have The text encrypted.You can get the code from vinay.Sorry for not staying back for not doing the project will finish this up tomorrow after I come there :)
