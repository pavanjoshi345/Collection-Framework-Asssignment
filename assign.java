package Collection;
import java.util.*;
class Student implements Comparable
{
	int id;
	String name;
	int marks;
	public Student()
	{
		
	}
	public Student(int id,String name, int marks)
	{
		this.id=id;
		this.name=name;
		this.marks=marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public int compareTo(Object o) 
	{
	    Student s1=(Student)o;
	    if(this.getMarks()<s1.getMarks())
	    {
	    	return 1;
	    }
	    else if(this.getMarks()>s1.getMarks())
	    {
	    	return -1;
	    }
	    else
	    {
	    	return 0;
	    }
		
	}
	
}
public class Basic_AssignmentApplication 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int choice;
		Vector<Student> v=new Vector<Student>();
		Student s=new Student();
		do
		{
		   System.out.println("Enter the your choice");
		   System.out.println("1: Add New Student");
		   System.out.println("2: View All Students");
		   System.out.println("3: Update Student Using Name");
		   System.out.println("4: Delete Student Using Name");
		   System.out.println("5: Find Second Topper");
		   System.out.println("6: Sort In Desc Using marks");
		   System.out.println("7: Exit");
		   choice=sc.nextInt();
		   switch(choice)
		   {
		   case 1:
			     System.out.println("Enter the id, name and marks of student");
			     int id=sc.nextInt();
			     String name=sc.next();
			     int marks=sc.nextInt();
			     v.add(new Student(id,name,marks));
			     System.out.println("Student Added Successfully !!!");
			     break;
		   case 2:
			    System.out.println("=========================================");
			    System.out.println("ID \t\t NAME \t\t Marks");
			    for(Object obj:v)
			    {
			    	Student st=(Student)obj;
			    	System.out.println(st.getId()+"\t\t"+st.getName()+"\t\t"+st.getMarks());
			    }
			    System.out.println("=========================================");
			    break;
		
		   case 3:
			   System.out.println("Enter the old Id and new ID of student");
			   int oid=id=sc.nextInt();
			   int nid=sc.nextInt();
			   int flag=0,index=-1;
			   for(Object obj:v)
			    {
			    	Student st=(Student)obj;
			    	if(st.getId()==oid)
			    	{
			    		flag=1;
			    		index++;
			    	}
			    }
			    if(flag==1)
			    {
			       try
			       {
			    	   Object up=v.get(nid);
				    	v.add(index,(Student)up);
				    	System.out.println("Data Update Successfully...");
			       }
			       catch(Exception exp)
			       {
			    	   System.out.println("Exception is:"+exp);
			       }
			    	
			    }
			    else
			    {
			    	System.out.println("ID NOT FOUND...");
			    }
			  break;
		   case 4:
			   System.out.println("Enter the Student ID");
			   int did=sc.nextInt();
			    flag=0;
			   Enumeration<Student> enn=v.elements();
			   while(enn.hasMoreElements())
			   {
				  Object obj=enn.nextElement();
				  Student std=(Student)obj;
				  if(std.getId()==did);
				  {
					  v.removeElement(std.getId());
					  flag=1;
					  break;
				  }
			   }
			   if(flag==1)
			   {
				    v.remove(did-1);
				    System.out.println("Data Remove Successfully....");
			   }
			   else
			   {
				   System.out.println("Student Name not found...");
			   }
			   break;
		   case 5:
			   Collections.sort(v);
			   System.out.println("Second Toper Student is:");
			   for(int i=0; i<v.size(); i++)
			   {
				   for(int j=i+1; j<v.size(); j++)
				   {
					    Student abc=v.get(i);
					    Student bb=v.get(j);
					    if(abc.getMarks()==bb.getMarks())
					    {
					    	i++;
					    }
					    else
					    {
					    	System.out.println(bb.getId()+"\t\t"+bb.getName()+"\t\t"+bb.getMarks());
					    	break;
					    }
				   }
			   }
			   break;
			   
		   case 6:
			   Collections.sort(v);
			   System.out.println("Show Students Marks Wise:");
			   for(Student st:v)
			   {
				   System.out.println(st.getId()+"\t\t"+st.getName()+st.getMarks());
			   }
			   break;
		   case 7:
			   System.out.println("!!!YOU ARE EXITED FROM THIS APPLICATIOIN!!!");
		       System.exit(0);
		   }
		   
		}while(true);
	}
}
