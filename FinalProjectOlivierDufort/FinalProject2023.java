//BookDemo class
package finalproject2023;
import java.io.*; //allows for usage of files and typewritters
import java.util.Scanner;//allows for scanning data or input 
import java.util.Arrays; //allows for specific commands with array usage
public class FinalProject2023 {

    public static void main(String[] args) throws IOException {//the IOException throws away any file reading, compiling or editing error
        
       Books booksArray [] = new Books [7];//there are 9 books in the text document, but the word document asks for 7 of those, therefore there will be 7 elements in the array
       int count = 0; //initialize count to 0 for a loop
       
       File f = new File("books.txt"); //creating a file and scanner to read the file named in the parenthesis (here it is "books.txt")
       Scanner sc = new Scanner(f); //the source for the scanner to read is the name given to the file, in this case "f"
       
       for(int i = 0; i < 4; i++){//this loop uses the first constructor to read the first 4 lines of data in the file and stores them in the bookArray as requested
           //first content of the text file is the book title
           String Title = sc.nextLine(); //sc.nextLine will mean that the line following that statement will be read and attributeted a variable type and a name
           //(here it is a String variable Named "Title")
           
           //second content of the text file is the author's name
           String Author = sc.nextLine();
           
           //third content of the text file is the year of publishing of the book
          int year = Integer.parseInt(sc.nextLine()); //allows to parse a string value (such as the one in the text document) as a decimal value of Integer type
          
           //fourth content of the text file is the sales for the first 6 months of the specified year above
           String Sales = sc.nextLine();
           String tempSales[]= Sales.split(" "); //important, this allows the scanner to determine when a number ends, 
           //which is when a space or " " in the document splits two numbers
         
         int [] saleNumbers = new int[tempSales.length]; //set the saleNumbers Array  equal to the length of the tempSales array
         for(int j =0;j<tempSales.length;j++){
             saleNumbers[j] = Integer.parseInt(tempSales[j]);// same as the other parseInt above, passes a String value as a decimal of Integer type
         }
         
        booksArray[count] = new Books(Title,Author,year, saleNumbers); //create an instance of the Books class using the second constructor
        
        //setting all values that were read, such as the Title, the Author and the Year of release and passing them on to the Books class
        booksArray[count].setTitle(Title); //passes to setTitle() method
        booksArray[count].setAuthor(Author);//passes to setAuthor() method
        booksArray[count].setYear(year);// passes to setYear() method
      
        count++; //increases the counter for "count" by 1 every time the loop runs, but only after everything else.  
       }
        for(int i = 0; i < 3; i++){ //reads the 3 remaining values that need to be read in the document, per the instructions
        //the explanations are the same as the block of code above, as it is almost the same.    
           //first content of the text file is the book title
           String Title = sc.nextLine();
           //second content of the text file is the author's name
           String Author = sc.nextLine();
           //third content of the text file is the year of publishing of the book
          int year = Integer.parseInt(sc.nextLine());
           //fourth content of the text file is the sales for the first 6 months of the specified year above
           String Sales = sc.nextLine();
           String tempSales[]= Sales.split(" ");
         
         int [] saleNumbers = new int[tempSales.length];
         for(int j =0;j<tempSales.length;j++){
             saleNumbers[j] = Integer.parseInt(tempSales[j]);
         }
         
         booksArray[count]= new Books(Title,Author,year,saleNumbers); //Creates an instance of the second constructor to set the 3 remaining line in the text file
         // and passes the values along to the Books class
          booksArray[count].setTitle(Title);
        booksArray[count].setAuthor(Author);
        booksArray[count].setYear(year);

         for(int month=1; month<=6;month++){ //for all months ranging from 1 to 6, the loop will repeat until it has assigned each SaleNumber to PreciseSaleNumber for each month
            int PreciseSaleNumber = saleNumbers[month-1]; //month-1 since the array starts at index position 0, thus months 1 to 6 will fill array positions 0 to 5
   
      booksArray[count].setSaleNumbers(PreciseSaleNumber, month); //passes values of PreciseSaleNumber and month to the Books class's setSaleNumbers method
         }
         count++;//increases the counter for "count" by 1
        }  
   for (int index = 0; index < booksArray.length; index++) {//executes until index is the same length as the array
    int maximum = booksArray[index].getTotal(); //setting a maximum to figure out which total is the biggest
    int position = index; //setting the index position equal to the integer position
    for (int i = index + 1; i < booksArray.length; i++) {//executing the loop for the value one above the value of index
        if (maximum < booksArray[i].getTotal()) { //if maximum is smaller than booksArray at position i, it becomes equal to it
            maximum = booksArray[i].getTotal();
            position = i;
        }
    }

    // swap around all the items in the text file based on the biggest sales in total to the lowest sales in total
    Books tempBook = booksArray[index];
    booksArray[index] = booksArray[position];
    booksArray[position] = tempBook;
}
       System.out.println(Arrays.toString(booksArray)); //convert the array to string so it can be printed
       for (int i=0; i<booksArray.length;i++){ //print the array a ttoal of 7 times
           System.out.println("Title: " + booksArray[i].getTitle());
           System.out.println("Author: " + booksArray[i].getAuthor());
           System.out.println("Year of publishing: " + booksArray[i].getYear());
           System.out.println("Total sales in first 6 months: " + booksArray[i].getTotal());
       }
       
       
       Scanner sc2 =  new Scanner(System.in); //adding a new scanner that does not read file f to scanner user input
       
       System.out.println("\n enter a month (betweeen 1 and 6) to see the sales for all 7  books in that month");
       int month=sc2.nextInt(); //asking the  user for a month between 1 and 6, otherwise this section of the program will not work. No error message was required to be shown
       //therefore, only a java error code will appear if the values are outside the range of 1 to 6
       
       for (int i =0; i<booksArray.length;i++){
       System.out.println("money earned in month number " + month + " is: " + booksArray[i].getSaleNumbers(month)+ " $ for book number " + (i+1)); //print the final result 
       //for the book number in the ordered list and the amount of sales made in the month entered by the user.
    }
    }
}
//Olivier Dufort
