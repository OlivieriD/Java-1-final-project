package finalproject2023;

public class Books {
    //setting all variables to private so they cannot be accessed outside the Books class
    private String title;
    private String author;
    private int year;
    private int [] saleNumbers; //saleNumbers is an array that has yet to be defined
    

    
    // Constructor with four parameters, setting values received from the main method equal to values in the class that are private
    public Books(String titl, String auth, int yr, int[] BooksSold){//constructor #1 
        title = titl;
        author = auth;
        year = yr;
        saleNumbers = BooksSold; // accepting an int number for the books sold in the first half of the year
    }
    // Constructor with three parameters which instantiates the array, and setting values received from the main method equal to values in the class that are private
    public Books(String titl, String auth, int yr) {//constructor #2
        title = titl;
        author = auth;
        year = yr;
        saleNumbers = new int[6]; // Initializing the array with for the first half of the year which is 6 months
    }


    // Accessor methods to set the values 
    public void setTitle(String titl) {
        title = titl;
    }

    public void setAuthor(String auth) {
        author = auth;
    }

    public void setYear(int yr) {
        year = yr;
    }

    // This Method will set the saleNumbers for a fixed month
    public void setSaleNumbers(int PreciseSales,int month) {
       if(month>=1 && month<=6)
           saleNumbers[month-1]=PreciseSales;
            /*
           only accepting values between 1 and 6, otherwise this method will show a java error. The saleNumbers month -1 is to fit in the according array index position
       and being set equal to PreciseSales.
            */     
    }
       // Mutator methods to return the values
 public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    // Method to get the number of books sold for a specific month
    public int getSaleNumbers(int month) {
     if(month >=1 && month<=6){
         return saleNumbers[month-1]; //again month - 1 to match the array index position
     }
     else{
         return 0; //since the method is not voided, it is an Integer, there needs to be a number returned, not a word otherwise it does not work. 
         //therefore if a problem were to occur, the number 0 is going to appear on the user screen
     }
    }
    // Method to get the total number of books sold in the first half of the year
    public int getTotal() {
        int total=0;
      for(int index = 0; index<saleNumbers.length;index++){  
        total +=saleNumbers[index]; // means total = total + saleNumbers[index], but in shortened notation. allows to add the numbers in the array one by one to the total 
        //and the total gets actualised everytime, so that it keeps track of all the numbers added together and only gives the final result
      }
       return total;      //returns the final result for this method, works the same for all the returning methods above. 
    }
}