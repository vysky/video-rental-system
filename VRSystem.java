import VRS.*;
import java.util.*;

public class VRSystem
{
   public static void main(String[] args)
   {
      Scanner input = new Scanner(System.in);
      int option;
   
      ArrayList videoList = new ArrayList();
      ArrayList memberList = new ArrayList();
      ArrayList allRentalList = new ArrayList();
      LinkedList ll = new LinkedList();
   
      initialisation(videoList, memberList, allRentalList);
   
      do
      {
         menu();
         option = input.nextInt();
         System.out.println();
      
         switch ( option )
         {
            case 1	:	option1(memberList);															//List all member
                        System.out.println();
                        break;
            case 2	:	option2(videoList);															//List all video
                        System.out.println();
                        break;
            case 3	:	option3(videoList, memberList, allRentalList);						//Rent video
                        System.out.println();
                        break;
            case 4	:	option4(allRentalList);														//Display the borrower of a video
                        System.out.println();
                        break;
            case 5	:	option5(allRentalList);														//List all videos rented out
                        System.out.println();
                        break;
            case 6	:	option6(allRentalList);														//Return a video
                        System.out.println();
                        break;
            case 7	:	option7(allRentalList);
                        System.out.println();
                        break;
            case 8	:	option8(videoList, allRentalList);
                        System.out.println();
                        break;
            case 0	:	System.out.println("Exit Program");
                        break;
            default	:	System.out.println("Invalid input, please enter a number between 0 - 8.");
         }
      }	while( option != 0 );
   }

   public static void menu()
   {
      System.out.print(	"MENU"                                            + "\n" +
                        "===="                                            + "\n" +
                        "1. List all members"                             + "\n" +
                        "2. List all videos"                              + "\n" +
                        "3. Rent video"                                   + "\n" +
                        "4. Display the borrower of a video"              + "\n" +
                        "5. List videos being rented out"                 + "\n" +
                        "6. Return a video"                               + "\n" +
                        "7. Display videos overdue and the fine incurred" + "\n" +
                        "8. Search for a video"                           + "\n" +
                        "0. Exit"                                         + "\n" +
                        "Enter your option : ");
   }

   public static void initialisation(ArrayList videoList, ArrayList memberList, ArrayList allRentalList)
   {
      Movie vm = null;
      vm = new Movie(10001, "Finding Nemo", true, 120);		videoList.add(vm);
      vm = new Movie(10002, "Spiderman 3", true, 100);		videoList.add(vm);
      vm = new Movie(10003, "Indianna Jones", true, 125);	videoList.add(vm);
   
      Drama d = null;
      d = new Drama(20001, "Little Nyonya", true, 7);			videoList.add(d);
      d = new Drama(20002, "Point Of Entry", true, 5);		videoList.add(d);
      d = new Drama(20003, "Phua Chu Kang", true, 8);			videoList.add(d);
   
      Member m = null;
      m = new Member(1111, "John", "88225005");					memberList.add(m);
      m = new Member(1113, "Mary", "82222222");					memberList.add(m);
      m = new Member(1116, "Anna", "83333333");					memberList.add(m);
   
      Rental r = null;
   }

   public static void option1(ArrayList memberList)
   {
      int i;
      
      Member m = null;
   
      if ( memberList.size() > 0 )
      {
         System.out.println("S/No\tID\tName\tTel");
         
         for ( i = 0; i < memberList.size(); i++ )
         {
            m = (Member)memberList.get(i);
            System.out.println( ( i + 1 ) + "\t" + m.getID() + "\t" + m.getName() + "\t" +  m.getTel() );
         }
      }
      else
      {
         System.out.println("No member found");
      }
   }

   public static void option2(ArrayList videoList)
   {
      int i;
      
      Video v = null;
   
      if ( videoList.size() > 0 )
      {
         System.out.println("S/No\tCode\tTitle\t\tAmount($)\tRemark");
         
         for ( i = 0; i < videoList.size(); i++ )
         {
            v = (Video)videoList.get(i);
            System.out.print( ( i + 1 ) + "\t" + v.getCode() + "\t" + v.getTitle() + "\t" + v.calculateAmount() + "\t\t");
         
            if ( v.getAvailable() == true )
            {
               System.out.println("Available");
            }
            else
            {
               System.out.println("Not Available");
            }
         }
      }
      else
      {
         System.out.println("No video found");
      }
   }
   
   public static void option3(ArrayList videoList, ArrayList memberList, ArrayList allRentalList)
   {
      Scanner input = new Scanner(System.in);
      int memberNo, videoNo, year = 0, month = 0, day = 0;
      boolean validateMember = false, validateVideo = false, validateAvailable = false;
      boolean validateYear = false, validateMonth = false, validateDay = false;
   
      Member m = null;
      Video v = null;
      Rental r = null;
   
      if ( memberList.size() > 0 && videoList.size() > 0 )
      {
         do
         {
            option1(memberList);
            System.out.print("Select member : ");
            memberNo = input.nextInt();
         
            if ( ( memberNo > 0 ) && ( memberNo <= memberList.size() ) )
            {
               m = (Member)memberList.get(memberNo - 1);
            
               validateMember = true;
            }
            else
            {
               System.out.println("Invalid input, please enter a correct number. ( 1 - " + memberList.size() + " )" );
               System.out.println();
            }
         }	while ( validateMember == false );
         
         do
         {
            option2(videoList);
            System.out.print("Select video : ");
            videoNo = input.nextInt();
               
            if ( ( videoNo > 0 ) && ( videoNo <= videoList.size() ) )
            {
               v = (Video)videoList.get(videoNo - 1);
                  
               if ( v.getAvailable() == true )
               {
                  validateAvailable = true;
               }
               else
               {
                  System.out.println("This video is not available, please choose another one.");
                  System.out.println();
               }
               
               validateVideo = true;
            }
            else
            {
               System.out.println("Invalid input, please enter a corect number. ( 1 - " + videoList.size() + " )" );
               System.out.println();
            }
         }	while ( ( validateAvailable == false ) || ( validateVideo == false ) );
         
         if ( validateAvailable == true )
         {
            do
            {
               System.out.print("Enter year  : ");
               year = input.nextInt();
               
               if ( year > 0 && year <= 9999 )
               {
                  validateYear = true;
               }
               else
               {
                  System.out.println("Please enter a number 0 - 9999.");
                  System.out.println();
               }
            }	while ( validateYear == false );
            
            do
            {
               System.out.print("Enter month : ");
               month = input.nextInt();
               
               if ( month > 0 && month <= 12 )
               {
                  validateMonth = true;
               }
               else
               {
                  System.out.println("Please enter a number from 1 - 12.");
                  System.out.println();
               }
            }	while ( validateMonth == false );
            
            do
            {
               System.out.print("Enter day   : ");
               day = input.nextInt();
               
               if ( day > 0 && day <= 31 )
               {
                  GregorianCalendar gc = new GregorianCalendar(year, ( month -1 ) , day);
                  
                  r = new Rental(m, v, gc);
                  m.getRentalList().add(r);
                  allRentalList.add(r);
                  
                  System.out.println("The rental has been processed successfully.");
                  
                  v.setAvailable(false);
                  validateDay = true;
               }
               else
               {
                  System.out.println("Please enter a number from 1 - 31.");
               }
            }	while ( validateDay == false );
         }
      }
      else
      {
         if ( memberList.size() < 1 && videoList.size() < 1 )
         {
            System.out.println("No member and video are found, cannot rent video.");
         }
         else
         {
            if ( memberList.size() < 1 )
            {
               System.out.println("No member found, cannot rent video.");
            }
         
            if ( videoList.size() < 1 )
            {
               System.out.println("No video found, cannot rent video.");
            }
         }
      }
   }
   
   public static void option4(ArrayList allRentalList)
   {
      Scanner input = new Scanner(System.in);
      int i, code, available = 0, notAvailable = 0;
      String date;
      boolean validateCode = true;
   
      Video v = null;
      Rental r = null;
      Calendar c = null;
   
      if ( allRentalList.size() > 0 )
      {
         do
         {
            System.out.print("Enter video code : ");
            code = input.nextInt();
         
            for ( i = 0; i < allRentalList.size(); i++ )
            {
               r = (Rental)allRentalList.get(i);
               c = (Calendar)r.getLoanDate();
            
               if ( r.getVideo().getCode() == code )
               {
                  date = c.get(Calendar.DATE) + "/" + ( c.get(Calendar.MONTH) + 1 ) + "/" + c.get(Calendar.YEAR);
                  System.out.println("Video Title : " + r.getVideo().getTitle() );
                  System.out.println("Borrower    : " + r.getBorrower().getName() );
                  System.out.println("Tel         : " + r.getBorrower().getTel() );
                  System.out.println("Loan Date   : " + date );
               
                  validateCode = false;
               }
            }
         
            if ( validateCode == true )
            {
               System.out.println("Invalid video code, please enter a correct code");
               System.out.println();
            }
         } while ( validateCode );
      }
      else
      {
         System.out.println("No rental found, all video(s) are available for rent.");
      }
   }

   public static void option5(ArrayList allRentalList)
   {
      int i;
      String date;
      
      Video v = null;
      Rental r = null;
      Calendar c = null;
   
      if ( allRentalList.size() > 0 )
      {
         System.out.println("S/No\tRental Number\tCode\tTite\t\tBorrower\tLoan Date");
         
         for ( i = 0; i < allRentalList.size(); i++ )
         {
            r = (Rental)allRentalList.get(i);
            v = (Video)r.getVideo();
            c = (Calendar)r.getLoanDate();
            date = c.get(Calendar.DATE) + "/" + ( c.get(Calendar.MONTH) + 1 ) + "/" + c.get(Calendar.YEAR);
            System.out.println( ( i + 1 ) + "\t" + r.getRentalNo()+ "\t\t" + v.getCode() + "\t"  + v.getTitle() + "\t" + r.getBorrower().getName() + "\t\t" + date);
         }
      }
      else
      {
         System.out.println("No rental found, all video(s) are available for rent.");
      }
   }

   public static void option6(ArrayList allRentalList)
   {
      Scanner input = new Scanner(System.in);
      int i, code, fine, totalDayRent, totalDayNow, dayDifference, year, month, day;
      boolean validateCode = false, returned = false;
   
      Member m = null;
      Video v = null;
      Rental r = null;
      Calendar c = null;
   
      if ( allRentalList.size() > 0 )
      {
         do
         {
            System.out.print("Enter video code : ");
            code = input.nextInt();
         
            for ( i = 0; i < allRentalList.size(); i++ )
            {
               r = (Rental)allRentalList.get(i);
            
               if ( r.getVideo().getCode() == code )
               {
                  m = (Member)r.getBorrower();
                  v = (Video)r.getVideo();
                  c = (Calendar)r.getLoanDate();
                  
                  year = c.get(Calendar.YEAR);
                  month = ( c.get(Calendar.MONTH) + 1 );
                  day = c.get(Calendar.DAY_OF_MONTH);
                  totalDayRent = day + ( ( month - 1 ) * 31 ) + ( ( year - 1 ) * 372 );
                  
                  c = Calendar.getInstance();
                  year = c.get(Calendar.YEAR);
                  month = ( c.get(Calendar.MONTH) + 1 );
                  day = c.get(Calendar.DAY_OF_MONTH);
                  totalDayNow = day + ( ( month - 1 ) * 31 ) + ( ( year - 1 ) * 372 );
               
                  dayDifference = totalDayNow - totalDayRent;
                  dayDifference++;
                  
                  System.out.println("Title    : " + v.getTitle() );
                  System.out.println("Borrower : " + m.getName() );
                  
                  if ( v instanceof Movie )
                  {
                     if( dayDifference > 3 )
                     {
                        fine = ( dayDifference - 3 ) * 2;
                        System.out.println("Overdue  : By " + ( dayDifference - 3 ) + " day(s)");
                        System.out.println("Fine     : $" + fine);
                        System.out.println("Movie return successfully.");
                        returned = true;
                     }
                     else
                     {
                        System.out.println("Movie return successfully, it is not overdue.");
                        returned = true;
                     }
                  }
                  else
                  if ( v instanceof Drama )
                  {
                     if ( dayDifference > 7 )
                     {
                        fine = ( dayDifference - 7 ) * 3;
                        System.out.println("Overdue  : By " + ( dayDifference - 7 ) + "day(s)");
                        System.out.println("Fine     : $" + fine);
                        System.out.println("Drama return successfully.");
                        returned = true;
                     }
                     else
                     {
                        System.out.println("Drama return successfully, it is not overdue.");
                        returned = true;
                     }
                  }
                  
                  if ( returned == true )
                  {
                     v.setAvailable(true);
                     allRentalList.remove(i);
                     
                     ArrayList rentalList = m.getRentalList();
                     
                     for ( i = 0; i < rentalList.size(); i++ )
                     {
                        r = (Rental)rentalList.get(i);
                        
                        if ( r.getVideo().getCode() == code )
                        {
                           rentalList.remove(i);
                        }
                     }
                  }
                  
                  validateCode = true;
               }
            }
            
            if ( validateCode == false )
            {
               System.out.println("Invalid video code, please enter a correct code.");
               System.out.println();
            }
         }	while ( validateCode == false );
      }
      else
      {
         System.out.println("No rental found, all video(s) are available for rent.");
      }
   }

   public static void option7(ArrayList allRentalList)
   {
      int i, fine = 0, totalDayRent, totalDayNow, dayDifference, year, month, day;
      boolean validateOverdue = false;
      
      Member m = null;
      Video v = null;
      Rental r = null;
      Calendar c = null;
      
      if( allRentalList.size() > 0 )
      {
         for ( i = 0; i < allRentalList.size(); i++ )
         {
            r = (Rental)allRentalList.get(i);
            m = (Member)r.getBorrower();
            v = (Video)r.getVideo();
            c = (Calendar)r.getLoanDate();
            
            year = c.get(Calendar.YEAR);
            month = ( c.get(Calendar.MONTH) + 1 );
            day = c.get(Calendar.DAY_OF_MONTH);
            totalDayRent = day + ( ( month - 1 ) * 31 ) + ( ( year - 1 ) * 372 );
            
            c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = ( c.get(Calendar.MONTH) + 1 );
            day = c.get(Calendar.DAY_OF_MONTH);
            totalDayNow = day + ( ( month - 1 ) * 31 ) + ( ( year - 1 ) * 372 );
            
            dayDifference = totalDayNow - totalDayRent;
            dayDifference++;
            
            if ( v instanceof Movie )
            {
               if ( dayDifference > 3 )
               {
                  fine = ( dayDifference - 3 ) * 2;
                  
                  validateOverdue = true;
               }
            }
            else
            if ( v instanceof Drama )
            {
               if ( dayDifference > 7 )
               {
                  fine = ( dayDifference - 7 ) * 3;
                  
                  validateOverdue = true;
               }
            }
            
            if ( validateOverdue == true )
            {
               if ( i == 0 )
               {
                  System.out.println("S/No\tTitle\t\tBorrower\tFine($)");
               }
            
               System.out.println( ( i + 1 ) + "\t" + v.getTitle() + "\t" + m.getName() + "\t\t" + fine);
            }
         }
         
         if ( validateOverdue == false )
         {
            System.out.println("No video(s) is overdue.");
         }
      }
      else
      {
         System.out.println("No rental found, all video(s) are available for rent.");
      }
   }

   public static void option8(ArrayList videoList, ArrayList allRentalList)
   {
      Scanner input = new Scanner(System.in);
      
      int i, j;
      String keyword, keywordLC, title, titleLC;
      boolean validateFound = false;
      
      Video v = null;
      Rental r = null;
      
      if ( videoList.size() > 0 )
      {
         do
         {
            System.out.print("Enter a keyword : ");
            keyword = input.nextLine();
            
            for ( i = 0; i < videoList.size(); i++ )
            {
               v = (Video)videoList.get(i);
               title = (String)v.getTitle();
               titleLC = title.toLowerCase();
               keywordLC = keyword.toLowerCase();
               
               if ( titleLC.indexOf(keywordLC) >= 0 )
               {
                  if ( i == 0 )
                  {
                     System.out.println("Code\tTitle\t\tAmount\tRemark\t\tBorrower");
                  }
                  
                  System.out.print( v.getCode() + "\t" + v.getTitle() + "\t" + v.calculateAmount() + "\t" );
                  
                  if ( v.getAvailable() == true )
                  {
                     System.out.println("Available" + "\t" + "No borrower");
                  }
                  else
                  {
                     System.out.print("Not available" + "\t" );
                     
                     for ( j = 0; j < allRentalList.size(); j++ )
                     {
                        r = (Rental)allRentalList.get(i);
                        
                        if ( r.getVideo().getCode() == v.getCode() )
                        {
                           System.out.println( r.getBorrower().getName() );
                        }
                     }
                  }
                  
                  validateFound = true;
               }
            }
         }	while ( validateFound == false );
         
         if ( validateFound == false )
         {
            System.out.println("No video found with this keyword.");
         }
      }
      else
      {
         System.out.println("No video found, cannot search for video.");
      }
   }
}